import java.awt.Image;

public abstract class Mob {
	int xPos;
	int yPos;
	double xVel;
	double yVel;
	double xAcceleration;
	double yAcceleration;
	public final double gravity = 9.8;
	
	public Mob(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = 0;
		this.yVel = 0;
		this.xAcceleration = 0;
		this.yAcceleration = gravity;
	}
	
	public abstract void fly();
	public abstract void kill();
	public abstract void spawn();
	public abstract void shoot();
	
	
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
	
	
	
	

}
