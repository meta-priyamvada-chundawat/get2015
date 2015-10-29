package com.metacube.carportal.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.carportal.exception.CarDekhoException;


/**
 * @author Priyamvada
 *
 */
public class ConnectionFactory {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection connection = null;
	
	/**for creating connection
	 * @return :connection
	 * @throws CarDekhoException
	 */
	public Connection createConnection() throws CarDekhoException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load driver class, please add mysql jdbc driver to classpath.");
			throw new CarDekhoException("Could not load driver class, please add mysql jdbc driver to classpath.", e);
		} catch (SQLException e) {
			System.out.println("Coult not create connection with database, [" + e.getMessage() + "]");
			throw new CarDekhoException("Coult not create connection with database, [" + e.getMessage() + "]", e);
		}
		return connection;
	}
	
	/**For closing connection
	 * @param connection:connection
	 */
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Could not close connection due to following error, [" + e.getMessage() + "]");
			}
		}
	}
	
	
	/** for getting connection
	 * @return :connection
	 * @throws CarDekhoException 
	 */
	public static Connection getConnection() throws CarDekhoException{
		return connection;
	}
	
	
}
