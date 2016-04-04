package maze.logic;
import java.util.Scanner;

import maze.cli.CommandLine;

public class Labirinto {
public int ndrakes=2;
public int sizex=11;
public int sizey=11;
public int modo=2;
public  LabirintoDraw lab;
public  Heroi heroi;
public  CommandLine cli;
/*	public static void main(String[] args) 
	{
		
		/*int k=1;
		Heroi heroi= new Heroi();
		Dragao drake= new Dragao();
		LabirintoDraw labirinto= new LabirintoDraw();
		labirinto.lab[heroi.y][heroi.x]='H';
		labirinto.lab[drake.y][drake.x]='D';
		labirinto.LabirintoDesenho();
		while(k==1)
		{
		drake.adacDragao();
		drake.moveDragao(labirinto);
		labirinto.lab[drake.y][drake.x]=drake.carater;
		labirinto.checkdeath(drake,heroi,labirinto);
		heroi.moveHeroi(labirinto,drake);
		labirinto.lab[heroi.y][heroi.x]=heroi.carater;
		labirinto.LabirintoDesenho();
		labirinto.checkdeath(drake,heroi,labirinto);
		
		}
		CommandLine cli = new CommandLine();
		cli.readMode();
		
		
		
		
    }
*/
	
public  void inicialize()
{
	lab= new LabirintoDraw(sizex,sizey);
	cli= new CommandLine();
	lab.MazeBuilder();
	int[] exit = lab.SearchExit();
	lab.MakeWay(exit[0],exit[1]);
	lab.makeDragons(ndrakes);
	heroi= lab.makeHero();
	System.out.println(heroi.x + " " + heroi.y );
	lab.makeEspada();
	lab.LabirintoDesenho();
}

public void inicialize2(){
	lab= new LabirintoDraw(sizex,sizey);
	cli= new CommandLine();
	lab.MazeBuilder2();
	heroi= new Heroi();
	/*int[] exit = lab.SearchExit();
	lab.MakeWay(exit[1],exit[0]);
	lab.makeDragons(ndrakes);
	heroi= 
	System.out.println(heroi.x + " " + heroi.y );
	lab.makeEspada();*/
	lab.LabirintoDesenho();
}

public void JogadaParado(char key)
{
	cli.moveHeroi(lab,heroi,key);
	System.out.println(heroi.x + " " + heroi.y );
	lab.lab[heroi.y][heroi.x]=heroi.carater;
	lab.LabirintoDesenho();
	
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.checkdeath(lab.drakes.get(i),heroi,lab);
	}
}
	
public  void JogadaMovimento(char key)
{
	/*int k=1;
	LabirintoDraw labirinto= new LabirintoDraw(sizex,sizey);
	labirinto.MazeBuilder();
	int[] exit = labirinto.SearchExit();
	labirinto.MakeWay(exit[1],exit[0]);
	labirinto.makeDragons(ndrakes);
	Heroi heroi= labirinto.makeHero();
	labirinto.makeEspada();
	labirinto.LabirintoDesenho();
	lab=labirinto;
	CommandLine cli = new CommandLine();
	while(k==1)
	{*/
	cli.moveHeroi(lab,heroi,key);
	lab.lab[heroi.y][heroi.x]=heroi.carater;
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.checkdeath(lab.drakes.get(i),heroi,lab);
	}
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.drakes.get(i).moveDragao(lab);
	lab.lab[lab.drakes.get(i).y][lab.drakes.get(i).x]=lab.drakes.get(i).carater;
	}
	lab.lab[heroi.y][heroi.x]=heroi.carater;
	lab.LabirintoDesenho();
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.checkdeath(lab.drakes.get(i),heroi,lab);
	}	
	
	
}


public  void JogadaDormir(char key)
{
	cli.moveHeroi(lab,heroi,key);
	lab.lab[heroi.y][heroi.x]=heroi.carater;
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.checkdeath(lab.drakes.get(i),heroi,lab);
	}
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.drakes.get(i).adacDragao();
	lab.drakes.get(i).moveDragao(lab);
	lab.lab[lab.drakes.get(i).y][lab.drakes.get(i).x]=lab.drakes.get(i).carater;
	}
	lab.lab[heroi.y][heroi.x]=heroi.carater;
	lab.LabirintoDesenho();
	for(int i=0; i < lab.drakes.size(); i++)
	{
	lab.checkdeath(lab.drakes.get(i),heroi,lab);
	}	
	
	}
}






