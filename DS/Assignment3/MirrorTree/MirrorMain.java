import java.util.Scanner;

//Class to check if two trees are mirror images or not
public class MirrorMain<T> {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int numberOfNodes;
		// Strings to store result of inorder traversal
		String result1 = "";
		String result2 = "";
		TreeOperations object = new TreeOperations();
		TreeOperations object1 = new TreeOperations();
		int element;
		// Entering values in first tree
		System.out.println("Enter 1st tree");
		System.out.println("Enter the number of nodes");
		numberOfNodes = scan.nextInt();
		Node root1 = new Node(scan.nextInt());
		for (int i = 0; i < numberOfNodes - 1; i++) {
			System.out.println("Insert an element");
			element = scan.nextInt();
			object.insertLeft(root1, element);
		}
		// Entering values in second tree
		System.out.println("Enter 2nd tree");
		System.out.println("Enter the number of nodes");
		numberOfNodes = scan.nextInt();
		Node root2 = new Node(scan.nextInt());
		for (int i = 0; i < numberOfNodes - 1; i++) {
			System.out.println("Insert an element");
			element = scan.nextInt();
			object1.insertRight(root2, element);
		}
		// For storing result of inorder traversal
		result1 = object.mirror(root1);
		System.out.println(result1);
		result2 = object1.mirror(root2);
		System.out.println(result2);
		// reversing the string
		String reverse = new StringBuffer(result2).reverse().toString();
		System.out.println(reverse);
		if (result1.equals(reverse))
			System.out.println("mirror");
		else
			System.out.println("not mirror");
	}
}
