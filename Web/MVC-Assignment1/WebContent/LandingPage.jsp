<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="Model.GenericTextModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Landing Page</title>
</head>
<body>

	<div class="header">
		<h1>Metacube Software Pvt. Ltd.</h1>
	</div>
	<div class="main">
		<h3>
			<%
				List<GenericTextModel> list = (List<GenericTextModel>) request
						.getAttribute("list");
				for (GenericTextModel str : list) {
					out.print(str.getDisplayData());
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
			%>
		</h3>
		<a
			href="./LandingController?page=EmployeeRegistrationPage">Register</a>
		&nbsp; &nbsp; &nbsp; &nbsp; <a
			href="./LandingController?page=EmployeeListPage">List
			of Employees</a>
	</div>
</body>
</html>