package default;

//has list of college
public class College {
	static int[] allocatedSeats = new int[5];
	static String[][] allotmentList = new String[5][4];

	public int checkingIfPossible(String name, int choice) {
		if (allocatedSeats[choice-1] < 4) {// check for seat if available or not
			allotmentList[choice-1][(allocatedSeats[choice-1])] = name;
			allocatedSeats[choice-1] = allocatedSeats[choice-1] + 1;
			System.out.println(allocatedSeats[choice-1]);
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}
	
	//returns 0 if not alloted, 1 if alotted, -1 for wrong input
	int allotToStudent(int choice, String Name){
		
		return checkingIfPossible(Name,choice);
	
	}

	// print list of colleges with available seats
		public void listOfCollegesWithAvailableSeats() {
			System.out.println("List of college        Seats Available");
			System.out.println("MLV   	           " + (4 - allocatedSeats[0]));
			System.out.println("MIT    		       " + (4 - allocatedSeats[1]));
			System.out.println("JCERC  		       " + (4 - allocatedSeats[2]));
			System.out.println("ARYA  		       " + (4 - allocatedSeats[3]));
			System.out.println("TINJR  		       " + (4 - allocatedSeats[4]));

		}

		// print choices
		public void selectCollege() {
			System.out.println("Enter choice 1 for MLV, 2 for MIT, 3 for JCERC, 4 for ARYA, 5 for TINJR");
		}

		// print list of students alloted to each college
		public void printListOfNamesOfStudentsAlloted() {
			
			System.out.println("College name and  Names of Students alloted to them");
			
			
			String[] collegeList = { "MLV", "MIT", "JCERC", "ARYA", "TINJR" };
			for (int i = 0; i < 5; i++) {
				System.out.println("List of students admitted in  "+ collegeList[i]);
				if( allocatedSeats[i]==0){
				System.out.println("No seats allocated");
				}
				else{
					for (int j = 0; j < allocatedSeats[i]; j++) {
						System.out.println(allotmentList[i][j]);
					}
				}
			}
		}

}
