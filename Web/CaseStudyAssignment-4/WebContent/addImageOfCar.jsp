<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="false"%>

<%
	HttpSession session = request.getSession();
	session.setAttribute("make", request.getParameter("make"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Car Portal</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
	</head>
	<body>
		<header> 
		<br />
		<span id="logo">Car Portal</span> 
		<%
	 	if (session.getAttribute("username") != null) {
	 	%>
		<div id="user">
			<%=session.getAttribute("username")%>&nbsp;&nbsp;<a href="login.jsp"> Logout!!</a>
		</div>
		<%
			}
		%> 
		</header>
		<nav>
		<%
			if (session.getAttribute("username") != null) {
		%> 
		<a href="admin-home">Home</a> 
		<%
			}else{
		%>
		<a href="login.jsp">Login</a> 
		<%
			}
		%>
		<span class="space">
			<a href="#">About Us</a></span> 
		<span class="space">
			<a href="#">Contact Us</a></span> 
		</nav>
	
		<div class="link">
			<span class="space">
			<a href="searchCar.jsp">Search Car</a>
			</span>
			<br />
			<span class="space">
			<a href="editCar.jsp">Update Car Details</a>
			</span>
			<br />
		</div>
		<div class="content">
			<h2>Add New Car</h2>
			<br/>
			<%
				if (request.getParameter("message") != null) {
			%>
			<p class="message"><%=request.getParameter("message")%></p>
			<%
				}
			%>
			<div class="details">
	
				<form class="formclass" enctype="multipart/form-data" action="add-car" method="post">
					<span class="space">
						<label>Image Path:</label><input type="file" name="image_path" autofocus required />			
					</span>
					<div class="submit-design">
						<span class="space">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Upload Image" />
						</span>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>