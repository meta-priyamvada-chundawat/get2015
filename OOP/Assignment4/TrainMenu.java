import java.util.*;

/**
 * @author Priyamvada--- Showing train menu
 *
 */
public class TrainMenu {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int tempVar;
		do {
			int count = 0;

			String fromPlace, toPlace;
			System.out.println("Enter your name");

			String userName = sc.next();
			MenuList menulist = new MenuList();
			int trainType;
			do {
				menulist.displayMenu();
				trainType = sc.nextInt();
				if ((trainType != 1) && (trainType != 2)) {
					System.out.println("Enter right values");

				}
			} while ((trainType != 1) && (trainType != 2));
			Procedure procedure = new Procedure();
			procedure.displayChart(trainType);

			System.out.println("Enter from where are you going");
			fromPlace = sc.next();
			System.out.println("Enter where are you going");
			toPlace = sc.next();
			procedure.availableTrains(trainType, fromPlace, toPlace);

			if (trainType == 1) {
				System.out.println("Enter train id ");
				int trainid = sc.nextInt();

				Iterator<PassengerTrain> itr = TrainDetails.passengerList
						.iterator();
				while (itr.hasNext()) {
					PassengerTrain object1 = itr.next();
					if ((object1.trainId == trainid)) {
						System.out.println("Enter no of seats");// tracking
																// seats
						int seats = sc.nextInt();
						if (seats < object1.seats) {
							double amount = seats * object1.price;
							int newSeats = object1.seats - seats;
							object1.setSeats(newSeats);

							menulist.displayPaymentMenu();// tracking payment
							int paymentType = sc.nextInt();
							PaymentMode paymentmode = new PaymentMode();
							if (paymentType == 1) {
								paymentmode.creditCard(amount);
							} else if (paymentType == 2) {
								paymentmode.wallet(amount);
							} else if (paymentType == 3) {
								paymentmode.netBanking(amount);
							} else {
								System.out.println("enter right value");

							}
							System.out.println("YOUR DETAILS");// showing
							// details
							// of ticket
							System.out.println("TRAINID-------" + trainid);
							System.out.println("UserName---" + userName);
							System.out.println("FROM----" + fromPlace);
							System.out.println("TO-------" + toPlace);
							System.out.println("SEATS----" + seats);
							System.out.println("AMOUNT---" + amount);

						} else {
							System.out
									.println("seats are less. Try another one");
							menu();

						}
					} else {
						count = count + 1;
					}

				}
				if (count == TrainDetails.passengerList.size()) {
					System.out.println("your id is wrong.No such trains");
					menu();
				}

			}

			if (trainType == 2) {

				System.out.println("Enter train id ");
				int trainid = sc.nextInt();

				Iterator<GoodsTrain> itr = TrainDetails.goodsList.iterator();
				while (itr.hasNext()) {
					GoodsTrain object1 = itr.next();
					if ((object1.trainId == trainid)) {
						System.out.println("Enter weight");// tracking weight
						double weight = sc.nextDouble();
						if (weight < object1.weight) {
							double amount = weight * object1.price;
							double newWeight = object1.weight - weight;
							object1.setWeight(newWeight);
							menulist.displayPaymentMenu();
							int paymentType = sc.nextInt();
							PaymentMode paymentmode = new PaymentMode();// tracking
																		// payment
							if (paymentType == 1) {
								paymentmode.creditCard(amount);
							} else if (paymentType == 2) {
								paymentmode.wallet(amount);
							} else if (paymentType == 3) {
								paymentmode.netBanking(amount);
							} else {
								System.out.println("enter right value");

							}

							System.out.println("YOUR DETAILS");// ticket
							// details
							System.out.println("TRAIN ID-------" + trainid);
							System.out.println("UserName---" + userName);
							System.out.println("FROM----" + fromPlace);
							System.out.println("TO-------" + toPlace);
							System.out.println("WEIGHT----" + weight);
							System.out.println("AMOUNT---" + amount);

						} else {
							System.out
									.println("seats are less. Try another one");
							menu();

						}
					} else {
						count = count + 1;
					}
					if (count == TrainDetails.goodsList.size()) {
						System.out.println("your id is wrong.No such trains");
						menu();
					}

				}

			}
			System.out.println("Press 0 if you want to continue");
			System.out.println("Else Press anythinng else if you want to exit");
			tempVar = sc.nextInt();
		} while (tempVar == 0);

		sc.close();
	}

}
