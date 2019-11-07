import java.util.ArrayList;
import java.util.Random;

public class Ranger extends Mob {
	private long time;
	private final int timeToMove = 150;
	private final double speed = 1;
	private boolean isShooting;
	private ArrayList<String> idleImages = new ArrayList<String>();
	private ArrayList<String> shootImages = new ArrayList<String>();

	public Ranger(int xPos, int yPos) {
		super(xPos, yPos);
		
		this.time = 0;
		this.aniTick = 0;
		this.setImages();
		this.setImage("Ranger0000.png");
		

	}
	
	private void setImages() {
		// set idle images
		for (int i = 0; i <= 1; i++) {
			String filename = "Ranger000" + Integer.toString(i) + ".png";
			this.idleImages.add(filename);
		}
		
		// set shooting image
		this.shootImages.add("RangerShooting0000.png");
		
	}

	@Override
	public void updateMovement(){
		this.runAwayVel();
		this.posUpdate();
		this.velUpdate();
		this.imageUpdate();
		this.updateAniTick();

		
	}
	private void imageUpdate() {
		if (this.isShooting) {
			this.setImage(this.shootImages.get(0));
		} else {
			if (this.aniTick >= this.idleImages.size())
				this.aniTick = 0;
			this.setImage(this.idleImages.get(aniTick));
		}
		
	}

	public void runAwayVel() {
		this.time++;
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

	@Override
	public void collidedWithHero() {
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

	}
	
	private void updateAniTick() {
		if (time % 30 == 0) {
			aniTick++;
		}
	}
}
