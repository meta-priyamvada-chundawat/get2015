<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<h1 align="center">Error Detail</h1>
	<div id="wrapper">

		<%if(request.getParameter("message")!=null){ %>
		
		<p align="center" class="error"><%=request.getParameter("message") %></p>
		
		<%} %>
	</div>
</body>
</html>