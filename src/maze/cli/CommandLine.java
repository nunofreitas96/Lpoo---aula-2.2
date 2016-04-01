package maze.cli;
import java.util.Scanner;

import maze.logic.Dragao;
import maze.logic.Heroi;
import maze.logic.Labirinto;
import maze.logic.LabirintoDraw;
public class CommandLine {
public int ganhaste = 0;
	public void commandLine(){
		
	}
	
	/*public void readMode(){
		int j;
		int k;
		Scanner reader = new Scanner(System.in);
		System.out.println("Escolha o modo de jogo: ");
		System.out.println("1- Dragao Parado");
		System.out.println("2- Dragao a Mover");
		System.out.println("3- Dragao a Mover e a Adormecer");
		k= reader.nextInt();
		while(k>3||k<1)
		{
			System.out.println("Numero invalido insira outro:");
			k= reader.nextInt();
		}
		if (k==1)
		Labirinto.Parado();
		if (k==2)
		Labirinto.MovDragao();
		if(k==3)
		Labirinto.AdorDragao();
	}
	*/
 public  void moveHeroi(LabirintoDraw labirinto,Heroi hero, char key)
	{
		
		
		moveHeroKey(key,labirinto,hero);

	}
	
	

public int moveHeroKey(char key,LabirintoDraw labirinto,Heroi hero)
{
	boolean alldead=false;
	int counter=0;
	for (int i=0;i<labirinto.drakes.size();i++)
	{
		if(labirinto.drakes.get(i).estado=="morto")
		{
			counter++;
		}
		
	}
	if (counter==labirinto.drakes.size())
	{
		alldead=true;
	}
	if( key=='w'&& (labirinto.lab[hero.y-1][hero.x]==' '||labirinto.lab[hero.y-1][hero.x]=='E'))
	{
		
		labirinto.lab[hero.y][hero.x]=' ';
		if(labirinto.lab[hero.y-1][hero.x]=='E')
		{
			hero.apanhaEspada();
		}
		hero.y=hero.y-1;
		return 1;
	}
	if( key=='s'&& (labirinto.lab[hero.y+1][hero.x]==' '||labirinto.lab[hero.y+1][hero.x]=='E'))
	{
		labirinto.lab[hero.y][hero.x]=' ';
		if(labirinto.lab[hero.y+1][hero.x]=='E')
		{
			hero.apanhaEspada();
		}
		hero.y=hero.y+1;
		return 2;
	}
	if( key=='a'&& (labirinto.lab[hero.y][hero.x-1]==' '||labirinto.lab[hero.y][hero.x-1]=='E'))
	{
		labirinto.lab[hero.y][hero.x]=' ';
		if(labirinto.lab[hero.y][hero.x-1]=='E')
		{
			hero.apanhaEspada();
		}
		hero.x=hero.x-1;
		return 3;
	}
	if( key=='d' && (labirinto.lab[hero.y][hero.x+1]==' '||labirinto.lab[hero.y][hero.x+1]=='E'))
	{
		labirinto.lab[hero.y][hero.x]=' ';
		if(labirinto.lab[hero.y][hero.x+1]=='E')
		{
			hero.apanhaEspada();
		}
		hero.x=hero.x+1;
		return 4;
	}
	if( key=='d' && labirinto.lab[hero.y][hero.x+1]=='S' && alldead==true )
	{
		labirinto.lab[hero.y][hero.x]=' ';
		hero.x=hero.x+1;
		ganhaste=1;
		
	}
	if( key=='a' && labirinto.lab[hero.y][hero.x-1]=='S' && alldead==true )
	{
		labirinto.lab[hero.y][hero.x]=' ';
		hero.x=hero.x+1;
		ganhaste=1;
		
	}
	if( key=='s' && labirinto.lab[hero.y+1][hero.x]=='S' && alldead==true )
	{
		labirinto.lab[hero.y][hero.x]=' ';
		hero.x=hero.x+1;
		ganhaste=1;
	}
	if( key=='w' && labirinto.lab[hero.y-1][hero.x]=='S' && alldead==true )
	{
		labirinto.lab[hero.y][hero.x]=' ';
		hero.x=hero.x+1;
		ganhaste=1;

	}
	return 0;
}
}
