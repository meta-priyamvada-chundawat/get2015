import java.util.Scanner;

/**
 * @author Priyamvada -----Main class to attempt all actions regarding printer
 * 
 */
public class AdminPrinterMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Enter size of priority queue for maximum requests ");
		int size;
		do {// Validation

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			size = sc.nextInt();
		} while (size <= 0);
		PriorityQueue queue = new PriorityQueue(size);

		char ch;
		/* Perform Priority Queue operations */
		do {
			System.out.println("\nPriority Queue Operations\n");
			System.out.println("1. insert job");
			System.out.println("2. Process,Print and remove from queue");
			System.out.println("3. size");

			int choice;
			do {// Validation

				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1:

				System.out.println("Choose what you are");
				System.out.println("4. ChairPerson");
				System.out.println("3. Professors");
				System.out.println("2. Graduates");
				System.out.println("1. Under Graduates");

				System.out.println("Enter choice");
				int priority;
				do {// Validation

					while (!sc.hasNextInt()) {
						System.out
								.println("It is not a number!Please enter again");
						sc.next();
					}

					priority = sc.nextInt();
					if (priority > 4 || priority < 0) {
						System.out
								.println("It is not available!Please enter again");
					}
				} while ((priority > 4) || (priority < 0));
				System.out.println("Enter job to print");

				queue.insert(sc.next(), priority);
				break;
			case 2:
				System.out.println("\nJob Processing::::\n\n");
				queue.remove();
				break;

			case 3:
				System.out.println("\nSize = " + queue.size());
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}

			System.out
					.println("\nDo you want to continue (Type y to continue) \n");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		sc.close();
	}

}
