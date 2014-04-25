import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	Game game;
	Map map;
	Position position1;
	Position position2;
	Position position3;
	Position position4;
	
	@Before
	public void setUp() throws Exception {
		game= new Game();
		map = new Map(20);
		position1=new Position(5,10);
		position2=new Position(0,0);
		position3=new Position(25,-1);
		position4=new Position(4,21);
	}

	@Test
	public void noOfPlayersTest() 
	{
		assertEquals(true, game.setNumPlayers(2));
		assertEquals(true, game.setNumPlayers(5));
		assertEquals(true, game.setNumPlayers(8));
		assertEquals(false, game.setNumPlayers(1));
		assertEquals(false, game.setNumPlayers(9));
		assertEquals(false, game.setNumPlayers(20));
	}


	@Test	
	public void outOfMapTest() 
	{
		assertEquals(true, game.outOfMap(position1, map));
		assertEquals(true, game.outOfMap(position2, map));
		assertEquals(false, game.outOfMap(position3, map));
		assertEquals(false, game.outOfMap(position4, map));
	
	}
	

	@Test	
	public void noOfTilesTest() 
	{
		assertEquals(false, game.noOfTiles(4, 2));
		assertEquals(true, game.noOfTiles(7, 2));
		assertEquals(true, game.noOfTiles(8, 5));
		assertEquals(false, game.noOfTiles(7, 8));
		assertEquals(true, game.noOfTiles(8, 8));
		assertEquals(true, game.noOfTiles(50, 8));
		assertEquals(false, game.noOfTiles(51, 8));
	}
	
}
