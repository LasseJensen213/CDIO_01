package dice;

public class Player {
	private String owner;
	private int points;
	private int[] lastThrow = new int[2];
	private static int playerNum = 1;



	//Account information
	public Player(int points) {
		this.owner = "Spiller_"+playerNum;
		this.points = points;
		this.lastThrow[0]=0;
		this.lastThrow[1]=0;
		playerNum++;
		
	}
	public Player(String name)
	{
		if(name.length()<1)
		{
			owner = "Spiller_"+playerNum;
		}
		else
		{
			owner = name;
		}
		playerNum++;
		
	}
	
	
	//Add points
	
	public void addpoints(int points) {
		this.points += points;
	}
	
	
	
	//Getters and setters:
	
	//Getter and setter for owner
	public String getowner() {
		return owner;
	}

	public void setowner(String owner) {
		this.owner = owner;
	}


	//Getter and setter for points.
	public int getpoints() {
		return points;
	}

	public void setpoints(int points) {
		this.points = points;
	}
	
	public void setLastThrow(int d1, int d2)
	{
		lastThrow[0]=d1;
		lastThrow[1]=d2;
	}
	
	public boolean lastThrowEqual(int d1, int d2)
	{
		if(lastThrow[0]==d1 && lastThrow[1]==d2)
		{
			return true;
		}
		else
		{
		return false;
		}
	}



}



