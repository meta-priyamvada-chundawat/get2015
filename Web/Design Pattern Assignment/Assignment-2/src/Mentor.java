
public class Mentor extends Approver 
{

	@Override
	public void ProcessRequest(int noOfDays) 
	{
		 if (noOfDays <= 5)
	      {
	        System.out.println("Leave GRanted by mentor");
	      }
	      else 
	      {
	        successor.ProcessRequest(noOfDays);
	      }
		
	}

}
