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
	
	
	
	public Labirinto StartTest(){
		Labirinto lab = new Labirinto();
		LabirintoDraw lab2 = new LabirintoDraw(6,5);
		lab.lab = lab2;
		lab.lab.lab = TMaze();
		Heroi heroi = new Heroi();
		Dragao drake = new Dragao();
		lab.lab.drakes.add(drake);
		CommandLine cli = new CommandLine();
		lab.cli = cli;
		
		drake.x = 3;
		drake.y = 1;
		lab.heroi = heroi;
		lab.lab.lab[drake.y][drake.x] = 'D';
		lab.lab.lab[heroi.y][heroi.x] = 'H';
		
		return lab;
	}
	@Test
	public void Movetest() {
		
		Labirinto lab = new Labirinto();
		lab = StartTest();
		
		
		
		
		int x = lab.heroi.x;
		lab.JogadaParado('d');
		
		assertEquals(x+1,lab.heroi.x);
		
	}
	
	
	@Test
	public void MoveWalltest() {
		
		
		Labirinto lab = new Labirinto();
		lab = StartTest();
		
		int x = lab.heroi.x;
		
		lab.JogadaParado('e');
		assertEquals(x,lab.heroi.x);
		
	}
	
	@Test
	public void TestCatchSword(){
		Labirinto lab = new Labirinto();
		lab = StartTest();
		
		int x = lab.heroi.x;
		if(lab.lab.lab[lab.heroi.x+1][lab.heroi.y] != 'E'){
			lab.lab.lab[lab.heroi.x+1][lab.heroi.y] = 'E';
		}
		lab.JogadaParado('s');
		lab.JogadaParado('s');
		assertEquals('A',lab.heroi.carater);
		
	}
	@Test
	public void TestDeath(){
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		lab.JogadaParado('d');
		
		assertEquals(' ',lab.lab.lab[x+1][y]);
		
	}
	@Test
	public void testDDeath(){
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		
		lab.JogadaParado('s');
		lab.JogadaParado('s');
		lab.JogadaParado('w');
		lab.JogadaParado('w');
		lab.JogadaParado('d');
		
		assertEquals(' ', lab.lab.lab[3][1] );
		
		
		
	}
	@Test
	public void testVictory() {
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		
		lab.JogadaParado('s');
		lab.JogadaParado('s');
		lab.JogadaParado('w');
		lab.JogadaParado('w');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		
		
		assertEquals(1, lab.cli.ganhaste);
	}
	
	@Test
	public void testVictoryFail() {
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		lab.lab.drakes.get(0).x = 3;
		lab.lab.drakes.get(0).y = 3;
		
		
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		
		
		assertEquals(0, lab.cli.ganhaste);
	}
	
	
	@Test
	public void testVictoryAFail() {
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		lab.lab.drakes.get(0).x = 3;
		lab.lab.drakes.get(0).y = 3;
		
		
		lab.JogadaParado('s');
		lab.JogadaParado('s');
		lab.JogadaParado('w');
		lab.JogadaParado('w');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		lab.JogadaParado('d');
		
		
		assertEquals(0, lab.cli.ganhaste);
	}
	
	
	@Test
	public void testDragonMove(){
		Labirinto lab = new Labirinto();
		lab = StartTest();
		int x = lab.heroi.x;
		int y = lab.heroi.y;
		lab.lab.drakes.get(0).x = 3;
		lab.lab.drakes.get(0).y = 3;
		
		
		lab.JogadaParado('s');
		
		assertEquals(3,lab.lab.drakes.get(0).y);
		assertEquals(2,4,lab.lab.drakes.get(0).x);
		
		
		
	}
	
	
	
}
