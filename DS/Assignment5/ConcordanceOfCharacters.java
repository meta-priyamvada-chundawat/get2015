//Program to find occurrence of elements in a string
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//Class to find concordance of characters occurring in a string
public class ConcordanceOfCharacters {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ConcordanceOfCharacters obj = new ConcordanceOfCharacters();
		String input = new String();
		// Input string from user
		System.out.println("Enter the string");
		input = scan.next();
		// Calculate string length
		int len = input.length();
		// HashSet for storing unique characters
		Set<Character> setA = new HashSet<Character>();
		for (int i = 0; i < len; i++) {
			setA.add(input.charAt(i));
		}
		obj.findConcordance(setA, input);
		scan.close();
	}

	// Function to store occurrence of characters in a string array
	public void findConcordance(Set<Character> setA, String input) {
		int len = input.length();
		int k = 0;
		String result[] = new String[len];
		Iterator<Character> itr = setA.iterator();
		while (itr.hasNext()) {
			char element = (char) itr.next();
			for (int i = 0; i < len; i++) {
				if (element == input.charAt(i)) {
					if (result[k] == null)
						result[k] = "" + i;
					else
						result[k] = result[k] + i;
				}
			}
			k++;
		}
		// Printing result
		Iterator<Character> itr1 = setA.iterator();
		while (itr1.hasNext()) {
			for (int i = 0; i < k; i++) {
				char element = itr1.next();
				System.out.println(element + result[i]);
			}
		}
	}
}