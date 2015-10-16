package Model;

import java.util.Date;

/**
 * @author Priyamvada
 *
 */
public class Employee {
	private int employeeId;
	private String name;
	private String email;
	private double age;
	private Date dateOfRegistration;

	/**
	 * Constructor 
	 */
	public Employee() {
		this.employeeId =0;
		this.name = "";
		this.email = "";
		this.age = 0.0;
	}

	/**
	 * @param employeeId :employee id
	 * @param name :name of employee
	 * @param email :email of employee
	 * @param age :age of employee
	 * @param dateOfRegistration :date of registeration of employee
	 */
	public Employee(int employeeId, String name, String email, double age,
			Date dateOfRegistration) {
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dateOfRegistration = dateOfRegistration;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}

	
	/**
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeId :" + employeeId + "\n Name :" + name + " \n  Email :"
				+ email + "\n Age :" + age + " \n DateOfRegistration :"
				+ dateOfRegistration;
	}

}
