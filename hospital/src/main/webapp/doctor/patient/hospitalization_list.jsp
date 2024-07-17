<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/7/14
  Time: 1:26
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
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 住院管理</strong> <a href="" style="float:right; display:none;"></a></div>
        <li><a href="<%=request.getContextPath()%>/main.jsp" target="right"><strong style="color: darkblue">返回主页</strong></a></li>
        <div class="padding border-bottom">

        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th>患者姓名</th>
                <th>房间号</th>
                <th>未缴费用</th>
                <th>缴费状态</th>
                <th>住院状态</th>

            </tr>

            <c:forEach items="${hospitalizationList}" varStatus="v" var="b">
                <tr>
                    <td style="text-align:left; padding-left:20px;">
                            ${v.count}</td>
                    <td>${b.patientName}</td>
                    <td>${b.roomNumber}</td>
                    <td>${b.cost}</td>

                    <td>
                        <c:if test="${b.paymentStatus=='paid'}">
                            <h3 style="color: #00aa00">已支付</h3>
                        </c:if>
                        <c:if test="${b.paymentStatus=='unpaid'}">
                            <h3 style="color: red">未支付</h3>
                        </c:if>
                        <c:if test="${b.paymentStatus=='partially_paid'}">
                            <h3 style="color: #00aaee">部分支付</h3>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${b.hospitalizationStatus=='admitted'}">
                            <h3>已入院</h3>
                        </c:if>
                        <c:if test="${b.hospitalizationStatus=='discharged'}">
                            <h3>已出院</h3>
                        </c:if>
                        <c:if test="${b.hospitalizationStatus=='in_progress'}">
                            <h3>处理中</h3>
                        </c:if>
                    </td>

                    <td>
                        <c:if test="${b.paymentStatus=='paid'&& b.hospitalizationStatus=='in_progress'}">
                            <div class="button-group">
                                <a class="button border-main" href="#" onclick="confirmHospitalization('${b.patientPhone}')">
                                    <span class="icon-edit"></span> 入院
                                </a>
                            </div>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${b.hospitalizationStatus=='admitted'}">
                            <div class="button-group">
                                <a class="button border-red" href="#" onclick="dischargeHospitalization('${b.patientPhone}')">
                                    <span class="icon-edit"></span> 出院
                                </a>
                            </div>
                        </c:if>
                    </td>

                    </div></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
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
                            <a href="<%=request.getContextPath()%>/backend/hospitalizationListServlet?pageNum=${currentPage}" class="<c:if test="${pageInfo.pageNum eq currentPage}">current</c:if>">${currentPage}</a>
                        </c:forEach>
                    </div></td>
            </tr>
        </table>
    </div>
</form>
<script>
    function confirmHospitalization(phone) {
        if (confirm("您确定要为该患者办理入院手续吗?")) {
            window.location.href = "<%=request.getContextPath()%>/backend/hospitalizationEnterServlet?phone=" + phone;
        }
    }
</script>
<script>
    function dischargeHospitalization(phone) {
        if (confirm("您确定要为该患者办理出院手续吗?")) {
            window.location.href = "<%=request.getContextPath()%>/backend/hospitalizationDischargeServlet?phone=" + phone;
        }
    }
</script>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){


            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var i = 0;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    i++;
                }
            });
            if(i>1){
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected","selected");
            }else{

                $("#listform").submit();
            }
        }
        else{
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected","selected");
            return false;
        }
    }

</script>
</body>
</html>
