<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Employee"%>
<%@page import="Model.GenericTextModel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail page</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div class="header">
		<h1>Metacube Software Pvt. Ltd.</h1>
	</div>
	<div class="main">
		<h1>
			<%
				List<GenericTextModel> list = (List<GenericTextModel>) request
						.getAttribute("list");
				for (GenericTextModel str : list) {
					out.print(str.getDisplayData());
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
			%>
		</h1>
		<%
			Employee employee = (Employee) request
					.getAttribute("employeeDetails");

			out.print("Details Of Employee ");
			out.write("<br><br>");
			out.print(employee.toString().replaceAll("\n", "<br>"));
		%>
	</div>
</body>
</html>