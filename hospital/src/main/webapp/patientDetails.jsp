<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/11
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <!--
    这里由于在监听器里设置了一些attriction
    因此可以写成
    <link rel="stylesheet" href="美元符号{css}/pintuer.css">
    用$替换”美元符号“
    下面的css部分也是一样的
    -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${root}/backend/modifyPatientServlet?patientId=${patientId}">

            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input readonly type="text" class="input w50" name="name" value="${patientInfo.name} "/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input readonly type="text" class="input w50" name="idCardNumber" value="${patientInfo.idCardNumber}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="phone" value="${patientInfo.phone}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>邮箱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="email" value="${patientInfo.email}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>余额：</label>
                </div>
                <div class="field">
                    <input readonly type="text" class="input w50" name="balance" value="${patientInfo.balance}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
        ${modifyError}
    </div>
</div>

</body>


</html>
