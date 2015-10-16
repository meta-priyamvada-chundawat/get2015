package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.EmployeeModelHelper;
import Helper.GenericTextHelper;
import Helper.PageEnum;
import Model.Employee;

/**
 * Priyamvada
 * 
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setAttribute("list", new GenericTextHelper()
				.selector(PageEnum.EmployeeRegistrationPage));//getting list of content and setting in request
		Employee employee = new Employee();
		out.println(request.getParameter("empname") + " "
				+ request.getParameter("empemail") + " "
				+ request.getParameter("empage") + " "
				+ request.getParameter("empdate"));
		employee.setName(request.getParameter("empname"));//setting values of employee after register click
		employee.setEmail(request.getParameter("empemail"));
		employee.setAge(Double.parseDouble(request.getParameter("empage")));
		employee.setDateOfRegistration(new Date());
		EmployeeModelHelper.addEmployee(employee);//adding employee to cache

		RequestDispatcher rd = request.getRequestDispatcher("/ListController");//forwarded to list page
		rd.forward(request, response);

	}

}
