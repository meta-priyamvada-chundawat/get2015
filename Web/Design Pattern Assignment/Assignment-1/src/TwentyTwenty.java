
public class TwentyTwenty extends Game
{
	
	@Override
	void endPlay() 
	{
		System.out.println("Team B chased the Required  runs and won the Match");
		System.out.println("Cricket Game Finished!");
	}



	@Override
	void startPlay()
	{
		System.out.println("Toss performed. Team A won the toss.");
		System.out.println("Team A elected to bat first");
		System.out.println("Game is now starting.");
	}
}