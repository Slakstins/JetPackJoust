
public class Chicken extends Diver {
	

	public Chicken(int xPos, int yPos) {
		super(xPos, yPos);
		this.setDuplicate(false);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * should be true if laying multiple eggs
	 */
	@Override
	public boolean checkDuplicate() {
		return false;
	}
	
	@Override
	public void kill() {
		if (this.getIsEgg() == false) {
			this.setDuplicate(true); // only difference from Ranger

		}
		super.kill();


	}

}
