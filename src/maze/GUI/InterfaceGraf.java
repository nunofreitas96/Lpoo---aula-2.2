package maze.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import maze.logic.*;
import maze.cli.*;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
public class InterfaceGraf {

	private JFrame frmAmazeing;
	private JTextField Dimentionx;
	private JTextField Ndrakes;
	private static Labirinto lab;
	private static boolean created=false;
	private JButton btnNewButton_9;
	private JButton btnNewButton_8;
	private JButton btnNewButton_7;
	private JButton btnNewButton_6;
	private JFrame frmGraphicsDemo;
	private JTextField Dimentiony;
	private JFrame frmCreate;
	GraphicsDemoPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraf window = new InterfaceGraf();
					window.frmAmazeing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGraf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmazeing = new JFrame();
		frmAmazeing.setResizable(false);
		frmAmazeing.setTitle("aMAZEing");
		frmAmazeing.setBounds(100, 100, 700, 500 );
		frmAmazeing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/*	frmGraphicsDemo = new JFrame();
		frmGraphicsDemo.setTitle("Graphics Demo");
		frmGraphicsDemo.setBounds(100, 100, 450, 300);
		frmGraphicsDemo.setPreferredSize(new Dimension(450, 300));
		frmGraphicsDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDemoPanel panel = new GraphicsDemoPanel();
		frmGraphicsDemo.getContentPane().add(panel);

		frmGraphicsDemo.pack();
		
		frmGraphicsDemo.setVisible(true);
		
		panel.requestFocus();*/

		frmAmazeing.getContentPane().setLayout(null);
		JLabel lblDimensaoDoLabirinto = new JLabel("Dimensao do Labirinto");
		lblDimensaoDoLabirinto.setBounds(29, 36, 134, 14);
		frmAmazeing.getContentPane().add(lblDimensaoDoLabirinto);
		
		JComboBox ModoDeJogo = new JComboBox();
		ModoDeJogo.setModel(new DefaultComboBoxModel(new String[] {"Dragao Agitado", "Dragao Parado", "Dragao Dorminhoco"}));
		ModoDeJogo.setBounds(192, 83, 134, 20);
		frmAmazeing.getContentPane().add(ModoDeJogo);
		
		JLabel lblNumeroDeDragoes = new JLabel("Numero de Dragoes");
		lblNumeroDeDragoes.setBounds(29, 61, 134, 14);
		frmAmazeing.getContentPane().add(lblNumeroDeDragoes);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(29, 139, 346, 299);
		frmAmazeing.getContentPane().add(textArea);
		
		Dimentionx = new JTextField();
		Dimentionx.setText("11");
		Dimentionx.setBounds(204, 33, 26, 20);
		frmAmazeing.getContentPane().add(Dimentionx);
		Dimentionx.setColumns(10);
		
		JLabel Descricao = new JLabel("Gere Labirinto!");
		Descricao.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		Descricao.setBounds(29, 446, 346, 14);
		frmAmazeing.getContentPane().add(Descricao);
		
		btnNewButton_9 = new JButton("LEFT");
		btnNewButton_9.setEnabled(false);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lab.modo==1)
				{
					lab.JogadaParado('a');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
						
				}
				if (lab.modo==2)
				{
					lab.JogadaMovimento('a');
				
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
				if (lab.modo==3)
				{
					lab.JogadaDormir('a');
					
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
			}
		});
		
		btnNewButton_8 = new JButton("UP");
		btnNewButton_8.setEnabled(false);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lab.modo==1)
				{
					lab.JogadaParado('w');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
						
				}
				if (lab.modo==2)
				{
					lab.JogadaMovimento('w');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
				if (lab.modo==3)
				{
					lab.JogadaDormir('w');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
			}
		});
		btnNewButton_8.setBounds(495, 218, 101, 23);
		frmAmazeing.getContentPane().add(btnNewButton_8);
		
	    btnNewButton_7 = new JButton("DOWN");
		btnNewButton_7.setEnabled(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lab.modo==1)
				{
					lab.JogadaParado('s');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
						
				}
				if (lab.modo==2)
				{
					lab.JogadaMovimento('s');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
				if (lab.modo==3)
				{
					lab.JogadaDormir('s');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
			}
		});
		btnNewButton_7.setBounds(495, 280, 101, 23);
		frmAmazeing.getContentPane().add(btnNewButton_7);
		
		btnNewButton_6 = new JButton("RIGHT");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lab.modo==1)
				{
					lab.JogadaParado('d');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
						
				}
				if (lab.modo==2)
				{
					lab.JogadaMovimento('d');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
				if (lab.modo==3)
				{
					lab.JogadaDormir('d');
					textArea.setText(lab.lab.mazeToString());
					if(lab.cli.ganhaste==1)
					{
						textArea.setText("YOU WIN");
						Descricao.setText("Parabens!!!");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
					if (lab.lab.gameover==true)
					{
						textArea.setText("YOU LOSE");
						Descricao.setText("Perdeu");
						btnNewButton_9.setEnabled(false);
						btnNewButton_8.setEnabled(false);
						btnNewButton_7.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
			}
		});
		btnNewButton_6.setBounds(595, 247, 89, 23);
		frmAmazeing.getContentPane().add(btnNewButton_6);
		btnNewButton_9.setBounds(408, 247, 89, 23);
		frmAmazeing.getContentPane().add(btnNewButton_9);
		
		Ndrakes = new JTextField();
		Ndrakes.setText("2");
		Ndrakes.setBounds(192, 58, 86, 20);
		frmAmazeing.getContentPane().add(Ndrakes);
		Ndrakes.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Modo de Jogo");
		lblNewLabel.setBounds(28, 86, 135, 14);
		frmAmazeing.getContentPane().add(lblNewLabel);
		
		JButton btnCreate = new JButton("Create Game");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Labirinto labirinto = new Labirinto();
				int possdrakes = Integer.parseUnsignedInt(Ndrakes.getText());
				int tempDimentionsx = Integer.parseUnsignedInt(Dimentionx.getText());
				int tempDimentionsy = Integer.parseUnsignedInt(Dimentiony.getText());
				
				frmCreate = new JFrame();
				frmCreate.setTitle("Graphics Demo");
				frmCreate.setBounds(100, 100, 1000, 1000);
				frmCreate.setPreferredSize(new Dimension(1000, 1000));
				frmCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MazeCreator panel2 = new MazeCreator(tempDimentionsx,tempDimentionsy, possdrakes);

				frmCreate.getContentPane().add(panel2);
				if(ModoDeJogo.getSelectedItem()=="Dragao Dorminhoco")
					
				{
					panel2.labirinto.modo=3;
				}
				if(ModoDeJogo.getSelectedItem()=="Dragao Agitado")
				{
					panel2.labirinto.modo=2;
				}
				if(ModoDeJogo.getSelectedItem()=="Dragao Parado")
				{
					panel2.labirinto.modo=1;
				}
			
				frmCreate.pack();
				
				frmCreate.setVisible(true);
				panel2.requestFocus();
			}
			
		});
				
		btnCreate.setBounds(425, 119, 246, 48);
		frmAmazeing.getContentPane().add(btnCreate);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Labirinto labirinto = new Labirinto();
				int tempNdrakes = Integer.parseUnsignedInt(Ndrakes.getText());
				labirinto.ndrakes= tempNdrakes;
				int tempDimentionsx = Integer.parseUnsignedInt(Dimentionx.getText());
				int tempDimentionsy = Integer.parseUnsignedInt(Dimentiony.getText());
				labirinto.sizex=tempDimentionsx;
				labirinto.sizey=tempDimentionsy;
				if(tempDimentionsx%2==0||tempDimentionsx<=4||tempDimentionsy%2==0||tempDimentionsy<=4 || tempNdrakes<=0|| tempNdrakes >(tempDimentionsx/3) )
				{
					if(tempDimentionsx%2==0||tempDimentionsx<=4)
					{
					Descricao.setText("Escolha uma dimencao X adequada (inteiro impar [5;27])");
					}
					else if(tempDimentionsy%2==0||tempDimentionsy<=4)
					{
					Descricao.setText("Escolha uma dimencao y adequada (inteiro impar [5;15])");
					}
					else if(tempNdrakes<=0 || tempNdrakes >(tempDimentionsx/3))
					{
						Descricao.setText("Numero de Dragoes nao permitido");
					}
					/*if((tempDimentions%2==0||tempDimentions<=0) && ( tempNdrakes<=0 || tempNdrakes >(tempDimentions/3)))
					{
						Descricao.setText("Ambos os campos nao permitidos");
					}*/
				}
				else{
				if(ModoDeJogo.getSelectedItem()=="Dragao Dorminhoco")
				
				{
					labirinto.modo=3;
				}
				if(ModoDeJogo.getSelectedItem()=="Dragao Agitado")
				{
					labirinto.modo=2;
				}
				if(ModoDeJogo.getSelectedItem()=="Dragao Parado")
				{
					labirinto.modo=1;
				}
				labirinto.inicialize();
				lab=labirinto;
				created=true;
				frmGraphicsDemo = new JFrame();
				frmGraphicsDemo.setTitle("Graphics Demo");
				frmGraphicsDemo.setBounds(100, 100,lab.sizex*50+15, lab.sizey*50+30);
				frmGraphicsDemo.setPreferredSize(new Dimension(450, 300));
				frmGraphicsDemo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				panel = new GraphicsDemoPanel();
				panel.labirinto=lab;
				frmGraphicsDemo.getContentPane().add(panel);
				
				//frmGraphicsDemo.pack();
				
				frmGraphicsDemo.setVisible(true);
				
				panel.requestFocus();
				btnNewButton_9.setEnabled(true);
				btnNewButton_8.setEnabled(true);
				btnNewButton_7.setEnabled(true);
				btnNewButton_6.setEnabled(true);
				textArea.setText(lab.lab.mazeToString());
				Descricao.setText("Sua vez de Jogar!");
				}
		}
				
				
		})
		;
		btnNewButton.setBounds(425, 19, 246, 48);
		frmAmazeing.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(425, 69, 246, 48);
		frmAmazeing.getContentPane().add(btnNewButton_1);
		
		Dimentiony = new JTextField();
		Dimentiony.setText("11");
		Dimentiony.setBounds(280, 33, 26, 20);
		frmAmazeing.getContentPane().add(Dimentiony);
		Dimentiony.setColumns(10);
		
		JLabel lblX = new JLabel("x:");
		lblX.setBounds(184, 36, 15, 14);
		frmAmazeing.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("y:");
		lblY.setBounds(263, 36, 15, 14);
		frmAmazeing.getContentPane().add(lblY);
	


	}
}
