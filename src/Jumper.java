import java.util.Random;

public class Jumper extends Ranger {

	private int timeToMove = 300;
	private int speedXMax = 10;
	private int jumpYVel = 7;

	public Jumper(int xPos, int yPos) {
		super(xPos, yPos);
	}

	/**
	 * check to see if jumper time to jump is true and checks if grounded if so jump
	 */
	@Override
	public void slimeMove() {

		// jump if grounded
		if (this.checkTimeToJump()) {
			Random random = new Random();
			double newXVel;
			newXVel = 2 + random.nextFloat() * speedXMax;
			int direction = 0;
			if (this.tick % (this.timeToMove) == this.timeToMove / 2 && this.tick != 0) {
				this.setXVel(0);
			}
			// if one, travel right, if 0, travel left
			direction = random.nextInt(2);
			if (direction == 0) {
				this.setXVel(newXVel);

			}
			if (direction == 1) {
				this.setXVel(-newXVel);
			}

			if (this.getX() < 10 && this.getXVel() < 0) {
				this.setXVel(this.getXVel() * -1);
			}
			if (this.getX() > 1790 && this.getXVel() > 0) {
				this.setXVel(this.getXVel() * -1);
			}
			this.setYVel(-this.jumpYVel);

		}
	}

	public boolean checkTimeToJump() {
		if (this.tick % (this.timeToMove) == this.timeToMove / 2 && this.tick != 0 && this.getIsGrounded()) {
			return true;
		}
		return false;
	}

	@Override
	public void shoot() {
		this.setIsShooting(2);
	}

	public void setImages() {
		// set idle images
		for (int i = 0; i <= 1; i++) {
			String filename = "./images/Ranger2000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.idleImages);
		}

		// set shooting image

		this.saveImage("./images/RangerShooting0000.png", this.shootImages);

	}

}
