<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/18
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Style Guide - Spurgeon</title>

    <script>
        document.documentElement.classList.remove('no-js');
        document.documentElement.classList.add('js');
    </script>

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/vendor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylemain.css">

    <!-- favicons
    ================================================== -->
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>

</head>

<body id="top">


<!-- preloader
================================================== -->
<div id="preloader">
    <div id="loader" class="dots-fade">
        <div></div>
        <div></div>
        <div></div>
    </div>
</div>


<!-- page wrap
================================================== -->
<div id="page" class="s-pagewrap">


    <!-- # site header
    ================================================== -->
    <header id="masthead" class="s-header">

        <div class="s-header__branding">
            <p class="site-title">
                <a href="main.jsp" rel="home">后台管理中心</a>
            </p>
        </div>

        <div class="row s-header__navigation">

            <nav class="s-header__nav-wrap">

                <h3 class="s-header__nav-heading">Navigate to</h3>

                <ul class="s-header__nav">

                    <li><a href="<%=request.getContextPath()%>/index.jsp" title="">目录页</a></li>
                    <li class="has-children">
                        <a href="" title="" class="">科室管理</a>
                        <ul class="sub-menu">
                            <li><a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet">修改科室信息</a></li>
                            <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet">科室列表</a></li>

                        </ul>
                    </li>

                    <li class="has-children">
                        <a href="" title="" class="">医生管理</a>
                        <ul class="sub-menu">
                            <li><a href="<%=request.getContextPath()%>/backend/addDoctorViewServlet">新增医生</a></li>
                            <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet">医生列表</a></li>

                        </ul>
                    </li>

                    <li class="has-children">
                        <a href="" title="" class="">患者管理</a>
                        <ul class="sub-menu">
                            <li><a href="<%=request.getContextPath()%>/backend/addPatientViewServlet">新增患者</a></li>
                            <li><a href="<%=request.getContextPath()%>/backend/patientListServlet">患者列表</a></li>

                        </ul>
                    </li>
                    <!--
                    <li><a href="styles.html" title="">Styles</a></li>
                    <li class="current-menu-item"><a href="about.html" title="">About</a></li>
                    <li><a href="contact.html" title="">Contact</a></li>
                    -->
                </ul> <!-- end s-header__nav -->

            </nav> <!-- end s-header__nav-wrap -->

        </div> <!-- end s-header__navigation -->



    </header> <!-- end s-header -->



    <!-- # site-content
    ================================================== -->
    <div id="content" class="s-content s-content--page">

        <div class="row entry-wrap">
            <div class="column lg-12">

                <article class="entry">

                    <header class="entry__header entry__header--narrower">

                        <h1 class="entry__title">
                            科室列表
                        </h1>

                    </header>

                    <div class="column lg-6 tab-12">
                        <p><a class="btn btn--stroke u-fullwidth" href="<%=request.getContextPath()%>/backend/addDepartmentViewServlet">新增一级科室</a></p>
                    </div>

                    <div class="row u-add-bottom">
                        <div class="column lg-12">
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>科室名称</th>
                                        <th>科室描述</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${rootDepartmentList}" varStatus="v" var="b">
                                        <tr id="${b.departmentId}">
                                            <td style="text-align:left; padding-left:20px;">${v.count}</td>
                                            <td>${b.departmentName}</td>
                                            <td>${b.departmentDescription}</td>
                                            <td>
                                                <a class="btn btn--stroke u-fullwidth" href="<%=request.getContextPath()%>/backend/addDepartmentViewServlet?pid=${b.departmentId}">新增二级科室</a>
                                                <a class="btn btn--stroke u-fullwidth" href="javascript:void(0)" onclick="return del(${b.departmentId})">删除科室</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>

                    </div> <!-- end row -->




                </article> <!-- end entry -->

            </div>
        </div> <!-- end entry-wrap -->

        </section> <!-- end s-content -->


        <!-- # site-footer
        ================================================== -->
        <footer id="colophon" class="s-footer">

            <div class="row s-footer__subscribe">
                <div class="column lg-12">

                    <h2>
                        用心做好每项工作，用爱护理每个病人
                    </h2>


                </div>
            </div> <!-- end s-footer__subscribe -->



            <div class="ss-go-top">
                <a class="smoothscroll" title="Back to Top" href="#top">
                    <svg width="24" height="24" fill="none" viewBox="0 0 24 24">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M17.25 10.25L12 4.75L6.75 10.25"/>
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M12 19.25V5.75"/>
                    </svg>
                </a>
            </div> <!-- end ss-go-top -->

        </footer><!-- end s-footer -->


        <!-- Java Script
        ================================================== -->
        <script src="<%=request.getContextPath()%>/js/plugins.js"></script>
        <script src="<%=request.getContextPath()%>/js/main.js"></script>
    </div>
</div>

<script type="text/javascript">
    function del(id) {
        if (confirm("你确定删除吗")) {
            $.get("<%=request.getContextPath()%>/backend/deleteDepartmentServlet", {id: id}, function (state) {
                if (state) {
                    // 找到 ID 匹配的行并移除它
                    $("#" + id).remove();
                }
            });
        }
    }
</script>
</body>
</html>
