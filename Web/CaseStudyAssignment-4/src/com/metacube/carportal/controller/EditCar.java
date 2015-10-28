/**
 * Case Study- Assignments
Phase 4
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3.
Follow the MVC-2 on front end for implementing the jsp and servlet. 
Use annotations in the Servlet. 
Implement the validations in javascript as well as in servlet for create/edit car.
Follow the complete coding standards for the assignment, like class names, variable names, etc.
Code should be modular and extensible by implementing smaller methods and separate classes for various purpose.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator
 */


package com.metacube.carportal.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.db.helper.CarPortalDao;
import com.metacube.carportal.dbconfig.ConnectionFactory;
import com.metacube.carportal.exception.CarDekhoException;
import com.metacube.carportal.model.Car;

/**
 * @author Priyamvada Servlet implementation class EditCar
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
		Connection connection = null;
		// getting connection
		try {
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();
				new CarPortalDao(connection);
			}
		} catch (CarDekhoException e) {
			e.printStackTrace();
		}

		int flag = 0;
		String message = "";
		// Validations for car company name
		if (request.getParameter("make").equals(null)
				|| request.getParameter("make").equals("")) {
			flag = 1;
			message += "Make field Empty";
		} // Validations for Model
		else if (request.getParameter("model").equals(null)
				|| request.getParameter("model").equals("")) {
			flag = 1;
			message += "Model field Empty";
			// Validations for Engine in cc
		} else if (request.getParameter("engineInCC").equals(null)
				|| request.getParameter("engineInCC").equals("")) {
			flag = 1;
			message += "EngineInCC field Empty";
			// Validations for Fuel Capacity
		} else if (request.getParameter("fuelCapacity").equals(null)
				|| request.getParameter("fuelCapacity").equals("")) {
			flag = 1;
			message += "FuelCapacity field Empty";
			// Validations for Milage
		} else if (request.getParameter("milage").equals(null)
				|| request.getParameter("milage").equals("")) {
			flag = 1;
			message += "Milage field Empty";
			// Validations for price
		} else if (request.getParameter("price").equals(null)
				|| request.getParameter("price").equals("")) {
			flag = 1;
			message += "Price field Empty";
			// Validations for roadTax
		}
		
		
		
		if (flag == 1) {
			// redirecting the response to Edit page for showing error
			response.sendRedirect("EditCar.jsp?message="
					+ URLEncoder.encode(message, "UTF-8"));
		} else {
			// getting car detail in table for this make and model
			List<Car> car = CarPortalDao.selectCarBasedOnMakeAndModel(
					connection, (String) request.getParameter("make"),
					(String) request.getParameter("model"));
			//setting updated value
			car.get(0).setEngineInCC(
					Double.parseDouble((String) request
							.getParameter("engineInCC")));
			car.get(0).setFuelCapacity(
					Double.parseDouble((String) request
							.getParameter("fuelCapacity")));
			car.get(0)
					.setMilage(
							Double.parseDouble((String) request
									.getParameter("milage")));
			car.get(0).setPrice(
					Double.parseDouble((String) request.getParameter("price")));
			car.get(0).setOnRoadPrice();
			//updating car details
			int update = CarPortalDao.updateCarDetails(connection, car.get(0));

			if (update == -1) {//if not updated
				request.setAttribute("message", "Car not inserted");
				//redirected to edit car page again
				RequestDispatcher rd = request
						.getRequestDispatcher("/editCar.jsp");
				rd.forward(request, response);
			} else {
				//redirected to home page of admin if successfully updated
				request.setAttribute("username",
						session.getAttribute("username"));
				RequestDispatcher rd = request.getRequestDispatcher("/admin-home");
				rd.forward(request, response);
			}
		}

	}

}
