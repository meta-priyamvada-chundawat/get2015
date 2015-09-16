// POJO class of Members
public class Member {
	private int memberId;
	private String memberName;
	private String addressLineFirst;
	private String addressLineSecond;
	private char category;
	private String personType;
	
	public Member() {
		this.memberId = 0;
		this.memberName = null;
		this.addressLineFirst = null;
		this.addressLineSecond = null;
		this.category = 0;
		this.personType = null;
	}

	// Parameterized constructor
	public Member(int memberId, String memberName, String addressLineFirst,
			String addressLineSecond, char category, String personType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.addressLineFirst = addressLineFirst;
		this.addressLineSecond = addressLineSecond;
		this.category = category;
		this.personType = personType;
	}

	// Return memberID
	public int getMemberId() {
		return memberId;
	}

	// Set memberID
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	// Return member name
	public String getMemberName() {
		return memberName;
	}

	// Set member name
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	// Return addressLineFirst
	public String getAddressLineFirst() {
		return addressLineFirst;
	}

	// Set addressLineFirst
	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}

	// Return addressLineSecond
	public String getAddressLineSecond() {
		return addressLineSecond;
	}

	// Set addressLineSecond
	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}

	// Return category
	public char getCategory() {
		return category;
	}

	// Set category
	public void setCategory(char category) {
		this.category = category;
	}

	// Return person type
	public String getPersonType() {
		return personType;
	}

	// Set person type
	public void setPersonType(String personType) {
		this.personType = personType;
	}
}
