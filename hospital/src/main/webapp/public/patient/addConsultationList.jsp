
<%--
  Created by IntelliJ IDEA.
  User: 姜沛辰
  Date: 2024/7/14
  Time: 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title></title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>就诊菜单</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${root}/patient/addConsultationServlet">

            <div class="form-group">
                <div class="label">
                    <label>就诊编号</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${consultationId}" readonly name="consultationId"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>患者编号</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${patientId}" readonly name="patientId"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>医生编号</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${doctorId}" name="doctorId"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>就诊时间</label>
                </div>
                <div class="field">
                    <input type="date" name="consultationTime" placeholder="就诊时间">
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>是否住院登记</label>
                </div>
                <div class="field">
                    <select name="isHospitalRegistered" class="input">
                        <option value="1">住院登记</option>
                        <option value="0">取消住院登记</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>是否住院</label>
                </div>
                <div class="field">
                    <select name="isHospitalized" class="input">
                        <option value="1">确定住院</option>
                        <option value="0">取消住院</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>医嘱病例</label>
                </div>
                <div class="field">
                    <textarea name="medicalAdviceCase" class="input" placeholder="请输入医嘱病例"></textarea>
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
