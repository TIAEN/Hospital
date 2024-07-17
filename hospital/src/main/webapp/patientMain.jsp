<%--
  Created by IntelliJ IDEA.
  User: 姜沛辰
  Date: 2024/7/14
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/8
  Time: 上午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1><img src="images/meilinna.jpg" class="radius-circle rotate-hover" height="50" alt="" />预约挂号中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>

    <h2><span class="icon-user"></span>就诊管理</h2>
    <ul style="display:block">
      <li><a href="<%=request.getContextPath()%>/patient/rootAddConsultationServlet" target="right"><span class="icon-caret-right"></span>就诊信息</a></li>
      <li><a href="<%=request.getContextPath()%>/patient/rootAppointmentServlet" target="right"><span class="icon-caret-right"></span>患者预约</a></li>
      <li><a href="<%=request.getContextPath()%>/patientPayViewServlet?phone=${phone}" target="right"><span class="icon-caret-right"></span>住院缴费</a></li>
    </ul>


    <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
    <ul style="display:block">
      <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet" target="right"><span class="icon-caret-right"></span>科室列表</a></li>
      <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet" target="right"><span class="icon-caret-right"></span>医生列表</a></li>
    </ul>

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
  <iframe scrolling="auto" rameborder="0" src="info.html" name="right" width="100%" height="100%"></iframe>
</div>
<!--iframe是内联框架，不能删-->

</body>
</html>

