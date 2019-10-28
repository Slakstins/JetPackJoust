import java.awt.Image;

public abstract class Mob {
	private int xPos;
	private int yPos;
	private double xVel;
	private double yVel;
	private double xAcceleration;
	private double yAcceleration;
	private Image image;
	public final double gravity = 5;
	private int width;
	private int height;
	public final int defaultMobHeight = 100;
	public final int defaultMobWidth = 100;
	
	public Mob(int xPos, int yPos) {
		this.height = defaultMobHeight;
		this.width = defaultMobWidth;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = 0;
		this.yVel = 0;
		this.xAcceleration = 0;
		this.yAcceleration = gravity;
		this.image = null;
		System.out.println("Position updated!");
	}
	
	

	public abstract void fly();
	public abstract void kill();
	public abstract void spawn();
	public abstract void shoot();
	
	public void updateMovement() {
		this.velUpdate();
		this.posUpdate();
		
	
	}
	
	public double getTravelDistance() {
		return this.yVel;
	}
	public void setPostition(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setYVel(double d) {
		this.yVel = d;
	}
	public double getYVel() {
		return this.yVel;
	}

	
	/**
	 * Call this often to make smooth!
	 * values will have to be reduced if calling more often for smoothness
	 */
	public void posUpdate() {
		this.xPos += this.xVel;
		this.yPos += this.yVel;
	}
	/**
	 * call often to make smooth
	 */
	public void velUpdate() {
		this.xVel += this.xAcceleration;
		this.yVel += this.yAcceleration;
	}
	
	public void setXAcceleration(int accelerationX) {
		this.xAcceleration = accelerationX;
	}
	
	public void setYAcceleration(int accelerationY) {
		this.yAcceleration = accelerationY;
	}
	
	public int getX() {
		return this.xPos;
	}
	public int getY() {
		return this.yPos;
	}
	
	
	
	public void setImage(Image newImage) {
		this.image = newImage;
	}
	
	public Image getImage() {
		return this.image;
	}
	

	
	
	
	

}
