<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/7/17
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 单页信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=request.getContextPath()%>/backend/addScheduleServlet">

            <div class="form-group">
                <div class="label">
                    <label>排班编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" readonly name="scheduleId" value="${scheduleId}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>医生信息：</label>
                </div>
                <div>
                    <select name="doctorId" style="width:250px;height:40px;display:inline-block">
                        <option value="">请选择医生编号--科室编号--备注信息</option>
                        <c:forEach items="${scheduleList}" var="l" varStatus="m">
                            <option value="${l.doctorId}"><jsp:text>${l.doctorId}_</jsp:text><jsp:text>${l.departmentId}_</jsp:text><jsp:text>${l.remarks}</jsp:text></option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>是否排班：</label>
                </div>
                <div>
                    <select name="isAvailable" style="width:150px;height:40px;display:inline-block">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>排班时间：</label>
                </div>
                <div class="field">
                    <input type="datetime-local" class="input" name="date" value="" />
                    <div class="tips"></div>
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

</body>
</html>