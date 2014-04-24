package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGame {

	Game game;
	
	@Before
	public void setUp() throws Exception {
		game= new Game();
	}

	@Test
	public void noOfPlayersTest() {
		assertEquals(true, game.setNumPlayers(2));
		assertEquals(true, game.setNumPlayers(5));
		assertEquals(true, game.setNumPlayers(8));
		assertEquals(false, game.setNumPlayers(1));
		assertEquals(false, game.setNumPlayers(9));
		assertEquals(false, game.setNumPlayers(20));
		
		
	}
	
}
