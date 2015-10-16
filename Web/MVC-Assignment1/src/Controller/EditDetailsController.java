package Controller;

import java.io.IOException;

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
 * Servlet implementation class EditDetailsController
 */
@WebServlet("/EditDetailsController")
public class EditDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list",new GenericTextHelper().selector(PageEnum.EmployeeRegistrationPage));//getting list of content and setting in request
		Employee employee= EmployeeModelHelper.getEmployeeForId(Integer.parseInt(request.getParameter("id")));//getting employee of this id
		request.setAttribute("employeeDetails", employee);//setting employee in request
		RequestDispatcher rd = request.getRequestDispatcher(PageEnum.EmployeeRegistrationPage.getUrl());
		rd.forward(request, response);
	}

}
