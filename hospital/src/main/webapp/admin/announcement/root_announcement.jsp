<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/10
  Time: 上午11:40
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
                <li> <a class="button border-main icon-plus-square-o" href="<%=request.getContextPath()%>/backend/addAnnouncementViewServlet"> 发布新公告</a> </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th>标题</th>
                <th>内容</th>
                <th>发布时间</th>
                c
            </tr>
            <c:forEach items="${rootAnnouncementList}" var="d" varStatus="v">
                    <tr id="${d.announcementId}">
                        <td style="text-align:left; padding-left:20px;">${v.count}</td>

                        <td>${d.announcementTitle}</td>
                        <td>${d.announcementContent}</td>
                        <td>${d.announcementCreateTime}</td>
                        <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(${d.announcementId})"><span class="icon-trash-o"></span> 删除</a> </div></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<script type="text/javascript">
    function del(id){
        if(confirm("你确定删除吗")){

            $.get("<%=request.getContextPath()%>/backend/deleteAnnouncementServlet",{id:id},function (state){
                if(state)
                    $("#"+id).remove();
            });

        }else{

        }
    }
</script>
</body>
</html>
