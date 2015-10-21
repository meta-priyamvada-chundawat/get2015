package Assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Assignment1.Singleton;

/**
 * @author Priyamvada
 * --Company class to add only developer using protected
 *         constructor and to show their list
 *
 */
public class Company extends Developer {

	private static Company company = new Company();

	// private constructor:: can only be get by the getInstance method()
	private Company() {
		super();

	}

	/**
	 * List to store developers data
	 */
	private List<Developer> developerList = new ArrayList<Developer>();

	/**
	 * Function to return instance of company
	 * 
	 * @return instance of company
	 */
	public static Company getInstance() {
		return company;
	}

	/**
	 * Function to add developers
	 * 
	 * @param name
	 *            ---Name of the developer
	 * @param role
	 *            ---Role of the developer
	 */
	public void addDeveloper(String name, String role) {
		Developer developer = new Developer();
		developer.setName(name);
		developer.setRole(role);
		developerList.add(developer);

	}

	/**
	 * Function to display the list of developers using overloaded to string
	 * function
	 * 
	 */
	public void showList() {
		if(developerList.isEmpty()){
			System.out.println("List is empty");
		}
		else{
		Iterator<Developer> iterator = developerList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
		}
	}

}
