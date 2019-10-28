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
	private int level;
	private final static int FRAME_HEIGHT = 1000;
	private final static int FRAME_WIDTH = 1000;

	public Main() {
		this.level = 1;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Testing Arcade Game");
		
		LevelGenerator levelGenerator = new LevelGenerator();
		levelGenerator.createLevel1Script();
		levelGenerator.createLevel2Script();
		
		
		
		
		
		//have only a draw component in main?? 
		//Draw component needs access to the stuff to draw it
		//need to find a way to only create the level
		JFrame frame = new JFrame();
		int frameWidth2 = FRAME_WIDTH;
		int frameHeight2 = FRAME_HEIGHT;

		frame.setSize(frameWidth2, frameHeight2);
		ScreenComponent component = new ScreenComponent();
		
		
	
		frame.add(component);
		frame.setTitle("Level " + component.getLevel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		
		frame.setVisible(true);
		
		
		
//		initialScreen.main(args);
		
		
	}

}
