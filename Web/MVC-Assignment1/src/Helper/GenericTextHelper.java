package Helper;

import java.util.ArrayList;
import java.util.List;

import Model.GenericTextModel;

/**
 * @author Priyamvada
 *
 */
public class GenericTextHelper {

	private List<GenericTextModel> contentList;//List of content on each page

	/**
	 * Constructor
	 */
	public GenericTextHelper() {
		contentList = new ArrayList<GenericTextModel>();

	}

	/**Getting details for a page
	 * @param contentList
	 *            the contentList to set
	 */
	public void setContentList(List<GenericTextModel> contentList) {
		this.contentList = contentList;
	}

	/**Getting content for a page
	 * @param page :PageEnum
	 * @return :List of content
	 */
	public List<GenericTextModel> selector(PageEnum page) {
		String value = "Metacube is a Software Engineering Services company with experience in"
				+ " developing enterprise applications for a wide spectrum of domains including"
				+ " global trade management, supply chain analytics, manufacturing analytics, business"
				+ " continuity planning, CRM, content management and eCommerce. These applications have"
				+ " been developed on a variety of technology platforms.";
		GenericTextModel model;
		
		
		if (page.equals(PageEnum.LandingPage)) {//if Landing Page
			model = new GenericTextModel(value);
			contentList.add(model);
		} else if (page.equals(PageEnum.EmployeeListPage)) { //if employee List page
			model = new GenericTextModel("Employee List Page");
			contentList.add(model);
		} else if (page.equals(PageEnum.EmployeeDetailsPage)) { //if employee Detail page
			model = new GenericTextModel("Employee Detail Page");
			contentList.add(model);
		} else if (page.equals(PageEnum.EmployeeRegistrationPage)) {//if employee Registeration page
			model = new GenericTextModel("Employee Registration/Edit Page");
			contentList.add(model);
		} else {//if other then all pages
			model = new GenericTextModel("Someting Wrong happen");
			contentList.add(model);
		}

		return contentList;
	}

	/**
	 * @param textGeneric :content to add
	 */
	public void addContent(GenericTextModel textGeneric) {
		contentList.add(textGeneric);
	}

	/**Content to get
	 * @return :list of contents 
	 */
	public List<GenericTextModel> getContentList() {
		return contentList;
	}

}
