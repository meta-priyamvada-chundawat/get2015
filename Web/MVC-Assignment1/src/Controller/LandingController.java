package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.GenericTextHelper;
import Helper.PageEnum;

/**
 * Priyamvada
 * 
 * Servlet implementation class LandingController
 */
@WebServlet("/LandingController")
public class LandingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = null;
		String pageLink = request.getParameter("page");//getting page
		request.setAttribute("list",new GenericTextHelper().selector(PageEnum.EmployeeRegistrationPage));//getting list of content and setting in request
		if (pageLink.equals(PageEnum.EmployeeRegistrationPage.toString())) {//if page is registeration
			rd = request.getRequestDispatcher(PageEnum.EmployeeRegistrationPage.getUrl());
		} else if (pageLink.equals(PageEnum.EmployeeListPage.toString())) {//if page is list page
			rd = request.getRequestDispatcher("/ListController");
		}
		rd.forward(request, response);
	}


}
