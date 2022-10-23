<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Hsw</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script>
	<style type="text/css">
	#loginmodal {
  width: 300px;
  padding: 15px 20px;
  background: #f3f6fa;
  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;
  -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
  -moz-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
}

#lean_overlay {
    position: fixed;
    z-index:100;
    top: 0px;
    left: 0px;
    height:100%;
    width:100%;
    background: #000;
    display: none;
}
	
	</style>
<script type="text/javascript">
function val(x)
{
	
	
	if(x=="viewencode")
		{
		document.userencode.action="userviewemb";
		document.userencode.submit();
		}
	
}
</script>

<script type="text/javascript">
$(function(){


  $('#modaltrigger').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
});
</script>

</head>
<body>

<form action="decode" method="post"></form>
<form action="userviewemb" method="post" name="userencode"></form>
<div id="loginmodal" style="display:none;">
    <h1>Proove your Ownership</h1>
    <form id="loginform" name="loginform" action="decoding" method="post">
      <label for="OWNERSHIP">OWNERSHIP:</label>
      <input type="text" name="ownership" id="ownership" class="txtfield" tabindex="1">
      <div class="center"><input type="submit"/></div>
    </form>
  </div>
  
  
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<a><img src="images/logo.png" alt="LOGO" height="52" width="362"></a>
			</div>
			<ul class="navigation">
				<li>
					<a onclick="val('viewencode')" >View Encode Records</a>
				</li>
				<li>
					<a href="#loginmodal" id="modaltrigger">Decode Records</a>
				</li>
				<li>
					<a href="index.jsp">Logout</a>
				</li>
			</ul>
		</div>
	</div>
	
	<%System.out.println("jsppage working"); %>
       <%//ServletContext con1=getServletContext();
		String status = (String)request.getAttribute("PARTITION");
		if(status!=null)
			{%>
			<span><font color="green"><%= status%></font></span><%	
			}
		%>
		
	<div id="contents">
		<div id="adbox">
			<div class="clearfix">
				<img src="images/family-large.jpg" alt="Img" height="382" width="594">
				<div class="detail">
					<h1>There are no secrets<br> better kept than the secrets that everybody guesses.</h1>
				</div>
			</div>
		</div>
		
			<div style="width: 1200px;height: 500px;overflow: auto;">
		
 <table border="1px solid black">
   <th><font color="black">SNO</font></th><th><font color="black">YEAR</font></th><th><font color="black">STAFF</font></th><th><font color="black">VECHICLE</font></th><th><font color="black">MATERIAL</font></th><th><font color="black">DAMAGE</font></th><th><font color="black">CUSTOMER</font></th><th><font color="black">BRANCHES</font></th><th><font color="black">RENTALEXPENSES(CRORES)</font></th><th><font color="black">	SALARYAMOUNT_PA(CRORES)</font></th><th><font color="black">OTHER_EXPENSES_PA(CR)</font></th><th><font color="black">ANNUALTURNOVER(CRORES)</font></th><th><font color="black">PROFITLOSS</font></th>
	
			 <%
			Vector st=(Vector)request.getAttribute("list");
      
      if(st!=null)
		{
		System.out.println("testing......");
	
		for(int i=0;i<st.size();i++)
		{
		Vector temp=new Vector();
		temp=(Vector)st.get(i);
		
		
		%>
			
		<tr><td><font color="black"><%=temp.get(0)%></font></td><td><font color="black"><%=temp.get(1)%></font></td><td><font color="black"><%=temp.get(2)%></font></td><td><font color="black"><%=temp.get(3)%></font><td><font color="black"><%=temp.get(4)%></font></td><td><font color="black"><%=temp.get(5)%></font></td><td><font color="black"><%=temp.get(6)%></font></td><td><font color="black"><%=temp.get(7)%></font></td><td><font color="black"><%=temp.get(8)%></font></td><td><font color="black"><%=temp.get(9)%></font></td><td><font color="black"><%=temp.get(10)%></font></td><td><font color="black"><%=temp.get(11)%></font></td><td><font color="black"><%=temp.get(12)%></font></td></tr>
		<%
		}
		}
		
	%>
		 </table>		
		
		
		</div>
		
		<div class="highlight">
			<div class="clearfix">
				<div class="testimonial">
					<h2>Histogram Shifting</h2>
					<p>
					HS uses the peak value of the histogram to hide watermark information. In
					terms of HS used in digital image reversible watermarking,the gray value corresponding to the peak value of the
					histogram is used to expand, and the gray values ranging from the peak to zero are used to shift.
					</p>
				</div>
				<h1>Genetic algorithm</h1>
				<p>
					Th genetic algorithm (GA) is an optimization technique inspired by the biological evolution process [33]. It is often used to solve optimization and search problems. GA
					uses a collection of data structures called chromosomes,which provides a possible solution for the problem.
				</p>
			</div>
		</div>
		<div class="featured">
			<h2>GAHSW METHOD</h2>
			<ul class="clearfix">
				<li>
					<div class="frame1">
						<div class="box">
							<img src="images/meeting.jpg" alt="Img" height="130" width="197">
						</div>
					</div>
					<p>
						<b>Watermark Preprocessing</b>Data preprocessing is needed before embedding watermark information.nu = H(Ks|H(Ks|tu.PK)) mod Ng
					</p>
					<p class="more">Read More</p>
				</li>
				<li>
					<div class="frame1">
						<div class="box">
							<img src="images/handshake.jpg" alt="Img" height="130" width="197">
						</div>
					</div>
					<p>
						<b>Watermark Embedding</b>GA outputs the best secret key for grouping in the preprocessing phase Each group will be embedded with 1-bit watermark using HS.
					</p>
					<p class="more">Read More</p>
				</li>
				<li>
					<div class="frame1">
						<div class="box">
							<img src="images/smile.jpg" alt="Img" height="130" width="197">
						</div>
					</div>
					<p>
						<b>HS using GA</b>GA is populated with a fitness
						function to obtain an optimal modification of data that can
						ensure data quality when embedding the watermark.
					</p>
					<p class="more">Read More</p>
				</li>
				<li>
					<div class="frame1">
						<div class="box">
							<img src="images/family-small.jpg" alt="Img" height="130" width="197">
						</div>
					</div>
					<p>
						<b>Extraction and Data Recovery</b>Extract the embedded watermark and recover the original database,attribute sorting is performed
					in alphabetic order...
					</p>
					<p class="more">Read More</p>
				</li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<div id="footnote">
			<div class="clearfix">
				<div class="connect">
				</div>
				<p>
					© Copyright 2018. All Rights Reserved.
				</p>
			</div>
		</div>
	</div>
</body>
</html>