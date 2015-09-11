package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;
public class Game  {
	static int clicksLeft = 9;
	public static int player = 0;
	JPanel pnl = new JPanel();
	JPanel pnl2 = new JPanel();
	static JLabel turn = new JLabel();
	XOButton buttons[]=new XOButton[9];
	static XOButton Bgrid[][];
	Game() {
		if ( PlayerInfo.p1name == "" )
		{
			PlayerInfo.p1name = "Player 1";
		}
		if ( PlayerInfo.p2name == "" )
		{
			PlayerInfo.p2name = "Player 2";
		}
		Font fon = new Font("Courier New", Font.ITALIC, 35);
		Game.turn.setText(PlayerInfo.p1name + "'s Turn");
		Bgrid = new XOButton[3][3]; 
		// FRAME
		// the frame that contains the components
		JFrame frame = new JFrame("SQUARE TROUBLE");
		frame.add(pnl2);
		pnl2.setBounds(900, 100, 400, 400);
		//pnl2.setBackground(Color.BLUE);
		pnl2.add(turn);
		pnl2.setLayout(null);
		turn.setFont(fon);
		turn.setBounds(50, 100, 400, 100);
		//frame.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setUndecorated(true);
	    frame.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // set the size of the frame
	    GridLayout grid = new GridLayout(3, 3);
	    frame.setLayout(null);
	   // frame.add(new XOButton());
	    frame.add(pnl);
	    pnl.setLayout(grid);
	    pnl.setBounds(450, 100, 400, 400);
	    for( int i = 0 ; i < 3 ; i++ )
	    {
	    	for ( int j = 0 ; j < 3 ; j++ )
	    	{
	    		Bgrid[i][j] = new XOButton(i, j);
	    		pnl.add(Bgrid[i][j]);
	    		
	    	}
	    }
	    frame.setVisible(true);
	    JPanel pnl2=new JPanel();
	    pnl2.setBounds(800,800,60,60);
	    pnl2.setVisible(true);
	    JButton start = new JButton("Restart");
		pnl2.add(start);
		start.setBounds(500, 90, 300, 200);
		// Action
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Restart");
				new Game();
			}
		});
	}
}
class XOButton extends JButton implements ActionListener{
	public int flag = 0, x, y;
	ImageIcon X,O;
	Image xImg, oImg;
	byte value=0;
	public XOButton(ImageIcon ico) {
		super(ico);
		//X=new ImageIcon(this.getClass());
		//O=new ImageIcon(this.getClass());
		this.addActionListener(this);
	}
	public XOButton(int i, int j) {
		setFocusPainted(false);
		x = i;
		y = j;
		X=new ImageIcon(Main.class.getResource("/X.png"));
		Image img = X.getImage();
		Image newimg = img.getScaledInstance(100,  100, java.awt.Image.SCALE_SMOOTH);
		xImg = newimg;
		X = new ImageIcon(newimg);
		O=new ImageIcon(Main.class.getResource("/O.png"));
		Image img2 = O.getImage();
		Image newimg2 = img2.getScaledInstance(100,  100, java.awt.Image.SCALE_SMOOTH);
		oImg = newimg2;
		O = new ImageIcon(newimg2);
		this.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a) {
		XOButton[][] Bgrid = Game.Bgrid;
		String name;
		if ( Game.player % 2 == 1 )
		{
			name = PlayerInfo.p1name;
		}
		else
		{
			name = PlayerInfo.p2name;
		}
		String text = name + "'s Turn";
		Game.turn.setText(text);
		if ( flag == 0 )
			{
				setImg(Game.player);
				if ( y - 1 >= 0 )
				{
					Bgrid[x][y-1].setImg(Game.player);
				}
				if ( x - 1 >= 0 )
				{
					Bgrid[x-1][y].setImg(Game.player);
				}
				if ( y + 1 < 3 )
				{
					Bgrid[x][y+1].setImg(Game.player);
				}
				if ( x + 1 < 3 )
				{
					Bgrid[x+1][y].setImg(Game.player);
				}
				if ( Game.clicksLeft <= 0 )
				{
					String winner;
					if ( Game.player == 0 )
					{
						winner = PlayerInfo.p1name;
					}
					else
					{
						winner = PlayerInfo.p2name;
					}
					System.out.println( winner +" wins!! ");
					JOptionPane.showMessageDialog(null,winner +" wins!! ","TITLE",JOptionPane.WARNING_MESSAGE);
					System.exit(1);
				}
				Game.player = (Game.player+1) % 2;
			}
	}
	public void setImg(int x)
	{
		if ( flag == 0 )
		{
			if ( x == 0 )
				setIcon(X);
			else
				setIcon(O);
			flag = 1;
			Game.clicksLeft--;
		}
	}
}
