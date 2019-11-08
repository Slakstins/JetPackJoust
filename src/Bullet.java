import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bullet extends Mob {
	private final double TOTAL_VELOCITY = 10;
	private ArrayList<Image> images = new ArrayList<Image>();
	
	public Bullet(int xPos, int yPos, double xVel, double yVel, Hero hero) {
		super(xPos, yPos);
		this.height = 100;
		this.width = 50;
		this.setYAccel(0);
		this.setXAccel(0);
		this.setXVel(xVel * TOTAL_VELOCITY);
		this.setYVel(yVel * TOTAL_VELOCITY);
		this.setHero(hero);
		
		this.setImages();
		this.setImage(this.images.get(0));
		
		
		
	}
/*
 * creates bounding box based on bullet size, not default mob size
 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX(), (int)this.getY(), (int)this.width, (int)this.height);

	}
	@Override
	public void updateMovement() {
		this.velUpdate();
		this.posUpdate();
		this.imageUpdate();
		this.updateAniTick();
		
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
	
	private void setImages() {
		// set idle images
		for (int i = 0; i < 3; i++) {
			String filename = "RangerBullet000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.images);
		}
	}
	

}
