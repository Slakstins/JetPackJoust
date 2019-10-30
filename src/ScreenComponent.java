import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent {
	private int levelNum;
	private HashMap<String, Boolean> keyMap;
	private Level level;

	private boolean levelChange;

	public ScreenComponent() {
		this.levelNum = 1;
		this.levelChange = true;
	}

	public void addLevel() {
		this.levelNum += 1;
		this.levelChange = true;
	}

	public void removeLevel() {
		this.levelNum -= 1;
		this.levelChange = true;
	}

	public int getLevel() {
		return this.levelNum;
	}

	public void setKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;

		if (this.keyMap.get("left") == false) {
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (this.levelChange) {
			this.level = new Level("Level " + this.levelNum, this.levelNum);
			this.level.setKeyMap(keyMap);
			this.level.readLevelFile();
			this.levelChange = false;
		}
		this.level.drawEverything(g2);
	}

	public void updateDraw() {

		this.repaint();
	}

}
