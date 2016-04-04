package maze.logic;
import java.util.Random;

public class Dragao {
	/**
	 * Estado do dragao, pode alterar entre "morto", "acordado", "dormir"
	 */
	public String estado;
	/**
	 * Coordenada x do dragao
	 */
	public int x;
	/**
	 * Coordenada y do dragao
	 */
	public int y;
	/**
	 * Carater do dragao, d-"dormir" D-"acordado"
	 */
	public char carater;
	/**
	 * True, se tiver encima da espada 
	*/
	public boolean temEspada;
	/**
	 * Cria um Dragao 
	 */
	public Dragao()
	{
		carater='D';
		estado="acordado";
		x=1;
		y=3;
		temEspada=false;
	}
	/**
	 *  Cria um Dragao com as coordenadas indicadas
	 * @param x, coordenada x
	 * @param y, coordenada y
	 */
	public Dragao(int x, int y){
		carater='D';
		estado="acordado";
		this.x = x;
		this.y = y;
		temEspada=false;
		
	}

/**
 * Altera o estado do dragao para "morto"	
 */
	public void dragaoMorre()
	{
		estado="morto";
		carater=' ';
		
	}
/**
 * Altera o estado do dragao para "dormir" ou "acordado" aleatoriamente
 */
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
/**
 * Utilizada para ter a certeza que o dragao move 
 * @param labirinto
 */
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
/**
 * Faz dragao apanhar a espada
 */
	public void apanhaEspada()
	{
		carater='F';
		temEspada=true;
	}
	
/**
 * Move o dragao numa direcao aleatoria
 * @param labirinto, labirinto utilizado.
 * @return
 */
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

