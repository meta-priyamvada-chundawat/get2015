/**
 * Case Study- Assignments
Phase 5
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3. Follow the layered architecture as discussed in the class.
 Use all the design patterns as discussed ie MVC-2, Facade, DAO, VO, Service and Factory. 
 Following use cases are must for the implementation.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator

 */

package com.metacube.carportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.carportal.service.CarPortalService;

/**
 * @Priyamvada
 * 
 * Servlet implementation class SearchCar
 */

@WebServlet("/search-car")
public class SearchCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**For admin Search
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String display = "";
		CarPortalService service=new CarPortalService();
		//if search by make
		if (search.equals("make")) {
			
				//getting list of company name of car
				List<String> makeList = service.getListOfCompanyNameOfCar();
				display += "<form action='searchCar.jsp' method='post'><select name='make'><option>-Select Company First-</option>";

				for (String str : makeList) {
					display += "<option>" + str + "</option>";
				}

				display += "</select><br/><input type='submit' value='Get Model'></form><br/>"
						+ "<form action='display-car' method='post'><select name='model'><option>-Select Car Model-</option></select>"
						+ "<br /><input type='submit' value='View'></form><br/>";

				request.setAttribute("makeList", makeList);
		} else {//if search by budget
			display += "<form action='display-car' method='post'>"
					+ "<select name='price'><option value='3000000'>Below 30,00,000</option>"
					+ "<option value='5000000'>Below 50,00,000</option>"
					+ "<option value='6000000'>Below 60,00,000</option>"
					+ "<option value='8000000'>Below 80,00,000</option>"
					+ "<option value='9000000'>Below 90,00,000</option></select>"
					+ "<br/><br/><input type='submit' value='View'></form>";
		}
		//request forward to Search page for displaying list of car
		request.setAttribute("display", display);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);
	}

	/**For Users
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("search");
		String display = "";
		CarPortalService service=new CarPortalService();
		//if search by make
		if (search.equals("make")) {
				//getting list of company name of car
			List<String> makeList = service.getListOfCompanyNameOfCar();
				display += "<br/><form action='login.jsp' method='post'><select name='make'><option>-Select Company First-</option>";

				for (String str : makeList) {
					display += "<option>" + str + "</option>";
				}

				display += "</select><br/><br/><input type='submit' value='Get Model'></form><br/>"
						+ "<form action='display-car' method='post'><select name='model'><option>-Select Car Model-</option></select>"
						+ "<br /><br/><input type='submit' value='View'></form><br/>";

				request.setAttribute("makeList", makeList);
		} else {//if search by budget
			display += "<form action='display-car' method='post'>"
						+ "<select name='price'><option value='3000000'>Below 30,00,000</option>"
						+ "<option value='5000000'>Below 50,00,000</option>"
						+ "<option value='6000000'>Below 60,00,000</option>"
						+ "<option value='8000000'>Below 80,00,000</option>"
						+ "<option value='9000000'>Below 90,00,000</option></select>"
						+ "<br/><br/><input type='submit' value='View'></form>";
		}
		//request forward to Login page
		request.setAttribute("display", display);

		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);

	}

}
