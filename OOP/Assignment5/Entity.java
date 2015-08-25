import java.math.BigInteger;

public class Entity implements Node {

	private String name;
	private BigInteger phone;
	private String email;

	// Checking phone validation and return true if correct else false
	boolean isValidPhone(BigInteger phone) {
		if (phone.toString().length() == 10)
			return true;
		else
			return false;
	}

	// Checking email validation and return true if correct else false
	boolean isValidEmail(String email) {
		if (email.contains("@") == true && email.contains(".com") == true)
			return true;
		else
			return false;
	}

	// return name
	public String getName() {
		return name;
	}

	// set name
	public void setName(String name) {
		this.name = name;
	}

	// return phone
	public BigInteger getPhone() {
		return phone;
	}

	// set phone
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	// return email
	public String getEmail() {
		return email;
	}

	// set email
	public void setEmail(String email) {
		this.email = email;
	}

}
