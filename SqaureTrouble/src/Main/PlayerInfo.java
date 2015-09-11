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

public class PlayerInfo extends JFrame implements ActionListener,WindowListener,ItemSelectable, ListDataListener, Accessible
{
	ImageIcon X;
	JLabel label;
	JButton start, exit;
	Connection con;
	JLabel p1L, p2L;
	JTextField p1T, p2T;
	JButton play;
	static String p1name="Player 1", p2name="Player 2";
	PlayerInfo()
	{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(con);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MAIN PANEL
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		//pnl.setLayout(null);
		pnl.setBounds(0, 0, 1366, 768);
		// Main Label
		//Image bg = Toolkit.getDefaultToolkit().createImage("/ti.jpg");
		
		label = new JLabel(new ImageIcon((new ImageIcon(Main.class.getResource("/game_bg.jpg"))).getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		
		label.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());	
		//MAIN WINDOW
		setUndecorated(true);
		// Comment it finally 
		//getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
	    setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
	    System.out.println(dim.getHeight());
		setVisible(true);
		this.setTitle("Square Trouble");
		//this.setBackground(Color.BLACK);
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
		JLabel p1L = new JLabel("Player 1 Name");
		pnl.add(p1L);
		p1L.setBounds(100, 100, 100, 30);
		// Text-Field
		JTextField p1T = new JTextField();
		pnl.add(p1T);
		p1T.setBounds(250, 100, 300, 30);
		//Player 2
		//Label
		JLabel p2L = new JLabel("Player 2 Name");
		pnl.add(p2L);
		p2L.setBounds(100, 200, 100, 30);
		// Text Field
		JTextField p2T = new JTextField();
		pnl.add(p2T);
		p2T.setBounds(250, 200, 300, 30);
		// Play Button
		JButton play = new JButton(new ImageIcon((new ImageIcon(Main.class.getResource("/play.png"))).getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));	
		play.setOpaque(false);
		pnl.add(play);
		play.setBounds(200, 300, 100, 50);
		// Play Action
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				p1name = p1T.getText();
				p2name= p2T.getText();
				System.out.println("**"+p1name+"**"+p2name+"**");
				if((p1name==null)||(p1name=="")||(p2name==null)||(p2name==""))
				{
					JOptionPane.showMessageDialog(null,"Please enter Valid Credentials","TITLE",JOptionPane.WARNING_MESSAGE);
					System.out.println("EEEE");
				}
				else{
				Game gm = new Game();
				dispose();
				}
			}
		});
		pnl.add(label);
		// Exit button
		exit = new JButton(new ImageIcon((new ImageIcon(Main.class.getResource("/exit.png"))).getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));
		pnl.add(exit);
		exit.setBounds(400, 300, 100, 50);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				StartScreen startScreen = new StartScreen();
			}
		});
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.setOpaque(false);
		exit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        //exit.setBackground(Color.GREEN);
		    }

		});
		//start.paintAll(Graphics.class);
		play.setOpaque(false);

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
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}