import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diver extends Mob {
	private Hero hero;
	private double totalVel;

	public Diver(int xPos, int yPos) {
		super(xPos, yPos);
		this.totalVel = 1;
		this.hero = hero;
		this.setImage("Diver.png");
		this.setYAccel(0);
		// TODO Auto-generated constructor stub
	}

	public void setImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image not found of Mob!!");
		}
		this.setImage(image);

	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void updateMovement() {
		this.updateDirection();
		this.posUpdate();

	}

	public void updateDirection() {
		double newXVel;
		double newYVel;
		if (this.hero.getX() - this.getX() == 0) {
			newXVel = 0;
			newYVel = this.totalVel;
		} else {

			double angle = Math.atan((this.hero.getY() - this.getY()) / (this.hero.getX() - this.getX()));
//			angle = Math.atan(0.8);
			System.out.println(angle*(180)/Math.PI);
			
			newXVel = this.totalVel * Math.cos(angle);
			newYVel = this.totalVel * Math.sin(angle);
//			if(this.hero.getX() < this.getX()) {
//				newXVel;
//			}
			System.out.println(Math.atan(4/5));
			if (this.hero.getY() < this.getY()) {
				newYVel *= -1;
			}

			
		}
//		this.setXVel(newXVel);
//		this.setYVel(newYVel);
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
		// TODO Auto-generated method stub

	}

}
