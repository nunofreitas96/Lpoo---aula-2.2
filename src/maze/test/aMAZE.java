package maze.test;

import static org.junit.Assert.*;


import org.junit.Test;
import maze.logic.*;
import maze.cli.*;
public class aMAZE {

	/*
	public char[][] TMaze() {
		char[][] 
		m1={{'X', 'X', 'X', 'X', 'X'},
		    {'X', ' ', ' ', ' ', 'S'}, 
		    {'X', ' ', 'X', ' ', 'X'},
		    {'X', 'E', ' ', ' ', 'X'},
		    {'X', 'X', 'X', 'X', 'X'}};
		return m1;
	}*/
	
	
	//@Test
	public void Movetest() {
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.x = 4;
		heroi.y =3;
		drake.x =1;
		drake.y =1;
		assertEquals(1,cli.moveHeroKey('w',labirinto,drake,heroi));
		assertEquals(4,heroi.x);
		assertEquals(2,heroi.y);
		
	}
	//@Test
	public void MoveWalltest() {
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.x = 4;
		heroi.y =3;
		drake.x =1;
		drake.y =1;
		assertEquals(0,cli.moveHeroKey('d',labirinto,drake,heroi));
		assertEquals(4,heroi.x);
		assertEquals(3,heroi.y);
		
	}
	//@Test
	public void TestCatchSword(){
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.x = 1;
		heroi.y =7;
		drake.x =1;
		drake.y =1;
		cli.moveHeroKey('s',labirinto,drake,heroi);
		assertEquals(true,heroi.armado);
		
	}
	//@Test
	public void TestDeath(){
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		cli.moveHeroKey('s',labirinto,drake,heroi);
		labirinto.checkdeath(drake,heroi,labirinto);
		assertEquals(true,labirinto.gameover);
		
	}
	//@Test
	public void testDDeath(){
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.armado = true;
		cli.moveHeroKey('s',labirinto,drake,heroi);
		labirinto.checkdeath(drake,heroi,labirinto);
		assertEquals("morto",drake.estado);
		
		
	}
	//@Test
	public void testVictory() {
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.armado = true;
		heroi.x = 8;
		heroi.y = 4;
		drake.estado = "morto";
		cli.moveHeroKey('s',labirinto,drake,heroi);
		cli.moveHeroKey('d',labirinto,drake,heroi);
		
		assertEquals(1, cli.ganhaste);
	}
	
	//@Test
	public void testVictoryFail() {
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.x = 8;
		heroi.y = 4;
		cli.moveHeroKey('s',labirinto,drake,heroi);
		cli.moveHeroKey('d',labirinto,drake,heroi);
		
		assertEquals(0, cli.ganhaste);
	}
	
	
	//@Test
	public void testVictoryAFail() {
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		heroi.armado= true;
		heroi.x = 8;
		heroi.y = 4;
		cli.moveHeroKey('s',labirinto,drake,heroi);
		cli.moveHeroKey('d',labirinto,drake,heroi);
		
		assertEquals(0, cli.ganhaste);
	}
	
	
	//@Test
	public void testDragonMove(){
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		LabirintoDraw labirinto = new LabirintoDraw();
		drake.move(labirinto);
		assertEquals(1,drake.x);
		assertEquals(2,4,drake.y);
		
		
		
	}
	
	
	
}
