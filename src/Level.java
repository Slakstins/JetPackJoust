import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Level extends Screen {

	private ArrayList<Mob> mobsToDraw;
	private ArrayList<Tile> tilesToDraw;
	private ArrayList<Tile> solidTiles;
	private int levelNum;
	public final int cellWidthHeight = 100;
	public final int xCells = 19;
	public final int yCells = 10;
	private final int bulletBoundKill = 10;
	private Hero hero;
	private Hero hero2;
	private HashMap<String, Boolean> keyMap;
	private ArrayList<Bullet> bullets;

	public Level(String title, int levelNum) {
		super(title);
		this.levelNum = levelNum;
		mobsToDraw = new ArrayList<Mob>();
		tilesToDraw = new ArrayList<Tile>();
		solidTiles = new ArrayList<Tile>();
		bullets = new ArrayList<Bullet>();

	}

	public int getLevelNum() {
		return this.levelNum;
	}

	public void setKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}

	public void readLevelFile() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("level" + levelNum + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		int posY = 0;

		// add bakground tiles before others

		// add background tiles before others
		for (int i = 0; i < this.xCells; i++) {
			for (int j = 0; j < this.yCells; j++) {
				Tile backgroundTile = new Air(i * this.cellWidthHeight, j * this.cellWidthHeight, this.cellWidthHeight,
						this.cellWidthHeight);
				this.tilesToDraw.add(backgroundTile);
			}
		}

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char toBuild = line.charAt(i);
				if (toBuild == 'H' || toBuild == 'D' || toBuild == 'R' || toBuild == 'P' || toBuild == 'M'
						|| toBuild == 'J' || toBuild == 'C') {

					if (toBuild == 'H') {

						Hero newMob = new Hero(i * this.cellWidthHeight, posY * this.cellWidthHeight);
						newMob.setKeyMap(this.keyMap);
						this.hero = newMob;
						getMobsToDraw().add(newMob);

					}
					if (toBuild == 'D') { // MAY NOT HAVE ACCESS TO HERO YET BECAUSE ITS SET AFTER

						Diver newMob = new Diver(i * this.cellWidthHeight, posY * this.cellWidthHeight);

						getMobsToDraw().add(newMob);

					}
					if (toBuild == 'J') { // MAY NOT HAVE ACCESS TO HERO YET BECAUSE ITS SET AFTER

						Jumper newMob = new Jumper(i * this.cellWidthHeight, posY * this.cellWidthHeight);

						getMobsToDraw().add(newMob);

					}

					if (toBuild == 'R') {
						Ranger newMob = new Ranger(i * this.cellWidthHeight, posY * this.cellWidthHeight);
						getMobsToDraw().add(newMob);
					}

					if (toBuild == 'P') {
						Teleporter newMob = new Teleporter(i * this.cellWidthHeight, posY * this.cellWidthHeight);

						getMobsToDraw().add(newMob);
					}

					if (toBuild == 'M') {
						Multiplier newMob = new Multiplier(i * this.cellWidthHeight, posY * this.cellWidthHeight);

						getMobsToDraw().add(newMob);
					}
					if (toBuild == 'C') {
						Chicken newMob = new Chicken(i * this.cellWidthHeight, posY * this.cellWidthHeight);

						getMobsToDraw().add(newMob);
					}

				}

				if (toBuild == 'T' || toBuild == 'E') {
					Tile newTile;
					if (toBuild == 'T') {
						newTile = new Tile(i * this.cellWidthHeight, posY * this.cellWidthHeight, this.cellWidthHeight,
								this.cellWidthHeight, "Tile.png");

						this.tilesToDraw.add(newTile);
						this.solidTiles.add(newTile);
					}

				}

				// i gives posX
				// posY gives y value(0 at top of page)
			}

			posY++;

		}
		scanner.close();

	}

	/**
	 * checks for collisions between a mob and a tile
	 * 
	 * @param mob
	 * @param tile
	 * @return
	 */
	private void setMobsHero() {
		for (int i = 0; i < this.getMobsToDraw().size(); i++) {
			this.getMobsToDraw().get(i).setHero(this.hero);
		}

	}

	/**
	 * Check for a collision between a mob and a solid tile
	 * 
	 * @param mob
	 * @param tile
	 * @return
	 */
	private boolean collision(Mob mob, Tile tile) {
		return mob.getBounds().intersects(tile.getBounds());
	}

	/**
	 * check for a collision between two mobs
	 * 
	 * @param mob1
	 * @param mob2
	 * @return
	 */
	private boolean mobCollision(Mob mob1, Mob mob2) {
		return mob1.getBounds().intersects(mob2.getBounds());
	}

	/**
	 * should switch to the game over screen
	 */

	public boolean checkHeroDead() {
		if (this.hero != null) {
			return this.hero.getHasDied();
		}
		return false;
	}

	public void drawEverything(Graphics2D g2) {

		this.setMobsHero();
		this.checkKillMobCollision();

		// draw background and solids
		for (int i = 0; i < this.tilesToDraw.size(); i++) {
			ImageObserver observer = null; // is this a problem????
			Tile thisTile = this.tilesToDraw.get(i);
			g2.drawImage(thisTile.getImage(), thisTile.getX(), thisTile.getY(), thisTile.getX() + this.cellWidthHeight,
					thisTile.getY() + this.cellWidthHeight, 0, 0, thisTile.getImage().getWidth(observer),
					thisTile.getImage().getHeight(observer), observer);
		}
		// draw mobs
		for (int i = 0; i < this.getMobsToDraw().size(); i++) {
			ImageObserver observer = null; // is this a problem????
			Mob thisMob = this.getMobsToDraw().get(i);
			thisMob.updateGrounded(solidTiles);

			// create a bullet if the mob var isShooting is true
			this.spawnBullets(thisMob);

			for (int j = 0; j < this.solidTiles.size(); j++) {
				Tile thisTile = solidTiles.get(j);
				if (collision(thisMob, thisTile) && bullets.contains(thisMob)) {
					this.killBullets(thisMob);
				}
				if (collision(thisMob, thisTile)) {
					thisMob.tileCollision(thisTile);

				}
			}

			g2.drawImage(thisMob.getImage(), (int) thisMob.getX(), (int) thisMob.getY(),
					(int) thisMob.getX() + this.cellWidthHeight, (int) (thisMob.getY() + this.cellWidthHeight), 0, 0,
					thisMob.getImage().getWidth(observer), thisMob.getImage().getHeight(observer), observer);

			thisMob.updateMovement();
			if (thisMob.checkDuplicate() > 0) {
				if (thisMob.checkDuplicate() == 1) {
					Multiplier multiplier = new Multiplier(thisMob.getX(), thisMob.getY());
					this.mobsToDraw.add(multiplier);
				}
				if (thisMob.checkDuplicate() == 2) {
					Chicken mobAsChicken = (Chicken)thisMob;
					for (int y = 1; y < mobAsChicken.getEggsDropped(); y++ ) {
						System.out.println(this.mobsToDraw.size());
						Chicken chicken = new Chicken(thisMob.getX(), thisMob.getY());
						chicken.turnIntoEgg();
						chicken.setInvincible(true, 50);

						this.mobsToDraw.add(chicken);
						
						chicken.setHero(this.hero);
						thisMob.setDuplicate(-1);
						
					}
					
				}
			
			}

		}
		this.checkKillBulletBounds();

		// MasterList SOMEWHERE! for letters
		// H is = Hero

	}

	/*
	 * checks if a given mob is shooting, then spawns bullets as appropriate
	 */
	public void spawnBullets(Mob thisMob) {
		if (thisMob.getShooting()) {
			double[] dir = thisMob.shootDirection();
			Bullet bullet = new Bullet((int) thisMob.getX(), (int) thisMob.getY(), dir[0], dir[1], this.hero);
			getMobsToDraw().add(bullet);
			bullets.add(bullet);

		}

	}

	/**
	 * check to see which mobs are touching to see if they die Why is there a delay
	 * in deleting Mobs?
	 */
	public void checkKillMobCollision() {
		ArrayList<Mob> mobsToDelete = new ArrayList<Mob>();
		for (int i = 0; i < this.getMobsToDraw().size(); i++) {
			Mob thisMob = this.getMobsToDraw().get(i);
			if (this.mobCollision(thisMob, this.hero) && !thisMob.equals(hero)) {

				mobsToDelete.add(thisMob);
				// IMPLEMENT
				thisMob.collidedWithHero();

			}
		}
		this.killDeadMobs();

	}

	/**
	 * Kill bullets that are too close to the sides or top bottoms of the screen
	 */
	public void checkKillBulletBounds() {
		for (int i = 0; i < this.bullets.size(); i++) {
			Bullet thisBullet = bullets.get(i);
			if ((thisBullet.getX() + this.cellWidthHeight > (this.xCells * this.cellWidthHeight - this.bulletBoundKill))
					|| (thisBullet.getX() < 0 + this.bulletBoundKill) || (thisBullet.getY()
							+ this.cellWidthHeight > this.yCells * this.cellWidthHeight - this.bulletBoundKill)
					|| (thisBullet.getY() < 0 + this.bulletBoundKill)) {
				this.killBullets(thisBullet);
			}
		}
	}

	/**
	 * Handles actions having to do with the death of mobs, removing them if hasDied
	 * is true
	 */
	public void killDeadMobs() {
		ArrayList<Mob> mobsToDelete = new ArrayList<Mob>();
		for (int i = 0; i < this.getMobsToDraw().size(); i++) {
			if (this.getMobsToDraw().get(i).getHasDied()) {
				mobsToDelete.add(this.getMobsToDraw().get(i));
			}
		}
		for (int i = 0; i < mobsToDelete.size(); i++) {

			for (int j = 0; j < this.getMobsToDraw().size(); j++) { // bullets have to be deleted in two places
				if (this.bullets.contains(mobsToDelete.get(i)) && this.getMobsToDraw().contains(mobsToDelete.get(i))) {
//					mobsToDelete.get(i).kill(); // NOT IMPLEMENTED YET
				}
				if (mobsToDelete.get(i).equals(getMobsToDraw().get(j))) {
					this.getMobsToDraw().get(j).kill(); // nested in case kill changes into an egg which has another
														// life
					if (mobsToDelete.get(i).getHasDied()) {
						this.getMobsToDraw().remove(j);
						System.out.println("Mob deleted");
					}

				}
			}
		}
	}

	/**
	 * Remove the specified bullet from existence since it exists in bullets as well
	 * as mobsToDraw
	 * 
	 * @param thisMob
	 */
	public void killBullets(Mob thisMob) {
		this.bullets.remove(thisMob);
		this.getMobsToDraw().remove(thisMob);
	}

	public ArrayList<Mob> getMobsToDraw() {
		return mobsToDraw;
	}
}
