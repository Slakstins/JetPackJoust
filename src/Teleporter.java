import java.util.Random;

public class Teleporter extends Mob {
	private int totalVel = 5;
	private boolean isTeleporting = false;
	private double nextX;
	private double nextY;

	public Teleporter(double d, double e) {
		super(d, e);
		this.tick = 0;
		this.setImage("Teleporter.png");
		

		
	}

	public boolean timeToTeleport() {
		if (this.tick % 500 == 0) {
			return true;
		}
		return false;


	}
	

	@Override
	public void updateMovement() {
		
		if (this.timeToTeleport()) {
			this.teleport();
			this.setImage("Teleporter.png");
		}
		this.posUpdate();
		boolean solidify = false;
		if (this.getIsTeleporting() && this.getX() + 20 > this.getNextX() && this.getX() - 20 < this.getNextX()) {
			if (this.getY() + 20 > this.getNextY() && this.getY() - 20 < this.getNextY()) {
				solidify = true;
			}
		}
		if (solidify) {
			this.solidify();
		}
	}
	/**
	 * stop moving, expand, activate hitbox/hurtbox, change image to solid teleporter
	 */
	public void solidify() {
		this.isTeleporting = false;
		this.setXVel(0);
		this.setYVel(0);
		this.setImage("SolidTeleporter.png");
	}
/**
 * select a random loaction on the stage and move to it
 */
	public void teleport() {
		this.isTeleporting = true;
		Random random = new Random();
		this.nextX = random.nextFloat() * (FRAME_WIDTH - CELLWIDTHHEIGHT);
		this.nextY = random.nextFloat() * (FRAME_HEIGHT - CELLWIDTHHEIGHT * 2);
		
		
		updateDirection();
		
		

	}

	public void updateDirection() {

		double newXVel;
		double newYVel;
		if (getNextX() - this.getX() == 0) {
			newXVel = 0;
			newYVel = this.totalVel;
		} else {

			double angle = Math.atan((this.getNextY() - this.getY()) / (this.getNextX() - this.getX()));

			newXVel = this.totalVel * Math.cos(angle);
			newYVel = this.totalVel * Math.sin(angle);
			if (this.getNextX() < this.getX()) {
				newXVel *= -1;
			}
			if (this.getNextX() < this.getX() && this.getNextY() > this.getY()) {
				newYVel *= -1;
			}

			if (this.getNextY() < this.getY()) {
				newYVel *= -1;
			}
			if (this.getNextY() < this.getY() && this.getNextX() > this.getX()) {
				newYVel *= -1;
			}

		}
		this.setXVel(newXVel);
		this.setYVel(newYVel);
	}
	
	@Override
	public void tileCollision(Tile tile) {
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collidedWithHero() {
		if (this.getInvincible()) {
			return;
		}
		
		if (this.getIsTeleporting()) {
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

	public boolean getIsTeleporting() {
		return isTeleporting;
	}

	public double getNextX() {
		return nextX;
	}

	public double getNextY() {
		return nextY;
	}
	
	

}
