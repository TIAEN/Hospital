<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/16
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<div class="box">
    <h2>注册</h2>

    <form action="<%=request.getContextPath()%>/backend/patientRegisterServlet" method="post">

    <div class="input-box">
        <label>姓名</label>
        <input type="text" name="name" placeholder="请输入你的姓名"/>
    </div>

    <div class="input-box">
        <label>身份证号</label>
        <input type="text" name="idCardNumber"/>
    </div>

    <div class="input-box">
        <label>密码</label>
        <input type="password" name="password"/>
    </div>

    <div class="input-box">
        <label>确认密码</label>
        <input type="password" name="passwordAgain"/>
    </div>

    <div class="input-box">
        <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
        <img src="<%=request.getContextPath()%>/backend/captServlet" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
    </div>

    <div class="btn-box">
        <div>
            <div style="padding:30px;">
                <input type="submit" class="button" value="注册">
            </div>
        </div>
    </div>

        <h4 style="color: red">${capError}</h4>
    <h4 style="color: red">${registerError}</h4>

    </form>
</div>

<script type="text/javascript">

</script>
</body>
</html>
