<%@page import="com.metacube.carportal.service.*"%>
<%@page import="com.metacube.carportal.model.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
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
				<a href="#">About Us</a>
			</span> 
			<span class="space">
				<a href="#">Contact Us</a>
			</span> 
		</nav>
		<%
			if (session.getAttribute("username") != null) {
		%>
		<div class="link">
			<span class="space"> <a href="addCar.jsp">Add New Car</a></span><br />
			<span class="space"> <a href="editCar.jsp">Update Car Details</a></span><br />
		</div>
		<%
			}
		%>
		<div class="offer_list clearfix" id="offer_list">
	
			<div class="offer_item clearfix" id="0">
	
				<div class="offer_aside">
	
					<h1 class="header2">Search Car</h1>
					<form action="search-car" method="get">
					<label>Search By Company</label><input type="checkbox" name="search" value="make"><br /><br />
					<label>Search By Budget</label><input type="checkbox" name="search" value="price"> 
					<br/><br />
						<input type="submit" value="Search">
					</form>
				</div>
		
				<div class="offer_form">
					<%
					
					CarPortalService service=new CarPortalService();
						List<String> makeList=null;
						if (request.getAttribute("display") != null) {
					%> 
					<%=request.getAttribute("display")%> 
					<%
 						}
 								 	if (request.getParameter("make") != null) {
 								 		//getting list of company
 										makeList=service.getListOfCompanyNameOfCar();
 								 		//getting list of model 
 								 		List<String> modelList = service.getListOfModelOfCarBasedOnCompany(
 								 									(String) request.getParameter("make") );
 					%>
					 
					<form action='searchCar.jsp' method="post">
						<select name='make'>
						<option><%=request.getParameter("make") %></option>
						<%
							for (String str : makeList) {
						%>
							<option><%=str%></option>
						<%
							}
						%>
						</select>
						<br/> 
						<input type='submit' value='Get Model'>
					</form>
					<br/>
					<form action='display-car' method="post">
						<input type="hidden" name="make" value="<%= request.getParameter("make")%>">
						<input type='hidden' name='username' value='gfdjhfd'>
						<select name='model'>
							<%if(request.getParameter("model")!=null){ %>
								<option><%=request.getParameter("model") %></option>
							<%}else{ %>
								<option>-Select Model-</option>
							
							<%}
								for (String str : modelList) {
							%>
								<option><%=str%></option>
							<%
								}
							%>
						</select><br/>
						<input type='submit' value='View'>
					</form>
					<%
						}
						
					%> 
					<p>&nbsp;</p>
				</div>
			</div>
		</div>
	
	
		<hr>
	
	
		<%
		//getting list of cars
		List<Car> carList=service.getListOfCarForAdminHome();
			if (request.getAttribute("carList") != null) {
				carList = (List<Car>) request.getAttribute("carList");
			}
				for (Car car : carList) {
		%>
		<div class="offer_list clearfix" id="offer_list">
	
			<div class="offer_item clearfix" id="0">
	
				<div class="offer_aside">
					<h2><%=car.getMake()%></h2>
					<div class="offer_descr">
						<p><%=car.getModel()%></p>
					</div>
					<div class="offer_data">
						<div class="offer_price">On Road Price
						</div>
						<span class="offer_miliage">Milage in KMPL</span> 
						<span class="offer_regist">Ex-showroom Price</span>
					</div>
					<hr>
					<div class="offer_data">
						<div class="offer_price">$<%=car.getOnRoadPrice()%>
						
						</div>
						<span class="offer_miliage"><%=car.getMilage()%>KMPL</span> 
						<span class="offer_regist">	$<%=car.getPrice()%></span>
					</div>
				</div>
				<div class="offer_image">
					<img src="<%=car.getImage_path()%>" alt="">
				</div>
	
			</div>
		</div>
		<%
		
		}
		%>
	
	
	</body>
</html>
