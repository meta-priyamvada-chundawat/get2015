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
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.exception.CarPortalException;
import com.metacube.carportal.model.Car;
import com.metacube.carportal.service.CarPortalService;
import com.metacube.carportal.service.Validation;

/**
 * @@Priyamvada Servlet implementation class EditCar
 */
@WebServlet("/edit-car")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		CarPortalService service = new CarPortalService();
		// Validation on Car details
		String message = Validation.validationOnCarDetails(
				request.getParameter("make"), request.getParameter("model"),
				request.getParameter("engineInCC"),
				request.getParameter("fuelCapacity"),
				request.getParameter("milage"), request.getParameter("price"),
				"abc");

		if (message.charAt(0) == '1') {
			// redirecting the response to Edit page for showing error
			response.sendRedirect("editCar.jsp?message="
					+ URLEncoder.encode(message.substring(1), "UTF-8"));
		} else {
			// getting car detail in table for this make and model
			List<Car> car = service.getListOfSearchedCarBasedOnMakeAndModel(
					(String) request.getParameter("make"),
					(String) request.getParameter("model"));
			if (car.size() > 0) {
				// setting updated value
				car.get(0).setEngineInCC(
						Double.parseDouble((String) request
								.getParameter("engineInCC")));
				car.get(0).setFuelCapacity(
						Double.parseDouble((String) request
								.getParameter("fuelCapacity")));
				car.get(0).setMilage(
						Double.parseDouble((String) request
								.getParameter("milage")));
				car.get(0).setPrice(
						Double.parseDouble((String) request
								.getParameter("price")));
				car.get(0).setOnRoadPrice();
				// updating car details
				int update = service.editDetailsOfCar(car.get(0));
				if (update == 1) {// if updated
					// redirected to home page of admin if successfully updated
					request.setAttribute("username",
							session.getAttribute("username"));
					RequestDispatcher rd = request
							.getRequestDispatcher("/admin-home");
					rd.forward(request, response);
				} else {// if not updated
					response.sendRedirect("editCar.jsp?message="
							+ URLEncoder
									.encode("Car not updated Successfully, Please Try Again",
											"UTF-8"));
				}
			} else {
				response.sendRedirect("editCar.jsp?message="
						+ URLEncoder
								.encode("No such Car Available to update, Please Try Again",
										"UTF-8"));
				return;
			}
		}

	}

}
