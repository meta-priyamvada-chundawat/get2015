//Class to traverse in pre order and post order
class BinaryTreeTraversal<T> {
	private Node<T> root;

	BinaryTreeTraversal() {
		root = null;
	}

	//To insert an element
	public void insert(int element) {
		root = insert(root, element);
	}

	private Node<T> insert(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data > element) {

				node.left = insert(node.left, element);
			} else {
				node.right = insert(node.right, element);
			}
		}
		return node;
	}

	//To traverse in pre order
	public void traversePreorder() {
		traversePreorder(root);
	}

	private void traversePreorder(Node r) {
		if (r != null) {
			System.out.print(r.data + ",");
			traversePreorder(r.left);
			traversePreorder(r.right);
		}
	}

	//To traverse in post order
	public void traversePostorder() {
		traversePostorder(root);
	}

	private void traversePostorder(Node r) {
		if (r != null) {
			traversePostorder(r.left);
			traversePostorder(r.right);
			System.out.print(r.data + ",");
		}
	}

}