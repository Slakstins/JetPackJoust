
public class Multiplier extends Teleporter {
	
	private boolean duplicate;

	public Multiplier(double d, double e) {
		super(d, e);
		this.duplicate = false;
		this.setImages();
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
	
	private void setImages() {
		// set idle images
		for (int i = 0; i <= 4; i++) {
			String filename = "Ghost2000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.idleImages);
		}

		// set fly images
		for (int i = 0; i <= 1; i++) {
			String filename = "GhostFlying2000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.flyImages);
		}

	}
	
	
	

}
