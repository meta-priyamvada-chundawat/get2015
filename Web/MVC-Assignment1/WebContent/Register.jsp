<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Employee"%>
<%@ page import="Model.GenericTextModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%!String name = "", email = "";
Date date=new Date();
	double age = 0;
	int id = 0;
	String submit = "Register";
	String action = "RegistrationController";%>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<title>Registeration Page3</title>
</head>
<body>
	<div class="header">
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
	</div>

	<%
		if (request.getAttribute("employeeDetails") != null) {
			Employee employee = (Employee) request
					.getAttribute("employeeDetails");
			id = employee.getEmployeeId();
			name = employee.getName();
			email = employee.getEmail();
			age = employee.getAge();
			date = employee.getDateOfRegistration();
			submit = "Update";
			action = "UpdateDetailsController";
		}
	%>

	<div class="content">
		<form action=<%=action%> method="get">

			<%
				if (request.getAttribute("employeeDetails") != null) {
			%>
			<div class="space">
				<label>Employee ID :</label> <input type='text' name="empid"
					required readonly="readonly" value="<%=id%>">
			</div>

			<%
				}
			%>

			<div class="space">
				<label>Name :</label> <input type="text" name="empname" required
					value="<%=name%>" />
			</div>
			<div class="space">
				<label>Email :</label> <input type="text" name="empemail" required
					value="<%=email%>" />
			</div>
			<div class="space">
				<label>Age :</label> <input type="text" name="empage" required
					value="<%=age%>" />
			</div>
			<div class="space">
				<label>Date :</label> <input type="text" name="empdate" readonly="readonly"
					value="<%=date%>" />
			</div>
			<div class="space">
				<div class="submit">
					<input type="submit" name="submit" value="<%=submit%>" />
				</div>
			</div>
		</form>

	</div>
</body>
</html>