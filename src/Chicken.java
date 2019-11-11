
public class Chicken extends Diver {
	private int eggsDropped = 3; //actual number of eggs dropped is eggsDropped + 1 for index

	public Chicken(double d, double e) {
		super(d, e);
		this.setDuplicate(-1);
		
		//will want to set the image as chicken here!
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * should be true if laying multiple eggs
	 */
	@Override
	public int checkDuplicate() {
		return this.getDuplicate();
	}
	/**
	 * set to duplicate as the functionality for chicken on death to produce a lotta eggs
	 */
	@Override
	public void kill() {
		System.out.println("KILL");
		this.setDuplicate(2); // only difference from Ranger

		
		super.kill();


	}
	public int getEggsDropped() {
		return this.eggsDropped;
	}

}
