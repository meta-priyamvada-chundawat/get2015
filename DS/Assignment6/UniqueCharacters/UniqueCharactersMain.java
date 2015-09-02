import java.io.IOException;
import java.util.Scanner;

//Class to call cache function and check unique characters in a string
public class UniqueCharactersMain {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (choice != 1) {
			//Input string from user
			System.out.println("enter string");
			String input = null;
			input = scan.nextLine();
			UniqueCharacters object = new UniqueCharacters();
			//To count the number of unique characters
			object.uniqueCharacterCount(input);
			System.out
					.println(" enter 1  to exit and any other  integer value to continue");
			choice = scan.nextInt();
		}
	}
}
