package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGame {

	Map map;
	Position position;
	
	@Before
	public void setUp() throws Exception {
		map= new Map(20);
		Position position = map.randomGrassTile();
	}
	
	

	@Test
	public void randomGrassTileTest{
	
		assertEquals('X', map.getTileType(position.x,position.y);	
		
		
	}
	
}
