import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Diver extends Mob {
	private double totalVel;
	private boolean isEgg = false;
	private long invincibleEggTime = 50;
	private long breakOutEggTime;
	private long timeInEgg = 600;
	private int eggYVel = 5;
	protected ArrayList<Image> dragonRimages = new ArrayList<Image>();
	protected ArrayList<Image> dragonLimages = new ArrayList<Image>();
	protected ArrayList<Image> eggImage = new ArrayList<Image>();

	public Diver(double d, double e) {
		super(d, e);

		this.totalVel = 3;
		this.aniTick = 0;
		this.setImages();
		this.setImage(this.dragonRimages.get(0));
		this.setYAccel(0);

	}

	/**
	 * Update movement based on whether Diver is in an egg. Run checkBreakOutOfEgg
	 */
	@Override
	public void updateMovement() {
		if (this.getIsEgg() == false) {
			this.updateDirection();
			this.posUpdate();
			this.updateImages();
			return;
		}
		this.posUpdate();
		this.velUpdate();
		this.checkBreakOutOfEgg();
		this.updateImages();
	}

	public void setImages() {
		// set right moving images
		for (int i = 0; i <= 3; i++) {
			String filename = "dragonR000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.dragonRimages);
		}

		// set left moving images
		for (int i = 0; i <= 3; i++) {
			String filename = "dragonL000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.dragonLimages);
		}

		// set egg image
		this.saveImage("Egg.png", this.eggImage);

	}

	private void updateImages() {
		if (this.isEgg)
			this.setImage(this.eggImage.get(0));
		else if (this.getXVel() >= 0) {
			if (this.aniTick >= this.dragonRimages.size())
				this.aniTick = 0;
			this.setImage(this.dragonRimages.get(aniTick));
		} else {
			if (this.aniTick >= this.dragonLimages.size())
				this.aniTick = 0;
			this.setImage(this.dragonLimages.get(aniTick));
		}

	}

	/**
	 * set the direction to be towards the player and break the velocity into
	 * components accordingly to retain total velocity
	 */
	public void updateDirection() {

		double newXVel;
		double newYVel;
		if (this.getHero().getX() - this.getX() == 0) { // prevents divide by zero error
			newXVel = 0;
			newYVel = this.totalVel;
		} else {

			double angle = Math.atan((this.getHero().getY() - this.getY()) / (this.getHero().getX() - this.getX()));

			newXVel = this.totalVel * Math.cos(angle);
			newYVel = this.totalVel * Math.sin(angle);
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
		this.setXVel(newXVel);
		this.setYVel(newYVel);
	}

	@Override
	public void fly() {

	}

	/**
	 * diver becomes an egg and must be killed again to be removed from the game
	 * Also becomes temporarily invincible to prevent instakilling of egg If is an
	 * egg, kill
	 */
	@Override
	public void kill() {
		if (this.getIsEgg() == true) {
			this.setKilled(true);
			return;
		}
		if (this.getInvincible() == true) {
			return;
		}
		this.setKilled(false);
		this.turnIntoEgg();

	}

	/**
	 * 
	 * replace the diver with an egg! randomize velocity and set invulnerable
	 * temporarily
	 */
	public void turnIntoEgg() {
		this.setIsEgg(true);
		this.giveEggVelocity();
		this.setInvincible(true, this.invincibleEggTime);
		this.setBreakOutOfEggTime();
	}

	public void giveEggVelocity() {
		Random random = new Random();
		double sign = 1;
		if (random.nextFloat() > .5) {
			sign = -1;
		}
		this.setXVel(random.nextFloat() * 5 * sign);
		this.setYVel(-this.eggYVel);
		this.setYAccel(super.getGravity());
	}

	public void setBreakOutOfEggTime() {
		this.breakOutEggTime = this.tick + this.timeInEgg;
	}

	/**
	 * check to see if the time to break out of the egg has elapsed
	 */
	public void checkBreakOutOfEgg() {
		if (this.tick == this.breakOutEggTime) {
			this.breakOutOfEgg(); // IMPLEMENT THIS

		}
	}

	public void breakOutOfEgg() {
		this.isEgg = false;
		this.setImage("Diver.png");

	}

	public void setIsEgg(boolean isEgg) {
		this.isEgg = isEgg;
	}

	@Override
	public void spawn() {

	}

	@Override
	public void shoot() {

	}

	@Override
	public double[] shootDirection() {
		double[] var = new double[2];
		var[0] = 1;
		var[1] = 1;
		return var;

	}

	/**
	 * Kill hero if not attacking if attacking and above diver, kill diver
	 */
	@Override
	public void collidedWithHero() {

		if (this.getInvincible() == true) {
			return;
		}
		if (this.getIsEgg() == true) {
			this.setKilled(true);
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

	public boolean getIsEgg() {
		return isEgg;
	}

}
