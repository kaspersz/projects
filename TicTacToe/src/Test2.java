import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;

public class Test2 extends JFrame{
	private Container pane;
	private String currentPlayer;
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	
	public Test2(){
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("Tic Tac Toe");
		setSize(500,500);
		
		
		
		
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer= "x";
		board = new JButton [3][3];
		hasWinner = false;
		
	}
}
