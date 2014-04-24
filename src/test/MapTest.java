package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGame {

	Map map;
	Map map1;
	Map map2;
	Map map3;
	Map map4;
	Position position;
	
	@Before
	public void setUp() throws Exception {
		map= new Map(20);
		map1= new Map(30);
		map2= new Map(50);
		map3= new Map(8);
		map4= new Map(23);
		Position position = map.randomGrassTile();
		Position position1 = map1.randomGrassTile();
		Position position2 = map2.randomGrassTile();
		Position position3 = map3.randomGrassTile();
		Position position4 = map4.randomGrassTile();
	}
	
	

	@Test
	public void randomGrassTileTest{
	
		assertEquals('X', map.getTileType(position.x,position.y);
		assertEquals('X', map.getTileType(position1.x,position1.y);
		assertEquals('X', map.getTileType(position2.x,position2.y);
		assertEquals('X', map.getTileType(position3.x,position3.y);
		assertEquals('X', map.getTileType(position4.x,position4.y);
		
		
	}
	
}
