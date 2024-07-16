<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/11
  Time: 上午10:44
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
        <div class="panel-head"><strong class="icon-reorder"> 就诊列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom" >
            <ul class="search" style="padding-left:10px;">

                <li> <a class="button border-main icon-plus-square-o" href="<%=request.getContextPath()%>/backend/addConsultationViewServlet">就诊</a> </li>
                    <li> <form method="get" action="<%=request.getContextPath()%>/backend/consultationListServlet"></form></li>
            </ul>
        </div>

        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">就诊编号</th>
                <th>病人编号</th>
                <th>医生编号</th>
                <th>就诊时间</th>
                <th>是否住院</th>
                <th>是否住院登记</th>
                <th width="310">医嘱病例</th>
            </tr>

            <c:forEach items="${rootConsultationList}"  varStatus="v" var="d">

                <tr>

                    <td>${d.consultationId}</td>
                    <td>${d.patientId}</td>
                    <td>${d.doctorId}</td>
                    <td>${d.consultationTime}</td>
                    <td>${d.isHospitalRegistered == 1 ? "是" : "否"}</td>
                    <td>${d.isHospitalized == 1 ? "是" : "否"}</td>
                    <td>${d.medicalAdviceCase}</td>

                </tr>
            </c:forEach>

            <tr>
                <!--表示列数-->
                <td colspan="4">
                    <div class="pagelist">

                        <a href="<%=request.getContextPath()%>/backend/consultationListServlet?pageNum=1">首页</a>

                        <c:if test="${pageInfo.pageNum > 1}">
                            <a href="<%=request.getContextPath()%>/backend/consultationListServlet?pageNum=${pageInfo.pageNum - 1}">上一页</a>
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
                            <a href="<%=request.getContextPath()%>/backend/consultationListServlet?pageNum=${currentPage}" class="<c:if test="${pageInfo.pageNum eq currentPage}">current</c:if>">${currentPage}</a>
                        </c:forEach>

                        <c:if test="${pageInfo.pageNum < pageInfo.pages - 1}">
                            <a href="<%=request.getContextPath()%>/backend/consultationListServlet?pageNum=${pageInfo.pageNum + 1}">下一页</a>
                        </c:if>

                        <a href="<%=request.getContextPath()%>/backend/consultationListServlet?pageNum=${pageInfo.pages}">尾页</a>


                    </div></td>
            </tr>
        </table>
    </div>
</form>
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