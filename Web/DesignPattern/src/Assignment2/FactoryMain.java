package Assignment2;

import java.util.Scanner;

/**
 * @author Priyamvada --Factory class which will decide to whom's instance is to
 *         create and perform all other functions
 *
 */
public class FactoryMain {

	public static void main(String[] args) {

		String name;
		String role;
		char choice;
		// getting instance of company
		Company company = Company.getInstance();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1 ->To add developer");
			System.out.println("2 ->to print list");

			int doChoice;
			do {// Validation

				System.out.println("enter integer value");
				while (!scanner.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scanner.next();
				}
				doChoice = scanner.nextInt();
			} while (doChoice < 0);
			switch (doChoice) {
			case 1:
				// adding data in list
				System.out.println("Enter name---");
				name = scanner.next();
				System.out.println("enter role---");
				role = scanner.next();
				company.addDeveloper(name, role);
				break;
			case 2:
				// showing list
				company.showList();
				break;
			default:
				System.out.println("enter correct choice");
				break;
			}

			System.out.println("want to continue(y/n)");
			choice = scanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

		scanner.close();
	}

}
