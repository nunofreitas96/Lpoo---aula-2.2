package maze.logic;
import java.util.Random;

public class Dragao {
	
	public String estado;
	public int x;
	public int y;
	public char carater;
	public boolean temEspada;
	public Dragao()
	{
		carater='D';
		estado="acordado";
		x=1;
		y=3;
		temEspada=false;
	}
	public Dragao(int x, int y){
		carater='D';
		estado="acordado";
		this.x = x;
		this.y = y;
		temEspada=false;
		
	}

	
	public void dragaoMorre()
	{
		estado="morto";
		carater=' ';
		
	}
	
	public void adacDragao()
	{
		Random generator= new Random();
		int n= generator.nextInt(4)+1;
		if(temEspada==true&&estado=="dormir")
		{
			carater='f';
		}
		if(temEspada==true&&estado=="acordado")
		{
			carater='F';
		}
		if (n==1&&estado!="morto")
		{estado="dormir";
		 carater='d';
		 if (temEspada==true)
		 {
			 estado="dormir";
			 carater='f';
		 }
		}
		if (n==2&&estado!="morto")
		{
		estado="acordado";
		carater='D';
		if (temEspada==true)
		 {
			 estado="acordado";
			 carater='F';
		 }
		}
	}
	public void moveDragao(LabirintoDraw labirinto)
	{
		if(labirinto.gameover==true)
		{return;}
		if(estado=="dormir")
		{
			return;
		}
		while (move(labirinto)==1)
		{
			
		}
	}
	public void apanhaEspada()
	{
		carater='F';
		temEspada=true;
	}
	
	public int move(LabirintoDraw labirinto)
	{
		Random generator =new Random();
		int n= generator.nextInt(6)+1;
		if((labirinto.lab[y-1][x]=='D'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='D'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='D'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='D')||
			(labirinto.lab[y-1][x]=='d'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='d'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='d'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='d')||
			(labirinto.lab[y-1][x]=='F'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='F'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='F'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='F')||
			(labirinto.lab[y-1][x]=='f'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='f'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='f'&& labirinto.lab[y-1][x-1]=='X')||
			(labirinto.lab[y-1][x]=='X'&& labirinto.lab[y+1][x]=='X'&& labirinto.lab[y][x+1]=='X'&& labirinto.lab[y-1][x-1]=='f'))
		{
			return 0;
		}
		if( n==1 && labirinto.lab[y-1][x]==' '||labirinto.lab[y-1][x]=='E')
		{
			if(temEspada==true&&estado=="acordado")
			{
				carater='D';
				labirinto.lab[y][x]='E';
				y=y-1;
				temEspada=false;
				return 0;
			}
			if(labirinto.lab[y-1][x]=='E')
			{
				apanhaEspada();
			}
			labirinto.lab[y][x]=' ';
			y=y-1;
			return 0;
		}
		if( n==2 && (labirinto.lab[y+1][x]==' '||labirinto.lab[y+1][x]=='E'))
		{
			labirinto.lab[y][x]=' ';
			if(temEspada==true&&estado=="acordado")
			{
				carater='D';
				labirinto.lab[y][x]='E';
				y=y+1;
				temEspada=false;
				return 0;
			}
			if(labirinto.lab[y+1][x]=='E')
			{
				apanhaEspada();
			}
			labirinto.lab[y][x]=' ';
			y=y+1;
			return 0;
		}
		if( (n==3||n==5 )&& (labirinto.lab[y][x-1]==' '||labirinto.lab[y][x-1]=='E'))
		{
			if(temEspada==true&&estado=="acordado")
			{
				carater='D';
				labirinto.lab[y][x]='E';
				x=x-1;
				temEspada=false;
				return 0;
			}
			if(labirinto.lab[y][x-1]=='E')
			{
				apanhaEspada();
			}
			labirinto.lab[y][x]=' ';
			x=x-1;
			return 0;
		}
		if( (n==4||n==6) && (labirinto.lab[y][x+1]==' '||labirinto.lab[y][x+1]=='E'))
		{
			if(temEspada==true&&estado=="acordado")
			{
				carater='D';
				labirinto.lab[y][x]='E';
				x=x+1;
				temEspada=false;
				return 0;
			}
			if(labirinto.lab[y][x+1]=='E')
			{
				apanhaEspada();
			}
			labirinto.lab[y][x]=' ';
			x=x+1;
			return 0;
		}
		return 1;
		
	}
}

