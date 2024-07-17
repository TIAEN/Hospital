<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/16
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
    <script>
        function checkTime() {
            var dateInput = document.getElementById('appointmentDate').value;
            var timeInput = document.getElementById('appointmentTime').value;
            var now = new Date();
            var selectedDate = new Date(dateInput + 'T' + timeInput);

            if (selectedDate < now) {
                alert('选择的时间已过，请重新选择时间段。');
                document.getElementById('appointmentTime').value = '';
            } else {
                var selectedOption = document.querySelector('#appointmentTime option[value="' + timeInput + '"]');
                if (selectedOption && selectedOption.text.includes('已满')) {
                    alert('当前时间段已满，请选择其他时间段。');
                    document.getElementById('appointmentTime').value = '';
                }
            }
        }

        document.addEventListener('DOMContentLoaded', function() {
            document.getElementById('appointmentTime').addEventListener('change', checkTime);
            document.getElementById('appointmentDate').addEventListener('change', checkTime);
        });
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 单页信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=request.getContextPath()%>/patient/addAppointmentServlet?patientId=${patientId}&doctorId=${doctorId}">
            <!--这里放隐藏域-->
            <input type="hidden" name="plevel" value="${plevel}"/>
            <input type="hidden" name="pid" value="${pid}"/>
            <div class="form-group">
                <div class="label">
                    <label>一级科室名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="${departmentFirstName}" readonly>
                    <div class="tips"></div>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>二级科室名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="${departmentSecondName}" readonly>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>医生姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="${doctorName}" readonly>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="${patientName}" readonly>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>预约日期：</label>
                </div>
                <div class="field">
                    <input type="date" class="input" id="appointmentDate" name="Date">
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>预约时段：</label>
                </div>
                <div class="field">
                    <select id="appointmentTime" class="input" name="Time">
                        <c:forEach items="${timeSlots}" var="entry">
                            <c:choose>
                                <c:when test="${entry.value == 0}">
                                    <option value="${entry.key}" disabled>${entry.key} - 已满</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${entry.key}">${entry.key} - 剩余${entry.value}人</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body></html>

