import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Mob {
	private Hero hero;
	private double xPos;
	private double yPos;
	private double xVel;
	private double yVel;
	private double xAcceleration;
	private double yAcceleration;
	private Image image;
	public final double gravity = 0.05;
	protected double width;
	protected double height;
	public final int defaultMobHeight = 100;
	public final int defaultMobWidth = 100;
	private double maxXVel = 50;
	private double maxYVel = 50;
	private double friction = 0.01;
	protected final double FRAME_WIDTH = 1900;
	protected final double FRAME_HEIGHT = 1000;
	

	protected final double CELLWIDTHHEIGHT = 100;
	private boolean isGrounded;
	protected int shootCooldown;
	protected boolean shooting;
	protected int tick;
	protected int aniTick;
	private boolean hasDied;
	
	
	private boolean invincible = false;
	private boolean checkInvincible = false;
	private long endInvincible;
	
	
	public Mob(double d, double e) {
		this.height = defaultMobHeight;
		this.width = defaultMobWidth;
		this.xPos = d;
		this.yPos = e;
		this.xVel = 0;
		this.yVel = 0;
		this.xAcceleration = 0;
		this.yAcceleration = gravity;
		this.image = null;
		this.isGrounded = false;
		this.hero = null;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX() + 5, (int)this.getY(), this.defaultMobWidth - 10, this.defaultMobHeight );
	}
	
	
	
	

	public abstract void fly();
	public abstract void kill();
	public abstract void spawn();
	public abstract void shoot();
	public abstract double[] shootDirection();
	
	public void updateMovement() {
		this.velUpdate();
		this.posUpdate();
		
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	public void setImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image not found " + filename);
		}
		this.setImage(image);

	}
	
	public void setIsGrounded(boolean grounded ) {
		this.isGrounded = grounded;
	}
	public boolean getIsGrounded() {
		return this.isGrounded;
	}
	
	
	
	public void setXAccel(double xAccel) {
		this.xAcceleration = xAccel;
	}
	
	public void setYAccel(double yAccel) {
		this.yAcceleration = yAccel;
	}
	
	
	/**
	 * also calls update invincibility to save space in level
	 * @param d
	 * @param y
	 */
	public void setPosition(double d, double y) {
		this.xPos = d;
		this.yPos = y;
		
	}
	
	
	public void setYVel(double d) {
		this.yVel = d;
		
	}
	public double getYVel() {
		
		return this.yVel;
	}
	public double getXVel() {
		return this.xVel;
	}
	
	public void setXVel(double vel) {
		this.xVel = vel;
	}
	
	public void keepInFrame() {
		if (this.xPos + this.xVel > this.FRAME_WIDTH - this.CELLWIDTHHEIGHT || this.xPos + this.xVel < 0) {
			
			this.setXVel(0);
		} 
		
		if (this.yPos  + this.yVel < 0) {
			this.setYVel(0);
		}
	}
	
	public boolean checkDuplicate() {
		return false;
	}
	

	
	/**
	 * Call this often to make smooth!
	 * values will have to be reduced if calling more often for smoothness
	 * this also checks to make sure the mob does not go out of the frame //THIS SHOULD BE SEPARATED INTO TWO METHODS
	 */
	public void posUpdate() {
		this.tick++;
		this.updateInvincibility();
		this.updateAniTick();

		keepInFrame();
		
		this.xPos += this.xVel;
		
		this.yPos += this.yVel;
	}
	/**
	 * call often to make smooth
	 */
	public void velUpdate() {
		
		if (this.xVel + this.xAcceleration < this.maxXVel && this.xVel + this.xAcceleration > -this.maxXVel) {
		this.xVel += this.xAcceleration;
		}
		if (this.yVel < this.maxYVel && this.yVel > -this.maxYVel) {
		this.yVel += this.yAcceleration;
		}
		if (this.xVel > 0) {
			this.xVel = this.xVel - this.friction;
		}
		if (this.xVel < 0) {
			this.xVel = this.xVel + this.friction;
		}
		// getting rid of friction for some reaseon fixes the issue of going faster to the left
	}
	public double getXAcceleration() {
		return this.xAcceleration;
	}
	public double getYAcceleration() {
		return this.yAcceleration;
	}
	
	public void setXAcceleration(double accelerationX) {
		this.xAcceleration = accelerationX;
	}
	
	public void setYAcceleration(double accelerationY) {
		this.yAcceleration = accelerationY;
	}
	
	public double getX() {
		return this.xPos;
	}
	public double getY() {
		return this.yPos;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	
	
	public void setImage(Image newImage) {
		this.image = newImage;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public boolean getShooting() {
		return this.shooting;
	}
	/**
	 * check to see if the mob is standing on a tile
	 * @param tiles
	 */
	public void updateGrounded(ArrayList<Tile> tiles) {
		for (int j = 0; j < tiles.size(); j++) {
			Tile thisTile = tiles.get(j);
			// check for collision on sides of tiles

			if (this.getYVel() > 0 && this.getY() + this.CELLWIDTHHEIGHT > thisTile.getY() - 3
					&& this.getY() + this.CELLWIDTHHEIGHT < thisTile.getY() + 3
					&& this.getX() + this.CELLWIDTHHEIGHT > thisTile.getX()
					&& this.getX() < thisTile.getX() + this.CELLWIDTHHEIGHT
					&& (!(this.getY() + this.CELLWIDTHHEIGHT < thisTile.getY() - 3))) {
				this.isGrounded = true;
				return;
				
			}

		}
		this.isGrounded = false;
	}
	
	
/**
 * update mob based on the collision with a tile
 * if bottom row of tiles, prevent fallthrough from pressing down
 * @param thisTile
 */
	public void tileCollision(Tile thisTile) {
		double distanceMovedY = (this.getYVel());
		if (this.getY() + this.CELLWIDTHHEIGHT < thisTile.getY() + distanceMovedY + 1) {

			this.setYVel(0);
			this.setPosition(this.getX(), thisTile.getY() - this.CELLWIDTHHEIGHT);
		}
		
		if (this.yPos > this.FRAME_HEIGHT - this.CELLWIDTHHEIGHT * 2) {
			this.setPosition(this.xPos, this.FRAME_HEIGHT - this.CELLWIDTHHEIGHT  * 2);
		}
		// TODO Auto-generated method stub
		
	}

	public void setKilled(boolean hasDied) {
		// TODO Auto-generated method stub
		if (this.invincible == true) {
			this.hasDied = false;
			return;
		}
		this.hasDied = hasDied;
		
	}
	
	public boolean getHasDied() {
		return this.hasDied;
	}

	public abstract void collidedWithHero();

	protected void saveImage(String filename, ArrayList<Image> images) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
			images.add(image);
		} catch (IOException e) {
			System.out.println("Image not found!");
		}
	}	
	
	
	protected void updateAniTick() {
		if (tick % 15 == 0) {
			aniTick++;
		}
	}
	/**
	 * set the mob to be invincible for a period of time, tick must be incremented in the movement update for the subclass of mobs
	 * @param invincible
	 * @param time
	 */
	public void setInvincible(boolean invincible, long time) {
		this.invincible = invincible;
		this.checkInvincible  = true;
		this.endInvincible = this.tick + time;
		
	}

	public boolean getInvincible() {
		return invincible;
	}
	
	public void updateInvincibility() {
		if (this.invincible) {
		
			if (this.tick == this.endInvincible) {
				this.invincible = false;
				System.out.println("invincibilty ended");
			}
		}
		
	}

}
