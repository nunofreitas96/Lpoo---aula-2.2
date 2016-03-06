package maze.logic;

public class LabirintoDraw {

public boolean gameover;
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

public void LabirintoDesenho()
{


for(int i=0;i<10;i++)
{
	for (int j=0;j<10;j++)
	{

		System.out.print(lab[i][j]+" ");
		if(j==9)
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
