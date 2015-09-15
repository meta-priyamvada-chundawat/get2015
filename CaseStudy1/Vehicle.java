// Class Vehicle that sores all the attributes of vehicle
public class Vehicle {
	String make;
	String model;
	int engineInCC;
	int fuelCapacity;
	int milage;
	int price;
	int roadTax;

	// Get value of Vehicle type
	public String getMake() {
		return make;
	}

	// Set value of Vehicle type
	public void setMake(String make) {
		this.make = make;
	}

	// Get value of model
	public String getModel() {
		return model;
	}

	// Set value of model
	public void setModel(String model) {
		this.model = model;
	}

	// Get value of Engine type
	public int getEngineInCC() {
		return engineInCC;
	}

	// Set value of Engine type
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	// Get value of Fuel Capacity
	public int getFuelCapacity() {
		return fuelCapacity;
	}

	// Set value of Fuel Capacity
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	// Get value of milage
	public int getMilage() {
		return milage;
	}

	// Set value of milage
	public void setMilage(int milage) {
		this.milage = milage;
	}

	// Get value of Price
	public int getPrice() {
		return price;
	}

	// Set value of Price
	public void setPrice(int price) {
		this.price = price;
	}

	// Get road tax
	public int getRoadTax() {
		return roadTax;
	}

	// Set road tax
	public void setRoadTax(int roadTax) {
		this.roadTax = roadTax;
	}

	// Calculate on road price
	public int calculateOnRoadPrice() {
		return (price + roadTax);
	}

	// Overwriting toString function to display result
	public String toString() {
		// function returning the parameters of object
		return "make:" + getMake() + "," + "model:" + getModel();

	}

}
