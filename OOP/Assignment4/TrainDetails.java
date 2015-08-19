import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Priyamvada--- THIS CLASS IS USED FOR FATCHING DATA FROM A FILE AND
 *         STORING IT IN A LIST ACCORDING TO ITS DATA
 *
 */
public class TrainDetails {

	static List<PassengerTrain> passengerList;
	static List<GoodsTrain> goodsList;

	public static void readTrainInfo() {

		passengerList = new ArrayList<PassengerTrain>(); // LIST TO STORE DATA
															// OF PASSENGER
															// TRAIN
		goodsList = new ArrayList<GoodsTrain>();
		BufferedReader br;
		try {
			// Reading the questions stored in the file
			br = new BufferedReader(new FileReader("E://TrainInfo.txt"));// READING
																			// FROM
																			// FILE
			String line = " ";
			String[] trainDetails;
			while ((line = br.readLine()) != null) {
				trainDetails = line.split(","); // Reading up details line by
												// line

				if (trainDetails[1].equals("1")) {// ADDING DETAILS IN PASSENGER
													// LIST
					passengerList.add(new PassengerTrain(Integer
							.parseInt(trainDetails[0]), trainDetails[2].trim(),
							trainDetails[3].trim(), Double
									.parseDouble(trainDetails[5].trim()),
							Double.parseDouble(trainDetails[6].trim()), Integer
									.parseInt(trainDetails[1].trim()), Integer
									.parseInt(trainDetails[4].trim())));
				}
				if (trainDetails[1].equals("2")) {// ADDING DETAILS IN GOODS
													// LIST
					goodsList.add(new GoodsTrain(Integer
							.parseInt(trainDetails[0]), trainDetails[2].trim(),
							trainDetails[3].trim(), Double
									.parseDouble(trainDetails[5].trim()),
							Double.parseDouble(trainDetails[6].trim()), Integer
									.parseInt(trainDetails[1].trim()), Double
									.parseDouble(trainDetails[4].trim())));
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println(e);

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
