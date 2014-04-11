import java.util.*;
public class Game {

    public static void main(String[] args) 
    {
        startGame();
    }
    
    public static void startGame()
    {
        int noOfPlayers=0; 
        int tiles=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of players: ");
        noOfPlayers=sc.nextInt();
        if (noOfPlayers < 2 || noOfPlayers >8)
        {
            startGame();
        }
        else
        {
            if(noOfPlayers>1 && noOfPlayers < 5)
            {
                tiles=tiles2to4();
            }
            if(noOfPlayers>4 && noOfPlayers < 9)
            {
                tiles=tiles5to8();
            }
        } 
        Map newMap = new Map(tiles);        
        newMap.generate();
		newMap.display();
    }
    
    public static int tiles2to4()
    {
        int tiles=0; 
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of tiles ");
        tiles=sc.nextInt();
        if (tiles < 5 || tiles >50)
        {
           tiles= tiles2to4();
        }
       return tiles;
    }
    
    public static int tiles5to8()
    {
        int tiles=0; 
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the number of tiles ");
        tiles=sc.nextInt();
        if (tiles < 7 || tiles >50)
        {
           tiles= tiles5to8();
        }
       return tiles;
    }

}