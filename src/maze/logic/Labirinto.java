package maze.logic;
import java.util.Scanner;

import maze.cli.CommandLine;

public class Labirinto {
static int ndrakes=2;
	public static void main(String[] args) 
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
		
		}*/
		CommandLine cli = new CommandLine();
		cli.readMode();
		
		
		
		
    }

public static void Parado()
{
	int k=1;
	LabirintoDraw labirinto= new LabirintoDraw();
	labirinto.MazeBuilder();
	int[] exit = labirinto.SearchExit();
	labirinto.MakeWay(exit[1],exit[0]);
	labirinto.makeDragons(ndrakes);
	Heroi heroi= labirinto.makeHero();
	System.out.println(heroi.x + " " + heroi.y );
	labirinto.makeEspada();
	labirinto.LabirintoDesenho();
	CommandLine cli = new CommandLine();
	while(k==1)
	{
	cli.moveHeroi(labirinto,heroi);
	System.out.println(heroi.x + " " + heroi.y );
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.LabirintoDesenho();
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.checkdeath(labirinto.drakes.get(i),heroi,labirinto);
	}
	if (labirinto.gameover==true)
	{
	 System.out.println(":::GAME_OVER:::");
	 System.exit(0);
	}
	}
}

	
public static void MovDragao()
{
	int k=1;
	LabirintoDraw labirinto= new LabirintoDraw();
	labirinto.MazeBuilder();
	int[] exit = labirinto.SearchExit();
	labirinto.MakeWay(exit[1],exit[0]);
	labirinto.makeDragons(ndrakes);
	Heroi heroi= labirinto.makeHero();
	labirinto.makeEspada();
	labirinto.LabirintoDesenho();
	CommandLine cli = new CommandLine();
	while(k==1)
	{
	
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.checkdeath(labirinto.drakes.get(i),heroi,labirinto);
	}
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.drakes.get(i).moveDragao(labirinto);
	labirinto.lab[labirinto.drakes.get(i).y][labirinto.drakes.get(i).x]=labirinto.drakes.get(i).carater;
	}
	cli.moveHeroi(labirinto,heroi);
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.LabirintoDesenho();
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.checkdeath(labirinto.drakes.get(i),heroi,labirinto);
	}	
	if (labirinto.gameover==true)
	{System.out.println(":::GAME_OVER:::");
	 System.exit(0);
	}
	}
}


public static void AdorDragao()
{
	int k=1;
	LabirintoDraw labirinto= new LabirintoDraw();
	labirinto.MazeBuilder();
	int[] exit = labirinto.SearchExit();
	labirinto.MakeWay(exit[1],exit[0]);
	labirinto.makeDragons(ndrakes);
	Heroi heroi= labirinto.makeHero();
	labirinto.makeEspada();
	labirinto.LabirintoDesenho();
	CommandLine cli = new CommandLine();
	while(k==1)
	{
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.checkdeath(labirinto.drakes.get(i),heroi,labirinto);
	}
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.drakes.get(i).adacDragao();
	labirinto.drakes.get(i).moveDragao(labirinto);
	labirinto.lab[labirinto.drakes.get(i).y][labirinto.drakes.get(i).x]=labirinto.drakes.get(i).carater;
	}
	cli.moveHeroi(labirinto,heroi);
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.LabirintoDesenho();
	for(int i=0; i < labirinto.drakes.size(); i++)
	{
	labirinto.checkdeath(labirinto.drakes.get(i),heroi,labirinto);
	}	
	if (labirinto.gameover==true)
	{System.out.println(":::GAME_OVER:::");
	 System.exit(0);
	}
	}
}
}






