<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/3
  Time: 下午2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("root", request.getContextPath());
    %>



    <script>
        $(function($) {
            $("#customBut").click(function (){
                var valueInfo=$(this).val();
                var spanText=$("span").text();
                var divText=$("div").text();
                alert(valueInfo);
                alert(spanText)
                alert(divText)
            });
        });
    </script>

</head>
<body>

<input id="customBut" value="click to test" type="button"/>



    <h2 style="color:blue">${memberInfo.username}</h2>
<a href="<%=request.getContextPath()%>/testServlet">
    测试请求
</a>

<hr>

<a href="<%=request.getContextPath()%>/goRegViewServlet">注册</a>
<c:if test="${empty memberInfo}">
    |<a href="<%=request.getContextPath()%>/loginViewServlet">登录</a>
</c:if>

<c:if test="${not empty membervInfo}">
    <a href="${root}/memberDetailsAddViewServlet">完善个人信息</a>
</c:if>


</body>
</html>
