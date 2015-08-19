import java.util.Iterator;
import java.util.Scanner;

//class to display traveling chart information
public class Procedure {

	// function to display train chart
	public void displayChart(int choice) {

		if (choice == 1) {
			System.out.println("---CURRENT TRAVELLING CHART");
			System.out
					.println("TRAIN No	STARTINGPOINT	ENDPOINT	PRICE		DURATION	SEATSAVAILABLE");
			Iterator<PassengerTrain> itr3 = TrainDetails.passengerList
					.iterator();
			while (itr3.hasNext()) {
				PassengerTrain object5 = itr3.next();
				System.out.println(object5.trainId + "		" + object5.fromPlace
						+ "		" + object5.toPlace + "		" + object5.price + "		"
						+ object5.duration + "		" + object5.seats);

			}

		} else if (choice == 2) {
			System.out.println("---CURRENT TRAVELLING CHART");
			System.out
					.println("TRAIN No	STARTINGPOINT	 ENDPOINT	PRICE	  DURATION	WEIGHTAVAILABLE");
			Iterator<GoodsTrain> itr4 = TrainDetails.goodsList.iterator();
			while (itr4.hasNext()) {
				GoodsTrain object5 = itr4.next();
				System.out.println(object5.trainId + "		" + object5.fromPlace
						+ "		 " + object5.toPlace + "	" + object5.price
						+ "     " + object5.duration + "		" + object5.weight);

			}

		} else {
			System.out.println("enter right values");

		}

	}

	// function to sort trains according to duration
	public void sortChart() {
		PassengerTrain temp;
		GoodsTrain temp1;

		for (int index = 0; index < TrainDetails.passengerList.size(); index++) {
			for (int i = 0; i < TrainDetails.passengerList.size(); i++) {
				double totalTime1 = ((TrainDetails.passengerList).get(index).duration);
				double totalTime2 = (TrainDetails.passengerList.get(i).duration);
				if (totalTime1 < totalTime2) {
					temp = TrainDetails.passengerList.get(index);
					TrainDetails.passengerList.set(index,
							TrainDetails.passengerList.get(i));
					TrainDetails.passengerList.set(i, temp);
				}
			}
		}

		for (int index = 0; index < TrainDetails.goodsList.size(); index++) {
			for (int i = 0; i < TrainDetails.goodsList.size(); i++) {
				double totalTime1 = ((TrainDetails.goodsList).get(index).duration);
				double totalTime2 = (TrainDetails.goodsList.get(i).duration);
				if (totalTime1 < totalTime2) {
					temp1 = TrainDetails.goodsList.get(index);
					TrainDetails.goodsList.set(index,
							TrainDetails.goodsList.get(i));
					TrainDetails.goodsList.set(i, temp1);
				}
			}
		}

	}

	// function to return updated amounts
	public double printAvailableTrains(String startPoint, String endPoint,
			int type) {
		Scanner sc = new Scanner(System.in);
		int temp1 = 0;
		int temp2 = 0;
		double amount = 0;
		if (type == 1) {
			Iterator<PassengerTrain> itr = TrainDetails.passengerList
					.iterator();
			while (itr.hasNext()) {
				PassengerTrain object1 = itr.next();
				if ((object1.fromPlace.equalsIgnoreCase(startPoint))
						&& (object1.toPlace.equalsIgnoreCase(endPoint))) {
					System.out.println("Enter no of seats");
					int seats = sc.nextInt();
					if (seats < object1.seats) {
						amount = seats * object1.price;
						int newSeats = object1.seats - seats;
						object1.setSeats(newSeats);
					} else {
						System.out.println("seats not available");
					}

				} else {
					temp1 = temp1 + 1;

				}
				if (temp1 == TrainDetails.passengerList.size()) {
					System.out.println("no such train");
				}

			}

		}
		if (type == 2) {
			Iterator<GoodsTrain> itr1 = TrainDetails.goodsList.iterator();
			while (itr1.hasNext()) {
				GoodsTrain object1 = itr1.next();
				if ((object1.getFromPlace().equalsIgnoreCase(startPoint))
						&& (object1.getToPlace().equalsIgnoreCase(endPoint))) {
					System.out.println("Enter weight");
					double weight = sc.nextDouble();
					if (weight < object1.weight) {
						double availWeight = object1.weight - weight;
						object1.setWeight(availWeight);
						amount = weight * object1.price;
					} else {
						System.out.println("Weight not available");
					}
				} else {
					temp2 = temp2 + 1;
				}
				if (temp2 == TrainDetails.goodsList.size()) {
					System.out.println("No such train");
				}

			}
		}
		return amount;
	}
}
