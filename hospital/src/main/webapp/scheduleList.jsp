<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/7/18
  Time: 11:23
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

<table class="table table-hover text-center">
    <tr>
        <td>
            <div class="button-group"> <a class="button border-main" href="<%=request.getContextPath()%>/searchScheduleViewServlet"><span class="icon-edit"></span> 搜索排班</a>
            </div>
        </td>
    </tr>
</table>

<script>

</script>

<form method="post" action="" id="listform">
    <div>
        <table class="table table-hover text-center">

            <tr>
                <th>排班编号</th>
                <th>医生编号</th>
                <th>科室编号</th>
                <th>是否排班</th>
                <th>排班时间</th>
                <th>就诊数量</th>
                <th>备注信息</th>
            </tr>
            <c:forEach items="${rootScheduleList}" var="s" varStatus="v">
                <tr>
                    <td>${s.scheduleId}</td>
                    <td>${s.doctorId}</td>
                    <td>${s.departmentId}</td>
                    <c:if test="${s.isAvailable == 1}">
                        <td>是</td>
                    </c:if>
                    <c:if test="${s.isAvailable == 0}">
                        <td>否</td>
                    </c:if>
                    <td>${s.date}</td>
                    <td>${s.visitCount}</td>
                    <td>${s.remarks}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6"><!--在第6列-->
                    <div class="pagelist">
                        总排班数量：${totalNum}&nbsp;&nbsp;
                        当前页数/总页数：${pageInfo.pageNum}/${pageInfo.pages}&nbsp;&nbsp;


                        <a href="<%=request.getContextPath()%>/scheduleListServlet?pageNum=1">首页</a>


                        <c:if test="${pageInfo.pageNum > 1}">
                            <a href="<%=request.getContextPath()%>/scheduleListServlet?pageNum=${pageInfo.pageNum - 1}">上一页</a>
                        </c:if>


                        <c:if test="${pageInfo.pageNum <= pageInfo.pages - 1}">
                            <a href="<%=request.getContextPath()%>/scheduleListServlet?pageNum=${pageInfo.pageNum + 1}">下一页</a>
                        </c:if>


                        <a href="<%=request.getContextPath()%>/scheduleListServlet?pageNum=${pageInfo.pages}">尾页</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
