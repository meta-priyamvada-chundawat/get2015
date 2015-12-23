package Assignment;


/**
 * @author Priyamvada
 *
 */
public class CharAt {
	private char value[];

	public CharAt(String value) {
		this.value = value.toCharArray();
	}

	public CharAt() {
		this.value = new char[0];

	}

	public char charAt(int index) {
		if ((index < 0) || (index >= value.length)) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return value[index];
	}
}
