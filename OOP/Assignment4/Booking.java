import java.util.Scanner;

//Main class for train reservation system
public class Booking {

	public static void main(String[] args) {
		int type;
		int choice = 0;
		int input = 0;
		double amount = 0.0;
		String startPoint = "";
		String endPoint = "";
		Scanner scan = new Scanner(System.in);
		TrainDetails.readTrainInfo();
		Procedure procedure = new Procedure();
		MenuList menu = new MenuList();
		PaymentMode payment = new PaymentMode();
		procedure.sortChart();
		do {
			// calling display menu of type of train required
			menu.displayMenu();
			type = scan.nextInt();
			procedure.displayChart(type);
			System.out.println("Enter source place");
			startPoint = scan.next();
			System.out.println("Enter destination place");
			endPoint = scan.next();
			// calculating train fare
			amount = procedure.printAvailableTrains(startPoint, endPoint, type);
			menu.displayPaymentMenu();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				payment.creditCard(amount);
				break;
			case 2:
				payment.wallet(amount);
				break;
			case 3:
				payment.netBanking(amount);
				break;
			default:
				System.out.println("Wrong choice entered");
			}
			procedure.displayChart(type);
			System.out
					.println("Do you want to continue?Press 1 to continue and 0 to exit");
			input = scan.nextInt();
		} while (input == 1);
	}

}
