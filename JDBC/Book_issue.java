// POJO class of Book_issue
public class Book_issue {
	private String issueDate;
	private String returDate;
	private String accessionNoOfBookIssue;
	private String memberIdOfBookIssue;

	// Return issue date
	public String getIssueDate() {
		return issueDate;
	}

	// Set issue_date
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	// Return the return date
	public String getReturDate() {
		return returDate;
	}

	// Set the return date
	public void setReturDate(String returDate) {
		this.returDate = returDate;
	}

	// Return the book's accession number
	public String getAccessionNoOfBookIssue() {
		return accessionNoOfBookIssue;
	}

	// Set the book's accession number
	public void setAccessionNoOfBookIssue(String accessionNoOfBookIssue) {
		this.accessionNoOfBookIssue = accessionNoOfBookIssue;
	}

	// Return member ID of book_issue
	public String getMemberIdOfBookIssue() {
		return memberIdOfBookIssue;
	}

	// Set member ID of book_issue
	public void setMemberIdOfBookIssue(String memberIdOfBookIssue) {
		this.memberIdOfBookIssue = memberIdOfBookIssue;
	}
}
