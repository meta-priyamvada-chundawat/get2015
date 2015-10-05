import java.util.Scanner;

// Class to call the operations of generalized linked list
public class GeneralListMain {

	public static void main(String[] args) {
		
		System.out.println("enter generalized list \n");
		Scanner scan=new Scanner(System.in);
		String inputList=scan.next();
		int choice=0;
		char mainChoice;
		GeneralizedList generalizedList=new GeneralizedList(inputList);
		
		do {// Menu
			System.out.println("Enter 1 to Display the linked list  "
							+ "\n2 sum of the list" + "\n3 max from list"+"\n4 Search an element");
			choice=scan.nextInt();
		
			switch (choice) {
			case 1:// to display list
				System.out.println("Linked List is: ");
				 System.out.println(generalizedList.getLinkedList());
				 break;
			case 2:
				// sum of list
				 System.out.println("Sum is"+generalizedList.calculateSum());
				
				break;
			case 3:
				// sum of list
				 System.out.println("Max is"+generalizedList.calculateMax());
				 break;
			case 4:

				System.out.println("enter value to search \n");
				
				 System.out.println("value found"+generalizedList.searchValue(Integer.parseInt(scan.next())));
				 break;
				
			default:
				System.out.println("Enter Correct Choice");
			}
			System.out.println("Do you want to continue");
			mainChoice = scan.next().toUpperCase().charAt(0);
		} while (mainChoice == 'Y');
		scan.close();
	}

}
