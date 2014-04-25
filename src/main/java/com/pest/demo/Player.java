public class Player
{
	
	Position position;
	
	Position startingPosition;

	public Player(Position positionInput) //constructor
	{
		position = positionInput;
		startingPosition = positionInput;
	}

	public Player(int x, int y) //constructor
	{
		position = new Position(x,y);
		startingPosition = new Position(x,y);
	} 
		

	public boolean setPosition(Position p) //set method
	{
		position = p;
		return true;
	}
	
	public Position getPosition() //get method
	{
		return position;
	}
	
	public void move( char direction )
	{
		//mbad nimluwa mux importanti
	}
}


