package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;
public class Game  {
	static int clicksLeft = 9;
	public static int player = 0;
	JPanel pnl = new JPanel();
	XOButton buttons[]=new XOButton[9];
	static XOButton Bgrid[][];
	Game() {
		
		Bgrid = new XOButton[3][3]; 
		// FRAME
		// the frame that contains the components
		JFrame frame = new JFrame("SQUARE TROUBLE");
		frame.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
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
					JOptionPane.showMessageDialog(null,"FUCK YOU NIGGA"+(Game.player+1) + " Congrats P2(BITCH!)","TITLE",JOptionPane.WARNING_MESSAGE);
					//JOptionPane.showMessageDialog(getComponent(0), "FUCK YOU ");
					System.out.println("Player "+(Game.player+1)+" wins!! Congrats Noobie...");
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
