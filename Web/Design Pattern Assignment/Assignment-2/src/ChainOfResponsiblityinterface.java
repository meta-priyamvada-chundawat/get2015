
public class ChainOfResponsiblityinterface {

	public static void main(String[] args) 
	{
		Approver priyamvada = new Mentor();
	      Approver amit = new SeniorMentor();
	      Approver abhishek = new HrManager();
	 
	      priyamvada.SetSuccessor(anand);
	      amit.SetSuccessor(abhishek);

	    priyamvada.ProcessRequest(5);


	}

}
