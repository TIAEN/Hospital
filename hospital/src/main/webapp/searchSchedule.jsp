<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/7/17
  Time: 19:21
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
    <div class="panel-head"><strong class="icon-reorder"> 医生排班 </strong></div>
    <div class="padding border-bottom">
        搜索到的结果为：
    </div>


    <table class="table table-hover text-center">
        <tr>
            <th>排班编号</th>
            <th>医生编号</th>
            <th>科室编号</th>
            <th>是否排班</th>
            <th>排班时间</th>
            <th>就诊数量</th>
            <th>备注信息</th>
        </tr>

        <c:forEach items="${searchList}" var="s" varStatus="v">
            <tr>
                <td>${s.scheduleId}</td>
                <td>${s.doctorId}</td>
                <td>${s.departmentId}</td>
                <td>${s.isAvailable}</td>
                <td>${s.date}</td>
                <td>${s.visitCount}</td>
                <td>${s.remarks}</td>
            </tr>
        </c:forEach>

    </table>
</div>

<a href="<%=request.getContextPath()%>/scheduleListServlet"><h1>点此返回</h1></a>

</body>
</html>
