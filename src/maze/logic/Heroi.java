package maze.logic;
import java.util.Scanner;

public class Heroi {
/**
 * Carater do Heroi 
 */
public char carater;
/**
 * True se estiver armado
 */
public boolean armado;
/**
 * Coordenada x do heroi
 */
public int x;
/**
 * Coordenada y do heroi
 */
public int y;
/**
 * Cria um heroi 
 */
public Heroi()
{
	carater='H';
	armado=false;
	x=1;
	y=1;
}
/**
 * faz heroi apanhar a espada, ficando assim "armado"
 */
public  void apanhaEspada()
{
	armado=true;
	carater='A';
}



}
