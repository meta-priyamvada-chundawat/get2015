package com.metacube.registration.controller;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.registration.databaseconfiguration.ConnectionUtil;
import com.metacube.registration.helper.UserRegisterationDao;
import com.metacube.registration.model.User;

/**
 * @author Priyamvada
 *
 * Servlet implementation class ValidateLogIn
 */
public class ValidateLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//getting values from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "";
		int flag = 0;
		//validating username field
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
			//checking if user is validate or not
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			if (UserRegisterationDao.isValidUser(user, ConnectionUtil.getConnection())) {
				//if user is validate then redirect to profile page
				response.sendRedirect("profile.jsp");

			} else {
				//if not valid user then display message on login page
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
