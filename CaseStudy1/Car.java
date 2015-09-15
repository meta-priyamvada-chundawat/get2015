// Car class that extends from Vehicle
public class Car extends Vehicle {
	String powerSteering;
	boolean airConditioner;
	String accessoryKit;

	// Default constructor
	Car() {
		this.make = null;
		this.model = null;
	}

	// Constructor to initialize Vehicle class attributes
	Car(String make, String model) {
		this.make = make;
		this.model = model;
	}

	// Get the value of PowerSteering
	public String getPowerSteering() {
		return powerSteering;
	}

	// Set the value of PowerSteering
	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}

	// Get the value of airConditioner
	public boolean isAirConditioner() {
		return airConditioner;
	}

	// Set the value of airConditioner
	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	// Get the value of AccessoryKit
	public String getAccessoryKit() {
		return accessoryKit;
	}

	// Set the value of AccessoryKit
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
}
