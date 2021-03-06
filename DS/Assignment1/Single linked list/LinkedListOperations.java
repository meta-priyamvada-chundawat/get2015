import java.util.Scanner;

//A general class to perform linked list operations on generic data type
public class LinkedListOperations<T> {

	// Create a new linked list with 2 values
	public Node<T> createLinkedList(T item1, T item2) {
		Node<T> first = null, p, q;
		p = new Node<T>(item1);
		q = new Node<T>(item2);
		p.next = q;
		first = p;
		return first;
	}

	// To insert at an element at particular position
	public Node<T> insertAtPosition(int position, T item, Node<T> first) {
		Node<T> current = first;
		Node<T> newNode = new Node<T>(item);
		if (position == 0) {
			first = newNode;
			newNode.next = current;
			return first;

		} else if (position > 0) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		return first;
	}

	// To delete an element at particular position
	public Node<T> deleteAtPosition(int position, Node<T> first, int n) {
		Node<T> current = first;
		Node<T> previous = first;
		int i;
		if (position == 0) {
			first = first.next;
			return first;
		} else if (position == (n - 1)) {
			for (i = 0; i <= n - 1; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			return previous;
		} else {
			for (i = 1; i < position; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}
		return current;
	}

	// To retrieve an element at particular position
	public T retrieveAtPosition(int position, Node<T> first) {
		Node<T> current = first;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current.nodeValue;
	}

	//To display all the node values
	public void display(Node<T> first) {
		Node<T> current = first;
		while (current != null) {
			System.out.println(current.nodeValue);
			current = current.next;
		}

	}

	//To reverse a linked list
	public Node<T> reverseLinkedList(Node<T> first) {
		if (first == null || first.next == null) {
			return first;
		}
		Node<T> Second = first.next;
		// store third node before we change
		Node<T> Third = Second.next;
		// Second's next pointer
		Second.next = first; // second now points to head
		first.next = null; // change head pointer to NULL
		// only two nodes, which we already reversed
		if (Third == null)
			return Second;
		Node<T> CurrentNode = Third;
		Node<T> PreviousNode = Second;
		while (CurrentNode != null) {
			Node<T> NextNode = CurrentNode.next;
			CurrentNode.next = PreviousNode;
			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}
		first = PreviousNode; // reset the head node

		return first;
	}

	//To calculate length of linkedList
	public int calculateLength(Node<T> first) {
		int count = 1;
		Node<T> current = first;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	//Delete value by position
	public Node<T> deleteAtValue(Node<T> first, String value, int n) {
		Node<T> current = first;
		Node<T> previous = first;
		if (current.nodeValue.equals(value)) {
			first = current.next;
		} else {

			while (current.next != null) {
				previous = current;
				current = current.next;
				if (current.nodeValue.equals(value)) {
					previous.next = current.next;
				}

			}
		}
		return first;
	}

	//Sorting a linked list <generic type>
	Node<T> sort(Node<T> first) {
		Node<T> tempNode1 = first, tempNode2;
		String temp;
		while (tempNode1 != null) // apply simple sorting to sort the elements
									// of Linked list
		{
			tempNode2 = first;
			while (tempNode2.next != null) {
				if (((String) tempNode2.nodeValue)
						.compareTo((String) tempNode2.next.nodeValue) > 0) {
					temp = (String) tempNode2.nodeValue;
					tempNode2.nodeValue = tempNode2.next.nodeValue;
					tempNode2.next.nodeValue = (T) temp;
				}
				tempNode2 = tempNode2.next;
			}
			tempNode1 = tempNode1.next;
		}
		return first;
	}

	//main function to perform operations
	public static void main(String args[]) {
		LinkedListOperations<String> object = new LinkedListOperations<String>();
		Scanner sc = new Scanner(System.in);
		int choice;
		int position;
		Node<String> second = null;
		String input = new String();

		do {
			System.out.println("1) Creation of linked list");
			System.out
					.println("2) Add the particular item in the linked list at the particular location");
			System.out.println("3) Removal of an item based on its value ");
			System.out.println("4) Removal of an item based on its index");
			System.out.println("5) Retrieval of an item of particular index");
			System.out.println("6) Reversal of linked list");
			System.out.println("7) Sorting of linked list");
			do {// Validation
				System.out.println("Please enter a positive number!");
				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);

			switch (choice) {
			case 1://To perform first operation of creating a linked list
				System.out
						.println("Enter a generic value to create a linked list");
				String line1 = sc.next();
				String line2 = sc.next();
				second = object.createLinkedList(line1, line2);
				System.out.println("After node creation");
				object.display(second);
				break;

			case 2:
				//To insert an element at given position
				System.out.println("Enter a string to be inserted");
				input = sc.next();
				System.out.println("Enter position of string to be inserted");
				position = sc.nextInt();
				System.out.println("After inserting at required position");
				second = object.insertAtPosition(position, input, second);
				object.display(second);

				break;

			case 3://To delete an element for a given value
				System.out.println("Enter string to be deleted");
				second = object.deleteAtValue(second, sc.next(),
						object.calculateLength(second));
				object.display(second);
				break;

			case 4://To delete an element at a given position
				System.out.println("Enter position of string to be deleted");
				position = sc.nextInt();
				System.out.println("After deleting at required position");
				second = object.deleteAtPosition(position, second,
						object.calculateLength(second));
				object.display(second);
				break;

			case 5://To retrieve an element at given position
				System.out.println("To retrieve at a particular position");
				System.out.println("Enter position of string to be retrieved");
				position = sc.nextInt();
				String str = object.retrieveAtPosition(position, second);
				System.out.println(str);
				break;
				
			case 6://To reverse a linked list
				System.out.println("Reverse Linked list");
				second = object.reverseLinkedList(second);
				object.display(second);
				break;
				
			case 7://Sort the linked list
				System.out.println("Sorting Linked list");
				object.sort(second);
				object.display(second);
				break;
			default:
				System.out.println("Enter Correct Choice");
			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!sc.hasNext()) {
					System.out.println("That's not a character!");
					sc.next(); // this is important!

				}
				choice = sc.next().toUpperCase().charAt(0);
				if (choice == 'N')
					System.exit(0);
			} while (choice != 'Y');

		} while (choice == 'Y');
		sc.close();
	}
}
