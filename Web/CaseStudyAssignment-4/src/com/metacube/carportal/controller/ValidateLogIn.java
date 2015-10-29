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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Priyamvada
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
		String message = "";
		int flag = 0;
		// validating username field
		if (username.equals(null) || username.equals("")) {
			flag = 1;
			message += "User Name field Empty";
		} // check for empty password field
		else if (password.equals(null) || password.equals("")) {
			flag = 1;
			message += "Password field Empty";
		}

		if (flag == 1) {
			// redirecting the response to log in page
			response.sendRedirect("login.jsp?message="
					+ URLEncoder.encode(message, "UTF-8"));
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
