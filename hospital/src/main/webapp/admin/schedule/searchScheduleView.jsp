<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/7/18
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form method="post" class="form-x" action="<%=request.getContextPath()%>/backend/searchScheduleServlet">
    <table class="table table-hover text-center">
        <tr>

            <td>
                <select name="doctorId" style="width:250px;height:40px;display:inline-block">
                    <option value="">请选择医生编号--科室编号--备注信息</option>
                    <c:forEach items="${scheduleList}" var="l" varStatus="m">
                    <option value="${l.doctorId}"><jsp:text>${l.doctorId}_</jsp:text><jsp:text>${l.departmentId}_</jsp:text><jsp:text>${l.remarks}</jsp:text></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="isAvailable" style="width:150px;height:40px;display:inline-block">
                    <option value="">请选择是否排班</option>
                    <option value="1">是</option>
                    <option value="0">否</option>
                </select>
            </td>

            <td>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit" style="width:150px;height:40px"> 搜索</button>
                    </div>
                </div>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
