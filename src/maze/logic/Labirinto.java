package maze.logic;
import java.util.Scanner;

import maze.cli.CommandLine;

public class Labirinto {

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
	Heroi heroi= new Heroi();
	Dragao drake= new Dragao();
	LabirintoDraw labirinto= new LabirintoDraw();
	CommandLine cli = new CommandLine();
	labirinto.lab[heroi.y][heroi.x]='H';
	labirinto.lab[drake.y][drake.x]='D';
	labirinto.LabirintoDesenho();
	while(k==1)
	{
	cli.moveHeroi(labirinto,drake,heroi);
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.LabirintoDesenho();
	labirinto.checkdeath(drake,heroi,labirinto);
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
	Heroi heroi= new Heroi();
	Dragao drake= new Dragao();
	LabirintoDraw labirinto= new LabirintoDraw();
	CommandLine cli = new CommandLine();
	labirinto.lab[heroi.y][heroi.x]='H';
	labirinto.lab[drake.y][drake.x]='D';
	labirinto.LabirintoDesenho();
	while(k==1)
	{
	cli.moveHeroi(labirinto,drake,heroi);
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	//labirinto.lab[drake.y][drake.x]=drake.carater;
	labirinto.checkdeath(drake,heroi,labirinto);
	drake.moveDragao(labirinto);
	labirinto.lab[drake.y][drake.x]=drake.carater;
	//labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.LabirintoDesenho();
	labirinto.checkdeath(drake,heroi,labirinto);	
	if (labirinto.gameover==true)
	{System.out.println(":::GAME_OVER:::");
	 System.exit(0);
	}
	}
}

public static void AdorDragao()
{
	int k=1;
	Heroi heroi= new Heroi();
	Dragao drake= new Dragao();
	LabirintoDraw labirinto= new LabirintoDraw();
	CommandLine cli = new CommandLine();
	labirinto.lab[heroi.y][heroi.x]='H';
	labirinto.lab[drake.y][drake.x]='D';
	labirinto.LabirintoDesenho();
	while(k==1)
	{
	drake.adacDragao();
	cli.moveHeroi(labirinto,drake,heroi);
	labirinto.lab[heroi.y][heroi.x]=heroi.carater;
	labirinto.checkdeath(drake,heroi,labirinto);
	drake.moveDragao(labirinto);
	labirinto.lab[drake.y][drake.x]=drake.carater;
	labirinto.LabirintoDesenho();
	labirinto.checkdeath(drake,heroi,labirinto);	
	if (labirinto.gameover==true)
	{System.out.println(":::GAME_OVER:::");
	 System.exit(0);
	}
	}
}
}






