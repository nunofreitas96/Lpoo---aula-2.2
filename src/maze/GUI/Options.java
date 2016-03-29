package maze.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import maze.logic.Labirinto;
import maze.logic.LabirintoDraw;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Options {

	private JFrame frame;
	private JTextField Ndrakes;
	private JTextField Dimention;
	private JButton btnNewButton;
	private JLabel lblModoDeJogo;
	private JComboBox ModoDeJogo;

	/**
	 * Launch the application.
	 */
	public static void options() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options window = new Options();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Options() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumeroDeDragoes = new JLabel("Numero de Dragoes:");
		lblNumeroDeDragoes.setBounds(40, 61, 132, 14);
		frame.getContentPane().add(lblNumeroDeDragoes);
		
		JLabel lblDimensoDoLabirinto = new JLabel("Dimens\u00E3o do Labirinto:");
		lblDimensoDoLabirinto.setBounds(40, 86, 167, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);
		
		Ndrakes = new JTextField();
		Ndrakes.setText("2");
		Ndrakes.setBounds(217, 58, 86, 20);
		frame.getContentPane().add(Ndrakes);
		Ndrakes.setColumns(10);
		
		ModoDeJogo = new JComboBox();
		ModoDeJogo.setModel(new DefaultComboBoxModel(new String[] {"Dragao Parado", "Dragao Agitado", "Dragao Dorminhoco"}));
		ModoDeJogo.setBounds(217, 114, 132, 20);
		frame.getContentPane().add(ModoDeJogo);
		//int tempNdrakes = Integer.parseUnsignedInt(Ndrakes.getText());
		//Labirinto.ndrakes= tempNdrakes;
		
		Dimention = new JTextField();
		Dimention.setText("11");
		Dimention.setBounds(217, 83, 86, 20);
		frame.getContentPane().add(Dimention);
		Dimention.setColumns(10);
		
		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempNdrakes = Integer.parseUnsignedInt(Ndrakes.getText());
				Labirinto.ndrakes= tempNdrakes;
				int tempDimentions = Integer.parseUnsignedInt(Dimention.getText());
				Labirinto.sizex=tempDimentions;
				Labirinto.sizey=tempDimentions;
				if(ModoDeJogo.getSelectedItem()=="Dragao Dorminhoco")
				{Labirinto.modo=3;}
				if(ModoDeJogo.getSelectedItem()=="Dragao Agitado")
				{Labirinto.modo=2;}
				if(ModoDeJogo.getSelectedItem()=="Dragao Parado")
				{Labirinto.modo=1;}
			}
		});
		btnNewButton.setBounds(179, 173, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblModoDeJogo = new JLabel("Modo de Jogo");
		lblModoDeJogo.setBounds(40, 111, 113, 14);
		frame.getContentPane().add(lblModoDeJogo);
	}
}
