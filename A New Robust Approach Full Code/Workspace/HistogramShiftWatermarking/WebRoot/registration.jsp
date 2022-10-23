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
			 var validmail=document.getElementById("mailid").value;
			  var password=document.getElementById("password").value;
			 var validaddress=document.getElementById("address").value;
			 var cnfpassword=document.getElementById("cnfpassword").value;
			 
			var atpos=validmail.indexOf("@");
			var dotpos=validmail.lastIndexOf(".com");
			if(validname=="")
			{
				errmsg("idfn");
			 //alert("Not a valid name");
			 return false;
			 
			}
		   else if(validmail=="" || atpos==-1 || dotpos==-1)
			{
			  
				errmsg("idmail");
				return false;
			}else if(password=="")
			{
			 errmsg("idpass");
			 return false;
			 
			}
			else if(cnfpassword=="")
			{
			 errmsg("cnpass");
			 return false;
			 
			}
			else if(cnfpassword!=password)
			{
				passmismatch();
				return false;
			}
		   else if(validaddress=="")
			{
				 errmsg("idadd");
				return false;
			}
		   		
		   else 
		     {
		 		 document.f1.action="register";
				 document.f1.submit();
			 }
		}
		function errmsg(id)
		{
			document.getElementById("idfn").style.color="#555555";
			document.getElementById("idmail").style.color="#555555";
			document.getElementById("idpass").style.color="#555555";
			document.getElementById("cnpass").style.color="#555555";
			document.getElementById("idadd").style.color="#555555";
			var elm=document.getElementById(id);
			elm.style.color='red';
		}
		function passmismatch()
		{
			document.getElementById("idpass").style.color="red";
			document.getElementById("cnpass").style.color="red";
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
            <div id="content">
            <%
		String status1 = "";
            if((String)request.getAttribute("status")!=null)
			{
            	status1=(String)request.getAttribute("status");
			}
		%>
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <!-- Register Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <form class="signup-page" name="f1" class="message" method="post"  onsubmit="return validateForm()">
                                    <h4> <a>Register a new account</a></h4>
                                    <p>Already a member? Click
                                        <a href="index.jsp">HERE</a> to login to your account.</p>
                                <label id="idfn">First Name</label>&nbsp;<label id="resmsg" style="color: red;"><%= status1%></label>
                                <input class="form-control margin-bottom-20" type="text" name="username" id="username">
                                <label id="idmail">Email Address
                                    <span class="color-red">*</span>
                                </label>
                                <input class="form-control margin-bottom-20" type="text" name="mailid" id="mailid">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <label id="idpass">Password
                                            <span class="color-red">*</span>
                                        </label>
                                        <input class="form-control margin-bottom-20" type="password" name="password" id="password">
                                    </div>
                                    <div class="col-sm-6">
                                        <label id="cnpass">Confirm Password
                                            <span class="color-red">*</span>
                                        </label>
                                        <input class="form-control margin-bottom-20" type="password" name="cnfpassword" id="cnfpassword">
                                    </div>
                                </div>
                                 <label id="idadd">Address</label>
                                <input class="form-control margin-bottom-20" type="text" name="address" id="address">
                                <hr>
                                <div class="row">
                                    <div class="col-lg-8">
                                    </div>
                                    <div class="col-lg-4 text-right">
                                        <button class="btn btn-primary" type="submit" id="submitBut">Register</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- End Register Box -->
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