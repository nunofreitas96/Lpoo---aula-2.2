package maze.logic;
import java.util.Scanner;

public class Heroi {

	public char carater;
public boolean armado;
public int x;
public int y;
public Heroi()
{
	carater='H';
	armado=false;
	x=1;
	y=1;
}

public  void apanhaEspada()
{
	armado=true;
	carater='A';
}



}
