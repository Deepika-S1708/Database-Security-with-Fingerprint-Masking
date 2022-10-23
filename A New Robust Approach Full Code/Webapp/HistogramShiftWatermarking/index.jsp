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
        <script>
		function validateForm()
		{
		 	 var validname=document.getElementById("username").value;
			 var password=document.getElementById("password").value;
			 
			if(validname=="")
			{
			 alert("Not a valid name");
			 return false;
			 
			}
				
		   else if(password=="")
			{
				alert("Enter Password");
				return false;
			}
		   else 
		     {
		 		 document.f1.action="adminlogin";
				 document.f1.submit();
			 }
		}
	</script>
    </head>
    <body>
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Top Menu -->
            <!-- === END HEADER === -->
            <!-- === BEGIN CONTENT === -->
            <%
		String status1 =(null!=(String)request.getAttribute("status")?(String)request.getAttribute("status"):"");
		%>
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <!-- Login Box -->
                            <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                                 <form class="login-page" name="f1" class="message" method="get" onsubmit="return validateForm()">
                                        <h4> <a>Login to your account </a></h4>&nbsp;<label id="resmsg" style="color: red;"><%= status1%></label>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user"></i>
                                        </span>
                                        <input placeholder="Username" class="form-control" type="text" name="username" id="username">
                                    </div>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                        <input placeholder="Password" class="form-control" type="password" name="password" id="password">
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                          </div>
                                        <div class="col-md-6">
                                            <button class="btn btn-primary pull-right" type="submit">
                                            <i class="fa-sign-in"></i>Sign In
                                            </button>
                                        </div>
                                    </div>
                                    <hr>
                                    <p>
                                    <h4>New Member? <i class="fa-group"></i> <a href="registration.jsp">Sign Up</a></h4>
                                    </p>
                                </form>
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
            <!-- End JS -->
    </body>
</html>
<!-- === END FOOTER === -->