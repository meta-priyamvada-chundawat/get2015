// POJO class of Title
public class Title {
	private int titleId;
	private String titleName;
	private int subjectIdOfTitle;
	private int publisherIdOfTitle;

	public Title(int titleId, String titleName, int subjectIdOfTitle,
			int publisherIdOfTitle) {
		this.titleId = titleId;
		this.titleName = titleName;
		this.subjectIdOfTitle = subjectIdOfTitle;
		this.publisherIdOfTitle = publisherIdOfTitle;
	}

	/**
	 * @return the titleId
	 */
	public int getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName
	 *            the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the subjectIdOfTitle
	 */
	public int getSubjectIdOfTitle() {
		return subjectIdOfTitle;
	}

	/**
	 * @param subjectIdOfTitle
	 *            the subjectIdOfTitle to set
	 */
	public void setSubjectIdOfTitle(int subjectIdOfTitle) {
		this.subjectIdOfTitle = subjectIdOfTitle;
	}

	/**
	 * @return the publisherIdOfTitle
	 */
	public int getPublisherIdOfTitle() {
		return publisherIdOfTitle;
	}

	/**
	 * @param publisherIdOfTitle
	 *            the publisherIdOfTitle to set
	 */
	public void setPublisherIdOfTitle(int publisherIdOfTitle) {
		this.publisherIdOfTitle = publisherIdOfTitle;
	}
}
