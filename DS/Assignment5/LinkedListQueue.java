//Class to perform queue operations using best collection available
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Implementation of queue using built in linked list functions
public class LinkedListQueue {

	//To use enqueue and dequeue using linked list 
	public static void main(String args[]) {
		List<Integer> list = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		int element, choice, ch;
		do {
			System.out.println("Menu");
			System.out.println("1.Add element");
			System.out.println("2.Delete element");
			System.out.println("3.Display queue");
			System.out.println("Enter choice");
			do {// Validation
				while (!scan.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scan.next(); // this is important!
				}
				choice = scan.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1:
				//Add element from rear
				element = scan.nextInt();
				((LinkedList<Integer>) list).addLast(element);
				break;
			case 2:
				//Delete from front
				System.out.println("Element deleted from first");
				((LinkedList<Integer>) list).removeFirst();
				break;
			case 3:
				//Display all the elements
				System.out.println("Queue Display");
				Iterator<Integer> itr = list.iterator();
				while (itr.hasNext()) {
					int value = itr.next();
					System.out.println(value);
				}
				break;
			default:
				//Default case definition
				System.out.println("Enter correct choice");
				break;
			}
			System.out.println("Do you want to continue... Press 1");
			ch = scan.nextInt();
		} while (ch == 1);
	}
}
