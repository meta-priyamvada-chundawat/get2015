// POJO class of Book
public class Book {
	private int accessionNo;
	private int titleIdOfBook;
	private String purchaseDate;
	private double price;
	private int status;

	// Parameterized constructor
	public Book(int accessionNo, int titleIdOfBook, String purchaseDate,
			double price, int status) {
		super();
		this.accessionNo = accessionNo;
		this.titleIdOfBook = titleIdOfBook;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.status = status;
	}

	// Return accession number
	public int getAccessionNo() {
		return accessionNo;
	}

	// Set accession number
	public void setAccessionNo(int accessionNo) {
		this.accessionNo = accessionNo;
	}

	// Return title_id of book
	public int getTitleIdOfBook() {
		return titleIdOfBook;
	}

	// Set title_id of book
	public void setTitleIdOfBook(int titleIdOfBook) {
		this.titleIdOfBook = titleIdOfBook;
	}

	// Return purchase_date of book
	public String getPurchaseDate() {
		return purchaseDate;
	}

	// Set purchase_date of book
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	// Return the price of book
	public double getPrice() {
		return price;
	}

	// Set the price of book
	public void setPrice(double price) {
		this.price = price;
	}

	// Return the status of book
	public int getStatus() {
		return status;
	}

	// Set the status of book
	public void setStatus(int status) {
		this.status = status;
	}
}
