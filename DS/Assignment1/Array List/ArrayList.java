package Session1;

import java.util.Scanner;

public class ArrayList {
	
	public static void main(String args[]) {
		int position,result;
		Scanner sc= new Scanner(System.in);
		ArrayListFunctions arrayListFunctionsObj = new ArrayListFunctions();
		 ArrayListFunctions arrayListFunctions = new ArrayListFunctions();
		int choice;
	
		do {
		System.out.println("1) Adding an item into array list and check if list is full, then resizing that arraylist");
		System.out.println("2) Adding an item into array list at the given particular location i");
		System.out.println("3) Retrieving the first occurrence of an item based on its given location");
		System.out.println("4) Retrieving the first index of particular item in the arraylist");
		System.out.println("5) Removing an item based on particular location");
		System.out.println("6) Remove given particular item from the arraylist");  
		System.out.println("7) Clear the list i.e. remove all the elements of the list");
		System.out.println("8) Reverse the arraylist");
		System.out.println("9) Show the elements of arraylist");
		System.out.println("10) Sort the elements of arraylist");
		System.out.println("11) Adding element to list 2");
		System.out.println("12) Merge List 1 with List 2");
			do {// Validation
				System.out.println("Please enter a positive number!");
				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);

			switch (choice) {
			case 1:
				System.out.println("Enter a value");
				arrayListFunctionsObj.addItem(sc.nextInt());
				break;

			case 2:
				System.out.println("Enter position where value to be inserted");
				position=sc.nextInt();
				System.out.println("Enter a value");
				arrayListFunctionsObj.addItem(sc.nextInt(),position-1);
			
				break;

			case 3:
				System.out.println("Enter position after which element to be found");
				position=sc.nextInt();
				System.out.println("Enter a value");
				result = arrayListFunctionsObj.firstOcccurence(sc.nextInt(), position-1);
				if(result == -1)
					System.out.println("not found in the list afer given index");
				else
					System.out.println("item is found at "+result+" index");
				break;

			case 4:
				System.out.println("Enter a value");
				result =arrayListFunctionsObj.firstIndex(sc.nextInt());
				if(result == -1)
					System.out.println("not found in the list");
				else
					System.out.println("item is found at "+result+" index");
				
				break;

			case 5:
				System.out.println("Enter position at which element to be removed");
				position=sc.nextInt();
				arrayListFunctionsObj.remove(position-1);
				break;
			case 6:
				System.out.println("Enter a value to be removed");
				arrayListFunctionsObj.remove(sc.nextInt());
				
				break;
			case 7:
				arrayListFunctionsObj.clear();
				System.out.println("Elements are:");
				arrayListFunctionsObj.show();
				break;
			case 8:
				arrayListFunctionsObj.reverse();
				System.out.println("Elements are:");
				arrayListFunctionsObj.show();
				break;
			case 9:
				System.out.println("Elements are:");
				arrayListFunctionsObj.show();
				break;
			case 10:
				arrayListFunctionsObj.sort();
				System.out.println("Elements are:");
				arrayListFunctionsObj.show();
				break;
			case 11:
				System.out.println("Enter a value");
				arrayListFunctions.addItem(sc.nextInt());
				
				break;
			case 12:
				arrayListFunctions.show();
				arrayListFunctionsObj.merge(arrayListFunctions);
				System.out.println("Elements are:");
				arrayListFunctionsObj.show();
				break;
			default:
				System.out.println("Enter Correct Choice");
			}
			do{//validation
				System.out.println("Do you want to continue(Y/N)");	// continuing the procedure
		        while (!sc.hasNext()) {
		            System.out.println("That's not a character!");
		            sc.next(); // this is important!
		           
		        }
		        choice = sc.next().toUpperCase().charAt(0);
		        if(choice=='N')
	            	System.exit(0);
			} while (choice!='Y');		  

		} while (choice=='Y');
		sc.close();
	}

}

