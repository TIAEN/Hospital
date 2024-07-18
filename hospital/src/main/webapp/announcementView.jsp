<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/18
  Time: 下午9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="panel-head"><strong class="icon-reorder"> 公告</strong></div>
        <c:if test="${empty patientId}">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <a class="button border-main icon-plus-square-o" href="#" onclick="window.history.back(); return false;">返回</a>
            </ul>
        </div>
        </c:if>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">序号</th>
            <th>公告标题</th>
            <th>公告内容</th>
            <th>发起时间</th>
            <th>发起人</th>
        </tr>

        <c:forEach items="${announcementList}" varStatus="v" var="b">
            <tr>
                <td style="text-align:left; padding-left:20px;">
                        ${v.count}</td>

                <td>${b.announcementTitle}</td>
                <td>
                    <textarea type="text" class="input" name="announcementContent" readonly rows="10" cols="100">${b.announcementContent}</textarea>
                </div>
                </td>
                <td>${b.announcementCreateTime}</td>
                <td>
                    ${b.announcementCreator}
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
</form>
</body>
</html>
