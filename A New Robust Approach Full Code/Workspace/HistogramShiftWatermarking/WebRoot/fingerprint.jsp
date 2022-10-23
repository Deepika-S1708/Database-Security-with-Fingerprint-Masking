<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=((String)session.getAttribute("username")!=null?(String)session.getAttribute("username"):"");
String userid=((String)session.getAttribute("userid")!=null?(String)session.getAttribute("userid"):"");
String fp=((String)request.getAttribute("fingerprint")!=null?(String)request.getAttribute("fingerprint"):"");
String fpt=((String)request.getAttribute("fingertemplate")!=null?(String)request.getAttribute("fingertemplate"):"");
String cm=((String)request.getAttribute("but")!=null?(String)request.getAttribute("but"):"");
%>
<!-- === BEGIN HEADER === -->
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
     <base href="<%=basePath%>">
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
        <script type="text/javascript" src=fingerprint/jquery-1.8.2.js charset="utf-8"></script>
        <script type="text/javascript" src="fingerprint/mfs100-9.0.2.6.js" charset="utf-8"></script>
        <script type="text/javascript" src="fingerprint/fingerprint.js" charset="utf-8"></script>
        <!-- Google Fonts-->
        <style>
			 .div1 {
			    border: 1px solid black;
			    background:url(assets/img/fingerprint.png);
			    background-repeat: no-repeat;
			    background-size: contain;
			}
        </style>
        <script type="text/javascript">
        function uploadfp()
        {
        	var isotmp=document.getElementById("txtIsoTemplate").value;
        	if(cpdone==true && isotmp!=""){
        		 document.f1.action="Updatefingerprint";
        		 document.forms["f1"]["txttemplate"].value=isotmp;
				 document.f1.submit();
        	}else
       		{
       		alert("Finger Print Missing,Capture Again..!");
       		}
        	
        }
        function decoding()
        {
        	if(cmdone==true)
        		{
        		 document.loginform.action="decoding";
				 document.loginform.submit();
        		}else
       			{
       			 alert("Finger not matched");
       			 return false;
       			}
        }
        </script>
    </head>
    <body>
    <form id="loginform" name="loginform" action="decoding" method="post">
     <input type="hidden" name="username" value="<%=username%>"/>
 	<input type="hidden" name="userid" value="<%=userid%>"/>
 	 <input type="hidden" id="txtIsoTemplate" name="txttemplate" value="<%=fp%>"/>
    </form>
     <form  method="post" name="f1">
     <input type="hidden" value="<%= (String)request.getAttribute("username")%>" name="username"/>
    <input type="hidden" value="<%= (String)request.getAttribute("userid")%>" name="userid"/>
    <input type="hidden" id="txtIsoTemplate" name="txttemplate"/>
     </form>
        <div id="body-bg">
            <!-- Header -->
            <div id="header">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div class="logo">
                            <a title="">
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
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <!-- Login Box -->
                            <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                                <div class="login-page">
                                        <h4> <a>Hi <%= ((String)request.getAttribute("username")!=null?(String)request.getAttribute("username"):"")%> Update your finger Print..!</a></h4>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                         <img alt="" src="assets/img/fingerprint.gif" width="150" height="150"/>
                                          </div>
                                        <div class="col-md-6">
                                           <img alt="" src="assets/img/fingerprint.png" id="imgFinger" class="div1" width="150" height="150"/>
                                        </div>
                                    </div>
                                    <br/>
                                    <%if(cm!=null && cm.equals("CM")){ %>
                                    <div class="row">
                                        <div class="col-md-6">
                                          <button class="btn btn-primary pull-right" type="submit" id="btnCapture" onclick="return Match()">
                                            <i class="fa-camera"></i>Capture & Match
                                            </button>
                                          </div>
                                        <div class="col-md-6">
                                            <button class="btn btn-primary pull-right" type="submit" onclick="return decoding()">
                                            <i class="fa-cloud-upload"></i>Sign In
                                            </button>
                                        </div>
                                    </div>
                                    <%}else{ %>
                                    <div class="row">
                                        <div class="col-md-6">
                                          <button class="btn btn-primary pull-right" type="submit" id="btnCapture" onclick="return Capture()">
                                            <i class="fa-camera"></i>Capture
                                            </button>
                                          </div>
                                        <div class="col-md-6">
                                            <button class="btn btn-primary pull-right" type="submit" onclick="return uploadfp()">
                                            <i class="fa-cloud-upload"></i>Upload
                                            </button>
                                        </div>
                                    </div>
                                    <%} %>
                                    <hr>
                                </div>
                            </div>
                            <!-- End Login Box -->
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
            
             <input type="hidden" value="" id="txtImageInfo"/>
             
  			<input type="hidden" value="" id="txtStatus" />
		    <input type="hidden" id="txtAnsiTemplate"/> 
		    <input type="hidden" id="txtIsoImage"/>
		    <input type="hidden" id="txtRawData"/>
		    <input type="hidden" id="txtWsqData"/>
            <!-- End JS -->
    </body>
</html>
<!-- === END FOOTER === -->