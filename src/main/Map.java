import java.util.*;
public class Map
{
    int size;
    char[][] square;
	
	 public Map(int sizeInput)
    {
        size = sizeInput;
		square = new char[sizeInput][sizeInput];
		
    }
    
    public boolean setMapSize(int x, int y)
    {               
        return true;
    }
    
    public void getTileType(int x, int y)
    {
        //A= grass
        //B= water
        //C= treasure
        
    }
    
    public void generate()
    { 
		Random rand = new Random();
		for (int i = 0; i < size; i++) 
        {
            for (int j = 0; j < size; j++) 
            {
                square[i][j] = randomChar();
            }
        }
		square[rand.nextInt(size)-1][rand.nextInt(size)-1] = 'C';		
    }
	
	public void display()
	{
		for (int i = 0; i < size; i++) 
        {
			System.out.println("");
            for (int j = 0; j < size; j++) 
            {
                System.out.print(square[i][j]);
            }
        }
	}
	public char randomChar()
	{
		Random rand = new Random();
		int n = rand.nextInt(3);
		switch (n){
			case 0: 
				return 'A';
			case 1: 
				return 'B';
			/*case 2: 
				return 'C'; */
			default:
				return 'A';
		}
    }
   
    
}