import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Screen {

	private String title;

	public abstract void drawEverything(Graphics2D g2);

	private HashMap<String, Boolean> keyMap;

	public Screen(String title) {
		this.title = title;
	}


	public void giveKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}

	public HashMap<String, Boolean> getKeyMap() {
		return this.keyMap;
	}

}
