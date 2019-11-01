import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diver extends Mob {
	private double totalVel;

	public Diver(int xPos, int yPos) {
		super(xPos, yPos);
		this.totalVel = 3;
		this.setImage("Diver.png");
		this.setYAccel(0);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void updateMovement() {
		this.updateDirection();
		this.posUpdate();

	}

	public void updateDirection() {
		
		double newXVel;
		double newYVel;
		if (this.getHero().getX() - this.getX() == 0) {
			newXVel = 0;
			newYVel = this.totalVel;
		} else {

			double angle = Math.atan((this.getHero().getY() - this.getY()) / (this.getHero().getX() - this.getX()));
//			angle = Math.atan(0.8);
			
			newXVel = this.totalVel * Math.cos(angle);
			newYVel = this.totalVel * Math.sin(angle);
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



	@Override
	public double[] shootDirection() {
		double[] var = new double[2];
		var[0] = 1;
		var[1] = 1;
		return var;
		
	}

}
