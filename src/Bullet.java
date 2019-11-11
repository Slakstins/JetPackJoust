import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bullet extends Mob {
	private final double TOTAL_VELOCITY = 10;
	private ArrayList<Image> images = new ArrayList<Image>();
	
	public Bullet(int xPos, int yPos, double xVel, double yVel, Hero hero, int type) {
		super(xPos, yPos);
		this.height = 10;
		this.width = 10;
		this.setYAccel(0);
		this.setXAccel(0);
		this.setXVel(xVel * TOTAL_VELOCITY);
		this.setYVel(yVel * TOTAL_VELOCITY);
		this.setHero(hero);
		
		this.setImages(type);
		this.setImage(this.images.get(0));
		
		
		
	}
/*
 * creates bounding box based on bullet size, not default mob size
 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX()+ 45, (int)this.getY() + 45, (int)this.width, (int)this.height);

	}
	@Override
	public void updateMovement() {
		this.velUpdate();
		this.posUpdate();
		this.imageUpdate();

		
	}
	private void imageUpdate() {
		if (this.aniTick >= this.images.size())
			this.aniTick = 0;
		this.setImage(this.images.get(aniTick));
		
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
	@Override
	public void collidedWithHero() {
		this.setKilled(true);
		this.getHero().setKilled(true);
		
		// TODO Auto-generated method stub
		
	}
	
	private void setImages(int type) {
		// set idle images
		if (type == 1) {
			for (int i = 0; i < 3; i++) {
				String filename = "RangerBullet000" + Integer.toString(i) + ".png";
				this.saveImage(filename, this.images);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				String filename = "RangerBullet2000" + Integer.toString(i) + ".png";
				this.saveImage(filename, this.images);
			}
		}
		
	}
	

}
