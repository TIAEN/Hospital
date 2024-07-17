<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/7/11
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form method="post" action="${root}/backend/doctorListServlet" id="listform">
  <input name="pageNum" type="hidden" id="pageNum" value="1">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 医生信息检索</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <li><a href="<%=request.getContextPath()%>/main.jsp" target="right"><strong style="color: darkblue">返回主页</strong></a></li>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>搜索：</li>
          <li>
            <select name="pid" class="input" style="width:200px; line-height:17px;" >

              <option value="0">请选择职称</option>
              <c:forEach items="${professionalTitleList}" var="p">
                <option value="${p.id}" <c:if test="${pid eq p.id}">selected</c:if> >${p.titleName}</option>
              </c:forEach>
            </select>
          </li>
        <li>
          <input type="text" placeholder="请输入医生姓名" value="${name}" name="name" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="goPage()" > 搜索</a></li>
      </ul>

    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">序号</th>
        <th>医生姓名</th>
        <th>工号</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>科室</th>
        <th>职称</th>
        <th>入职日期</th>
      </tr>

      <c:forEach items="${pageInfo.getList()}" varStatus="v" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">
              ${v.count}</td>
          <td>${d.name}</td>
          <td>${d.jobNumber}</td>
          <td>${d.phone == null ? '-' :d.phone}</td>
          <td>${d.email == null ? '-' :d.email}</td>
          <td>${d.departmentName}</td>
          <td>${d.professionalTitleName}</td>
          <td> <fmt:formatDate value="${d.entryDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>


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

            <c:if test="${pageInfo.pages ne 1}">
              <a href="javascript:void(0)" onclick="goPage(${pageInfo.pageNum-1})">上一页</a>
            </c:if>
            <c:forEach begin="${begin}" end="${end}" var="currentPage">
              <a href="javascript:void(0)" onclick="goPage(${currentPage})" class="<c:if test="${pageInfo.pageNum eq currentPage}">current</c:if>">${currentPage}</a>
            </c:forEach>
            <c:if test="${pageInfo.pages ne pageInfo.pageNum}">
              <a href="javascript:void(0)" onclick="goPage(${pageInfo.pageNum+1})">下一页</a>
            </c:if>

          </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

  $(function (){

  })

  function goPage(pageNum){
      $("#pageNum").val(pageNum).innerText=pageNum;
      document.getElementById("listform").submit()
  }

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
