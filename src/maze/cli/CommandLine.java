package maze.cli;
import java.util.Scanner;

import maze.logic.Dragao;
import maze.logic.Heroi;
import maze.logic.Labirinto;
import maze.logic.LabirintoDraw;
public class CommandLine {

	public void commandLine(){
		
	}
	
	public void readMode(){
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
	
	public  int moveHeroi(LabirintoDraw labirinto,Dragao drake,Heroi hero)
	{
		/*if(drake.carater=='D');
		{if ((((drake.x+1)==x&&drake.y==y)||((drake.x-1)==x&&drake.y==y)||((drake.y-1)==y&&drake.x==x)||((drake.y+1)==y&&drake.x==x))&&armado==false)
		{
			System.out.println("::::GAME OVER::::");
		System.exit(0);
		
		}
		
		if ((((drake.x+1)==x&&drake.y==y)||((drake.x-1)==x&&drake.y==y)||((drake.y-1)==y&&drake.x==x)||((drake.y+1)==y&&drake.x==x))&&armado==true)
		{
			labirinto.lab[drake.y][drake.x]=' ';
			drake.dragaoMorre();
		}}*/
		Scanner reader = new Scanner(System.in);
		System.out.print("Insira key: ");
		char key = reader.nextLine().charAt(0);
		
		if( key=='w'&& labirinto.lab[hero.y-1][hero.x]==' ')
		{
			
			labirinto.lab[hero.y][hero.x]=' ';
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
		if( key=='a'&& labirinto.lab[hero.y][hero.x-1]==' ')
		{
			labirinto.lab[hero.y][hero.x]=' ';
			hero.x=hero.x-1;
			return 3;
		}
		if(key=='d' && labirinto.lab[hero.y][hero.x+1]==' ')
		{
			labirinto.lab[hero.y][hero.x]=' ';
			hero.x=hero.x+1;
			return 4;
		}
		if(key=='d' && labirinto.lab[hero.y][hero.x+1]=='S' && drake.carater==' ')
		{
			labirinto.lab[hero.y][hero.x]=' ';
			hero.x=hero.x+1;
			System.out.println("::::YOU WIN::::");
			System.exit(0);
		}
		return 0;
	}
	
	
}
