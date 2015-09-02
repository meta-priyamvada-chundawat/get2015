package default;

import java.util.Scanner;

//Class to implement stack functions
public class StackMain {

	public static void main(String[] args) {
		StackLinkList stacklist = new StackLinkList();
		StackLinkList stacklist1 = new StackLinkList();
		Scanner sc = new Scanner(System.in);
		char ch;
		do {
			System.out.println("Enter what you want to do");
			System.out.println("1 push item");
			System.out.println("2 pop item");
			System.out.println("3 Display stack");
			System.out.println("4. Infix to postfix conversion");
			int choice;

			do {// Validation

				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); 
				}
				choice = sc.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1: //To input an element
				String string;
				System.out.println("enter a no to add");
				string = sc.next();
				StackLinkList.push(string);
				break;
			case 2: //To delete an element
				stacklist.pop();
				break;
			case 3: //To display the element
				stacklist.display();
				break;
			case 4:
				System.out.println("Enter Expression");
				String postfix = new String();
				
				postfix=stacklist1.convert(sc.next());
				System.out.println("postfix is"+postfix);
				
				break;
			default:
				System.out.println("enter rightvalues");

			}

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		sc.close();

	}

}
