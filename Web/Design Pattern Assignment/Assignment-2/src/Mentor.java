
public class Mentor extends Approver 
{

	@Override
	public void ProcessRequest(int noOfDays) 
	{
		 if (noOfDays <= 1)
	      {
	        System.out.println("1 Day Leave GRanted by mentor");
	      }
	      else 
	      {
	        successor.ProcessRequest(noOfDays);
	      }
		
	}

}
