import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Level extends Screen {

	ArrayList<Mob> mobsToDraw;
	ArrayList<Tile> tilesToDraw;
	ArrayList<Tile> solidTiles;
	private int levelNum;
	public final int cellWidthHeight = 100;
	public final int xCells = 10;
	public final int yCells = 10;
	private Hero hero;
	private HashMap<String, Boolean> keyMap;
	private ArrayList<Diver> divers;

	public Level(String title, int levelNum) {
		super(title);
		this.levelNum = levelNum;
		mobsToDraw = new ArrayList<Mob>();
		tilesToDraw = new ArrayList<Tile>();
		solidTiles = new ArrayList<Tile>();
		divers = new ArrayList<Diver>();

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
				if (toBuild == 'H' || toBuild == 'D') {

					if (toBuild == 'H') {

						Hero newMob = new Hero(i * this.cellWidthHeight, posY * this.cellWidthHeight);
						newMob.setKeyMap(this.keyMap);
						this.hero = newMob;
						mobsToDraw.add(newMob);

					}
					if (toBuild == 'D') { // MAY NOT HAVE ACCESS TO HERO YET BECAUSE ITS SET AFTER

						Diver newMob = new Diver(i * this.cellWidthHeight, posY * this.cellWidthHeight);
						mobsToDraw.add(newMob);
						divers.add(newMob);

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
					if (toBuild == 'E') {
//						newTile = new Air(i * this.cellWidthHeight, posY * this.cellWidthHeight, this.cellWidthHeight,
//								this.cellWidthHeight);
//						
//						this.tilesToDraw.add(newTile);
						// need to put air behind all other tiles -- put in draw everything
					}

				}

				// i gives posX
				// posY gives y value(0 at top of page)
			}

			posY++;

			// PUT METHOD HERE THAT BUILDS CHARACTERS AND BLOCKS FROM CHAR USING DRAW

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
	private void setDiversHero() {
		for (int i = 0; i < this.divers.size(); i++) {
			this.divers.get(i).setHero(this.hero);
		}
		
	}

	private boolean collision(Mob mob, Tile tile) {
		return mob.getBounds().intersects(tile.getBounds());
	}

	public void drawEverything(Graphics2D g2) {
		this.setDiversHero();

		// draw background and solids
		for (int i = 0; i < this.tilesToDraw.size(); i++) {
			ImageObserver observer = null; // is this a problem????

			Tile thisTile = this.tilesToDraw.get(i);
			g2.drawImage(thisTile.getImage(), thisTile.getX(), thisTile.getY(), thisTile.getX() + this.cellWidthHeight,
					thisTile.getY() + this.cellWidthHeight, 0, 0, thisTile.getImage().getWidth(observer),
					thisTile.getImage().getHeight(observer), observer);

		}

		// draw mobs
		for (int i = 0; i < this.mobsToDraw.size(); i++) {
			ImageObserver observer = null; // is this a problem????
			Mob thisMob = this.mobsToDraw.get(i);
//			double distanceMovedX = Math.abs(thisMob.getXVel());
			double distanceMovedY = (thisMob.getYVel());
			boolean grounded = false;

			for (int j = 0; j < this.solidTiles.size(); j++) {
				Tile thisTile = solidTiles.get(j);
				// check for collision on sides of tiles
				
				if (thisMob.getYVel() > 0 && thisMob.getY() + this.cellWidthHeight > thisTile.getY() - 3 &&  thisMob.getY() + this.cellWidthHeight < thisTile.getY() + 3 &&thisMob.getX() + this.cellWidthHeight > thisTile.getX() && thisMob.getX() < thisTile.getX() + this.cellWidthHeight) {
					grounded = true;
					System.out.println("isgrounded set to true");

				}
//				if (thisMob.getY() + this.cellWidthHeight < thisTile.getY() - 3) {
//					thisMob.setIsGrounded(false);
//					System.out.println("isgrounded set to false");
//
//				}

				if (collision(thisMob, thisTile)) {
									
					
					
//					if (thisMob.getX() + this.cellWidthHeight < thisTile.getX() + distanceMovedX + 1) {
//						thisMob.setXVel(0);
//						
//						thisMob.setPosition(thisTile.getX() - this.cellWidthHeight, thisMob.getY());
//					}
//					else if (thisMob.getX() + distanceMovedX + 1 > thisTile.getX() + this.cellWidthHeight) {
//						thisMob.setXVel(0);
//					
//						thisMob.setPosition(thisTile.getX() + this.cellWidthHeight, thisMob.getY());
//				//check for collisions on top and bottom of tiles
//					}
					if (thisMob.getY() + this.cellWidthHeight < thisTile.getY() + distanceMovedY + 1) {

						thisMob.setYVel(0);
						thisMob.setPosition(thisMob.getX(), thisTile.getY() - this.cellWidthHeight);
//					}
//					else if (thisMob.getY() > thisTile.getY() + this.cellWidthHeight - distanceMovedY - 1) {
//					
//						thisMob.setYVel(0);
//						thisMob.setPosition(thisMob.getX(), thisTile.getY() + this.cellWidthHeight);
					}

				} 
					
				
			}
			System.out.println(grounded);
			thisMob.setIsGrounded(grounded);

			g2.drawImage(thisMob.getImage(), thisMob.getX(), thisMob.getY(), thisMob.getX() + this.cellWidthHeight,
					thisMob.getY() + this.cellWidthHeight, 0, 0, thisMob.getImage().getWidth(observer),
					thisMob.getImage().getHeight(observer), observer);

			thisMob.updateMovement();

			// Will need to differnetiate between mob types for position update

		}
		// MasterList SOMEWHERE! for letters
		// H is = Hero

	}
}
