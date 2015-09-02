package default;

//To create a stack
public class StackNode {

	protected String data;
	protected StackNode link;

	//To assign value to data
	public StackNode(String item) {
	    this.data = item;
	    link=null;
	}

	//return data
	public String getData() {
		return data;
	}

	//to set data
	public void setData(String data) {
		this.data = data;
	}
	
	//return link
	public StackNode getLink() {
		return link;
	}

	
	//to set link
	public void setLink(StackNode link) {
		this.link = link;
	}

	
}
