/**
 * @author Priyamvada---Class to set a new node when new job arrived
 * 
 */

public class TaskNode {

	String job;
	int priority;

	/**
	 * ===----Constructor calling
	 * 
	 * @param job
	 *            ----job to be printed
	 * @param priority
	 *            -----its priority
	 */
	public TaskNode(String job, int priority) {
		this.job = job;
		this.priority = priority;
	}

}
