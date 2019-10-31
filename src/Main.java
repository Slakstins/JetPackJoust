import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
	private final static int REFRESHES = 10; // should be 10
	private final static int FRAME_HEIGHT = 1000;
	private final static int FRAME_WIDTH = 1000;

	public Main() {
		
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
		

		
		KeyInput input = new KeyInput();
		
		
		frame.addKeyListener(input);
		
		

		frame.setSize(frameWidth2, frameHeight2);
		ScreenComponent component = new ScreenComponent();
		frame.add(component);
		component.setKeyMap(input.getKeyMap());
	
		
		GameAdvanceListener advanceListener = new GameAdvanceListener(component);	
		Timer timer = new Timer(REFRESHES, advanceListener);
		timer.start();
	
		
		input.setScreenComponent(component);
		frame.setTitle("Level " + component.getLevel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		frame.setVisible(true);
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
		
		
		
		
		
//		initialScreen.main(args);
		
		
	}

}
