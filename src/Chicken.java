
public class Chicken extends Diver {
	private int eggsDropped = 5; // actual number of eggs dropped is eggsDropped + 1 for index
	private long eggTime = 300;



	public Chicken(double d, double e) {
		super(d, e);
		this.setDuplicate(-1);
		this.setTimeInEgg(this.eggTime);
		this.setMaxEggVel(10);

	}

	public void setImages() {
		// set right moving images
		for (int i = 0; i <= 3; i++) {
			String filename = "./images/chickenR000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.dragonRimages);
		}

		// set left moving images
		for (int i = 0; i <= 3; i++) {
			String filename = "./images/chickenL000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.dragonLimages);
		}

		// set egg image
		this.saveImage("./images/Egg2.png", this.eggImage);
	}

	/**
	 * should be true if laying multiple eggs
	 */
	@Override
	public int checkDuplicate() {
		return this.getDuplicate();
	}

	/**
	 * set to duplicate as the functionality for chicken on death to produce a lotta
	 * eggs
	 */
	@Override
	public void kill() {
		this.setDuplicate(2); // only difference from Ranger

		super.kill();
	}

	public int getEggsDropped() {
		return this.eggsDropped;
	}

}
