<%@page import="com.metacube.carportal.dbconfig.ConnectionFactory"%>
<%@page import="com.metacube.carportal.db.helper.CarPortalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.*"%>



<%
session.setAttribute("username",null);%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Car Portal</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script
			src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="jquery-1.9.1.js"></script>
		<script type="text/javascript" src="scripts/scriptMain.js"></script>
	</head>

	<body>

		<header> 
		<br />
		<span id="logo">Car Portal</span> 
		</header>
	
		<div id="toppanel" style="z-index: 5">
			<div id="panel">
				<div class="content clearfix">
					<div class="left" style="width: 100%">
						<h2>Log In</h2>
						<form action="validate-admin" method="post">
							<input name="username" type="text" placeholder="Username" /><br />
							<input name="password" type="password" placeholder="Password" /><br />
							<input type="submit" value="LogIn" />
						</form>
						<%
							if (request.getParameter("message") != null) {
						%>
						<p class="message"><%=request.getParameter("message")%></p>
						<%
							}
						%>
					</div>
				</div>
			</div>
	
			<div class="tab">
				<ul class="login">
					<li class="left">&nbsp;</li>
					<li id="toggle">
					<span href="#" class="a" id="toggle-login">Log in</span>
					</li>
					<li class="right">&nbsp;</li>
				</ul>
			</div>
	
		</div>
	
		<nav> 
		<a href="login.jsp">Login</a> 
		<span class="space">
		<a href="#">About Us</a>
		</span> 
		<span class="space">
		<a href="#">Contact Us</a>
		</span> 
		</nav>
	
	
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
	
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="images/car1.jpg">
					<div class="carousel-caption">
						<h3>
							<font color="white">LUXURY CARS</font>
						</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/car2.jpg">
					<div class="carousel-caption">
						<h3>
							<font color="white">NEW AND SECOND HAND</font>
						</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/car3.jpg">
					<div class="carousel-caption">
						<h3>
							<font color="white">QUALITY OF SERVICE</font>
						</h3>
					</div>
				</div>
				<div class="item">
					<img src="images/car4.jpg">
					<div class="carousel-caption">
						<h3>
							<font color="white">SUPER SPORTS</font>
						</h3>
					</div>
				</div>
			</div>
	
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
			</a>
		</div>
		
		<section>
		
			<p>
				Let's explore the world of amazing car.<br />Just on one click search
				your dream car and book now on lowest prices.
			</p>
			<h2 class="header2">Search Car</h2>
			<br>
			<form action="search-car" method="post">
				<input type="checkbox" name="search" value="make">Search By Make 
				<input type="checkbox" name="search" value="price">Search By budget<br/><br/>
				<input type="submit" value="Search">
			</form>
		
		
			<%
				List<String> makeList = null;
				if (request.getAttribute("display") != null) {
			%> 
			<br />
			<br />
		
			<%=request.getAttribute("display")%> 
			<% }
		 	if (request.getParameter("make") != null) {
		 		Connection connection = ConnectionFactory.getConnection();
		 		if (connection == null) {
		 			connection = new ConnectionFactory().createConnection();
		 			new CarPortalDao(connection);
		 		}
		 		makeList = CarPortalDao.selectListOfMakeOfCar(connection);
		 		List<String> modelList = CarPortalDao
		 				.selectListOfModelOfCarBasedOnMake(connection,
		 						(String) request.getParameter("make"));
			%> 
			<br />
			<form action='#' method="post">
				<select name='make'>
					<option><%=request.getParameter("make")%></option>
					<%
						for (String str : makeList) {
					%>
					<option><%=str%></option>
					<%
						}
					%>
				</select><br/> <br/>
				<input type='submit' value='Get Model'><br/><br/>
			</form>
			<br />
			<form action='display-car' method="post">
				<input type="hidden" name="make" value="<%=request.getParameter("make")%>">
				<select name='model'><br/><br/>
					<option>-Select Model-</option><br/><br/>
					<%
						for (String str : modelList) {
					%>
					<option><%=str%></option>
					<%
						}
					%>
				</select> <br /><br/>
				<input type='submit' value='View'>
			</form>
			<%
				}
			%> 
		</section>
	</body>
</html>