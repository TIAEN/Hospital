<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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
<body>

<a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet">点此返回</a>

</body>
</html>
