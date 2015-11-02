/**
 * Case Study- Assignments
Phase 5
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3. Follow the layered architecture as discussed in the class.
 Use all the design patterns as discussed ie MVC-2, Facade, DAO, VO, Service and Factory. 
 Following use cases are must for the implementation.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator

 */

package com.metacube.carportal.exception;

/**
 * @author Deepali
 *
 */
public class CarPortalException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message :message of exception
	 */
	public CarPortalException(String message) {
		super(message);
		
	}
	
	/**
	 * @param message :message
	 * @param cause :cause of exception
	 */
	public CarPortalException(String message ,Throwable cause) {
		super(message,cause);
		
	}


}
