//Class containing check for mirror functions and insertion functions
public class TreeOperations<T> {

	String result = "";

	// To start inserting from left child
	public Node<T> insertLeft(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data > element) {

				node.left = insertLeft(node.left, element);
			} else {
				node.right = insertLeft(node.right, element);
			}
		}
		return node;
	}

	// To start inserting from right child
	public Node<T> insertRight(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data < element) {

				node.left = insertRight(node.left, element);
			} else {
				node.right = insertRight(node.right, element);

			}
		}
		return node;
	}

	// To check for mirror image
	public String mirror(Node<T> r1) {
		if (r1 != null) {
			mirror(r1.left);
			result = result + r1.data;
			mirror(r1.right);
		}
		return result;

	}

}
