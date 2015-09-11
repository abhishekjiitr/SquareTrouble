package Main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Splash extends JFrame
{
	ImageIcon X;
	JLabel label;
	Splash()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());		JPanel pnl = new JPanel();
		Image bg = Toolkit.getDefaultToolkit().createImage("/tic.jpg");
		X=new ImageIcon(Main.class.getResource("/tic.jpg"));
		Image img = X.getImage();
		Image newimg = img.getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), java.awt.Image.SCALE_SMOOTH);
		X = new ImageIcon(newimg);
		label = new JLabel(X);
		add(label);
		label.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());	

	}
}
