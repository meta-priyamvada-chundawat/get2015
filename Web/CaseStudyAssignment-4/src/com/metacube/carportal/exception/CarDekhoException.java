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


package com.metacube.carportal.exception;

/**
 * @author Priyamvada
 *
 */
public class CarDekhoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message :message of exception
	 */
	public CarDekhoException(String message) {
		super(message);
		
	}
	
	/**
	 * @param message :message
	 * @param cause :cause of exception
	 */
	public CarDekhoException(String message ,Throwable cause) {
		super(message,cause);
		
	}


}
