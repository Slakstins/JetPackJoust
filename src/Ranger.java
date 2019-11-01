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
		System.out.println("Ranger shooting!");
	}

	public boolean getShooting() {
		return isShooting;
	}
}
