package default;

import java.util.Stack;

//Class to implement stack operations
public class StackLinkList {
	protected static StackNode start;
	protected static StackNode end;
	public static int size;

	//To enter or push an element
	public static void push(String item) {
		StackNode nptr = new StackNode(item);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}

	}

	//pop an element
	public static String pop() {
		String string = start.data;
		start = start.getLink();
		size--;
		return string;
	}

	//to display top-most element
	public static String peek() {
		String string = start.data;

		return string;
	}
	
	//to check if char is alphabet or digit
	boolean isAlpha(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
			return true;
		else
			return false;

	}

	//to check for operators
	private boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Name: checkPrecedence
	 * 
	 * @param c1
	 * @param c2
	 * @return Description: checks the precedence
	 **/
	private boolean checkPrecede(char c1, char c2) {
		if ((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-')) {
			return true;
		} else if ((c2 == '*' || c2 == '/')
				&& (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/')) {
			return true;
		}

		else {
			return false;
		}
	}

	/**
	 * Name: convert
	 * 
	 * @param infix
	 * @return Description: Converts infix expression to postfix
	 **/
	public String convert(String infix) {
	
		String postfix = "";	// equivalent postfix is empty initially
	
			// stack to hold symbols
	
		push("#");	// symbol to denote end of stack
		for (int i = 0; i < infix.length(); i++) {
		
			char inputSymbol = infix.charAt(i);	// symbol
			if (isOperator(inputSymbol)) {
				while (checkPrecede(inputSymbol, peek().charAt(0))) {
					postfix += pop();
				}
				push(Character.toString(inputSymbol));
			} else if (inputSymbol == '(') {
				push(Character.toString(inputSymbol));	// push if left parenthesis
			} else if (inputSymbol == ')') {
			
				while (!peek().equals("(")) {	// repeatedly pops if right parenthesis until left parenthesis is found
					postfix += pop();
				}
				pop();
			} else {
				postfix += inputSymbol;
			}
		}
	
		while (!peek().equals("#") )	// pops all elements of stack left
		{
			postfix += pop();
		}
		return postfix;
	}

	//to display elements
	public void display() {

		System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.println("empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		StackNode ptr = start;
		System.out.println(start.getData());
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getLink();
		}
		System.out.println(ptr.getData() + "\n");

	}

}
