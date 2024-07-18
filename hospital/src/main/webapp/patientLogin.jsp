<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/8
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <!--这里的height表示框和上边缘的距离-->
            <div style="height:100px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form action="<%=request.getContextPath()%>/patientLoginServlet" method="post">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>患者登录</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="idCardNumber" placeholder="身份证号" data-validate="required:请填写身份证号" />
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>

                        <br>

                        <div class="form-group">
                            <div class="field">
                                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" required />
                                <img src="<%=request.getContextPath()%>/backend/captServlet" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
                                <!--每次在地址后面加上?，保证每次的地址不一样，防止浏览器没有检测到地址变化，不真正地发送请求-->
                            </div>
                        </div>


                        <h4 style="color: red">${capError}</h4><h4 style="color: red">${loginError}</h4>



                    </div>
                    <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
                    <a href="<%=request.getContextPath()%>/patientRegisterServlet">点此注册</a>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
