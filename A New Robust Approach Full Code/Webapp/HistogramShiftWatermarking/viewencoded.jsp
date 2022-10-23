<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=((String)request.getParameter("username")!=null?(String)request.getParameter("username"):"");
String userid=((String)request.getParameter("userid")!=null?(String)request.getParameter("userid"):"");
String status="";
status = (String)request.getAttribute("PARTITION");
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
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
 
        
<script type="text/javascript">
function val(x)
{
	
	
	if(x=="view")
		{
		document.viewrecord.action="viewrecords1";
		document.viewrecord.submit();
		}
	else if(x=="embed")
		{
		document.embedrecords.action="viewemb";
		document.embedrecords.submit();
		}
	
}
</script>
</head>
    <body>
    <form action="viewemb2" method="post" name="embedrecords">
     <input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
 </form>
<form action="viewrecords1" method="post" name="viewrecord">
 <input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
 </form>
        <div id="body-bg">
            <!-- Phone/Email -->
            <div id="pre-header" class="background-gray-lighter">
                <div class="container no-padding">
                    <div class="row hidden-xs">
                        <div class="col-sm-6 padding-vert-5">
                            <h4> <a>Hi <%= username%>..!</a></h4>
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
                                        <a href="home.jsp" class="fa-home active">Home</a>
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
            <div id="content">
                <div class="container background-white">
                    <div class="row margin-vert-30">
                        <div class="col-md-12">
                            <h2>Watermark Embedding</h2>&nbsp; <label id="resmsg" style="color: red;"><%= status%></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 portfolio-group no-padding">
                            <!-- Portfolio Item -->
                            <div class="col-md-3 portfolio-item margin-bottom-40 code">
                                <div onclick="val('view')">
                                        <figure >
                                            <img src="images/Report_summary.png" alt="image1" >
                                            <figcaption>
                                                <h3 class="margin-top-20">View Record</h3>
		                                              <span>Generated Numeric report Summary has user can able to view here.</span>
                                            </figcaption>
                                        </figure>
                                </div>
                            </div>
                            <div class="col-md-3 portfolio-item margin-bottom-40 code">
                                <div onclick="val('embed')">
                                        <figure >
                                            <img src="images/decode.jpg" alt="image1" >
                                            <figcaption>
                                                <h3 class="margin-top-20">View Embeded Records </h3>
		                                              <span>Generated Numeric report Summary has user can able to view here.</span>
                                            </figcaption>
                                        </figure>
                                </div>
                            </div>
                            <!-- End Portfolio Item -->
                           
                           
                            <!-- End Portfolio Item -->
                           </div>
                    </div>
                </div>
                
         <div class="table100 ver2 m-b-110" style="padding-left:2%;height: 500px;overflow: auto;">
		 <table data-vertable="ver2">
      <thead>
	      <tr class="row100 head">
		<th>SNO</th><th>YEAR</th><th>STAFF</th><th>MATERIAL</th><th>DAMAGE</th><th>PROJECTSCOUNT</th>
		<th>CUSTOMER</th><th>BRANCHES</th><th>RENTALEXPENSES</th><th>	SALARYAMOUNT_PA</th><th>OTHER_EXPENSES_PA</th><th>ANNUALTURNOVER</th><th>PROFITLOSS</th>
		</tr></thead>	 <%
			Vector st=(Vector)request.getAttribute("list");
      
      if(st!=null)
		{
		System.out.println("testing......");
		for(int i=0;i<st.size();i++)
		{
		Vector temp=new Vector();
		temp=(Vector)st.get(i);
		
		%>
		<tr class="row100"><td><%=temp.get(0)%></td><td><%=temp.get(1)%></td><td><%=temp.get(2)%></td><td><%=temp.get(3)%><td><%=temp.get(4)%></td><td><%=temp.get(5)%></td><td><%=temp.get(6)%></td><td><%=temp.get(7)%></td><td><%=temp.get(8)%></td><td><%=temp.get(9)%></td><td><%=temp.get(10)%></td><td><%=temp.get(11)%></td><td><%=temp.get(12)%></td></tr>
		<%
		}
		}
		
	%>
		 </table>						
	 
		 
		 <%//ServletContext con1=getServletContext();
		String status1 = (String)request.getAttribute("status");
		if(status1!=null)
			{%>
			<span><%= status1%></span><%	
			}
		%>
		
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