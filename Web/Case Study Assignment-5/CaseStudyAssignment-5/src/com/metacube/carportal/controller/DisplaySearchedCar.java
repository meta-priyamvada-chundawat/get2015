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

import com.metacube.carportal.model.Car;
import com.metacube.carportal.service.CarPortalService;

/**
 * @Priyamvada
 * 
 * Servlet implementation class DisplaySearchedCar
 */
@WebServlet("/display-car")
public class DisplaySearchedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Car> carList = null;
		CarPortalService service=new CarPortalService();
		//search by model and make
		if (request.getParameter("model") != null) {
			//getting carlist for this make and model
			carList = service.getListOfSearchedCarBasedOnMakeAndModel(
							request.getParameter("make"),
							request.getParameter("model"));
		}
		//search by price 
		else if (Double.parseDouble(request.getParameter("price")) != 0.0) {
			//getting car list for car lower than this budget
			carList = service.getListOfSearchedCarBasedOnBudget(Double.parseDouble(request.getParameter("price")));
		}
		//request forwarded to searchcar page to display list of cars
		request.setAttribute("carList", carList);
		RequestDispatcher rd = request.getRequestDispatcher("/searchCar.jsp");
		rd.forward(request, response);

	}
}
