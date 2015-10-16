/**
 * Assumption/Guidelines -

Employee Information in a thread-safe Cache (Map).
Employee ID is Unique 
Employee Cache Map is not persisted. It is initialized during the application start-up with 5 Sample Employees
For any edit, or registration flow, same map is modified.
Employee Cache Map should be accessed/updated using a helper/util class only. Suggestive methods:
EmployeeModel getEmployeeForId(int id)
List<EmployeeModel> getAllEmployees()
void updateEmployee(EmployeeModel e)
void addEmployee(EmployeeModel e)



Assignment 1 (2.5 Hours)

Create a simple web application using MVC2 Design Pattern for the following pages -
Landing Page
Should have a short description about Metacube Software Pvt. Ltd.
Should have a link to Registration Page (Empty Link - to be updated as part of Assignment 3)
Should have a link to Employee List Page
Employee List Page
Should list out all the registered employees (Name, Email and Employee ID)
Should have link to "View Details" for each employee (Empty Link - to be updated as part of Assignment 2)
Should have link to "Edit" for each employee (Empty Link - to be updated as part of Assignment 3)


Assignment 2 (1 Hour)

Add following page to the above site -
Employee Details Page
Should list out following details for the selected Employee -
Name
Email
Age
Employee ID
Date of Registration
Should have link to Landing Page
Should have link to Registration Page (Empty Link - to be updated as part of Assignment 3)


Assignment 3 (1.5 Hours)

Add following page to above site -
Employee Registration Page / Employee Edit Info Page (Common page should be used)
Should have a Registration / Edit form with following fields (In case of Edit, values should be pre-filled)-
Name
Email
Age
Employee ID
Upon successful registration/edit, should redirect to Employee List Page
 */

package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.EmployeeCache;
import Helper.GenericTextHelper;
import Helper.PageEnum;

/**
 * Priyamvada
 * 
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("servlet is initialized");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws IOException, ServletException {
		new EmployeeCache();//initialize cache with 5 employees
		req.setAttribute("list",
				new GenericTextHelper().selector(PageEnum.LandingPage));//getting list of content and setting in request
		
		RequestDispatcher rd = req.getRequestDispatcher(PageEnum.LandingPage
				.getUrl());//forwarded to landing page
		rd.forward(req, res);

	}

}
