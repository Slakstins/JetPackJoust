
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
		if (this.timeToTeleport()) {
			this.teleport();
//			this.setImage("Multiplier.png");
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
	
	
	

}
