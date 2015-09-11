package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

class nJButton extends JButton
	{
	private static final long serialVersionUID = 1L;

		nJButton(){
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
		}
	}
public class StartScreen extends JFrame implements ActionListener,WindowListener,ItemSelectable, ListDataListener, Accessible
	{
		ImageIcon X;
		JLabel label;
		JButton start, exit;
		Connection con;
		StartScreen()
		{
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			System.out.println(con);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//MAIN PANEL
			JPanel pnl = new JPanel();
			setLayout(null);
			add(pnl);
			pnl.setLayout(null);
		    setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());	
			pnl.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());	
			// Main Label
			//Image bg = Toolkit.getDefaultToolkit().createImage("/ti.jpg");
			X=new ImageIcon(Main.class.getResource("/game_bg.jpg"));
			Image img = X.getImage();
			Image newimg = img.getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), java.awt.Image.SCALE_SMOOTH);
			X = new ImageIcon(newimg);
			label = new JLabel(X);
			
			label.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());	
			//MAIN WINDOW
			setUndecorated(true);
			// Comment it finally 
			//getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		    setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		    System.out.println(dim.getHeight());
			setVisible(true);
			this.setTitle("Square Trouble");
			this.setBackground(Color.BLACK);
		    //Lprizes.setContentAreaFilled(false);
		    //Lprizes.setBorderPainted(false);
			
			//Main Panel
			//JPanel Main = new JPanel();
			//Main.setBackground(Color.getHSBColor( 94, 72, 1));
			//pnl.add(Main);
			//Main.setLayout(null);
			//Main.setBounds(400, 50, 500, 500);
			//UPPER HALF
			Font fon = new Font("Courier New", Font.ITALIC, 16);
			//l1.setFont(fon);
			//l1.setBounds(30, 50, 250, 30);
			// Buttons
			// Start Button
			
			start = new JButton(new ImageIcon((new ImageIcon(Main.class.getResource("/start.png"))).getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH)));
			pnl.add(start);
			start.setBounds(500, 90, 300, 200);
			// Action
			start.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Start");
					PlayerInfo pInfo = new PlayerInfo();
					dispose();
				}
			});
			//Exit Button
			exit = new JButton(new ImageIcon((new ImageIcon(Main.class.getResource("/exit.png"))).getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH)));
			pnl.add(exit);
			exit.setBounds(500, 310, 300, 200);
			exit.setBorderPainted(false);
			exit.setContentAreaFilled(false);
			//exit.setFocusPainted(false);
			exit.setOpaque(false);
			// Action
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
					dispose();
				}
			});
			pnl.add(label);
			start.setVisible(true);
			exit.setVisible(true);
			//start.paintAll(Graphics.class);
			exit.repaint();
			//Main.add(pos);
		}
		public void actionPerformed(ActionEvent arg0) {}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			this.dispose();
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			this.dispose();
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			this.dispose();
		}

		@Override
		public void contentsChanged(ListDataEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void intervalAdded(ListDataEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void intervalRemoved(ListDataEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addItemListener(ItemListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object[] getSelectedObjects() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void removeItemListener(ItemListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
