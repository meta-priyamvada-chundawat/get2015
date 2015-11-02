public class HrManager extends Approver 
{

	@Override
	public void ProcessRequest(int noOfDays) 
	{
		 if (noOfDays <= 5)
	      {
	        System.out.println(" Leave GRanted by  Hr manager ");
	      }
	      else 
	      {
	        System.out.println("valid reasons should be provided");
	      }
		
	}

}