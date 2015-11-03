/**
 *WebService- Assignments
Session 2
Duration (3 Hr)

Assignment 1:

Create a Restful web service as follows: (Use JDBC for data base for Employee) Contains only one table employee which will keep basic property of employee (id,name , etc..)

             It will do following operations:

1. Create a Employee
2. Retrieve a employee info by giving its  id as input
3. Retrieve all employees info whose name matches as input name
4. Retrieve all employee
5. Delete an employee by specifying id

	Access all above apis through browser (Rest Client)
 *
 */
package com.metacube.webservices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 * @author Priyamvada
 *
 */
@Path("/employee-service")
public class EmployeeService {
	
	/**
	 * 
	 * function to insert employee
	 * 
	 * @param name :name of employee
	 * @param id :id of employee
	 * @param salary:salary of employee
	 * @param department :department of employee
	 * @return :output String
	 * @throws SQLException
	 */

	@POST
	@Produces("application/xml")
	@Path("{name}/{id}/{salary}/{department}")
	public String insertEmployee(@PathParam("name") String name,
			@PathParam("id") int id, @PathParam("salary") Double salary,
			@PathParam("department") String department) throws SQLException {
		String output="";
		//getting connection
		Connection connection = ConnectionFactory.getConnection();
		//Creating database and table
		new EmployeeDao(connection);
		//Employee to insert
		Employee employee = new Employee(id, name, department, salary);
		//employee inserted
		int result = EmployeeDao.insertIntoEmployeeTable(employee,
				connection);

		if (result == 1) {//if employee inserted successfully
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee Inserted";
			return "<insertEmployee>" + output + "</insertEmployee>";
		} else {//if not inserted successfully
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee not Inserted";
			return "<insertEmployee>" + output + "</insertEmployee>";
		}

	}

	/**
	 * function to show employee by id
	 * 
	 * @param id :id of employee
	 * @return String of employee  of this id as output 
	 * @throws SQLException
	 */
	@POST
	@Produces("application/xml")
	@Path("{id}")
	public String selectEmployeeById(@PathParam("id") int id)
			throws SQLException {
		//getting connection
		Connection connection=ConnectionFactory.getConnection();
		//use employee database
		EmployeeDao.useEmployeeDatabase(connection);
		String output="";
		//get employee based on id
		Employee employeeById = EmployeeDao.selectListOfEmployeeById(
				connection, id);

		if (employeeById != null) {//if employee of this id available then 
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee Found";
			return "<Employee>" + output + "\n" + "<employeeId>"
					+ employeeById.getId() + "</employeeId>" + "\n"
					+ "<employeeName>" + employeeById.getName()
					+ "</employeeName>" + "\n" + "<employeeSalary>"
					+ employeeById.getSalary() + "</employeeSalary>" + "\n"
					+ "<employeeDept>" + employeeById.getDepartment()
					+ "</employeeDept>" + "</Employee>";
		} else {//if this employee not available

			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee not found";
			return "<EmployeeById>" + output + "</EmployeeById>";
		}
	}

	/**
	 * 
	 * function to return list of employee by name
	 * 
	 * @param name :name of employee
	 * @return :string of employee of this name
	 * @throws SQLException
	 */
	@POST
	@Produces("application/xml")
	@Path("name/{name}")
	public String selectEmployeeByName(@PathParam("name") String name)
			throws SQLException {
		String output = "";
		List<Employee> employeeList = null;
		//getting connection
		Connection connection = ConnectionFactory.getConnection();
		//using employee database
		EmployeeDao.useEmployeeDatabase(connection);
		//getting employee based on employee name
		employeeList = EmployeeDao.selectListOfEmployeeByName(connection,
				name);
		if (!employeeList.isEmpty()) {//if employee list is not empty
			
			Iterator<Employee> iterator = employeeList.iterator();
			while (iterator.hasNext()) {//iterating employee
				Employee employee = iterator.next();

				output += "<Employee>" + "\n" + "<employeeId>"
						+ employee.getId() + "</employeeId>" + "\n"
						+ "<employeeName>" + employee.getName()
						+ "</employeeName>" + "\n" + "<employeeSalary>"
						+ employee.getSalary() + "</employeeSalary>" + "\n"
						+ "<employeeDept>" + employee.getDepartment()
						+ "</employeeDept>" + "</Employee>";
			}
			return "<EmployeeById>" + output + "</EmployeeById>";
		} else {//if no employee in list
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee not found";
			return "<EmployeeById>" + output + "</EmployeeById>";
		}

	}

	/**
	 * Function to display all employees
	 * 
	 * @return :all employee as String
	 * @throws SQLException
	 */
	@POST
	@Produces("application/xml")
	@Path("all")
	public String selectAllEmployeeList() throws SQLException {
		String output = "";
		List<Employee> employeeList=null;
		//getting connecion
		Connection connection = ConnectionFactory.getConnection();
		//using employee database
		EmployeeDao.useEmployeeDatabase(connection);
		//getting ist of all employee
		employeeList = EmployeeDao.selectListOfEmployee(connection);
		if (!employeeList.isEmpty()) {//if list is not empty
			
			Iterator<Employee> itr = employeeList.iterator();
			while (itr.hasNext()) {//iterating employee list
				Employee employee = itr.next();

				output += "<Employee>" + "\n" + "<employeeId>"
						+ employee.getId() + "</employeeId>" + "\n"
						+ "<employeeName>" + employee.getName()
						+ "</employeeName>" + "\n" + "<employeeSalary>"
						+ employee.getSalary() + "</employeeSalary>" + "\n"
						+ "<employeeDept>" + employee.getDepartment()
						+ "</employeeDept>" + "</Employee>";
			}
			return "<EmployeeById>" + output + "</EmployeeById>";
		} else {//if list of employee is empty

			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee not found";
			return "<EmployeeById>" + output + "</EmployeeById>";
		}

	}

	/**
	 * 
	 * function to delete employees by id
	 * 
	 * @param id :id of employee
	 * @return :String if employee deleted or not
	 * @throws SQLException
	 */
	@POST
	@Produces("application/xml")
	@Path("id/{id}")
	public String deleteEmployeeById(@PathParam("id") int id)
			throws SQLException {

		//getting connection
		Connection connection = ConnectionFactory.getConnection();
		String output="";
		//use employee database
		EmployeeDao.useEmployeeDatabase(connection);
		//delete employee of this id
		int result = EmployeeDao.deleteEmployeeById(connection, id);

		if (result == 1){//if employee deleted
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee deleted";
			return "<deleteEmployee>" + output + "</deleteEmployee>";
		} else {//if employee not deleted
			output = "@Produces(\"application/xml\") Output: \n"
					+ "Employee not deleted";
			return "<deleteEmployee>" + output + "</deleteEmployee>";
		}
	}

}
