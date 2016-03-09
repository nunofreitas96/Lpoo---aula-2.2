package maze.logic;

public class LabirintoDraw {
public boolean gameover;
public int sizex=10;
public int sizey=10;
public char[][] lab =   {{'X','X','X','X','X','X','X','X', 'X','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','E','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	
	
public LabirintoDraw(){
	gameover=false;
};

public char[][] MazeBuilder()
{
	char[][]maze = new char[sizey][sizex];
	//encher de X's as posiçoes pares
	
	for (int i =0; i<sizey; i++)
		{
			for(int j=0; j<sizex;j++)
			{
				if (i % 2 != 0 && j % 2 != 0)
					maze[i][j] = ' ';
				else
					maze[i][j] = 'X';
						
			};
		}
	lab=maze;
	return maze;
}


public void LabirintoDesenho()
{


for(int i=0;i<sizey;i++)
{
	for (int j=0;j<sizex;j++)
	{

		System.out.print(lab[i][j]+" ");
		if(j==sizex-1)
		{System.out.print('\n');}
	}
}

}

public void checkdeath(Dragao drake,Heroi heroi, LabirintoDraw labirinto)
{
	if(drake.estado!="morto")
	{
	if ((((drake.x+1)==heroi.x&&drake.y==heroi.y)||((drake.x-1)==heroi.x&&drake.y==heroi.y)||((drake.y-1)==heroi.y&&drake.x==heroi.x)||((drake.y+1)==heroi.y&&drake.x==heroi.x))&&heroi.armado==false&&drake.estado=="acordado")
	{
		gameover=true;
	
	}
	
	if ((((drake.x+1)==heroi.x&&drake.y==heroi.y)||((drake.x-1)==heroi.x&&drake.y==heroi.y)||((drake.y-1)==heroi.y&&drake.x==heroi.x)||((drake.y+1)==heroi.y&&drake.x==heroi.x))&&heroi.armado==true)
	{
		lab[drake.y][drake.x]=' ';
		drake.dragaoMorre();
	}
	}
	
	
}
}
