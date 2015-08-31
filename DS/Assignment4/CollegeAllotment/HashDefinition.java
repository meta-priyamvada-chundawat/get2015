//Class to manage student entry in hash maps
public class HashDefinition {
      private int key;
      private int age;
      private String name;
 
      HashDefinition(int key, int age,String name) {
            this.key = key;
            this.age = age;
            this.name=name;
      }     
 
      public int getKey() {
            return key;
      }
 
      public int getAge() {
            return age;
      }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @param value the value to set
	 */
	public void setAge(int value) {
		this.age = value;
	}
}