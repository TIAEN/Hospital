<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/11
  Time: 16:50
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
    <!--
    这里由于在监听器里设置了一些attriction
    因此可以写成
    <link rel="stylesheet" href="美元符号{css}/pintuer.css">
    用$替换”美元符号“
    下面的css部分也是一样的
    -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>新增患者</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${root}/backend/addPatientServlet">
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="name"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="idCardNumber"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>科室名称：</label>
                </div>
                <div class="field">
                    <select name="departmentId" id="department" class="input w50">
                        <option value="">请选择科室名称</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>职称信息：</label>
                </div>
                <div class="field">
                    <select name="professionalTitle" class="input w50">
                        <option value="">请选择科室名称</option>
                        <c:forEach items="${professionalTitleList}" var="p">
                            <option value="${p.id}">${p.titleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>入职时间：</label>
                </div>
                <div class="field">
                    <input type="date" name="entryDate" placeholder="入职时间">
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

<script>
    $(function (){
        $("#rootDepartment").change(function(){
            var rootId=$(this).val();
            if(rootId!=0){
                //获取到耳机科室的下拉列表元素对象
                //这里是按照ID取的
                var departmentObj=$("#department");
                //为其做清空，防止内容不停地追加
                departmentObj.html("");
                //执行一个异步的加载二级科室请求
                var url="${root}/backend/loadTwoDepartmentServlet?rootId="+rootId
                //由于参数是通过问号追加的方式写的，所以这里不需要基于JASON格式去写
                $.get(url,function (r){
                    //创建一个string的变量 对响应的数据进行遍历
                    var optionHtml="<option>请选择科室名称</option>";
                    for(var i=0;i<r.length;i++){
                        optionHtml+="<option value='"+r[i].departmentId+"'>"+r[i].departmentName+"</option>"
                    }
                    //因为里面是带着标签的，所以要用html方法，将optionHtml加进去
                    departmentObj.append(optionHtml)
                },'json')
            }else{
                return
            }
        })
    })
</script>

</html>
