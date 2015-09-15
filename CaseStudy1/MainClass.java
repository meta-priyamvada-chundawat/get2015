public class MainClass {
	// To create vehicle type
	public static void main(String args[]) {
		Vehicle vehicle = new Vehicle();
		vehicle = VehicleHelper.createVehicle("CAR", "YES", "abc");
		String a = VehiclePrinter.printVehicleSpecification(vehicle);
		System.out.println(a);
	}
}
