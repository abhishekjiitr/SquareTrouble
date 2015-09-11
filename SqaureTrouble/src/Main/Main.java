package Main;

import java.io.IOException;

public class Main 
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		Splash sp = new Splash();
		Thread.sleep(3000);
		StartScreen startScreen = new StartScreen();
		sp.dispose();	
		
		//PlayerInfo pInfo = new PlayerInfo();
		//Game gm = new Game();
	}
}
