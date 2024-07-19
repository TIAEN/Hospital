<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/7/11
  Time: 0:24
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
    <link rel="stylesheet" href="${css}/pintuer.css">
    <link rel="stylesheet" href="${css}/admin.css">
    <script src="${js}/jquery.js"></script>
    <script src="${js}/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>我的信息</strong></div>
    <li><a onclick="window.history.back()" target="right"><strong style="color: darkblue">返回主页</strong></a></li>
    <div class="body-content">
        <form method="post" class="form-x" action="${root}/backend/updateDoctorDetailsServlet" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>医生工号：</label>
                </div>
                <div class="field">
                    <input type="text" value="${doctor.jobNumber}" readonly class="input w50" name="jobNumber"/>
                    <div class="tips"></div>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>真实名称：</label>
                </div>
                <div class="field">
                    <input type="text" value="${doctor.name}" readonly class="input w50" name="name" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="image" class="button bg-blue margin-left" id="image" value="+ 浏览上传"  style="float:left;">
                    <c:if test="${not empty doctor.avatar}">
                        <img src="http://localhost/upload/${doctor.avatar}">
                    </c:if>
                    <c:if test="${empty doctor.avatar}">
                        <img src="${images}/meilinna.jpg">
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>电话：</label>
                </div>
                <div class="field">
                    <input type="text" value="${doctor.phone}" name="phone"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>邮箱地址：</label>
                </div>
                <div class="field">
                    <input type="text" value="${doctor.email}"  name="email"/>
                    <div class="tips"></div>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="introduction" style="height: 90px">
                        ${doctor.introduction}
                    </textarea>
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
