import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Class to perform name sorting on collection of class EmployeeInformation
public class EmployeeNameSort implements Comparator<Object> {
	static List<EmployeeInformation> employeeList = new LinkedList<EmployeeInformation>();

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int choice;
		int ch = 0;
		do {
			// Calling display function
			menu.display();
			do {// Validation
				while (!scan.hasNextInt()) {
					System.out.println("That's not a number!Please enter again");
					scan.next(); // this is important!
				}
				choice = scan.nextInt();
			} while (choice <= 0);
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				int count = 0;
				EmployeeInformation obj = menu.inputEmployeeInformation();
				// To prevent any duplicate entry in employeeList
				if (employeeList.size() == 0) {
					employeeList.add(obj);
				} else {
					Iterator<EmployeeInformation> itr = employeeList.iterator();
					while (itr.hasNext()) {
						Object objec = itr.next();
						if (obj.equals(objec)) {
							System.out
									.println("1.Employee Id already exists!!!");
							break;
						}
						count++;
					}
					if (count == employeeList.size()) {
						employeeList.add(obj);
					}
				}
				break;
			case 2:
				// Perform name sorting
				Collections.sort(employeeList, new EmployeeNameSort());
				break;
			case 3:
				menu.displayEmployeeInformation(employeeList);
				break;
			default:
				// Default case definition
				System.out.println("Enter correct choice");
				break;
			}
			System.out.println("Do you want to continue");
			ch = scan.nextInt();
		} while (ch == 1);
	}

	@Override
	// Compare two objects for name sorting
	public int compare(Object arg0, Object arg1) {

		return ((EmployeeInformation) arg0).getName().compareTo(
				((EmployeeInformation) arg1).getName());
	}
}
