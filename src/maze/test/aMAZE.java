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
	
	/*@Test
	public void Movetest() {
		
		
		Labirinto lab= StartTest();
		lab.lab.lab[lab.lab.drakes.get(0).y][lab.lab.drakes.get(0).y] = 'D';
		lab.lab.lab[heroi.y][heroi.x] = 'H';
		
		
		
		int x = lab.heroi.x;
		lab.JogadaParado('d');
		
		assertEquals(x+1,lab.heroi.x);
		
	}*/
	
	/*@Test
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
	
	@Test(timeout=1000)

	public void testDragonSleep(){
	Labirinto labirinto= StartTest();
	boolean adormece = false, acorda = false;
	while (! adormece|| ! acorda) {
	labirinto.lab.drakes.get(0).adacDragao();
	if (labirinto.lab.drakes.get(0).estado=="acordado")
	acorda = true;
	else if (labirinto.lab.drakes.get(0).estado=="dormir")
	adormece= true;
	else
	fail("some error message");
	}
	
	}
	
	@Test(timeout=1000)

	public void testDragonSleepEspada(){
	Labirinto labirinto= StartTest();
	boolean adormece = false, acorda = false;
	while (! adormece|| ! acorda) {
	labirinto.lab.drakes.get(0).temEspada=true;
	labirinto.lab.drakes.get(0).adacDragao();
	if (labirinto.lab.drakes.get(0).estado=="acordado"&&labirinto.lab.drakes.get(0).carater=='F')
	acorda = true;
	else if (labirinto.lab.drakes.get(0).estado=="dormir"&&labirinto.lab.drakes.get(0).carater=='f')
	adormece= true;
	else
	fail("some error message");
	}
	}
	@Test
	public void testDragonEspada(){
	Labirinto labirinto= StartTest();
	labirinto.lab.drakes.get(0).apanhaEspada();
	assertEquals(true,labirinto.lab.drakes.get(0).temEspada);
	
	}
	@Test
	public void testDragonConst()
	{
		Dragao drake= new Dragao(3,1);
		assertEquals(3,drake.x);
		assertEquals(1,drake.y);
		assertEquals("acordado",drake.estado);
		assertEquals('D',drake.carater);
	}
	
	@Test
	public void testJogadaParado()
	{
		Labirinto labirinto= StartTest();
		int tempx=labirinto.lab.drakes.get(0).x;
		int tempy=labirinto.lab.drakes.get(0).y;
		labirinto.JogadaParado('a');
		assertEquals(labirinto.heroi.x,1);
		assertEquals(labirinto.heroi.y,1);
		labirinto.JogadaParado('s');
		assertEquals(labirinto.heroi.x,1);
		assertEquals(labirinto.heroi.y,2);
		labirinto.JogadaParado('d');
		assertEquals(labirinto.heroi.x,1);
		assertEquals(labirinto.heroi.y,2);
		labirinto.JogadaParado('w');
		assertEquals(labirinto.heroi.x,1);
		assertEquals(labirinto.heroi.y,1);
		
	}
	@Test
	public void testJogadamov()
	{
		Labirinto labirinto= StartTest();
		labirinto.JogadaMovimento('a');
		labirinto.JogadaMovimento('s');
		labirinto.JogadaMovimento('d');
		labirinto.JogadaMovimento('w');
		
	}
	@Test
	public void testJogadaDorm()
	{
		Labirinto labirinto= StartTest();
		labirinto.JogadaDormir('a');
		labirinto.JogadaDormir('s');
		labirinto.JogadaDormir('d');
		labirinto.JogadaDormir('w');
	}
	@Test
	public void testini()
	{
		Labirinto lab= new Labirinto();
		lab.inicialize();
		
	}
	@Test
	public void testini2()
	{
		Labirinto lab= new Labirinto();
		lab.inicialize2();
	}
	
	
	
}
