
public class ChainOfResponsiblityinterface {

	public static void main(String[] args) 
	{
		Approver anurag = new Mentor();
	      Approver anand = new SeniorMentor();
	      Approver abhishek = new HrManager();
	 
	      anurag.SetSuccessor(anand);
	      anand.SetSuccessor(abhishek);

	    anurag.ProcessRequest(1);


	}

}
