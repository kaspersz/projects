import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Test {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 GUI gui = new GUI();
             }
         });

 }

 }

 class GUI extends JFrame {

 GUI() {
     super("Calculator");
     setBounds(30, 30, 160, 190); // Size
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JTextField jta = new JTextField(20);
     JPanel panel = new JPanel();
     setLayout(new BorderLayout(5, 5));
     Container content = this.getContentPane(); // Get the content pane
     content.add(jta, BorderLayout.NORTH);
     // Now add six button components
     int array[] = {7, 8, 9, 4, 5, 6, 1, 2, 3};
     for (int i = 0; i < 9; i++) {
         panel.add(new JButton("" + array[i])); 

     }
     content.add(panel, BorderLayout.CENTER);
     content.add(new JButton("0"), BorderLayout.SOUTH);
     setVisible(true); // Display the window
 }
 }