import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Ranger extends Mob {
	private final int timeToMove = 150;
	private final double speed = 1;
	private int isShooting;
	protected ArrayList<Image> idleImages = new ArrayList<Image>();
	protected ArrayList<Image> shootImages = new ArrayList<Image>();

	public Ranger(int xPos, int yPos) {
		super(xPos, yPos);
		this.aniTick = 0;
		this.setImages();
		this.setImage("Ranger0000.png");

	}

	public void setImages() {
		// set idle images
		for (int i = 0; i <= 1; i++) {
			String filename = "Ranger000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.idleImages);
		}

		// set shooting image
		this.saveImage("RangerShooting0000.png", this.shootImages);
	}

	@Override
	public void updateMovement() {
		this.setIsShooting(0);

		this.slimeMove();
		this.posUpdate();
		this.velUpdate();
		this.imageUpdate();
		this.checkShoot();

	}

	private void imageUpdate() {
		if (this.getShooting() > 0) {
			this.setImage(this.shootImages.get(0));

		} else {
			if (this.aniTick >= this.idleImages.size())
				this.aniTick = 0;
			this.setImage(this.idleImages.get(aniTick));
		}

	}

	public void slimeMove() {

		if (this.checkTimeToMove()) {
			Random random = new Random();
			int direction = 0;
			// if one, travel right, if 0, travel left
			direction = random.nextInt(2);
			if (direction == 0) {
				this.setXVel(-this.speed);

			}
			if (direction == 1) {
				this.setXVel(this.speed);
			}
		}

	}

	public boolean checkTimeToMove() {
		return (this.tick % this.timeToMove == 0);
	}

	/**
	 * Ranger moves twice for each time Jumper moves once
	 * 
	 * @return
	 */
	public boolean checkShoot() {
		if (this.tick % (this.timeToMove * 2) == (this.timeToMove + this.timeToMove / 2) && this.tick != 0) {
			this.setXVel(0);
			this.shoot();
			return true;
		}

		return false;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shoot() {
		this.setIsShooting(1);
	}

	public int getShooting() {
		return this.isShooting;
	}

	public double[] shootDirection() {

		double newXVel;
		double newYVel;
		if (this.getHero().getX() - this.getX() == 0) {
			newXVel = 0;
			newYVel = 1;
		} else {

			double angle = Math.atan((this.getHero().getY() - this.getY()) / (this.getHero().getX() - this.getX()));

			newXVel = Math.cos(angle);
			newYVel = Math.sin(angle);
			if (this.getHero().getX() < this.getX()) {
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
		double[] dir = new double[2];
		dir[0] = newXVel;
		dir[1] = newYVel;
		return dir;
	}

	@Override
	public void collidedWithHero() {
		if (this.getInvincible() == true) {
			return;
		}
		if (this.getHero().getIsAttacking() == false) {
			this.getHero().setKilled(true);
			return;
		}
		if (this.getY() <= this.getHero().getY()) {
			this.getHero().setKilled(true);
			return;

		}

		if (this.getY() > this.getHero().getY() && this.getHero().getIsAttacking()) {
			this.setKilled(true);
			return;
		}

	}

	public void setIsShooting(int isShooting) {
		this.isShooting = isShooting;
	}

}
