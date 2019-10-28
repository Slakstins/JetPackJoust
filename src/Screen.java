import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;


public abstract class Screen {
	final private int w = 1000; // screen width
	final private int h = 1000; // screen height
	private String title;
	public abstract void drawEverything(Graphics2D g2);
	private HashMap<String, Boolean> keyMap;
	
	
	public Screen(String title) {
		this.title = title;
	}
	
	
	//questionable way of getting keyMap to Screen to handle input, 
	//but the map has to be added to the
	//JFrame in Main
	public void giveKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}
	public HashMap<String,Boolean> getKeyMap() {
		return this.keyMap;
	}
	
	
	
	
}


