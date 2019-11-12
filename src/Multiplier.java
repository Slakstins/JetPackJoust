
public class Multiplier extends Teleporter {
	
	private boolean duplicate;

	public Multiplier(double d, double e) {
		super(d, e);
		this.duplicate = false;
		// TODO Auto-generated constructor stub
	}
	/**
	 * check to see if duplication should occur
	 * Occurs at the time of teleportation
	 * 1 is the duplication value for Multiplyer so that level knows what duplication to run
	 * @return
	 */
	@Override
	public int checkDuplicate() {
		if (this.timeToTeleport()) {
				return 1;
		}
		return -1;
	}
	
	@Override
	public void updateMovement() {
		this.checkDuplicate();

		super.updateMovement();
		
	}
	
	
	

}
