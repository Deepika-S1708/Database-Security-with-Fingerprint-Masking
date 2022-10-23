<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=((String)request.getParameter("username")!=null?(String)request.getParameter("username"):"");
String userid=((String)request.getParameter("userid")!=null?(String)request.getParameter("userid"):"");
String status="";
status = ((String)request.getParameter("FETCH")!=null?(String)request.getParameter("FETCH"):"");
status = ((String)request.getParameter("status")!=null?(String)request.getParameter("status"):"");
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
	 if(x=="Threshold")
		{
		
		document.Threshold.action="datasetwatermark";
		document.Threshold.submit();
		}
	else if(x=="Tuple")
		{
		document.Tupleselect.action="tupleseselection";
		document.Tupleselect.submit();
		}
	 else if(x=="watermark")
		{
		document.WaterMark.action="embedding";
		document.WaterMark.submit();
		}
	else if(x=="binaryrec")
		{
		document.binaryrecord.action="binary";
		document.binaryrecord.submit();
		}
}

</script>

    </head>
    <body>
 <form action="datasetwatermark" method="post" name="Threshold">
 <input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
 </form>
<form action="tupleseselection" method="post" name="Tupleselect">
<input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
 </form>
<form action="binary" method="post" name="binaryrecord">
<input type="hidden" name="username" value="<%=username%>"/>
 <input type="hidden" name="userid" value="<%=userid%>"/>
 </form>
<form action="embedding" method="post" name="WaterMark">
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
                            <h2>WATERMARK PREPROCESSING</h2>&nbsp; <label id="resmsg" style="color: red;"><%= status%></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 portfolio-group no-padding">
                            <!-- Portfolio Item -->
                            <div class="col-md-3 portfolio-item margin-bottom-40 code">
                                <div onclick="val('Threshold')">
                                        <figure >
                                            <img src="images/Threshold.png" alt="image1" >
                                            <figcaption>
                                                <h3 class="margin-top-20">Secure Hash Algorithm</h3>
                                                <span>which
						is applied to the primary key of the tuple (tu.PK).</span>
                                            </figcaption>
                                        </figure>
                                </div>
                            </div>
                            <!-- End Portfolio Item -->
                            <!-- Portfolio Item -->
                            <div class="col-md-3 portfolio-item margin-bottom-40 video">
                                <div>
                                    <a onclick="val('Tuple')">
                                        <figure>
                                            <img src="images/rowselection.png" alt="image7" >
                                            <figcaption>
                                                <h3 class="margin-top-20">Tuple Selection</h3>
                                                <span>Each group will be
					embedded with 1-bit watermark using HS.</span>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </div>
                            </div>
                            <!-- End Portfolio Item -->
                            <!-- Portfolio Item -->
                            <div class="col-md-3 portfolio-item margin-bottom-40 audio">
                                <div>
                                    <a onclick="val('binaryrec')">
                                        <figure>
                                            <img src="images/binary.png" alt="image8" >
                                            <figcaption>
                                                <h3 class="margin-top-20">Convert Binary</h3>
                                                <span>Certain tuples in the
					group are increase of +1 or-1 under the distortion constraints.</span>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </div>
                            </div>
                            <!-- End Portfolio Item -->
                            <!-- Portfolio Item -->
                            <div class="col-md-3 portfolio-item margin-bottom-40 audio">
                                <div>
                                    <a onclick="val('watermark')">
                                        <figure>
                                            <img src="images/watermark.png" alt="image9" >
                                            <figcaption>
                                                <h3 class="margin-top-20">Histogram shifting</h3>
                                                <span>A single
							watermark bit is embedded into some tuples.</span>
                                            </figcaption>
                                        </figure>
                                    </a>
                                </div>
                            </div>
                            <!-- End Portfolio Item -->
                                                   </div>
                    </div>
                </div>
              <div class="table100 ver2 m-b-110" style="padding-left:2%;height: 500px;overflow: auto;">
		
		
		<%--	Data partition code start	--%>
		
		<%//ServletContext con1=getServletContext();
		 status = (String)request.getAttribute("PARTITION");
		if(status!=null)
			{%>
			<font color="DARKPINK" size="5"><%= status%><%	
			}
		%><br/>
      <table data-vertable="ver2">
      <%
			Vector st=(Vector)request.getAttribute("list");
      //System.out.println("vector received");
      if(st!=null)
		{
		//System.out.println("testing......");
		
		%>
		<thead><tr class="row100 head">
		<th>FIRST PARTITION PRIMAYKEYS</th><th>SECOND PARTITION PRIMAYKEYS</th><th>THIRD PARTITION PRIMAYKEYS</th><th>FOURTH PARTITION PRIMAYKEYS</th>
		</tr>
		</thead>
		<% 
		
		%>
		
		<tr class="row100"><td><%=st.get(0).toString().replace("[","").replace("]","")%></td><td><%=st.get(1).toString().replace("[","").replace("]","")%></td><td><%=st.get(2).toString().replace("[","").replace("]","")%></td><td><%=st.get(3).toString().replace("[","").replace("]","")%></td></tr>
		
		<%
		
		
		
		}
	%>
		
		
		 </table>				

		 
		 	  <%//ServletContext con1=getServletContext();
		String statusa = (String)request.getAttribute("PARTITIONa");
		if(statusa!=null)
			{%>
			<font color="DARKPINK" size="5"><%= statusa%><%	
			}
		%><BR/>	
     
      <table data-vertable="ver2">
      <%
			Vector sta=(Vector)request.getAttribute("lista");
    //  System.out.println("vector received");
      if(sta!=null)
		{
	//	System.out.println("testing......");
		
		%>
		<thead><tr class="row100 head">
		<th>FIRST PARTITION PRIMAYKEYS</th><th>SECOND PARTITION PRIMAYKEYS</th><th>THIRD PARTITION PRIMAYKEYS</th><th>FOURTH PARTITION PRIMAYKEYS</th>
		<tr></thead>
		<% 
		
		%>
		
		<tr class="row100"><td><%=sta.get(0).toString().replace("[","").replace("]","")%></td><td><%=sta.get(1).toString().replace("[","").replace("]","")%></td><td><%=sta.get(2).toString().replace("[","").replace("]","")%></td><td><%=sta.get(3).toString().replace("[","").replace("]","")%></td></tr>
		
		<%
		
		
		
		}
	%>
		
		
		 </table>		<BR/>		
		 
			
		  <%//ServletContext con1=getServletContext();
		String status1 = (String)request.getAttribute("PARTITION1");
		if(status1!=null)
			{%>
			<font color="DARKPINK" size="5"><%= status1%><%	
			}
		%>			<BR/>				
      
      
      <table data-vertable="ver2">
      <%
			Vector st1=(Vector)request.getAttribute("list1");
     // System.out.println("vector received");
      if(st1!=null)
		{
	//	System.out.println("testing......");
		
		%>
		<thead><tr class="row100 head">
		<th>FIRST GROUP PRIMAYKEYS</th><th>SECOND GROUP PRIMAYKEYS</th><th>THIRD GROUP PRIMAYKEYS</th><th>FOURTH GROUP PRIMAYKEYS</th>
		<tr></thead>
		<% 
		
		%>
		
		<tr class="row100"><td><%=st1.get(0).toString().replace("[","").replace("]","")%></td><td><%=st1.get(1).toString().replace("[","").replace("]","")%></td><td><%=st1.get(2).toString().replace("[","").replace("]","")%></td><td><%=st1.get(3).toString().replace("[","").replace("]","")%></td></tr>
		
		<%
		
		
		
		}
	%>
	 </table>		<BR/> 
	 
	  <%
		String status2 = (String)request.getAttribute("PARTITION2");
		if(status2!=null)
			{%>
			<font color="DARKPINK" size="5"><%= status2%><%	
			}
		%>			<BR/>			
      
      
      <table data-vertable="ver2">
      <%
			Vector st2=(Vector)request.getAttribute("list2");
     // System.out.println("vector received");
      if(st2!=null)
		{
		//System.out.println("testing......");
		
		%>
		<thead><tr class="row100 head">
		<th>FIRST GROUP PRIMAYKEYS</th><th>SECOND GROUP PRIMAYKEYS</th><th>THIRD GROUP PRIMAYKEYS</th><th>FOURTH GROUP PRIMAYKEYS</th>
		<tr></thead>
		<% 
		
		%>
		
		<tr class="row100"><td><%=st2.get(0).toString().replace("[","").replace("]","")%></td><td><%=st2.get(1).toString().replace("[","").replace("]","")%></td><td><%=st2.get(2).toString().replace("[","").replace("]","")%></td><td><%=st2.get(3).toString().replace("[","").replace("]","")%></td></tr>
		
		<%
		
		
		
		}
	%>
	 </table>
	
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