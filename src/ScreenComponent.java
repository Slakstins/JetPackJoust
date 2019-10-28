import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent {
	private int levelNum;
	private HashMap<String, Boolean> keyMap;
	private Level level;
	private int firstTry;
	public ScreenComponent() {
		this.firstTry = 0;
		this.levelNum = 1;
		if (levelNum == 1) {
		level = new Level("Title", 1);
		}
		if (levelNum == 2) {
		level = new Level("Title", 2);
		}
		
		
	}
	public void addLevel() {
		this.levelNum += 1;
	}
	public void removeLevel() {
		this.levelNum -= 1;
	}
	public int getLevel() {
		return this.levelNum;
	}
	public void setKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
		
		if (this.keyMap.get("left") == false) {
			System.out.println("KEY GOT");
		}
	}
//	public HashMap<String, Boolean> setLevelKeyMap(Level level) {
//		return this.keyMap;
//	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Get the 2D graphics object
		Graphics2D g2 = (Graphics2D) g;
		// need a BETTER WAY to access level info for drawing in screen.
		// is there a way to do this without putting level1 in Main and DrawComponent?

		if (levelNum == 0) {
//			Screen level0 = new StartScreen("Title, 0");
		}

		if (levelNum == 1) {
			this.level.setKeyMap(keyMap);
			if (this.firstTry == 0) {
				this.level.readLevelFile();
				this.firstTry++;
			}
			
			
			this.level.drawEverything(g2);

			System.out.println("Level painted!");
			if (keyMap.get("left")) {
				System.out.println("HI");
			}

		}

		if (levelNum == 2) {
			Screen level2 = new Level("Title", 2);
			level2.drawEverything(g2);
			level2.giveKeyMap(this.keyMap);
		}

	}

}
