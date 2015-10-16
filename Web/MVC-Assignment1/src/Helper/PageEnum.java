package Helper;

/**
 * @author Priyamvada
 *
 */
public enum PageEnum {
	LandingPage("/LandingPage.jsp"), EmployeeListPage("/EmployeeListPage.jsp"), EmployeeDetailsPage(
			"/ViewDetails.jsp"), EmployeeRegistrationPage("/Register.jsp");

	private String url; //url of a page

	/**Parameterized Constructor
	 * @param url :url of a page
	 */
	PageEnum(String url) {
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
}
