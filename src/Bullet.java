import java.awt.Rectangle;

public class Bullet extends Mob {
	private final double TOTAL_VELOCITY = 10;

	public Bullet(int xPos, int yPos, double xVel, double yVel, Hero hero) {
		super(xPos, yPos);
		this.height = 10;
		this.width = 10;
		this.setYAccel(0);
		this.setXAccel(0);
		this.setXVel(xVel * TOTAL_VELOCITY);
		this.setYVel(yVel * TOTAL_VELOCITY);
		this.setHero(hero);
		
		
		this.setImage("bullet.png");
		
		System.out.println("BULLET");
		
		
	}
/*
 * creates bounding box based on bullet size, not default mob size
 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX(), (int)this.getY(), (int)this.width, (int)this.height);

	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kill() {

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}
	@Override
	public double[] shootDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
