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
import javax.swing.Box;
public class InterfaceGraf {

	private JFrame frmAmazeing;

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
		frmAmazeing.setTitle("aMAZEing");
		frmAmazeing.setBounds(100, 100, 500, 450 );
		frmAmazeing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmazeing.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Labirinto lab = new Labirinto();
				lab.quasemain();
			}
		});
		btnNewGame.setBounds(132, 100, 216, 78);
		frmAmazeing.getContentPane().add(btnNewGame);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options opcoes = new Options();
				opcoes.options();
			}
		});
		btnOptions.setBounds(165, 266, 150, 65);
		frmAmazeing.getContentPane().add(btnOptions);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(165, 189, 150, 65);
		frmAmazeing.getContentPane().add(btnExit);
	}
}
