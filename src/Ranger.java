import java.util.Random;

public class Ranger extends Mob {
	private long time;
	private final int timeToMove = 150;
	private final double speed = 1;
	private boolean isShooting;

	public Ranger(int xPos, int yPos) {
		super(xPos, yPos);
		
		this.time = 0;
		this.setImage("Ranger.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void updateMovement(){
		this.runAwayVel();
		this.posUpdate();
		this.velUpdate();

		
	}
	public void runAwayVel() {
		this.time += 1;
		Random random = new Random();
		int direction = 0;
		this.isShooting = false;
		if (this.time % (this.timeToMove*2) == 0) {
			this.setXVel(0);
			this.shoot();
		}
		
		else if (this.time % this.timeToMove == 0) {
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
		this.isShooting = true;
	}

	public boolean getShooting() {
		return isShooting;
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
		double[] dir = new double[2];
		dir[0]= newXVel;
		dir[1] = newYVel;
		return dir;
	}
}
