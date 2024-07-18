<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
        .input-box {
            margin-bottom: 20px;
        }
        .input-with-code {
            display: flex;
            align-items: center;
        }
        .input-with-code input {
            flex: 1;
            margin-right: 10px;
        }
        .btn-box {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .btn-box input,
        .btn-box a {
            margin: 0 10px;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color: gray;
            border-radius: 5px;
            font-size: 18px;
            text-align: center;
            display: inline-block;
            width: 120px; /* Adjust width to ensure uniform size */
        }
        .btn-box input.bg-main,
        .btn-box a.bg-main {
            background-color: #0ae;
        }
    </style>
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
            <label>验证码</label>
            <div class="input-with-code">
                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                <img src="<%=request.getContextPath()%>/backend/captServlet" alt="" width="100" height="32" class="passcode" onclick="this.src=this.src+'?'">
            </div>
        </div>
        <div class="btn-box">
            <input type="submit" class="button bg-main" value="注册">
        </div>
        <h4 style="color: red">${capError}</h4>
        <h4 style="color: red">${registerError}</h4>

        <div class="back-home">
            <a href="<%=request.getContextPath()%>/index.jsp">返回首页</a>
        </div>
    </form>
</div>
</body>
</html>