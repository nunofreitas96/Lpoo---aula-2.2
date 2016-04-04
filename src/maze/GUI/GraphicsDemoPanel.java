package maze.GUI;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import maze.logic.Labirinto;



public class GraphicsDemoPanel extends JPanel {
	private BufferedImage brickWall;
	private BufferedImage portao;
	private BufferedImage dragao;
	private BufferedImage heroi;
	private BufferedImage espada;
	private BufferedImage heroiArmado;
	private BufferedImage dragaoDormir;
	private BufferedImage relva;
	private BufferedImage portaoVertical;
	private BufferedImage dragaoDormirArmado;
	private BufferedImage dragaoArmado;
	private BufferedImage youWin;
	private BufferedImage youLose;
	
	private int x=0, y=0, width=100, height=100;
	public Labirinto labirinto;
	
	public GraphicsDemoPanel() {
		try {
			brickWall =  ImageIO.read(new File("brickWall.png"));
			portao = ImageIO.read(new File("portao.png"));
			heroi=ImageIO.read(new File("heroi.png"));
			dragao= ImageIO.read(new File("dragao.png"));
			espada=  ImageIO.read(new File("Espada.png"));
			heroiArmado= ImageIO.read(new File("heroiArmado.png"));
			dragaoDormir= ImageIO.read(new File("dragaoDorminhoco.png"));
			relva=ImageIO.read(new File("relva.png"));
			portaoVertical=ImageIO.read(new File("portaoVertical.png"));
			dragaoDormirArmado= ImageIO.read(new File("dragaoDorminhocoArmado.png"));
			dragaoArmado= ImageIO.read(new File("dragaoArmado.png"));
			youLose= ImageIO.read(new File("youLose.png"));
			youWin= ImageIO.read(new File("youWIN.png"));
			
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
		});
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("x=" + x);
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT: 
					if (labirinto.modo==1)
					{
						labirinto.JogadaParado('a');
							
					}
					if (labirinto.modo==2)
					{
						labirinto.JogadaMovimento('a');
					}
					if (labirinto.modo==3)
					{
						labirinto.JogadaDormir('a');
						
					}
					break;
				case KeyEvent.VK_ESCAPE: 
				{
					Window d= SwingUtilities.getWindowAncestor(GraphicsDemoPanel.this);
					d.setVisible(false);
				}
				case KeyEvent.VK_RIGHT: 
					if (labirinto.modo==1)
					{
						labirinto.JogadaParado('d');
						
							
					}
					if (labirinto.modo==2)
					{
						labirinto.JogadaMovimento('d');
					}
					if (labirinto.modo==3)
					{
						labirinto.JogadaDormir('d');
						
					}
					//System.out.println("x=" + x);
					break;

				case KeyEvent.VK_UP: 
					if (labirinto.modo==1)
					{
						labirinto.JogadaParado('w');
							
					}
					if (labirinto.modo==2)
					{
						labirinto.JogadaMovimento('w');
					}
					if (labirinto.modo==3)
					{
						labirinto.JogadaDormir('w');
						
					}
					break;

				case KeyEvent.VK_DOWN: 
					if (labirinto.modo==1)
					{
						labirinto.JogadaParado('s');
							
					}
					if (labirinto.modo==2)
					{
						labirinto.JogadaMovimento('s');
					}
					if (labirinto.modo==3)
					{
						labirinto.JogadaDormir('s');
						
					}
					break;
				}
				repaint();

				
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}			
		});
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
					g.drawImage(youLose, 0, 0,  300, 150, 0, 0, 300, 150, null);
					Window d= SwingUtilities.getWindowAncestor(GraphicsDemoPanel.this);
					d.setBounds(100, 100,300+15, 150+30);
					}
					if (labirinto.cli.ganhaste==1)
					{
					g.drawImage(youWin, 0, 0,  300, 150, 0, 0, 300, 150, null);
					Window d= SwingUtilities.getWindowAncestor(GraphicsDemoPanel.this);
					d.setBounds(100, 100,300+15, 150+30);
					
					}
				}
				else
				{
				if (labirinto.lab.lab[i][j]=='X')
				{//g.drawImage(brickWall, sitiox, sitioy, sitiox + brickWall.getWidth()-100-1, sitioy + brickWall.getHeight()-100-1, 0, 0, brickWall.getWidth()-100, brickWall.getHeight()-100, null);
					g.drawImage(brickWall, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='S')
				{
					if(labirinto.lab.lab[i][0]=='S'||labirinto.lab.lab[i][labirinto.sizex-1]=='S')
					{
						g.drawImage(portaoVertical, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
					}
					else
					{
					g.drawImage(portao, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
					}
				}
				if (labirinto.lab.lab[i][j]=='H')
				{
					g.drawImage(heroi, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='D')
				{
					g.drawImage(dragao, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='E')
				{
					g.drawImage(espada, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='A')
				{
					g.drawImage(heroiArmado, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='d')
				{
					g.drawImage(dragaoDormir, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]==' ')
				{
					g.drawImage(relva, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				if (labirinto.lab.lab[i][j]=='f')
				{
					g.drawImage(dragaoDormirArmado, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				
				}
				if (labirinto.lab.lab[i][j]=='F')
				{
					g.drawImage(dragaoArmado, sitiox, sitioy, sitiox + 50, sitioy +50, 0, 0, 50, 50, null);
				}
				}
			}
			
		}
		
	}

}
