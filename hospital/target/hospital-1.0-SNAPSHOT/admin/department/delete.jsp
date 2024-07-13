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

  <script src ="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
  <script>
    function cancelDelete() {
      window.history.back(); // 返回上一页
    }

    $(function($) {
      if (confirm("确定要删除该部门吗？")) {
        // 点击确认，提交表单
        document.getElementById("deleteForm").submit();
      } else {
        // 点击取消，不执行任何操作
        cancelDelete();
      }
    });


  </script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 删除界面</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/backend/rootDepartmentListServlet">
      <a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet" ><h2 style="color: red">   点此返回</h2></a>
    </form>
  </div>
</div>


</body>
</html>
