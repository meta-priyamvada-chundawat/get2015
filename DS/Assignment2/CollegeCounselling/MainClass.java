package CollegeCounseling;

import java.util.Scanner;

//main class
public class MainClass {

	// main function
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		College college = new College();
		String name;
		int rank;
		int choice;
		int noOfStudents;
		System.out.println("enter total number of students");
		do {// Validation
			while (!scanner.hasNextInt()) {
				System.out
						.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			noOfStudents = scanner.nextInt();
		} while (noOfStudents <= 0);
	
		Students students = new Students(noOfStudents);
		do {
			System.out.println("1 to Add name and rank of all the students who want to apply");
			System.out.println("2 to get list of available colleges");
			System.out.println("3 to select a college");
			System.out.println("4 to print list of names of students alloted to colleges");
			System.out.println("5 to clear list");
			System.out.println("6 to exit");
			do {// Validation
				while (!scanner.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scanner.next(); // this is important!
				}
				choice = scanner.nextInt();
			} while (choice <= 0);

			switch (choice) {

			case 1:// to add students

				for (int i = 0; i < noOfStudents; i++) {
					System.out.println("enter name");
					name = scanner.next();
					System.out.println("enter rank");
					do {// Validation
						while (!scanner.hasNextInt()) {
							System.out.println("That's not a number!Please enter again");
							scanner.next(); // this is important!
						}
						rank = scanner.nextInt();
					} while (rank <= 0);

					
					students.enqueue(name, rank);
				}
				students.sortingByRank();
				break;

			case 2:// to print list of available colleges
				college.listOfCollegesWithAvailableSeats();
				break;

			case 3: // for allotment
				if(students.getFront().equals("noName")){
					System.out.println("Please enter Details of student by choosing correct option");
					break;
				}
				for (int i = 0; i < noOfStudents; i++) {

					int check;
				
					name = students.getFront();
				
					do {
						college.selectCollege();
						System.out.println(name + "  enter your choice");
						rank = scanner.nextInt();
						check = college.allotToStudent(rank, name);
					} while (check != 1);
					name = students.dequeue();
					System.out.println(name + "  was alloted");
				}
				
				break;
				
			case 4:// to print list of students alloted to colleges
				college.printListOfNamesOfStudentsAlloted();
				break;

			case 5: // to empty lists
				students.makeEmpty();
				System.out.println("list cleared");
				break;

			default:
				System.out.println("invalid input");
				break;
			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!scanner.hasNext()) {
					System.out.println("That's not a character!");
					scanner.next(); // this is important!

				}
				choice = scanner.next().toUpperCase().charAt(0);
				if (choice == 'N')
					System.exit(0);
			} while (choice != 'Y');

		} while (choice == 'Y');

	}
}
