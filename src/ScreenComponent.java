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
	private int lives;
	private int seconds;
	private int comboTimer;
	private int comboMultiplyer;
	private int comboTime = 5;
	private int levelScore;
	private double totalScore;
	private int numOfLives = 1;

	private boolean isPaused = false;

	private boolean levelChange;

	public ScreenComponent() {
		this.lives = this.numOfLives;
		this.comboMultiplyer = 1;
		this.comboTimer = 1;
		this.levelNum = 0;
		this.levelChange = true;
		this.seconds = 0;
		this.totalScore = 0;
	}

	public void addSecond() {
		this.seconds++;
	}

	public boolean getIsPaused() {
		return this.isPaused;
	}

	public void addLevel() {
		this.levelNum += 1;
		this.levelChange = true;
		this.totalScore += this.levelScore;
		this.levelScore = 0;
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
		if (this.level.getMobsToDraw().size() < 2 && !this.level.checkHeroDead() && this.levelNum != 20) {
			this.addLevel();
		}
	}

	public void checkHeroDeath() {
		if (this.level.checkHeroDead()) {
			this.levelChange = true;
			this.lives -= 1;
			this.levelScore = 0;
			this.comboMultiplyer = 1;
			this.comboTimer = 0;
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

		if (this.levelChange) {

			this.level = new Level("Level " + this.levelNum, this.levelNum);
			this.level.setKeyMap(keyMap);
			if (this.levelNum != 0) {
				this.level.readLevelFile();

			}
			this.levelChange = false;
		}

		if (this.levelNum != 0) {
			if (this.levelNum == 20 || this.levelNum == -1) {
				if (this.keyMap.get("space")) {
					this.restartGame();
				}
			}
			this.level.drawEverything(g2);
			Font font = new Font("Verdana", Font.BOLD, 25);
			g2.setFont(font);
			if (this.levelNum > 0) {
				g2.drawString("Lives: " + this.lives, 5, 30);
				g2.drawString("Level: " + this.levelNum, 1745, 30);

				g2.drawString("Time: " + this.seconds, 5, 80);
				if (this.levelNum != 20) {
					g2.drawString("Level score: " + this.levelScore, 5, 150);
				}
			}
			if (this.comboTimer > 0) {
				g2.drawString("Combo multiplier: x" + this.comboMultiplyer, 5, 190);
				g2.drawString("Combo time: " + this.comboTimer, 5, 220);
			}
			g2.drawString("Total score: " + this.totalScore, 5, 120);

			if (this.levelNum == 20) {
				g2.drawString("TOTAL SCORE: " + (int) (1000 * this.totalScore / (this.seconds)), 1500, 400);

			}
			if (this.levelNum == -1 || this.levelNum == 20) {
				g2.drawString("Press space to play again!", 775, 470);

			}

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
		if (this.level != null) {
			if (this.level.getLevelNum() > 0) {
				this.updateCombo();
			}
		}

	}

	public void lowerComboTimer() {
		this.comboTimer -= 1;
	}

	public void updateCombo() {
		if (!(this.level.getMobsToDraw().size() <= 1)) {
			this.updateScore();

		}

		if (this.level.getHeroKill()) {
			if (this.comboMultiplyer < 5) {
				this.comboMultiplyer += 1;
			}
			this.comboTimer = this.comboTime;

		} else {
			if (this.comboTimer < 0) {
				this.comboTimer = 0;
				this.comboMultiplyer = 1;
			}

		}
		this.level.setHeroKillFalse();

	}

	public void restartGame() {
		this.levelNum = 0;
		this.comboTimer = 0;
		this.levelChange = true;
		this.totalScore = 0;
		this.seconds = 0;
		this.lives = this.numOfLives;
	}

	public void updateScore() {
		if (this.level.getHeroKill()) {
			this.levelScore += 1 * this.comboMultiplyer;
		}
	}

	public void updateIsPaused() {
		if (keyMap.get("p") == false) {
			this.isPaused = false;
		} else {
			this.isPaused = true;
		}
	}

	/**
	 * update the state of the game and update isPaused
	 */
	public void updateDraw() {
		if (this.isPaused == false) {
			this.repaint();
		}
	}

}
