import java.util.Random;

public class Jumper extends Ranger {

	private int timeToMove = 300;
	private int speedXMax = 10;
	private int jumpYVel = 7;
	public Jumper(int xPos, int yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	/**
	 * check to see if jumper should jump, if so, jump
	 */
	@Override
	public void runAwayVel() {

		Random random = new Random();
		double newXVel;
		newXVel = 2 + random.nextFloat() * speedXMax;

		int direction = 0;
		this.setIsShooting(false);
		if (this.tick % (this.timeToMove * 2) == 0 && this.tick != 0) {
			this.setXVel(0);
			this.shoot();
		}
		
		else if (this.tick % this.timeToMove == 0 && this.tick != 0) {
			// if one, travel right, if 0, travel left
			direction = random.nextInt(2);
			if (direction == 0) {
				this.setXVel(newXVel);
				
			}
			if (direction == 1) {
				this.setXVel(-newXVel);
			}
			this.setYVel(-this.jumpYVel);
			if (this.getX() < 10 && this.getXVel() < 0) {
				this.setXVel(this.getXVel() * -1);
			}
			if (this.getX() > 1790 && this.getXVel() > 0) {
				this.setXVel(this.getXVel() * -1);
			}
		}
		
		
		
		
	}

}
