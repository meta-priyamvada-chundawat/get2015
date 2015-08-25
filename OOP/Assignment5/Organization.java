public class Organization extends Entity {
	private String courses[];
	private String placements[];
	private String faculty[];

	// return course
	public String[] getCourses() {
		return courses;
	}

	// set course
	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	// return placement
	public String[] getPlacements() {
		return placements;
	}

	// set placement
	public void setPlacements(String[] placements) {
		this.placements = placements;
	}

	// return faculty
	public String[] getFaculty() {
		return faculty;
	}

	// set faculty
	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}

}
