package CollegeCounseling;

import java.util.Arrays;

public class Students {
	private int front = -1;
	private int rear = -1;
	private String[] studentNameList;
	private int[] studentRanklist;

	// constructor to initialize limit of list
	Students(int length) {
		studentNameList = new String[length];
		studentRanklist = new int[length];
	}

	
	
	// to add student
	public void enqueue(String name, int rank) {
		if (front < 200) {
			if (front == -1 && rear == -1) {
				front++;
				rear++;

			} else {
				rear++;
			}
			studentRanklist[rear] = rank;
			studentNameList[rear] = name;
		} else {
			studentNameList = Arrays.copyOf(studentNameList,
					studentNameList.length + 10);
			rear++;
			studentNameList[rear] = name;
			studentRanklist[rear] = rank;
		}

	}

	// to remove student
	public String dequeue() {
		String name;
		if (rear != -1) {
			name = studentNameList[front];
			front++;
		} else {
			System.out.println("queue empty");
			name = "";
		}
		return name;
	}

	// to clear list
	public void makeEmpty() {
		studentNameList = null;
		front = -1;
		rear = -1;
		studentRanklist = null;
	}

	// to get name at top of queue
	public String getFront() {
		if(front!=-1){
		return studentNameList[front];
		}
		else{
		return "noName";
		}
	}
		

	// for sorting
	public void sortingByRank() {
		String forName = "";
		int forRank;

		for (int i = 0; i < (studentNameList.length); i++) {
			for (int j = i; j < studentNameList.length - 1; j++) {
				if (studentRanklist[j] > studentRanklist[j + 1]) {
					forName = studentNameList[j + 1];
					studentNameList[j + 1] = studentNameList[j];
					studentNameList[j] = forName;

					forRank = studentRanklist[j + 1];
					studentRanklist[j + 1] = studentRanklist[j];
					studentRanklist[j] = forRank;
				}

			}

		}

	}


	
}
