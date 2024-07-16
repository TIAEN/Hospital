<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/15
  Time: 下午4:39
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 科室列表</strong></div>
        <div class="padding border-bottom">

        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th>科室名称</th>
                <th>科室描述</th>
            </tr>

            <c:forEach items="${departmentList}" varStatus="v" var="b">
                <tr>
                    <td style="text-align:left; padding-left:20px;">
                            ${v.count}</td>

                    <td>${b.departmentName}</td>
                    <td>${b.departmentDescription}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main" href="<%=request.getContextPath()%>/patient/addAppointmentViewSecondServlet?departmentFirstId=${b.departmentFirstId}&&patientId=${patientId}">
                                <span class="icon-edit">
                                </span>二级科室
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <!--表示列数-->
                <td colspan="4">
                    <div class="pagelist">

                        <a href="<%=request.getContextPath()%>/patient/appointSelectDoctorServlet?pageNum=1&&departmentSecondId=${departmentSecondId}">首页</a>

                        <c:if test="${pageInfo.pageNum > 1}">
                            <a href="<%=request.getContextPath()%>/patient/appointSelectDoctorServlet?pageNum=${pageInfo.pageNum - 1}&&departmentSecondId=${departmentSecondId}">上一页</a>
                        </c:if>


                        <c:choose>
                            <c:when test="${pageInfo.pages <= 6}">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="${pageInfo.pages}"/>
                            </c:when>
                            <%--页数超过了6页--%>
                            <c:otherwise>
                                <c:set var="begin" value="${pageInfo.pageNum - 1}"/>
                                <c:set var="end" value="${pageInfo.pageNum + 3}"/>
                                <%--如果begin减1后为0,设置起始页为1,最大页为6--%>
                                <c:if test="${begin -1 <= 0}">
                                    <c:set var="begin" value="1"/>
                                    <c:set var="end" value="6"/>
                                </c:if>
                                <%--如果end超过最大页,设置起始页=最大页-5--%>
                                <c:if test="${end > pageInfo.pages}">
                                    <c:set var="begin" value="${pageInfo.pages - 5}"/>
                                    <c:set var="end" value="${pageInfo.pages}"/>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach begin="${begin}" end="${end}" var="currentPage">
                            <a href="<%=request.getContextPath()%>/patient/appointSelectDoctorServlet?pageNum=${currentPage}&&departmentSecondId=${departmentSecondId}" class="<c:if test="${pageInfo.pageNum eq currentPage}">current</c:if>">${currentPage}</a>
                        </c:forEach>

                        <c:if test="${pageInfo.pageNum < pageInfo.pages - 1}">
                            <a href="<%=request.getContextPath()%>/patient/appointSelectDoctorServlet?pageNum=${pageInfo.pageNum + 1}&&departmentSecondId=${departmentSecondId}">下一页</a>
                        </c:if>

                        <a href="<%=request.getContextPath()%>/patient/appointSelectDoctorServlet?pageNum=${pageInfo.pages}&&departmentSecondId=${departmentSecondId}">尾页</a>


                    </div></td>
            </tr>

        </table>
    </div>
</form>
</body>
</html>

