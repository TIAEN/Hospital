<%--
  Created by IntelliJ IDEA.
  User: G1503
  Date: 2024/7/18
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理中心</title>

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
                    <li><a href="index.jsp" title="">目录页</a></li>

                    <c:if test="${not empty AdminInfo}">

                        <li class="has-children">
                            <a href="" title="" class="">科室管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet">修改科室信息</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet">科室列表</a></li>
                            </ul>
                        </li>

                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">医生管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/addDoctorViewServlet">新增医生</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet">医生列表</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">患者管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/addPatientViewServlet">新增患者</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/patientListServlet">患者列表</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <!--
                    <li><a href="styles.html" title="">Styles</a></li>
                    <li class="current-menu-item"><a href="about.html" title="">About</a></li>
                    <li><a href="contact.html" title="">Contact</a></li>
                    -->

                    <c:if test="${not empty DoctorInfo}">
                        <a href="" title="" class="">我的信息</a>
                        <ul class="sub-menu">

                        </ul>
                    </c:if>

                </ul> <!-- end s-header__nav -->

            </nav> <!-- end s-header__nav-wrap -->

        </div> <!-- end s-header__navigation -->



    </header> <!-- end s-header -->


    <!-- # site-content
    ================================================== -->
    <div id="content" class="s-content s-content--page">
        <div class="comments-wrap">
            <div class="comment-respond">
                <!-- START respond -->
                <div id="respond">
                    <h3>
                        增加科室
                    </h3>

                    <form name="contactForm" id="contactForm" method="post" action="<%=request.getContextPath()%>/backend/addDepartmentServlet" autocomplete="off">
                        <input type="hidden" name="plevel" value="${plevel}"/>
                        <input type="hidden" name="pid" value="${pid}"/>
                        <fieldset class="row">

                            <div class="column lg-6 tab-12 form-field">
                                <input name="departmentName" class="u-fullwidth h-remove-bottom" placeholder="科室名称" type="text">
                            </div>

                            <div class="column lg-12 message form-field">
                                <textarea name="departmentDesc" class="u-fullwidth" placeholder="科室信息"></textarea>
                            </div>

                            <div class="column lg-12">
                                <input name="submit" class="btn btn--primary btn-wide btn--large u-fullwidth" value="提交" type="submit">
                            </div>

                        </fieldset>
                    </form> <!-- end form -->

                </div>
                <!-- END respond-->

            </div> <!-- end comment-respond -->

        </div> <!-- end comments-wrap -->

    </div>


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
</body>
</html>
