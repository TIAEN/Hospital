<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/10
  Time: 9:53
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
    <title>搜索结果</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<input type="hidden" name="searchContent"/>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">患者列表</strong></div>

    <table class="table table-hover text-center">
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">序号</th>
            <th>患者编号</th>
            <th>患者姓名</th>
            <th>身份证号</th>
            <th>电话</th>
            <th>余额</th>
        </tr>

        <c:forEach items="${searchPatientList}" varStatus="v" var="p">
            <tr>
                <td style="text-align:left; padding-left:20px;">${v.count}</td>
                <td>${p.patientId}</td>
                <td>${p.name}</td>
                <td>${p.idCardNumber}</td>
                <td>${p.phone}</td>
                <td>${p.balance}</td>
            </tr>
        </c:forEach>

        <tr>
            <!--表示列数-->
            <td colspan="6">
                <div class="pagelist">
                    <a href="<%=request.getContextPath()%>/backend/patientSearchServlet?searchPageNum=1;">首页</a>
                    <c:if test="${searchPatientInfo.pageNum > 1}">
                        <a href="<%=request.getContextPath()%>/backend/patientSearchServlet?searchPageNum=${searchPatientInfo.pageNum - 1}">上一页</a>
                    </c:if>

                    <c:choose>
                        <c:when test="${searchPatientInfo.pages <= 6}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="${searchPatientInfo.pages}"/>
                        </c:when>
                        <%--页数超过了6页--%>
                        <c:otherwise>
                            <c:set var="begin" value="${searchPatientInfo.pageNum - 1}"/>
                            <c:set var="end" value="${searchPatientInfo.pageNum + 3}"/>
                            <%--如果begin减1后为0,设置起始页为1,最大页为6--%>
                            <c:if test="${begin -1 <= 0}">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="6"/>
                            </c:if>
                            <%--如果end超过最大页,设置起始页=最大页-5--%>
                            <c:if test="${end > searchPatientInfo.pages}">
                                <c:set var="begin" value="${searchPatientInfo.pages - 5}"/>
                                <c:set var="end" value="${searchPatientInfo.pages}"/>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach begin="${begin}" end="${end}" var="currentPage">
                        <a href="<%=request.getContextPath()%>/backend/patientSearchServlet?searchPageNum=${currentPage}" class="<c:if test="${searchPatientInfo.pageNum eq currentPage}">current</c:if>">${currentPage}</a>
                    </c:forEach>

                    <c:if test="${searchPatientInfo.pageNum < searchPatientInfo.pages - 1}">
                        <a href="<%=request.getContextPath()%>/backend/patientSearchServlet?searchPageNum=${searchPatientInfo.pageNum + 1}">下一页</a>
                    </c:if>

                    <a href="<%=request.getContextPath()%>/backend/patientSearchServlet?searchPageNum=${searchPatientInfo.pages}">尾页</a>


                </div></td>
        </tr>

    </table>
</div>


</body>
</html>
