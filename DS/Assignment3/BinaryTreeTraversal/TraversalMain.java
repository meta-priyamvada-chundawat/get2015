import java.util.Scanner;
//Class to implement preorder and postorder functions
public class TraversalMain {

	public static <T> void main(String args[]) {
		int ch, element, value;
		int choice;
		Scanner scan = new Scanner(System.in);
		BinaryTreeTraversal<Object> object = new BinaryTreeTraversal<Object>();
		do {/ Validation
				System.out.println("Please enter a positive number!");
				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
			System.out.println("Menu");
			System.out.println("1.Insert");
			System.out.println("2. Pre Order traversal");
			System.out.println("3. Post Order traversal");
			System.out.println("Enter choice");
			ch = scan.nextInt();
			switch (ch) {
			case 1://To input an element
				System.out.println("Insert an element");
				element = scan.nextInt();
				object.insert(element);
				break;

			case 2://For pre order display
				System.out.println("Pre order display");
				object.traversePreorder();
				break;

			case 3://For post order display
				System.out.println("Post order display");
				object.traversePostorder();
				break;
				
			default://default case
				System.out.println("Enter correct choice");
				break;
			}
			System.out.println("Do you want to continue..Press 1");
			choice = scan.nextInt();
			
		} while (choice == 1);
	}
}
