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
                            <a href="" title="" class="">医生管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/addDoctorViewServlet">新增医生</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet">医生信息列表</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">科室管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/rootDepartmentServlet">新增科室</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/departmentListServlet">科室列表</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">患者住院管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/patientListServlet">患者住院安排</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/hospitalizationListServlet">住院信息</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">栏目管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/rootAnnouncementServlet">发布公告</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/announcementListServlet">内容管理</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty AdminInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">排班管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/ScheduleListServlet">排班列表</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/rootScheduleServlet">排班安排</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <!--
                    <li><a href="styles.html" title="">Styles</a></li>
                    <li class="current-menu-item"><a href="about.html" title="">About</a></li>
                    <li><a href="contact.html" title="">Contact</a></li>
                    -->

                    <c:if test="${not empty DoctorInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">个人信息管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/currentDoctorInfoServlet?jobNumber=${jobNumber}">我的信息</a></li>
                                <li><a href="<%=request.getContextPath()%>/backend/doctorListServlet">医生信息列表</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty DoctorInfo}">
                        <li class="has-children">
                            <a href="" title="" class="">病人管理</a>
                            <ul class="sub-menu">
                                <li><a href="<%=request.getContextPath()%>/backend/rootAddConsultationServlet?jobNumber=${jobNumber}">就诊管理</a></li>
                            </ul>
                        </li>
                    </c:if>

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
                    <header class="entry__header entry__header--narrow">
                        <h1 class="entry__title">
                            欢迎，${adminUsing}<br>祝您工作顺利！
                        </h1>
                    </header>

                    <div class="entry__media">
                        <figure class="featured-image">
                            <img src="<%=request.getContextPath()%>/images/thumbs/about/welcome.png">
                        </figure>
                    </div>

                    <div class="content-primary">
                        <div class="entry__content">
                            <p class="lead">
                                不要温和地走进那个良宵。<br>
                                白昼将尽，暮年仍应燃烧咆哮。<br>
                                怒斥吧，怒斥光的消逝。<br>
                                Do not go gentle into that good night.<br>
                                Rage, rage against the dying of the light.
                            </p>

                            <div class="row block-lg-one-half block-tab-whole">
                                <div class="column">
                                    <p class="drop-cap">
                                        我用什么才能留住你<br>
                                        我给你瘦落的街道、绝望的落日、荒郊的月亮。<br>
                                        我给你一个久久地望着孤月的人的悲哀。<br>
                                        我给你我已死去的祖辈，后人们用大理石祭奠的先魂。<br>
                                        我父亲的父亲，阵亡于布宜诺斯艾利斯的边境，<br>两颗子弹射穿了他的胸膛，死的时候蓄着胡子，尸体被士兵们用牛皮裹起；<br>
                                        我母亲的祖父——那年才二十四岁——<br>在秘鲁率领三百人冲锋，如今都成了消失的马背上的亡魂。<br>
                                        我给你我的书中所能蕴含的一切悟力，以及我生活中所能有的男子气概和幽默。<br>
                                        我给你一个从未有过信仰的人的忠诚。
                                    </p>
                                </div>
                                <div class="column">
                                    <p>
                                        我给你我设法保全的我自己的核心——<br>
                                        不营字造句，不和梦交易，不被时间、欢乐和逆境触动的核心。<br>
                                        我给你早在你出生前多年的一个傍晚看到的一朵黄玫瑰的记忆。<br>
                                        我给你关于你生命的诠释，关于你自己的理论，你的真实而惊人的存在。<br>
                                        我给你我的寂寞、我的黑暗、我心的饥渴；我试图用困惑、危险、失败来打动你。
                                    </p>
                                </div>
                            </div>
                        </div> <!-- end content-primary -->
                    </div>
                </article> <!-- end entry -->

            </div>
        </div> <!-- end entry-wrap -->

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
