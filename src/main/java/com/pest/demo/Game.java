package com.pest.demo;
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
        if (setNumPlayers(input)==false)
        {
            startGame();
        }
        else
        {
            do
			{
			 System.out.println("Please enter the number of tiles : ");
				input = sc.nextInt();
			}while(noOfTiles(input,noOfPlayers)==false);
			tiles = input;
        } 
        Map newMap = new Map(tiles);        
        newMap.generate();
		
		Map [] mapArray = new Map[8]; 
		
		for(count =0;count<noOfPlayers; count++ )  //create a map for each player
		{
			mapArray[count]=new Map(newMap.size, newMap.square);
		}
		
		//newMap.display();
		
		Player [] playerArray = new Player[8]; 
		
		for(count =0;count<noOfPlayers; count++ )  //create player objects
		{
			Player player = new Player(mapArray[count].randomGrassTile());
			playerArray[count]= player;		
		}
		
			
				
		for(count =0;count<noOfPlayers; count++ )  //mbad method bix jamel HTML files  DO IT MARIJA :P
		{
		
			HTMLfiles(playerArray[count],mapArray[count],count);
		
		}
		
		boolean win=false;
		int endGame = 0;
		
		do{
			for(count =0;count<noOfPlayers; count++ )
			{
				
				System.out.println("Enter a direction you want to move, Player "+count+":");
				win = Gameplay(playerArray[count],mapArray[count]);
				if (win == true) 
				{
					System.out.println("Player "+ count + " Wins!");
					endGame ++;
				}
				HTMLfiles(playerArray[count],mapArray[count],count);
				
				
			}
		}while(endGame==0);
		System.out.println("The game has been won by "+endGame+" players");
		
    }

	public boolean Gameplay(Player player , Map map){ 
	
		Scanner sc = new Scanner(System.in);
		char input='a';
		input = sc.next().charAt(0);
		Position newPosition;
		switch (input){
			case 'l': 
				newPosition = new Position((player.getPosition().x),(player.getPosition().y)-1); 
				if(outOfMap(newPosition,map)==false)//check if out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y)); 
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B') //check if fell in the water
				{				
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition);
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
			case 'r': 
				newPosition = new Position((player.getPosition().x),(player.getPosition().y)+1);
				if(outOfMap(newPosition,map)==false)//check if out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y)); 
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{				
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition);
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
			case 'u': 
				newPosition = new Position((player.getPosition().x-1),(player.getPosition().y));
				if(outOfMap(newPosition,map)==false)//check if out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y)); 
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{				
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition);
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
			case 'd': 
				newPosition = new Position((player.getPosition().x+1),(player.getPosition().y));
				if(outOfMap(newPosition,map)==false)//check if out of map
				{
					newPosition = new Position((player.getPosition().x),(player.getPosition().y)); 
					return Gameplay(player,map);
				}
				else if (map.getTileType(newPosition.x,newPosition.y)=='Y'||map.getTileType(newPosition.x,newPosition.y)=='B')
				{				
					System.out.println("Oops! You fell in the water..");
					map.uncover(newPosition.x,newPosition.y);
					player.setPosition(player.startingPosition);
					return false;
				}
				else
				{
					player.setPosition(newPosition);
					map.uncover(newPosition.x,newPosition.y); //
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
	
	
	/*public static Position RandomGrassTile(Map currentMap)  //method to return a random starting position on grass
    {
        Random rand = new Random();
        Position randomPos;
		
        int x = rand.nextInt(currentMap.getSize());
        int y = rand.nextInt(currentMap.getSize());
        if (currentMap.getTileType(x, y)=='X')
        { 
            randomPos = new Position(x,y);
			currentMap.uncover(x,y);
        }
        else
        { 
            randomPos=RandomGrassTile(currentMap);      
        }
        return randomPos;
    }  */
	
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
	
    public int tiles2to4()
    {
        int tiles=0; 
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of tiles (5-50): ");
        tiles=sc.nextInt();
        if (tiles < 5 || tiles >50)
        {
           tiles= tiles2to4();
        }
       return tiles;
    }
    
    public int tiles5to8()
    {
        int tiles=0; 
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of tiles (8-50): ");
        tiles=sc.nextInt();
        if (tiles < 7 || tiles >50)
        {
           tiles= tiles5to8();
        }
       return tiles;
    }

}