<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/7/13
  Time: 23:32
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
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 单页信息</strong></div>
    <li><a href="<%=request.getContextPath()%>/main.jsp" target="right"><strong style="color: darkblue">返回主页</strong></a></li>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=request.getContextPath()%>/backend/addHospitalizationServlet">
            <input type="hidden" name="patientPhone" value="${patientPhone}"/>
            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" readonly class="input" name="patientName" value="${patientName}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>住院房号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="roomNumber" value="" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>住院费用：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="cost" value="" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
