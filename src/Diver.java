import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diver extends Mob {
	private double totalVel;
	private boolean isEgg = false;;

	public Diver(int xPos, int yPos) {
		super(xPos, yPos);
//		this.setInvincible(true, 5);

		this.totalVel = 3;
		this.setImage("Diver.png");
		this.setYAccel(0);

	}

	

	@Override
	public void updateMovement() {
		if (this.isEgg == false) {
			this.updateDirection();
		}
	
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
	/**
	 * diver becomes an egg and must be killed again to be removed from the game
	 */
	@Override
	public void kill() {
		// TODO Auto-generated method stub
		if (this.isEgg == true) {
			this.setKilled(true);
		}
		if (this.getInvincible() == true) {
			return;
		}
		this.setKilled(false);
		this.turnIntoEgg();
		
		
		
		

	}
	/**
	 * replace the diver with an egg! randomize velocity and set invulnerable temporarily somehow TBD
	 */
	public void turnIntoEgg() {
		System.out.println("turned into egg");
		this.setImage("Egg.png");
		this.setIsEgg(true);
		this.setXVel(0);
		this.setYVel(0);
		this.setYAccel(-3);
		this.setInvincible(true, 500);
	}
	
	public void setIsEgg(boolean isEgg) {
		this.isEgg  = isEgg;
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



	/**
	 * Kill hero if not attacking
	 * if attacking and above diver, kill diver
	 */
	@Override
	public void collidedWithHero() {
		
		
		
		
		if (this.getInvincible() == true) {
			return;
		}
		if(this.getHero().getIsAttacking() == false) {
			this.getHero().setKilled(true);
			return;
		}
		if(this.getY() <= this.getHero().getY()) {
			this.getHero().setKilled(true);
			return;
			
		} 
		
		if (this.getY() > this.getHero().getY() && this.getHero().getIsAttacking()) {
			this.setKilled(true);
			return;
		}
		
		// TODO Auto-generated method stub
		
	}

}
