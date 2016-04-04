package maze.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import maze.logic.Dragao;
import maze.logic.Labirinto;

public class MazeCreator extends JPanel {

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
	private JButton play;
	private boolean jogavel;
	private JFrame frmCreate;
	public int modo;
	int status =0;
	int ndragons;
	int npos;
	int nhero = 0;
	int nsword = 0;
	int nexits = 0;
	private int x=0, y=0, width=100, height=100;
	public Labirinto labirinto = new Labirinto();
	
	
	public MazeCreator(int posx,int posy, int drag ){
		labirinto.sizex = posx;
		labirinto.sizey = posy;
		labirinto.inicialize2();
		
		this.setLayout(null);
		JComboBox<String> comboChoices = new JComboBox<String>();
		comboChoices.addItem("Wall");
		comboChoices.addItem("Dragons");
		comboChoices.addItem("Hero");
		comboChoices.addItem("Sword");
		comboChoices.addItem("Gate");
		comboChoices.setBounds(900,10, 80, 25);
		this.add(comboChoices);
		
		play = new JButton("PLAY");
		play.setEnabled(false);
		play.setBounds(900,45, 80, 25);
		this.add(play);
		play.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmCreate = new JFrame();
			frmCreate.setTitle("Graphics Demo");
			frmCreate.setBounds(100,100,labirinto.lab.sizex*50+15,labirinto.lab.sizey*50+30);
			frmCreate.setPreferredSize(new Dimension(1000, 1000));
			frmCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Custom panel = new Custom();
			;
			panel.labirinto=labirinto;
			
			frmCreate.getContentPane().add(panel);
			Window d= SwingUtilities.getWindowAncestor(MazeCreator.this);
			d.setVisible(false);
		

			
			
			frmCreate.setVisible(true);

			
			panel.requestFocus();
		
			
			
		}
		
		});
		
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
				int tempx;
				int tempy;
				tempx = x/50;
				tempy = y/50;
				
				switch(comboChoices.getSelectedItem().toString()){
				
				case "Wall":
					if(tempx !=0 && tempy !=0 && tempx != posx-1 && tempy != posy-1 ){
						if(labirinto.lab.lab[tempy][tempx]  =='H')
						{
							labirinto.lab.lab[tempy][tempx]  ='X';
							labirinto.heroi.x=0;
							labirinto.heroi.y=0;
							play.setEnabled(false);
						}
						else if(labirinto.lab.lab[tempy][tempx]  =='X')
						{
							labirinto.lab.lab[tempy][tempx]  =' ';
						}
						else if(labirinto.lab.lab[tempy][tempx]  == 'D')
						{
							for (int i=0; i<	labirinto.lab.drakes.size();i++)
							{
								if (labirinto.lab.drakes.get(i).x==tempx && labirinto.lab.drakes.get(i).y==tempy)
								{
									labirinto.lab.lab[tempy][tempx]='X';
									labirinto.lab.drakes.remove(i);
									labirinto.lab.drakes.trimToSize();
									
									ndragons--;
								}
							}
						}
						else
						labirinto.lab.lab[tempy][tempx]  ='X';
						
					}
				break;
				case "Hero":
				if(tempx !=0 && tempy !=0 && tempx != posx-1 && tempy != posy-1 ){
		
					if(labirinto.lab.lab[tempy][tempx]  == 'D')
					{
						for (int i=0; i<	labirinto.lab.drakes.size();i++)
						{
							if (labirinto.lab.drakes.get(i).x==tempx && labirinto.lab.drakes.get(i).y==tempy)
							{
								labirinto.lab.lab[tempy][tempx]='H';
								labirinto.lab.lab[labirinto.heroi.y][labirinto.heroi.x]  =' ';
								labirinto.heroi.x=tempx;
								labirinto.heroi.y=tempy;
								labirinto.lab.drakes.remove(i);
								labirinto.lab.drakes.trimToSize();
								play.setEnabled(true);
								ndragons--;
							}
						}
					}
					else if (labirinto.heroi.x==0&&labirinto.heroi.y==0)
					{
						labirinto.lab.lab[tempy][tempx]  ='H'; 
						labirinto.heroi.x=tempx;
						labirinto.heroi.y=tempy;
						play.setEnabled(true);
						nhero =1;
					}
					else if (labirinto.lab.lab[tempy][tempx]  == 'H')
					{
						labirinto.lab.lab[labirinto.heroi.y][labirinto.heroi.x]  =' ';
						labirinto.heroi.x=0;
						labirinto.heroi.y=0;
						play.setEnabled(false);
					}
					 else if(nhero ==0)
					{
					labirinto.lab.lab[tempy][tempx]  ='H'; 
					labirinto.heroi.x=tempx;
					labirinto.heroi.y=tempy;
					play.setEnabled(true);
					nhero =1;
					}
					else if(nhero ==1)
					{
						labirinto.lab.lab[labirinto.heroi.y][labirinto.heroi.x]  =' '; 
						labirinto.lab.lab[tempy][tempx]  ='H'; 
						labirinto.heroi.x=tempx;
						labirinto.heroi.y=tempy;
						play.setEnabled(true);
						
					}
						
				
						
			
						
					}
					
					
				break;
				case "Dragons":
					
					if(tempx !=0 && tempy !=0 && tempx != posx-1 && tempy != posy-1 )
					 {
						if(labirinto.lab.lab[tempy][tempx]  =='H')
						{
							if(ndragons <= drag-1)
							{
								labirinto.lab.lab[tempy][tempx]  ='D';
								Dragao drake= new Dragao();
								labirinto.lab.drakes.add(drake);
								labirinto.lab.drakes.get(ndragons).x=tempx;
								labirinto.lab.drakes.get(ndragons).y=tempy;
								ndragons++;
								
							}
							
							else{
								
								labirinto.lab.lab[labirinto.lab.drakes.get(0).y][labirinto.lab.drakes.get(0).x]  =' ';
								labirinto.lab.drakes.remove(0);
								labirinto.lab.drakes.trimToSize();
								ndragons--;
							
						}
							labirinto.heroi.x=0;
							labirinto.heroi.y=0;
							play.setEnabled(false);
						}
						else if(labirinto.lab.lab[tempy][tempx]  == 'D')
						{
							for (int i=0; i<	labirinto.lab.drakes.size();i++)
							{
								if (labirinto.lab.drakes.get(i).x==tempx && labirinto.lab.drakes.get(i).y==tempy)
								{
									labirinto.lab.lab[tempy][tempx]=' ';
									labirinto.lab.lab[0][0]='X';
									labirinto.lab.drakes.remove(i);
									labirinto.lab.drakes.trimToSize();
									ndragons--;
								}
							}
						}
						else if(ndragons <= drag-1)
						{
							labirinto.lab.lab[tempy][tempx]  ='D';
							Dragao drake= new Dragao();
							labirinto.lab.drakes.add(drake);
							labirinto.lab.drakes.get(ndragons).x=tempx;
							labirinto.lab.drakes.get(ndragons).y=tempy;
							ndragons++;
							
						}
						
						else{
							
							labirinto.lab.lab[labirinto.lab.drakes.get(0).y][labirinto.lab.drakes.get(0).x]  =' ';
							labirinto.lab.drakes.remove(0);
							labirinto.lab.drakes.trimToSize();
							ndragons--;
						
					}
					
				}
					break;
				case "Sword":
					if(tempx !=0 && tempy !=0 && tempx != posx-1 && tempy != posy-1 ){
						if(labirinto.lab.lab[tempy][tempx]  == 'D')
						{
							for (int i=0; i<	labirinto.lab.drakes.size();i++)
							{
								if (labirinto.lab.drakes.get(i).x==tempx && labirinto.lab.drakes.get(i).y==tempy)
								{
									labirinto.lab.lab[tempy][tempx]='E';
									labirinto.lab.drakes.remove(i);
									labirinto.lab.drakes.trimToSize();
									
									ndragons--;
								}
							}
						}
						else if (labirinto.lab.lab[tempy][tempx] =='H')
						{
							labirinto.lab.lab[tempy][tempx]  ='E'; 
							labirinto.heroi.x=0;
							labirinto.heroi.y=0;
							play.setEnabled(false);
							nhero =0;
						}
					else if(labirinto.lab.lab[tempy][tempx] =='E')
						{
						labirinto.lab.lab[tempy][tempx]  =' ';
						}
						else labirinto.lab.lab[tempy][tempx]  ='E';
							
						
						
						}
					break;
				case "Gate":
					if(tempx ==0 || tempy ==0 || tempx == posx-1 || tempy == posy-1 ){
						if((tempx ==0&&tempy==0)||(tempx ==0&&tempy==posy-1)||(tempx ==posx-1&&tempy==0)||(tempx ==posx-1&&tempy==posy-1))
						{
							break;
						}
						else if(labirinto.lab.lab[tempy][tempx]  == 'D')
						{
							for (int i=0; i<	labirinto.lab.drakes.size();i++)
							{
								if (labirinto.lab.drakes.get(i).x==tempx && labirinto.lab.drakes.get(i).y==tempy)
								{
									labirinto.lab.lab[tempy][tempx]='H';
									labirinto.lab.lab[labirinto.heroi.y][labirinto.heroi.x]  =' ';
									labirinto.heroi.x=tempx;
									labirinto.heroi.y=tempy;
									labirinto.lab.drakes.remove(i);
									labirinto.lab.drakes.trimToSize();
									
									ndragons--;
								}
							}
						}
						else if(labirinto.lab.lab[tempy][tempx]=='S')
						{
							labirinto.lab.lab[tempy][tempx]='X';
							nexits=0;
						}
						else if (nexits ==1)
						{
							for (int i =0; i<labirinto.lab.sizey;i++ )
							{
								for (int j =0; j<labirinto.lab.sizex; j++ )
								{
									if(labirinto.lab.lab[i][j]=='S')
									{
										labirinto.lab.lab[i][j]='X';
										labirinto.lab.lab[tempy][tempx]='S';
									}
								}
							}
						}
							
						else if(nexits ==0)
						{
							labirinto.lab.lab[tempy][tempx]  ='S';
							nexits =1;
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
			}}	
		 );
		
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
					Window d= SwingUtilities.getWindowAncestor(MazeCreator.this);
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
					Window d= SwingUtilities.getWindowAncestor(MazeCreator.this);
					d.setBounds(100, 100,300+15, 150+30);
					}
					if (labirinto.cli.ganhaste==1)
					{
					g.drawImage(youWin, 0, 0,  300, 150, 0, 0, 300, 150, null);
					Window d= SwingUtilities.getWindowAncestor(MazeCreator.this);
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
