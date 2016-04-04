package maze.test;

import static org.junit.Assert.*;


import org.junit.Test;
import maze.logic.*;
import maze.GUI.InterfaceGraf;
import maze.cli.*;
public class aMAZE {

	
	public char[][] TMaze() {
		char[][] 
		m1={{'X', 'X', 'X', 'X', 'X', 'X'},
		    {'X', ' ', ' ', ' ', ' ', 'S'}, 
		    {'X', ' ', 'X', ' ', ' ', 'X'},
		    {'X', 'E', ' ', ' ', ' ', 'X'},
		    {'X', 'X', 'X', 'X', 'X', 'X'}};
		return m1;
	}
	
	//public Labirinto StartTest(){
		
	//}
	@Test
	public void Movetest() {
		
		
		Labirinto lab = new Labirinto();
		LabirintoDraw lab2 = new LabirintoDraw(6,5);
		lab.lab = lab2;
		lab.lab.lab = TMaze();
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		CommandLine cli = new CommandLine();
		lab.cli = cli;
		
		drake.x = 3;
		drake.y = 1;
		lab.heroi = heroi;
		lab.lab.lab[drake.y][drake.x] = 'D';
		lab.lab.lab[heroi.y][heroi.x] = 'H';
		
		
		
		int x = lab.heroi.x;
		lab.JogadaParado('d');
		
		assertEquals(x+1,lab.heroi.x);
		
	}
	@Test
	public void MoveWalltest() {
		Labirinto lab = new Labirinto();
		lab.inicialize();
		
		int x = lab.heroi.x;
		if(lab.lab.lab[lab.heroi.x+1][lab.heroi.y] != 'X' ){
			lab.lab.lab[lab.heroi.x+1][lab.heroi.y] = 'X';
		}
		lab.JogadaDormir('d');
		assertEquals(x,lab.heroi.x);
		
	}
	/*
	@Test
	public void TestCatchSword(){
		Labirinto lab = new Labirinto();
		lab.inicialize();
		
		int x = lab.heroi.x;
		if(lab.lab.lab[lab.heroi.x+1][lab.heroi.y] != 'E'){
			lab.lab.lab[lab.heroi.x+1][lab.heroi.y] = 'E';
		}
		lab.JogadaDormir('d');
		assertEquals('A',lab.heroi.carater);
		
	}/*
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
	
	
	*/
}
