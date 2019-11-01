import java.awt.Rectangle;

public class Bullet extends Mob {
	private final int TOTAL_VELOCITY = 10;

	public Bullet(int xPos, int yPos, Hero hero) {
		super(xPos, yPos);
		this.height = 10;
		this.width = 10;
		this.setYAccel(0);
		this.setXAccel(0);
		this.setHero(hero);
		this.updateDirection();
		
		
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
	
	public void updateDirection() {
			
			double newXVel;
			double newYVel;
			if (this.getHero().getX() - this.getX() == 0) {
				newXVel = 0;
				newYVel = this.TOTAL_VELOCITY;
			} else {
	
				double angle = Math.atan((this.getHero().getY() - this.getY()) / (this.getHero().getX() - this.getX()));
				
				newXVel = this.TOTAL_VELOCITY * Math.cos(angle);
				newYVel = this.TOTAL_VELOCITY * Math.sin(angle);
				if(this.getHero().getX() < this.getX()) {
					newXVel *= -1;
				}
				if (this.getHero().getX() < this.getX() && this.getHero().getY() > this.getY()) {
					newYVel *= -1;
				}
			
				if (this.getHero().getY() < this.getY()) {
					newYVel *= -1;
				}
				if (this.getHero().getY() < this.getY() && this.getHero().getX() > this.getX()) {
					newYVel *= -1;
				}
	
				
			}
			this.setXVel(newXVel);
			this.setYVel(newYVel);
		}

}
