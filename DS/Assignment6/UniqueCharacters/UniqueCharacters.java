import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Class to find out unique characters in a string using cache mechanism
public class UniqueCharacters {
	//Map to store cache string and its size
	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	void uniqueCharacterCount(String input) {

		Set<Character> characterSet = new HashSet<Character>();
		//To check if input already exists in cache
		if (cache.containsKey(input)) {

			System.out.println("Number of Unique characters in "
					+ cache.get(input));
		} else {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == ' ') {
					i = i + 1;
				}
				characterSet.add(input.charAt(i));
			}
			//Storing values in cache
			cache.put(input, characterSet.size());
			System.out.println("Number of Unique characters in "
					+ characterSet.size());
		}

	}

}
