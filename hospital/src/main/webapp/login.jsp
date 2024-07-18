<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/17
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>登录</title>

    <!-- Meta-Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- style CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleBackendLogin.css" type="text/css" media="all">
    <%--
      Created by IntelliJ IDEA.
      User: G1503
      Date: 2024/7/17
      Time: 20:53
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>

        <title>登录</title>

        <!-- Meta-Tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- style CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleBackendLogin.css" type="text/css" media="all">

    </head>


<body>

<section class="main">
    <div class="logo text-center">
        <h1> 后台管理中心<br>登录</h1>
    </div>
    <div class="content-w3ls text-center">
        <img src="<%=request.getContextPath()%>/css/imageBackendLogin/admin.png" alt="管理员图标" class="op">
        <form action="<%=request.getContextPath()%>/backend/loginServlet" method="post">
            <div class="wthree-field">
                <input name="username" id="text1" type="text"  placeholder="用户名/工号" required>
            </div>
            <div class="wthree-field">
                <input name="password" id="myInput" type="Password" placeholder="登录密码" required>
            </div>

            <div class="wthree-field">
                <select name="roleId" >
                    <option value="0">管理员</option>
                    <option value="1">医生</option>
                </select>
            </div>

            <div class="yzmrq">

                <input type="text" class="input" name="code" placeholder="填写右侧的验证码" required/>
                <!--每次在地址后面加上?，保证每次的地址不一样，防止浏览器没有检测到地址变化，不真正地发送请求-->
                <img src="<%=request.getContextPath()%>/backend/captServlet" width="100" height="32" class="picimg"  onclick="this.src=this.src+'?'">

            </div>
            <div class="wthree-field">
                <button type="submit" class="btn">登录</button>
            </div>
            <h4 style="color: red">${capError}</h4><h4 style="color: red">${loginError}</h4>
        </form>
    </div>

</section>

</body>
</html>

</head>


<body>

<section class="main">
    <div class="logo text-center">
        <h1> 后台管理中心<br>登录</h1>
    </div>
    <div class="content-w3ls text-center">
        <img src="<%=request.getContextPath()%>/css/imageBackendLogin/admin.png" alt="管理员图标" class="op">
        <form action="<%=request.getContextPath()%>/backend/loginServlet" method="post">
            <div class="wthree-field">
                <input name="username" id="text1" type="text"  placeholder="用户名/工号" required>
            </div>
            <div class="wthree-field">
                <input name="password" id="myInput" type="Password" placeholder="登录密码" required>
            </div>

            <div class="wthree-field">
                <select name="roleId" >
                    <option value="0">管理员</option>
                    <option value="1">医生</option>
                </select>
            </div>

            <div class="yzmrq">

                <input type="text" class="input" name="code" placeholder="填写右侧的验证码" required/>
                <!--每次在地址后面加上?，保证每次的地址不一样，防止浏览器没有检测到地址变化，不真正地发送请求-->
                <img src="<%=request.getContextPath()%>/backend/captServlet" width="100" height="32" class="picimg"  onclick="this.src=this.src+'?'">

            </div>
            <div class="wthree-field">
                <button type="submit" class="btn">登录</button>
            </div>
            <h4 style="color: red">${capError}</h4><h4 style="color: red">${loginError}</h4>
        </form>
    </div>

</section>

</body>
</html>
