<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=((String)session.getAttribute("username")!=null?(String)session.getAttribute("username"):"");
String userid=((String)session.getAttribute("userid")!=null?(String)session.getAttribute("userid"):"");
request.setAttribute("username",username);
request.setAttribute("userid",userid);
String status="";
status = ((String)request.getAttribute("status")!=null?(String)request.getAttribute("status"):"");
%>
<!-- === BEGIN HEADER === -->
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <!-- Title -->
        <title>HSW</title>
        <!-- Meta -->
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <!-- Favicon -->
        <link href="favicon.ico" rel="shortcut icon">
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.css" rel="stylesheet">
        <!-- Template CSS -->
        <link rel="stylesheet" href="assets/css/animate.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/nexus.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/responsive.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/custom.css" rel="stylesheet">
        <!-- Google Fonts-->
        <script type="text/javascript">
        
        function val(x)
        {
        	document.f1.action="Managemodule";
        	document.f1.module.value=x;
			document.f1.submit();
        }
        </script>
    </head>
    <body>
    <form action="Managemodule" method="post" name="f1">
    <input type="hidden" name="module"/>
     <input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
    </form>
        <div id="body-bg">
            <!-- Phone/Email -->
            <div id="pre-header" class="background-gray-lighter">
               <div class="container no-padding">
                    <div class="row hidden-xs">
                        <div class="col-sm-6 padding-vert-5">
                            <h4> <a>Hi <%= username%>..!</a></h4><label id="resmsg" style="color: red;"><%= status%></label>
                        </div>
                        <div class="col-sm-6 text-right padding-vert-5">
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Phone/Email -->
            <!-- Header -->
            <div id="header">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div class="logo">
                            <a  title="">
                                <img src="assets/img/logo.png" alt="Logo" />
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>
                </div>
            </div>
            <!-- End Header -->
            <!-- Top Menu -->
            <div id="hornav" class="bottom-border-shadow">
                <div class="container no-padding border-bottom">
                    <div class="row">
                        <div class="col-md-8 no-padding">
                            <div class="visible-lg">
                                <ul id="hornavmenu" class="nav navbar-nav">
                                    <li>
                                        <a href="home.jsp" class="fa-home active">Home</a>
                                    </li>
                                    <li>
                                        <a onclick="val('module1')" class="fa-caret-right" style="cursor: pointer">Phase-I & II</a>
                                    </li>
                                    <li>
                                        <a onclick="val('module3')" class="fa-caret-right" style="cursor: pointer">Phase-III</a>
                                    </li>
                                    <li>
                                        <a href="index.jsp" class="fa-sign-out ">Logout</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Top Menu -->
            <!-- === END HEADER === -->
            <!-- === BEGIN CONTENT === -->
            <div id="slideshow" class="bottom-border-shadow">
                <div class="container no-padding background-white bottom-border">
                    <div class="row">
                        <!-- Carousel Slideshow -->
                        <div id="carousel-example" class="carousel slide" data-ride="carousel">
                            <!-- Carousel Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example" data-slide-to="1"></li>
                                <li data-target="#carousel-example" data-slide-to="2"></li>
                            </ol>
                            <div class="clearfix"></div>
                            <!-- End Carousel Indicators -->
                            <!-- Carousel Images -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="assets/img/slideshow/slide1.jpg">
                                </div>
                                <div class="item">
                                    <img src="assets/img/slideshow/slide2.jpg">
                                </div>
                                <div class="item">
                                    <img src="assets/img/slideshow/slide3.jpg">
                                </div>
                                <div class="item">
                                    <img src="assets/img/slideshow/slide4.jpg">
                                </div>
                            </div>
                            <!-- End Carousel Images -->
                            <!-- Carousel Controls -->
                            <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                            <!-- End Carousel Controls -->
                        </div>
                        <!-- End Carousel Slideshow -->
                    </div>
                </div>
            </div>
            <div id="icons" class="bottom-border-shadow">
                <div class="container background-grey bottom-border">
                    <div class="row padding-vert-60">
                        <!-- Icons -->
                        <div class="col-md-4 text-center">
                            <i class="fa-pencil-square-o fa-4x color-primary animate fadeIn"></i>
                            <h3 class="padding-top-10 animate fadeIn">Watermark Preprocessing</h3>
                            <p class="animate fadeIn">The purpose of data preprocessing is to make
							the watermark insertion/reading independent of the way
							the database is stored.</p>
                        </div>
                        <div class="col-md-4 text-center">
                            <i class="fa-cloud-download fa-4x color-primary animate fadeIn"></i>
                            <h3 class="padding-top-10 animate fadeIn">Watermark Embedding</h3>
                            <p class="animate fadeIn">Histogram expansion algorithm is
							improved to embed one symbol of message into numerical
							attributes for each group of tuples.</p>
                        </div>
                        <div class="col-md-4 text-center">
                            <i class="fa-bar-chart fa-4x color-primary animate fadeIn"></i>
                            <h3 class="padding-top-10 animate fadeIn">Extraction and Data Recovery</h3>
                            <p class="animate fadeIn">Embedded watermark and
								recover the original database, attribute sorting is performed
								in alphabetic order according to the attribute name in the
								database.</p>
                        </div>
                        <!-- End Icons -->
                    </div>
                </div>
            </div>
            <div id="content" class="bottom-border-shadow">
                <div class="container background-white bottom-border">
                    <div class="row margin-vert-30">
                        <!-- Main Text -->
                        <div class="col-md-6">
                            <h2>Welcome to Robust</h2>
                            <p>Many reversible watermarking methods are proposed recently to protect rights of owners along
								with recovering original data.</p>
                            <p>Most state-of-the-art methods modify the original data to a large extent, result in data quality degradation,
							and cannot achieve good balance between robustness against malicious attacks and data recovery</p>
	                        </div>
                        <!-- End Main Text -->
                        <div class="col-md-6">
                            <h3 class="padding-vert-10">Key Features</h3>
	                            <p>The main focus of watermark embedding phase is to
							    embed watermark information in such a way that ensures
								the usability and the imperceptibility of the watermarked
								database.</p>
                            <ul class="tick animate fadeInRight">
                                <li>sorting the attribute columns</li>
                                <li>determining the range of attribute values</li>
                                <li>calculating an approximately optimal secret key string with the help of GA</li>
                                <li>Histogram shifting</li>
                                <li>absolute value of prediction</li>
                                <li>HS using GA</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- === END CONTENT === -->
             <!-- === BEGIN FOOTER === -->
            <div id="base">
                <div class="container bottom-border padding-vert-30">
                    <div class="row">
                        <!-- Disclaimer -->
                        <div class="col-md-4">
                            <h3 class="class margin-bottom-10">GAHSW METHOD</h3>
                            <p>
                            Th genetic algorithm (GA) is an optimization technique inspired by the biological evolution process [33]. It is often used to solve optimization and search problems. GA
							uses a collection of data structures called chromosomes,which provides a possible solution for the problem.
						</p>
                        </div>
                        <!-- End Disclaimer -->
                        <!-- Contact Details -->
                        <div class="col-md-4">
                            <h3 class="margin-bottom-10">HISTOGRAM SHIFTING</h3>
                            <p>
							HS uses the peak value of the histogram to hide watermark information. In
							terms of HS used in digital image reversible watermarking,the gray value corresponding to the peak value of the
							histogram is used to expand, and the gray values ranging from the peak to zero are used to shift.
							</p>
                        </div>
                        <!-- End Contact Details -->
                        <!-- Sample Menu -->
                        <div class="col-md-4">
                            <h3 class="margin-bottom-10">PHASES</h3>
                            <ul class="menu">
                                <li>
                                    <a class="fa-tasks">Watermark Preprocessing</a>
                                </li>
                                <li>
                                    <a class="fa-users">Watermark Embedding</a>
                                </li>
                                <li>
                                    <a class="fa-signal">Watermark Extraction</a>
                                </li>
                                <li>
                                    <a class="fa-coffee">Data Recovery</a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <!-- End Sample Menu -->
                    </div>
                </div>
            </div>
            <!-- Footer -->
            <div id="footer" class="background-grey">
                <div class="container">
                    <div class="row">
                        <!-- Footer Menu -->
                        <!-- End Footer Menu -->
                        <!-- Copyright -->
                        <div id="copyright" class="col-md-4">
                            <p class="pull-right">(c) 2018 Your Copyright Info</p>
                        </div>
                        <!-- End Copyright -->
                    </div>
                </div>
            </div>
            <!-- End Footer -->
            <!-- JS -->
            <script type="text/javascript" src="assets/js/jquery.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="assets/js/bootstrap.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="assets/js/scripts.js"></script>
            <!-- Isotope - Portfolio Sorting -->
            <script type="text/javascript" src="assets/js/jquery.isotope.js" type="text/javascript"></script>
            <!-- Mobile Menu - Slicknav -->
            <script type="text/javascript" src="assets/js/jquery.slicknav.js" type="text/javascript"></script>
            <!-- Animate on Scroll-->
            <script type="text/javascript" src="assets/js/jquery.visible.js" charset="utf-8"></script>
            <!-- Sticky Div -->
            <script type="text/javascript" src="assets/js/jquery.sticky.js" charset="utf-8"></script>
            <!-- Slimbox2-->
            <script type="text/javascript" src="assets/js/slimbox2.js" charset="utf-8"></script>
            <!-- Modernizr -->
            <script src="assets/js/modernizr.custom.js" type="text/javascript"></script>
            <!-- End JS -->
    </body>
</html>
<!-- === END FOOTER === -->