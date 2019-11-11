import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ScreenComponent extends JComponent {
	private int levelNum;
	private HashMap<String, Boolean> keyMap;
	private Level level;
	private int lives = 3;

	private boolean levelChange;

	public ScreenComponent() {
		this.levelNum = 0;
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
	
	public int getLives() {
		return this.lives;
	}
	
	public void goUpALevelIfMonstersDead() {
		if (this.level.getMobsToDraw().size() < 2 && !this.level.checkHeroDead()) {
			this.addLevel();
		}
	}
	
	public void checkHeroDeath() {
		if (this.level.checkHeroDead()) {
			this.levelChange = true;
			this.lives -= 1;
		}
		if (this.lives < 0) {
			this.gameOver();
		}
	}
	public void gameOver() {
		this.levelChange = true;
		this.levelNum = -1; // freezes game because lives is still < 0
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		JLabel lives = new JLabel();

		if (this.levelChange) {
			this.level = new Level("Level " + this.levelNum, this.levelNum);
			this.level.setKeyMap(keyMap);
			this.level.readLevelFile();
			this.levelChange = false;
		}
		
		if (this.levelNum != 0) {
			this.level.drawEverything(g2);
			Font font = new Font("Verdana", Font.BOLD, 25);
			g2.setFont(font);
			g2.drawString("Lives: " + this.lives , 5, 30);
			g2.drawString("Level: " + this.levelNum, 5, 80);
			this.goUpALevelIfMonstersDead();
			this.checkHeroDeath();
		} else {
			Image startScreen = null;
			try {
				startScreen = ImageIO.read(new File("startScreen.png"));
			} catch (IOException e) {
				System.out.println("Start Screen image not found ");
			}
			g2.drawImage(startScreen, 0, 0, 1900, 1000, 0, 0, 1900, 1000, null);
			if (this.keyMap.get("space"))
				this.addLevel();
		}
		
	}

	public void updateDraw() {

		this.repaint();
	}

}
