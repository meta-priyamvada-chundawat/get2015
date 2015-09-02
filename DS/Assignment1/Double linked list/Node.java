//Class to create a self referencing node
public class Node<T> {
	public T nodeValue;
	public Node<T> next;
	public Node<T> prev;

	Node() {
		nodeValue = null;
		next = null;
		prev = null;
	}

	Node(T item) {
		nodeValue = item;
		next = null;
		prev = null;
	}

}

