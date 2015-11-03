package com.metacube.webservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyamvada
 * 
 */
public class EmployeeDao {
	private static String CREATE_EMPLOYEE_QUERY, INSERT_EMPLOYEE_QUERY,
			CREATE_EMPLOYEE_DATABASE_QUERY, USE_EMPLOYEE_DATABASE_QUERY,
			SELECT_EMPLOYEE_QUERY, SELECT_EMPLOYEE_BY_ID_QUERY,
			SELECT_EMPLOYEE_BY_NAME_QUERY, DELETE_EMPLOYEE_BY_ID_QUERY; // Query Strings

	static {
		CREATE_EMPLOYEE_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS employeeDatabase";
		USE_EMPLOYEE_DATABASE_QUERY = "USE employeeDatabase";
		CREATE_EMPLOYEE_QUERY = "CREATE TABLE IF NOT EXISTS employee" + "("
				+ "name VARCHAR(20), " + "id INT," + "salary DOUBLE,"
				+ "department VARCHAR(40)," + "PRIMARY KEY(id) )";
		INSERT_EMPLOYEE_QUERY = "INSERT INTO employee(name, id, salary, department) VALUES(?,?,?,?)";
		SELECT_EMPLOYEE_QUERY = "SELECT * FROM employee";
		SELECT_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employee where id=?";
		SELECT_EMPLOYEE_BY_NAME_QUERY = "SELECT * FROM employee where name=?";
		DELETE_EMPLOYEE_BY_ID_QUERY = "DELETE FROM employee where id=?";
	}

	/**
	 * Creating and using database and creating employee table here Constructor
	 * connection: Connection of database
	 */
	public EmployeeDao(Connection connection) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Creating database and creating table employee
			statement.execute(CREATE_EMPLOYEE_DATABASE_QUERY);
			// Use query For employee Database
			useEmployeeDatabase(connection);
			// create employee table
			statement.execute(CREATE_EMPLOYEE_QUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * To use Employee Database for further query
	 * 
	 * @param connection
	 *            :connection
	 */
	public static void useEmployeeDatabase(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// use query for employee database
			statement.execute(USE_EMPLOYEE_DATABASE_QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * To insert employee into database
	 * 
	 * @param employee :employee details
	 * @param connection :connection of database
	 * @return :if data inserted then 1 else -1
	 */
	public static int insertIntoEmployeeTable(Employee employee,
			Connection connection) {

		PreparedStatement preparedStatement = null;

		try {
			// inserting employee into employee table
			preparedStatement = connection
					.prepareStatement(INSERT_EMPLOYEE_QUERY);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getId());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setString(4, employee.getDepartment());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * for selecting all employee from database
	 * 
	 * @param connection :connection
	 * @return : list of employee
	 */
	public static List<Employee> selectListOfEmployee(Connection connection) {

		List<Employee> employeeList = new ArrayList<Employee>();// List of employee
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement(SELECT_EMPLOYEE_QUERY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// setting employee in list
				employeeList.add(new Employee(resultSet.getInt(2), resultSet
						.getString(1), resultSet.getString(4), resultSet
						.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	/**
	 * To get employee by id
	 * 
	 * @param connection :connection
	 * @param id :employee id
	 * @return :employee of specified id
	 */
	public static Employee selectListOfEmployeeById(Connection connection,int id) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {

			preparedStatement = connection
					.prepareStatement(SELECT_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				// getting employee of this id
				employee = new Employee(resultSet.getInt(2),
						resultSet.getString(1), resultSet.getString(4),
						resultSet.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	/**
	 * function to return all employee by name
	 * 
	 * @param connection :connection
	 * @param name :name of employee
	 * @return :employee list of this name
	 */
	public static List<Employee> selectListOfEmployeeByName(
			Connection connection, String name) {

		List<Employee> employeeList = new ArrayList<Employee>();// List of employee
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			preparedStatement = connection
					.prepareStatement(SELECT_EMPLOYEE_BY_NAME_QUERY);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				// getting employee of this name
				employeeList.add(new Employee(resultSet.getInt(2), resultSet
						.getString(1), resultSet.getString(4), resultSet
						.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	/**
	 * Function to delete employee by id
	 * 
	 * @param connection :connection
	 * @param id :employee id
	 * @return :1 if employee deleted else 0
	 */
	public static int deleteEmployeeById(Connection connection, int id) {

		PreparedStatement preparedStatement = null;

		int result = 0;
		try {

			preparedStatement = connection
					.prepareStatement(DELETE_EMPLOYEE_BY_ID_QUERY);

			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
