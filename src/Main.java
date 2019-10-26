import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start
 * by running main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author Buffalo
 *
 */
public class Main {
	


	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Testing Arcade Game");
		
		Screen testScreen = new Level("Level 0", 0);
		LevelGenerator levelGenerator = new LevelGenerator();
		

		
		
		levelGenerator.createLevel1Script();
		Level level1 = new Level("Title", 1);
		
		
		
		
		testScreen.main(args);
		
		
	}

}
