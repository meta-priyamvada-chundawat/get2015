//Program to insert an element in sorted linked list
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Class to input sorted linked list from user using recursion
public class SortedLinkedList {

	List<Integer> node = new LinkedList<Integer>();
	Iterator<Integer> itr1 = node.iterator();

	public static void main(String args[]) {
		SortedLinkedList obj = new SortedLinkedList();
		Scanner scan = new Scanner(System.in);
		int size, i, input;
		int element;
		// Input number of elements from user
		System.out.println("Enter number of elements to be added");
		size = scan.nextInt();
		// Input the elements from user
		for (i = 0; i < size; i++) {
			element = scan.nextInt();
			obj.node.add(element);
		}
		// Input the new element to be added
		System.out.println("Enter new element to be added");
		input = scan.nextInt();
		// Calling insert function
		obj.addElements(0, input);
		Iterator<Integer> itr = obj.node.iterator();
		// Printing values after insertion
		while (itr.hasNext()) {
			Object a = itr.next();
			System.out.println(a);
		}
		scan.close();
	}

	// To add elements in a linked list in a recursive manner
	public void addElements(int index, int element) {
		if (itr1.hasNext()) {
			int output = node.get(index);
			if (output <= element) {
				index++;
				// Passing index of element in function recursively
				addElements(index, element);
			} else {
				// Base condition to return from function
				node.add(index, element);
				return;
			}
		}
	}
}