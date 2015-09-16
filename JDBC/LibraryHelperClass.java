// Helper class to execute all queries
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryHelperClass {
	private Connection con;
	private ResultSet rs;
	private java.sql.Statement stmt;
	private Scanner sc = new Scanner(System.in);

	// Constructor declaration
	public LibraryHelperClass() {
		con = null;
		rs = null;
		stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
	}

	// Main function to execute queries
	public static void main(String[] args) throws SQLException {
		int choice;
		char mainChoice;
		// Calling menu function
		MenuClass menuClass = new MenuClass();
		Utility utility = new Utility();
		LibraryHelperClass libraryHelperClass = new LibraryHelperClass();
		do {
			menuClass.menuForLibraryManagement();
			// Taking choice
			choice = utility.checkingChoice();
			switch (choice) {
			case 1:
				// To display all titles according to author_name
				List<Title> titleList = libraryHelperClass
						.getBooksDataRelatedToAuthor();
				System.out.println("List of Books:");
				// Validation for empty list returned by query
				if (titleList.isEmpty())
					System.out.println("No match found");
				for (Title title : titleList) {
					System.out.println(title.getTitleName());
				}
				break;
			case 2:
				// To add new members and issue book
				boolean flag = libraryHelperClass.addNewMemberAndIssueBook();
				if (flag == true) {
					System.out.println("Member inserted and book is issued");
				} else {
					System.out
							.println("Member not inserted or book is not issued");
				}
				break;
			case 3:
				// Delete books not issued for more than a year
				int numberOfBooks = libraryHelperClass
						.getNumberOfBooksNotUseful();
				System.out.println("Number of Books Not used since 1 year"
						+ numberOfBooks);
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
			mainChoice = utility.checkingString();
		} while (mainChoice == 'Y');
		// Closing connection
		libraryHelperClass.con.close();
	}

	// Function to display all titles according to author_name
	public List<Title> getBooksDataRelatedToAuthor() {
		System.out.println("Enter Name of Author");
		String query = "SELECT t.title_id,t.title_nm,t.subject_id,t.publisher_id FROM "
				+ "authors a inner join title_author ta ON a.author_id = ta.author_id "
				+ "inner join titles t where (t.title_id=ta.title_id AND a.author_nm='"
				+ sc.nextLine() + "')";
		List<Title> titleList = new ArrayList<Title>();
		try {
			stmt = con.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery(query);
			while (rs.next()) {
				Title title = new Title(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				titleList.add(title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleList;
	}

	// Function to add new members and issue book
	public boolean addNewMemberAndIssueBook() {
		Member member = new Member();
		Book book = null;
		boolean flag = false;
		String query;
		System.out.println("Enter New Member Name");
		member.setMemberName(sc.nextLine());
		System.out.println("Enter Address Line1 of Member");
		member.setAddressLineFirst(sc.nextLine());
		System.out.println("Enter Address Line2 of Member");
		member.setAddressLineSecond(sc.nextLine());
		System.out.println("Enter Category of Member");
		member.setCategory(sc.nextLine().charAt(0));
		System.out.println("Enter Person type of Member");
		member.setPersonType(sc.nextLine());
		query = "INSERT INTO Members (member_nm,addressLine1,addressLine2,category,person_type)"
				+ "VALUES( '"
				+ member.getMemberName()
				+ "','"
				+ member.getAddressLineFirst()
				+ "','"
				+ member.getAddressLineSecond()
				+ "','"
				+ member.getCategory()
				+ "','" + member.getPersonType() + "')";
		try {
			stmt = con.createStatement();
			int i = stmt.executeUpdate(query);
			if (i == 1) {
				System.out.println("Member inserted");
				query = "Select member_id from members where member_nm='"
						+ member.getMemberName() + "'";
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					member.setMemberId(rs.getInt(1));
				}
				System.out.println("Enter Name of Book for issue");
				String bookName = sc.nextLine();

				String query1 = "SELECT t.title_id,b.accession_no,b.purchase_dt,b.price,b.status from titles t inner join books b where (t.title_id=b.title_id AND t.title_nm='"
						+ bookName + "')";
				rs = stmt.executeQuery(query1);
				while (rs.next()) {
					book = new Book(rs.getInt(2), rs.getInt(1),
							rs.getString(3), rs.getDouble(4), rs.getInt(5));
				}
				if (book.getStatus() == 0) {
					query = "INSERT INTO book_issue (accession_no,member_id)"
							+ "VALUES(" + book.getAccessionNo() + ","
							+ member.getMemberId() + ")";
					i = stmt.executeUpdate(query);
					if (i == 1) {
						System.out.println("Member inserted into book issue");
						query = "Update books Set status=1 where accession_no="
								+ book.getAccessionNo();
						i = stmt.executeUpdate(query);
						if (i == 1) {
							System.out.println("Book Updated");
							flag = true;
						}
					} else {
						System.out.println("Member not inserted in book issue");
						flag = false;
					}
				} else {
					System.out.println("Book cannot be issued");
					flag = false;
				}
			} else {
				System.out.println("Member not inserted");
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Function to delete books not issued for more than a year
	public int getNumberOfBooksNotUseful() {
		PreparedStatement ps = null;
		int count = 0;
		String query = "select distinct b.accession_no from book_issue bi right join books b on b.accession_no=bi.accession_no "
				+ "AND bi.issue_dt=(Select max(issue_dt) from book_issue bi1  "
				+ "where bi1.accession_no=bi.accession_no group by (bi1.accession_no)) "
				+ "Where((DATEDIFF( NOW(), bi.issue_dt)>=365) or bi.issue_dt is null)";
		String query1 = "Delete from books where accession_no=?";
		String query2 = "Delete from book_issue where accession_no=?";
		String query3 = "Delete from book_return where accession_no=?";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					ps = con.prepareStatement(query2);
					ps.setInt(1, rs.getInt(1));
					ps.executeUpdate();
					ps = con.prepareStatement(query3);
					ps.setInt(1, rs.getInt(1));
					ps.executeUpdate();
					ps = con.prepareStatement(query1);
					ps.setInt(1, rs.getInt(1));
					count = count + ps.executeUpdate();
				}
			} else {
				System.out.println("No such book exists");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
