<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/19
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">接诊列表</a></div>
        <table class="table table-hover text-center" id="appointmentTable">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th>患者名称</th>
                <th>医生名称</th>
                <th>预约日期</th>
                <th>状态</th>
                <th width="310">操作</th>
            </tr>
            <c:forEach items="${appointmentList}" var="d" varStatus="v">
                <tr id="${d.appointmentId}">
                    <td style="text-align:left; padding-left:20px;">${v.count}</td>

                    <td>${d.patientName}</td>
                    <td>${d.doctorName}</td>
                    <td>
                        <fmt:formatDate value="${d.appointmentDate}" pattern="yyyy-MM-dd HH:mm" />
                    </td>
                    <td>${d.currentStatus}</td>
                    <td>
                        <c:if test="${d.currentStatus == 'booked'}">
                            <button type="button" onclick="cancelAppointment(${d.appointmentId})">就诊</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<script type="text/javascript">
    function del(id){
        if(confirm("你确定删除吗")){

            $.get("<%=request.getContextPath()%>/backend/deleteDepartmentServlet",{id:id},function (state){
                if(state)
                    $("#"+id).remove();
            });

        }else{

        }
    }
    function cancelAppointment(appointmentId) {
        // 这里添加取消预约
            fetch('<%=request.getContextPath()%>/backend/AddConsultationViewServlet', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    body: new URLSearchParams({
                        'appointmentId': appointmentId
                    })
                }
            )
                .then(response => response.text())
                .then(appointmentList => {

                    handleResponse(appointmentList);
                    location.reload();
                })
                .catch(error => {
                    console.error('发生错误：', error);
                })
    }
    function handleResponse(appointmentList){


    }
</script>
</body>
</html>