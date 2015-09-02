//Employee class that contains all the attributes of employee
public class EmployeeInformation implements Comparable {
	int empId;
	String name;
	String address;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	// To check if two employee ID are unique
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeInformation other = (EmployeeInformation) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

	// Constructor with default parameters
	EmployeeInformation() {
		this.empId = 0;
		this.name = null;
		this.address = null;
	}

	// Constructor to input employee attributes
	EmployeeInformation(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	// Get employee ID
	public Integer getEmpId() {
		return empId;
	}

	// Set employee ID
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// Get employee Name
	public String getName() {
		return name;
	}

	// Set employee Name
	public void setName(String name) {
		this.name = name;
	}

	// Get employee Address
	public String getAddress() {
		return address;
	}

	// Set employee Address
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	// Compare employee IDs
	public int compareTo(Object obj) {
		return getEmpId().compareTo(((EmployeeInformation) obj).getEmpId());
	}
}
