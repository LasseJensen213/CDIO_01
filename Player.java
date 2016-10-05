package dice;

public class Player {
	private String owner;
	private int points;
	private int[] lastThrow = new int[2];
	private static int playerNum = 1;
	private int timesRolled = 0;
	private boolean vundet;

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
		this.timesRolled = 0;
		
	}

	//Konstruktør
	public Player(int points) {
		this.owner = "Spiller_"+playerNum;
		this.points = points;
		this.lastThrow[0]=0;
		this.lastThrow[1]=0;
		this.timesRolled = 0;
		this.vundet = false;
		playerNum++;
		
	}
	
	public boolean getvundet() {
		return this.vundet;
	}
	public void setvundet(boolean vundet) {
		this.vundet = vundet; 
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

	public void setowner(String owner)
	{
		this.owner = owner;
	}


	//Getter and setter for points.
	public int getpoints() 
	{
		return points;
	}
	
	//getter for antal kast
	public int getTimesRolled()
	{
		return this.timesRolled;
	}
	
	public static int getPlayerNum()
	{
		return playerNum;
	}
	//inkrementerer antal kast med 1
	public void incTimesRolled()
	{
		this.timesRolled++;
	}

	public void setTimesRolled(int timesRolled) {
		this.timesRolled = timesRolled;
	}

	public void setpoints(int points) 
	{
		this.points = points;
	}
	
	public static void resetPlayerNum()
	{
		playerNum=1;
	}
	
	public void setLastThrow(int d1, int d2)
	{
		lastThrow[0]=d1;
		lastThrow[1]=d2;
	}
	
	
	//checker om et kast er lig med sidste kast, fx når man skal se hvis man har slået 2 seksere i sidste kast
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
