<%@page import="com.metacube.carportal.dbconfig.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.metacube.carportal.db.helper.CarPortalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Portal</title>
</head>
<body>
<%
Connection connection=new ConnectionFactory().createConnection();
CarPortalDao carPortalDao=new CarPortalDao(connection);
carPortalDao.insertIntoTableDefaultCar(connection);

RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response);
%>
</body>
</html>