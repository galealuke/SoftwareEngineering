import java.util.*;
import java.io.*;
public class Game {

	 int noOfPlayers;
     int tiles;

	public Game()  //game constructor
	{
		noOfPlayers=0;
		tiles = 0;
	}

    public void startGame()
    {

		int count =0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of players (2-8):  ");
        int input=sc.nextInt();
        if (!setNumPlayers(input)) //to make sure that input is between 2 and 8 players
        {
            startGame();
        }
        else //if the no of players is entered correctly
        {
            do
			{
            	System.out.println("Please enter the number of tiles : ");
				input = sc.nextInt();
			}while(!(noOfTiles(input,noOfPlayers))); // to keep looping until no of tiles is entered correctly depending on the number of players
			tiles = input;
        }
        Map newMap = new Map(tiles);
        newMap.generate();

		Map [] mapArray = new Map[8];

		for(count =0;count<noOfPlayers; count++ )  //create a map for each player
		{
			mapArray[count]=new Map(newMap.size, newMap.square);
		}

		Player [] playerArray = new Player[8];

		for(count =0;count<noOfPlayers; count++ )  //create player objects
		{
			Player player = new Player(mapArray[count].randomGrassTile());
			playerArray[count]= player;
		}



		for(count =0;count<noOfPlayers; count++ )
		{

			HTMLfiles(playerArray[count],mapArray[count],count);

		}

		askForDirections(playerArray , mapArray); //ask each player for directions


    }

    public void askForDirections(Player [] playerArray , Map [] mapArray)
    {
    	boolean win=false;
		int endGame = 0;
		int count=0;

		do{
			for(count =0;count<noOfPlayers; count++ ) //to move each player in turns
			{
				System.out.println("Enter a direction you want to move, Player "+count+"( l/r/u/d) : " );
				win = Gameplay(playerArray[count],mapArray[count]);
				if (win == true)
				{
					System.out.println("Player "+ count + " Wins!");
					endGame ++;
				}
				HTMLfiles(playerArray[count],mapArray[count],count);
			}

		}while(endGame==0); //to keep moving players until player(s) win
		System.out.println("The game has been won by "+endGame+" players");
    }


	public boolean Gameplay(Player player , Map map)
	{

		Scanner sc = new Scanner(System.in);
		char input='a';
		input = sc.next().charAt(0);
		Position newPosition;
		switch (input)
		{
			case 'l': //when direction entered is l
				newPosition = new Position((player.getPosition().x),(player.getPosition().y)-1);
				if(!(outOfMap(newPosition,map))) //if player tries to move out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y));
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B') //check if fell in the water
				{
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition); //if player falls in the water it starts again from the initial position
					return false;
				}
				else
				{
					player.setPosition(newPosition);
					map.uncover(newPosition.x,newPosition.y);
					if (map.getTileType(newPosition.x,newPosition.y)=='Z'||map.getTileType(newPosition.x,newPosition.y)=='C') //if player finds the treasure
					{
						return true;
					}
					else return false;
				}
			case 'r': //when direction entered is r
				newPosition = new Position((player.getPosition().x),(player.getPosition().y)+1);
				if(outOfMap(newPosition,map)==false) //if player tries to move out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y));
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition); //if player falls in the water it starts again from the initial position
					return false;
				}
				else
				{
					player.setPosition(newPosition);
					map.uncover(newPosition.x,newPosition.y);
					if (map.getTileType(newPosition.x,newPosition.y)=='Z'||map.getTileType(newPosition.x,newPosition.y)=='C')
					{
						return true;
					}
					else return false;
				}
			case 'u': //when direction entered is u
				newPosition = new Position((player.getPosition().x-1),(player.getPosition().y));
				if(outOfMap(newPosition,map)==false) //if player tries to move out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y));
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition); //if player falls in the water it starts again from the initial position
					return false;
				}
				else
				{
					player.setPosition(newPosition);
					map.uncover(newPosition.x,newPosition.y);
					if (map.getTileType(newPosition.x,newPosition.y)=='Z'||map.getTileType(newPosition.x,newPosition.y)=='C')
					{
						return true;
					}
					else return false;
				}
			case 'd': //when direction entered is d
				newPosition = new Position((player.getPosition().x+1),(player.getPosition().y));
				if(outOfMap(newPosition,map)==false) //if player tries to move out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y));
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition); //if player falls in the water it starts again from the initial position
					return false;
				}
				else
				{
					player.setPosition(newPosition);
					map.uncover(newPosition.x,newPosition.y);
					if (map.getTileType(newPosition.x,newPosition.y)=='Z'||map.getTileType(newPosition.x,newPosition.y)=='C')
					{
						return true;
					}
					else return false;
				}
			default:
				return false;
		}

	}

	public boolean outOfMap(Position newPosition, Map map)
	{
			if(((newPosition.x)>map.size-1)||((newPosition.x)<0)||((newPosition.y)>map.size-1)||((newPosition.y)<0))
			{
				System.out.println("Error, Out of map, please enter direction again:");
				return false;
			}
			else
			{
				return true;
			}

	}

	public  void HTMLfiles(Player player, Map map, int number)  //HTML display
	{
		PrintWriter out=null;
		try
		{
			out = new PrintWriter("map__player_"+number+".html");  //linking printwriter object to output "map.html"
		}catch(Throwable exc)
		{
			System.out.println("File doesnt exist");
		}

		out.println("<!DOCTYPE html>");  //at the start of every html document

		//long string that styles the table how we want it
		out.println("<style> \ntable, th, td \n{ \nborder-collapse:collapse; \nborder:1px solid black;\n} \n td{\nheight:55px;\nwidth:55px;\n}\n</style>");

		out.println("<table>"); //table start
		for (int i = 0; i < map.getSize(); i++)
		{
		out.println("<tr>"); //for every row we print a row <tr>
			for (int j = 0; j < map.getSize(); j++)
			{
				if (map.getTileType(i,j)=='X' || map.getTileType(i,j)=='Y' || map.getTileType(i,j)=='Z')
					out.println("<td style = background-color:gray>"); //if XYZ then background gray
				if (map.getTileType(i,j)=='A')
					out.println("<td style = background-color:green>"); //if A then background green
				if (map.getTileType(i,j)=='B')
					out.println("<td style = background-color:blue>"); //if B blue
				else if (map.getTileType(i,j)=='C')
					out.println("<td style = background-color:yellow>"); //if C yellow..treasure

				if(((player.getPosition().x)==i)&&((player.getPosition().y)==j)){
					out.println("<img src = \"http://s1.postimg.org/6kjevoygr/player.png\">");
					}
				out.println("</td>");
			}
		out.println("</tr>");	//close each row
		}
		out.println("</table>"); //close the table
		out.close();	//save
	}



	public boolean setNumPlayers(int n)
	{
		if (n < 2 || n >8)
		{
			return false;
		}
		else
		{
			noOfPlayers=n;
			return true;
		}

	}


	public boolean noOfTiles(int n, int noOfPlayers)
	{
		 if(noOfPlayers>1 && noOfPlayers < 5)
            {
                if (n < 5 || n >50)
					return false;
				else
					return true;
            }
			else  if(noOfPlayers>4 && noOfPlayers < 9)
            {

                if (n < 8 || n >50)
					return false;
				else
					return true;
			 }
			else
				return false;
	}



}
