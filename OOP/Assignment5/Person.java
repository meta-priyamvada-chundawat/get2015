public class Person extends Entity {

	private String school;
	private String college;
	private String[] interests;

	// return school
	public String getSchool() {
		return school;
	}

	// set school
	public void setSchool(String school) {
		this.school = school;
	}

	// return college
	public String getCollege() {
		return college;
	}

	// set college
	public void setCollege(String college) {
		this.college = college;
	}

	// return intresst
	public String[] getInterests() {
		return interests;
	}

	// set interest
	public void setInterests(String[] interests) {
		this.interests = interests;
	}

}
