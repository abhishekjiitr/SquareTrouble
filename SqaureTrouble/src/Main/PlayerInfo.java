package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.accessibility.Accessible;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class PlayerInfo extends JFrame 
{
	JLabel p1L, p2L;
	JTextField p1T, p2T;
	JButton play;
	PlayerInfo()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		System.out.println("Started Player info");
		// Main JFRAME
		setVisible(true);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		JPanel pnl = new JPanel();
		setLayout(null);
		add(pnl);
		pnl.setBounds(100, 100, 700, 400);
		pnl.setBackground(Color.gray);
		this.setTitle("Square Trouble : Player Info");
		this.setBackground(Color.RED);
		//Player 1
		// Label
		p1L = new JLabel("Player 1 Name");
		pnl.add(p1L);
		p1L.setBounds(100, 100, 100, 100);
		// Text-Field
		p1T = new JTextField("Enter your name here...");
		pnl.add(p1T);
		p1T.setBounds(150, 100, 300, 70);
		//Player 2
		//Label
		p2L = new JLabel("Player 2 Name");
		pnl.add(p2L);
		p2L.setBounds(100, 204, 100, 100);
		// Text Field
		p2T = new JTextField("Enter your name here...");
		pnl.add(p2T);
		p2T.setBounds(150, 200, 300, 70);
		// Play Button
		play = new JButton("PLAY!");
		pnl.add(play);
		play.setBounds(200, 300, 100, 50);
		// Play Action
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Game gm = new Game();
			}
		});
	}
}
