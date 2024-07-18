<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/18
  Time: 下午2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>

        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a class="button border-main icon-plus-square-o" href="<%=request.getContextPath()%>/main.jsp"> 返回</a> </li>
            </ul>
        </div>

        <table class="table table-hover text-center" id="appointmentTable">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th>患者名称</th>
                <th>医生名称</th>
                <th>预约日期</th>
                <th>状态</th>
            </tr>
            <c:forEach items="${appointmentList}" var="d" varStatus="v">
                <tr id="${d.appointmentId}">
                    <td style="text-align:left; padding-left:20px;">${v.count}</td>

                    <td>${d.patientName}</td>
                    <td>${d.doctorName}</td>
                    <td>${d.appointmentDate}</td>
                    <td>${d.currentStatus}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<script type="text/javascript">


</script>
</body>
</html>