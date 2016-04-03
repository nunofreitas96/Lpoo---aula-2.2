package maze.GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import maze.logic.Labirinto;

public class MazeCreator extends JPanel {

	private BufferedImage brickWall;
	private BufferedImage portao;
	private BufferedImage dragao;
	private BufferedImage heroi;
	private BufferedImage espada;
	private BufferedImage heroiArmado;
	private BufferedImage dragaoDormir;
	
	int status =0;
	int ndragons;
	int npos;
	int nhero = 0;
	int nsword = 0;
	int nexits = 0;
	private int x=0, y=0, width=100, height=100;
	public Labirinto labirinto = new Labirinto();
	
	
	public MazeCreator(int pos, int drag){
		labirinto.sizex = pos;
		labirinto.sizey = pos;
		labirinto.inicialize2();
		
		JComboBox<String> comboChoices = new JComboBox<String>();
		comboChoices.addItem("Wall");
		comboChoices.addItem("Dragons");
		comboChoices.addItem("Hero");
		comboChoices.addItem("Sword");
		comboChoices.addItem("Gate");
		this.add(comboChoices, BorderLayout.PAGE_END);
		
		try {
			brickWall =  ImageIO.read(new File("brickWall.png"));
			portao = ImageIO.read(new File("portao.png"));
			heroi=ImageIO.read(new File("heroi.png"));
			dragao= ImageIO.read(new File("bigD.png"));
			espada=  ImageIO.read(new File("Espada.png"));
			heroiArmado= ImageIO.read(new File("armado.png"));
			dragaoDormir= ImageIO.read(new File("smalld.png"));
			 
		} catch (IOException e) {
			e.printStackTrace();
		}	
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				int tempx;
				int tempy;
				tempx = x/50;
				tempy = y/50;
				
				switch(status){
				
				case 0:
					if(tempx !=0 && tempy !=0 && tempx != pos && tempy != pos ){
						labirinto.lab.lab[tempx][tempy]  ='X';
						
					}
				break;
				case 1:
				if(tempx !=0 && tempy !=0 && tempx != pos && tempy != pos ){
					if(nhero ==0){
					labirinto.lab.lab[tempx][tempy]  ='H';
					nhero =1;
						}
					if(nhero ==1){
						for(int i = 0; i< labirinto.lab.sizex; i++){
							for (int j = 0; j < labirinto.lab.sizey; j++){
								if(labirinto.lab.lab[i][j] == 'H'){
									labirinto.lab.lab[i][j] = ' ';
								}
							}
						}
						
						
						
					}
					
					}
				break;
				case 2:
					if(tempx !=0 && tempy !=0 && tempx != pos && tempy != pos ){
						if(ndragons < drag){
							labirinto.lab.lab[tempx][tempy]  ='D';
							ndragons++;
						}
						else{
							for(int i = 0; i< labirinto.lab.sizex; i++){
								for (int j = 0; j < labirinto.lab.sizey; j++){
									if(labirinto.lab.lab[i][j] == 'D'){
										labirinto.lab.lab[i][j] = ' ';
										break; //Make sure it works
									}
								}
						}
							
							labirinto.lab.lab[tempx][tempy]  ='D';
						
					}
					
				}
					break;
				case 3:
					if(tempx !=0 && tempy !=0 && tempx != pos && tempy != pos ){
						if(nsword ==0){
						labirinto.lab.lab[tempx][tempy]  ='E';
						nsword =1;
							}
						if(nsword ==1){
							for(int i = 0; i< labirinto.lab.sizex; i++){
								for (int j = 0; j < labirinto.lab.sizey; j++){
									if(labirinto.lab.lab[i][j] == 'E'){
										labirinto.lab.lab[i][j] = ' ';
									}
								}
							}
							
							
							
						}
						
						}
					break;
				case 4:
					if(tempx ==0 || tempy ==0 || tempx == pos || tempy == pos ){
						if(nexits ==0){
							labirinto.lab.lab[tempx][tempy]  ='S';
							nexits =1;
						}
						else{
							for(int i = 0; i< labirinto.lab.sizex; i++){
								for (int j = 0; j < labirinto.lab.sizey; j++){
									if(labirinto.lab.lab[i][j] == 'S'){
										labirinto.lab.lab[i][j] = ' ';
									}
								}
						}
						
					}
					
				
				}break;
					}
				repaint();
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}	
		} );
		
		
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i=0,sitioy=0; i<labirinto.lab.sizey;i++,sitioy+=50)
		{
			for (int j=0,sitiox=0; j<labirinto.lab.sizex;j++,sitiox+=50)
			{
				if (labirinto.lab.gameover==true || labirinto.cli.ganhaste==1)
				{
					if (labirinto.lab.gameover==true)
					{
					g.drawImage(dragaoDormir, 10, 10,  200, 200, 0, 0, 200, 200, null);
					}
					if (labirinto.cli.ganhaste==1)
					{
					g.drawImage(dragao, 10, 10,  200, 200, 0, 0, 200, 200, null);
					}
				}
				else
				{
				if (labirinto.lab.lab[i][j]=='X')
				{//g.drawImage(brickWall, sitiox, sitioy, sitiox + brickWall.getWidth()-100-1, sitioy + brickWall.getHeight()-100-1, 0, 0, brickWall.getWidth()-100, brickWall.getHeight()-100, null);
					g.drawImage(brickWall, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='S')
				{
					g.drawImage(portao, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='H')
				{
					g.drawImage(heroi, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='D')
				{
					g.drawImage(dragao, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='E')
				{
					g.drawImage(espada, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='A')
				{
					g.drawImage(heroiArmado, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='d')
				{
					g.drawImage(dragaoDormir, sitiox, sitioy, sitiox + 50-1, sitioy +50-1, 0, 0, 50, 50, null);
				}
				}
			}
			
		}
		
	}
}



