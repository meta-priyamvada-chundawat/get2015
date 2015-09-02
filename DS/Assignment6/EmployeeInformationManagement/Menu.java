import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
	int empId;
	String name;
	String address;

	// To display main menu of program
	public void display() {
		System.out.println("Menu");
		System.out.println("1.Enter employee details");
		System.out.println("2.Sort employee details");
		System.out.println("3.Display employee details");
		System.out.println("Enter choice");
	}

	// To input employee information
	public EmployeeInformation inputEmployeeInformation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Enter employee ID");
		empId = scan.nextInt();
		System.out.println("2.Enter employee name");
		name = scan.next();
		System.out.println("3.Enter employee address");
		address = scan.next();
		EmployeeInformation obj = new EmployeeInformation(empId, name, address);
		scan.close();
		return obj;
	}

	// To display employee information
	public void displayEmployeeInformation(
			List<EmployeeInformation> employeeList) {
		Iterator<EmployeeInformation> itr = employeeList.iterator();
		while (itr.hasNext()) {
			EmployeeInformation objec = itr.next();
			System.out.println(objec.empId);
			System.out.println(objec.name);
			System.out.println(objec.address);
		}
	}
}
