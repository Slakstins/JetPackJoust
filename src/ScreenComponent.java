import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent {
	private int levelNum;
	private HashMap<String, Boolean> keyMap;
	private Level level;
	private int firstTry1;
	private int firstTry2;

	public ScreenComponent() {
		this.firstTry1 = 0;
		this.firstTry2 = 0;
		this.levelNum = 1;

	}

	public void addLevel() {
		this.levelNum += 1;
	}

	public void removeLevel() {
		this.levelNum -= 1;
		System.out.println("Level removed");
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
			this.firstTry2 = 0;			
			if (this.firstTry1 == 0) {
				this.level = new Level("Level 1", 1);
				this.level.setKeyMap(keyMap);
				this.level.readLevelFile();
				this.firstTry1++;
			}


			//System.out.println("Level 1 painted!");
		}

		if (levelNum == 2) {
			
			
			if (this.firstTry2 == 0) {
				this.firstTry1 = 0;
				this.level = new Level("Level 2", 2);
				this.level.setKeyMap(keyMap);

				//System.out.println("Level 2 painted!");
				this.level.readLevelFile();
				this.firstTry2++;
			}


		}
		this.level.drawEverything(g2);
		repaint();
	}

}
