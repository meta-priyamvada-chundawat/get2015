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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.carportal.service.Validation;

/**
 * @Priyamvada
 * 
 *         Servlet implementation class ValidateLogIn
 */

@WebServlet("/validate-admin")
public class ValidateLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// getting values from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message=Validation.validationOnLoginOfAdmin(username, password);

		if (message.charAt(0)=='1') {
			// redirecting the response to log in page
			response.sendRedirect("login.jsp?message="
					+ URLEncoder.encode(message.substring(1), "UTF-8"));
		} else {
			// checking if user is validate or not

			if (username.equals("abc") && password.equals("1234")) {
				// if user is validate then redirect to Home page
				request.setAttribute("username", username);// setting employee
															// in request
				RequestDispatcher rd = request.getRequestDispatcher("/admin-home");
				rd.forward(request, response);

			} else {
				// if not valid user then display message on login page
				response.sendRedirect("login.jsp?message="
						+ URLEncoder.encode("Invalid Username or Password",
								"UTF-8"));
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
