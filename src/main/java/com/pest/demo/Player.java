<<<<<<< HEAD
package com.pest.demo;
=======
package com.pest.demo;
>>>>>>> 19c0572aef6de7ae2ff5bd5b52b0fee76de05331

public class Player
{

	
	Position position;
	
	Position startingPosition;

	public Player(Position positionInput){
		position = positionInput;
		startingPosition = positionInput;
	}

	public Player(int x, int y){
		position = new Position(x,y);
		startingPosition = new Position(x,y);
	} 
		

	public boolean setPosition(Position p)
	{
		position = p;
		return true;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public void move( char direction ) 
	{
	Position newPosition;
		switch (direction)
		{
			case 'l': //when direction entered is l
				newPosition = new Position((position.x),(position.y)-1); 
				setPosition(newPosition);
				break;
						
				
			case 'r': //when direction entered is r
				newPosition = new Position((position.x),(position.y)+1);
				setPosition(newPosition);
				break;
				
			case 'u': //when direction entered is u
				newPosition = new Position((position.x-1),(position.y));
				setPosition(newPosition);
				break;
				
			case 'd': //when direction entered is d
				newPosition = new Position((position.x+1),(position.y));
				setPosition(newPosition);
				break;
								
			default:
				break;
		}
	}
}
