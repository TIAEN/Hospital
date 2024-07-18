
<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/8
  Time: 上午11:29
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
    <title>后台管理中心</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="<%=request.getContextPath()%>/images/meilinna.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;&nbsp;<a class="button button-little bg-red" href="<%=request.getContextPath()%>/index.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>

    <c:if test="${not empty AdminInfo}">

        <h2><span class="icon-user"></span>医生信息管理</h2>
        <ul style="display:block">
            <li><a href="<%=request.getContextPath()%>/backend/addDoctorViewServlet" target="right"><span class="icon-caret-right"></span>新增医生</a></li>
            <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet" target="right"><span class="icon-caret-right"></span>医生信息列表</a></li>
        </ul>

        <h2><span class="icon-user"></span>科室管理</h2>
        <ul style="display:block">
            <li><a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet" target="right"><span class="icon-caret-right"></span>新增科室</a></li>
            <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet" target="right"><span class="icon-caret-right"></span>科室列表</a></li>
        </ul>

        <h2><span class="icon-user"></span>患者住院管理</h2>
        <ul style="display:block">
            <li><a href="<%=request.getContextPath()%>/backend/patientListServlet" target="right"><span class="icon-caret-right"></span>患者住院安排</a></li>
            <li><a href="<%=request.getContextPath()%>/backend/hospitalizationListServlet" target="right"><span class="icon-caret-right"></span>住院信息</a></li>
        </ul>

        <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
        <ul style="display:block">
            <li><a href="<%=request.getContextPath()%>/backend/rootAnnouncementServlet" target="right"><span class="icon-caret-right"></span>发布公告</a></li>
            <li><a href="<%=request.getContextPath()%>/backend/announcementListServlet" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
        </ul>

        <h2><span class="icon-user"></span>排班管理</h2>
        <ul style="display:block">
            <li><a href="<%=request.getContextPath()%>/backend/ScheduleListServlet" target="right"><span class="icon-caret-right"></span>排班列表</a></li>
            <li><a href="<%=request.getContextPath()%>/backend/rootScheduleServlet" target="right"><span class="icon-caret-right"></span>排班安排</a></li>
        </ul>

    </c:if >

    <c:if test="${not empty DoctorInfo}">

    <h2><span class="icon-user"></span>个人信息管理</h2>
    <ul style="display:block">
        <li><a href="<%=request.getContextPath()%>/backend/currentDoctorInfoServlet?jobNumber=${jobNumber}" target="right"><span class="icon-caret-right"></span>我的信息</a></li>
        <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet" target="right"><span class="icon-caret-right"></span>医生信息列表</a></li>
    </ul>

    <h2><span class="icon-pencil-square-o"></span>病人管理</h2>
    <ul>
        <li><a href="<%=request.getContextPath()%>/backend/rootAddConsultationServlet" target="right"><span class="icon-caret-right"></span>就诊管理</a></li>
    </ul>

    </c:if >

</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>

<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="<%=request.getContextPath()%>/info.html" name="right" width="100%" height="100%"></iframe>
</div>
<!--iframe是内联框架，不能删-->

</body>
</html>
