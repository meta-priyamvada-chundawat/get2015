public class SeniorMentor extends Approver 
{

	@Override
	public void ProcessRequest(int noOfDays) 
	{
		 if (noOfDays <= 2)
	      {
	        System.out.println(" Leave GRanted by  Senior mentor");
	      }
	      else if (successor != null)
	      {
	        successor.ProcessRequest(noOfDays);
	      }
		
	}

}