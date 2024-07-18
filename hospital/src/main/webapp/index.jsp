<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=request.getContextPath()%>/css/styleindex.css" rel="stylesheet" type="text/css" media="all" />
    <link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/login.js"></script>
</head>
<body>
<div class="index-banner">
    <div class="header-top">
        <div class="wrap">

            <div class="menu">


                <script type="text/javascript">
                    var $ = jQuery.noConflict();
                    $(function() {
                        $('#activator').click(function(){
                            $('#box').animate({'top':'0px'},500);
                        });
                        $('#boxclose').click(function(){
                            $('#box').animate({'top':'-700px'},500);
                        });
                    });
                    $(document).ready(function(){

                        //Hide (Collapse) the toggle containers on load
                        $(".toggle_container").hide();

                        //Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
                        $(".trigger").click(function(){
                            $(this).toggleClass("active").next().slideToggle("slow");
                            return false; //Prevent the browser jump to the link anchor
                        });

                    });
                </script>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="wmuSlider example1">
        <article style="position: absolute; width: 100%; opacity: 0;">
            <div class="banner-wrap">
                <div class="cont span_2_of_3">
                    <h1>用心守护健康，专业铸就生命<br> 您的健康，我们的承诺</h1>

                </div>
            </div>
        </article>
        <article style="position: absolute; width: 100%; opacity: 0;">
            <div class="banner-wrap">
                <div class="cont span_2_of_3">
                    <h1>精湛医术，贴心服务<br>为您的健康保驾护航</h1>
                </div>
            </div>
        </article>
    </div>
    <script src="js/jquery.wmuSlider.js"></script>
    <script>
        $('.example1').wmuSlider();
    </script>
</div>
<div class="main">
    <div class="content-top">
        <div class="section1">
            <div class="cont1 span_2_of_about">
                <h3 class="m_1"><a href="<%=request.getContextPath()%>/patientLoginServlet">开启医疗服务</a></h3>
            </div>
            <div class="rsidebar span_1_of_about">
                <a href="<%=request.getContextPath()%>/login.jsp"><div class="btn">后台登录</div></a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="content-bottom">

    </div>
</div>
</div>
</div>

</body>
</html>