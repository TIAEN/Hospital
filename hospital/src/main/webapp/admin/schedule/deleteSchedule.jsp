<%--
  Created by IntelliJ IDEA.
  User: 姜沛辰
  Date: 2024/7/8
  Time: 16:22
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
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 删除界面</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <input type="hidden" name="schedule" value="${schedule}"/>

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
      <tr>
        <td>${schedule.scheduleId}</td>
        <td>${schedule.doctorId}</td>
        <td>${schedule.departmentId}</td>
        <td>${schedule.isAvailable}</td>
        <td>${schedule.date}</td>
        <td>${schedule.visitCount}</td>
        <td>${schedule.remarks}</td>
      </tr>

  </table>
      <div class="button-group"> <a class="button border-main" href="<%=request.getContextPath()%>/backend/deleteScheduleServlet?scheduleId=${schedule.scheduleId}" style="color: red"><span class="icon-edit"></span> 确定删除</a>
      </div>
      <div class="button-group"> <a class="button border-main" href="<%=request.getContextPath()%>/backend/rootScheduleServlet"><span class="icon-edit"></span> 取消删除</a>
      </div>

    </form>
  </div>
</div>


</body>
</html>
