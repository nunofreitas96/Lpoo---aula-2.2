package maze.logic;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public class LabirintoDraw {
public boolean gameover;
public int sizex=7;
public int sizey=7;

Deque<Integer> stackVisitsx = new ArrayDeque<Integer>();
Deque<Integer> stackVisitsy = new ArrayDeque<Integer>();
public ArrayList<Dragao> drakes = new ArrayList<Dragao>();
public char[][] lab; /*=   {{'X','X','X','X','X','X','X','X', 'X','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','E','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	*/
/**
 * 	Cria um LabirintoDraw com as dimensoes  indicadas	
 * @param sizex, dimensao em x
 * @param sizey, dimensao em y
 */
public LabirintoDraw(int sizex,int sizey){
	gameover=false;
	this.sizex=sizex;
	this.sizey=sizey;
};



/** 
 * Cria um labirinto de dimensoes sizex,sizey base com as celulas pares preenchidas por paredes
 * @return labirinto gerado
 */
public char[][] MazeBuilder()
{
	char[][]maze = new char[sizey][sizex];
	//encher de X's as pares
	
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
/**
 * Cria um labirinto de dimensoes sizex,sizey base com paredes a volta
 * @return
 */
public char[][] MazeBuilder2()
{
	char[][]maze = new char[sizey][sizex];
	//encher de X's as pares
	for(int i = 0; i < sizex ;i++){
		maze[0][i] = 'X';
	}
	for(int i = 0; i < sizey ;i++){
		maze[i][0] = 'X';
	}
	for(int i = 0; i < sizex ;i++){
		maze[sizey-1][i] = 'X';
	}
	for(int i = 0; i < sizey ;i++){
		maze[i][sizex-1] = 'X';
	}
	for(int i =0; i <sizey;i++)
	{
		for(int j = 0; j < sizex ;j++)
		{
			if(maze[i][j]!='X')
			{
				maze[i][j]=' ';
			}
		}
	}
	lab=maze;
	return maze;
}
/**
 * Procura um sitio aleatorio para colocar a saida do labirinto
 * @return array com as coordenadas da saida gerada
 */
public int[] SearchExit(){
	int[] exit = new int[2];
	Random generator= new Random();
	int x =0;
	int y =0;
	while(x != 1 && x!= (sizex-1)/2 && y != 1 && y != (sizey-1)/2){
		x= generator.nextInt((sizex-1)/2)+1;
		y= generator.nextInt((sizey-1)/2)+1;
	}
	if (x==1&&y==1)
	{
		int n= generator.nextInt(2);
		if (n == 0)
		{lab[1][0] = 'S';}
		else
		{lab[0][1] = 'S';}
	}
	else if (x==1 && y ==(sizey-1)/2) 
	{
		int n= generator.nextInt(2);
		if (n == 0)
		{lab[sizey-2][0] = 'S';}
		else
		{lab[sizey-1][1] = 'S';}
	}
	else if (x==(sizex-1)/2 && y==1)
	{
		int n= generator.nextInt(2);
		if (n == 0)
		{lab[0][sizex-2] = 'S';}
		else
		{lab[1][sizex-1] = 'S';}
	}
	else if (x==(sizex-1)/2 && y==(sizey-1)/2)
	{
		int n= generator.nextInt(2);
		if (n == 0)
		{lab[sizey-1][sizex-2] = 'S';}
		else
		{lab[sizey-2][sizex-1] = 'S';}
	}
	else if(x == 1){
		lab[y*2-1][0] = 'S';
		
	}
	else if(x == (sizex-1)/2){
		lab[y*2-1][sizex-1] = 'S';
	}
	else if(y ==1){
		lab[0][x*2-1] = 'S';
	}
	else if(y ==(sizey-1)/2){
		lab[sizey-1][x*2-1] = 'S';
	}
	
	
	
	exit[0] =x-1;
	exit[1] =y-1;
	
	
	return exit;
}



static int[] shuffleArray()
{
	int[] ar =  {1,2,3,4};
  // If running on Java 6 or older, use `new Random()` on RHS here
  Random rnd = new Random();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
    // Simple swap
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
  return ar;
}

/**
 * Gera um labirinto aleatorio partindo das coordenadas da saida
 * @param x1 coordenada x da saida
 * @param y1 coordanada y da saida
 * @return labirinto gerado
 */
public char[][]MakeWay(int x1, int y1){
	char[][]visited;
	visited = FillVisited();
	visited[y1][x1] = '+';
	
	stackVisitsx.push(x1);
	stackVisitsy.push(y1);
	whyudodis:
	while(!CheckVisited(visited)){
		
		int[] intDirections = shuffleArray();
		for(int i=0; i< intDirections.length+1; i++)
		{
			if(i == intDirections.length){
				
				stackVisitsx.pop();
				stackVisitsy.pop();
				if(stackVisitsx.isEmpty()){
					break whyudodis;
				}
				x1 = stackVisitsx.getFirst();
				y1 = stackVisitsy.getFirst();
				System.out.println(5);
			}
			else{	
			if(intDirections[i]==1 && y1-1 >= 0){
				if(visited[y1-1][x1]== '.')
			
			{
				visited[y1-1][x1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1-1);
				lab[y1*2][x1*2+1] = ' ';
				y1=y1-1;
				System.out.println(1);
				break;
				
			}}
			if(intDirections[i]==2 && y1+1 < visited.length )
			{
				if(visited[y1+1][x1]== '.' ){
				visited[y1+1][x1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1+1);
				lab[y1*2+2][x1*2+1] = ' ';
				y1=y1+1;
				System.out.println(2);
				break;
				}
			}
			if(intDirections[i]==3 && x1-1 >= 0 )
			{
				if( visited[y1][x1-1]== '.' ){
				
				visited[y1][x1-1]='+';
				stackVisitsx.push(x1-1);
				stackVisitsy.push(y1);
				lab[y1*2+1][x1*2] = ' ';
			
				x1=x1-1;
				System.out.println(3);
				break;}
			}
			if(intDirections[i]==4 && x1 +1 < visited[0].length )
			{
				if(visited[y1][x1+1]== '.' ){
				
				visited[y1][x1+1]='+';
				stackVisitsx.push(x1+1);
				stackVisitsy.push(y1);
				lab[y1*2+1][x1*2+2] = ' ';
				
				x1=x1+1;
				System.out.println(4);
				break;}
			}}
		}
		
			/*if(n ==1 && visited[y1-1][x1] == '.'){
				visited[y1-1][x1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1);
				lab[y1*2-2][x1*2-1] = ' ';
				move = true;
				MakeWay(x1,y1-1,visited);
				
				
			}
			if(n ==2 && visited[y1+1][x1] == '.'){
				visited[y1+1][x1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1);
				lab[y1*2][x1*2-1] = ' ';
				move = true;
				MakeWay(x1,y1+1,visited);
			}
			if(n ==3 && visited[y1][x1-1] == '.'){
				visited[y1][x1-1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1);
				lab[y1*2-1][x1*2-2] = ' ';
				move = true;
				MakeWay(x1-1,y1,visited);
			}
			if(n ==4 && visited[y1][x1+1] == '.'){
				visited[y1][x1+1]='+';
				stackVisitsx.push(x1);
				stackVisitsy.push(y1);
				lab[y1*2-1][x1*2] = ' ';
				move = true;
				MakeWay(x1+1,y1,visited);
				
			}*/
		}
	
	
	return lab;
}

private char[][] FillVisited(){
	
	char[][]visited = new char[(sizey-1)/2 ][(sizex-1)/2];
	for(int j =0; j < (sizey-1)/2 ; j++){
		for(int i=0; i < (sizex-1)/2; i++){
			visited[j][i] = '.';
		}
	}
	return visited;
}

private boolean CheckVisited(char[][] visited){
	
	for(int j=0; j < (sizey-1)/2; j++){
		for(int i =0; i < (sizex-1)/2; i++){
			if(visited[j][i] == '.'){
				return false;
			}
		}
	}
	
	
	return true;
}
/**
 * Desenha labirinto na consola
 */
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
/**
 * Cria e coloca os dragoes no labirinto 
 * @param n, numero de dragoes
 */
public void makeDragons(int n){
	int ncheck =0;
	while(ncheck < n){
		 Random rnd = new Random();
		 int x;
		 int y;
		 x= rnd.nextInt(sizex-1)+1;
		 y= rnd.nextInt(sizey-1)+1;
		 if(lab[y][x] == ' '){
			 Dragao Drake = new Dragao(x,y);
			 lab[y][x] = 'D';
			 drakes.add(Drake);
			 ncheck++;
		 }
		 
		 
	}
}
/**
 * Cria e coloca o heroi no labirinto em posicao nao adjacente aos dragoes
 * @return
 */
public Heroi makeHero(){
	int ncheck =0;
	while(ncheck < 1){
		 Random rnd = new Random();
		 int x;
		 int y;
		 x= rnd.nextInt(sizex-1)+1;
		 y= rnd.nextInt(sizey-1)+1;
		 if(lab[y][x] == ' ' && lab[y+1][x] != 'D'&& lab[y-1][x] != 'D' && lab[y][x+1] != 'D' && lab[y][x-1] != 'D')
		 {
			 Heroi hero = new Heroi();
			 hero.x=x;
			 hero.y=y;
			 lab[y][x] = hero.carater;
			 ncheck++;
			 return hero;
		 }
	}
	return null;
	
}
/**
 * Cria e colaca espada no labirinto
 */
public void makeEspada(){
	int ncheck =0;
	while(ncheck < 1){
		 Random rnd = new Random();
		 int x;
		 int y;
		 x= rnd.nextInt(sizex-1)+1;
		 y= rnd.nextInt(sizey-1)+1;
		 if (lab[y][x] == ' ' )
		 {
			
			 lab[y][x] = 'E';
			 ncheck++;
			 return;
		 }
	}
	return;
}
/**
 * Converte o labirinto atual para string
 * @return labirinto em string
 */
public String mazeToString()
{
String maze="";
	for(int i=0;i<sizey;i++)
	{
		for (int j=0;j<sizex;j++)
		{

			maze= maze+lab[i][j]+" ";
			if(j==sizex-1)
			{maze= maze+'\n';}
		}
	}
return maze;
}
/**
 * Controla a morte de um dragao ou do heroi
 * @param drake dragao 
 * @param heroi heroi
 * @param labirinto labirinto
 */
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
