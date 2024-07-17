<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/16
  Time: 21:19
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
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=request.getContextPath()%>/backend/patientPasswordServlet?patientId=${patientId}">
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input readonly type="text" class="input w50" name="name" value="${patientInfo.name}">
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input readonly type="text" class="input w50" name="idCardNumber" value="${patientInfo.idCardNumber}">
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label >原始密码：</label>
                </div>
                <div class="field">
                    <input type="password"  class="input w50" name="originalPassword" size="50" data-validate="required:请输入原始密码" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="newPassword" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>确认新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="repeatNewPassword" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
            ${passwordError}
            ${passwordSuccess}
        </form>
    </div>
</div>
</body>
</html>
