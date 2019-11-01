import java.awt.Rectangle;

public class Bullet extends Mob {

	public Bullet(int xPos, int yPos) {
		super(xPos, yPos);
		this.height = 10;
		this.width = 10;
		this.setYAccel(0);
		this.setXAccel(0);
		this.setYVel(0);
		this.setXVel(15);
		
		this.setImage("bullet.png");
		
		System.out.println("BULLET");
		
		
	}

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

}
