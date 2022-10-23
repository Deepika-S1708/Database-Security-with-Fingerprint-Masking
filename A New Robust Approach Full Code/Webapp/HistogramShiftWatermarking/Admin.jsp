<!DOCTYPE HTML>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Hsw</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<script src="js/jquery.min.js" type="text/javascript"></script>
		<script>
		function validateForm()
		{
		 	 var validname=document.getElementById("username").value;
			 var password=document.getElementById("password").value;
			 
			if(validname=="")
			{
			 alert("Not a valid name");r
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
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt="LOGO" height="52" width="362"></a>
			</div>
			<ul class="navigation">
				<li>
					<a href="index.jsp">Home</a>
				</li>
				
				<li>
					<a href="registration.jsp">Sign Up</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="contents" >
		<div class="clearfix" >
			<div class="sidebar">
				<div>
					<h2>Information Security</h2>
					<img src="images/userlogin.png" height="100" width="100">
					 <marquee behavior="scroll" direction="up" scrolldelay="300" style="color: blue;">
					<li>Confidentiality: This means that information is only being seen or used by people who are authorized to access it.</li>
					<br/><li>Integrity: This means that any changes to the information by an unauthorized user are impossible (or at least detected), and changes by authorized users are tracked.</li>
					<br/><li>Availability: This means that the information is accessible when authorized users need it.</li>
					 </marquee>
				</div>
			</div>
			<div class="loginmain">
				<h1>Admin Sign In</h1>
				
				 <div class="right">
		<%
		String status1 = (String)request.getAttribute("status");
		if(status1!=null)
			{%>
			<span><%= status1%></span><%	
			}
		%>
			</div>	
			
				 <form name="f1" class="message" method="get" onsubmit="return validateForm()">
					<label>Username</label>
					<input type="text" name="username" id="username"/> 
					<label>Password</label>
					<input type="password" name="password" id="password"/> 
					<input type="submit" value="Sign IN">
				</form>
				
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="footnote">
			<div class="clearfix">
				<div class="connect">
					<a href="http://freewebsitetemplates.com/go/facebook/" class="facebook"></a><a href="http://freewebsitetemplates.com/go/twitter/" class="twitter"></a><a href="http://freewebsitetemplates.com/go/googleplus/" class="googleplus"></a><a href="http://pinterest.com/fwtemplates/" class="pinterest"></a>
				</div>
				<p>
					© Copyright 2023 Manes Winchester. All Rights Reserved.
				</p>
			</div>
		</div>
	</div>
</body>
</html>