public class Bike extends Vehicle {
	boolean selfStart;
	int helmetPrice;

	Bike() {
		this.make = null;
		this.model = null;
	}

	Bike(boolean selfStart) {
		this.selfStart = selfStart;
	}

	Bike(int helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	Bike(String make, String model) {
		this.make = make;
		this.model = model;
	}
	
	public boolean isSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public int getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(int helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

}
