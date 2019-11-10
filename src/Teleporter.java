import java.util.Random;

public class Teleporter extends Mob {
	private int totalVel = 5;
	private boolean isTeleporting = false;
	private double nextX;
	private double nextY;

	public Teleporter(int xPos, int yPos) {
		super(xPos, yPos);
		this.tick = 0;
		this.setImage("Teleporter.png");
		

		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateMovement() {
		
		if (this.tick % 500 == 0) {
			this.teleport();
			this.setImage("Teleporter.png");
		}
		this.posUpdate();
		boolean solidify = false;
		if (this.isTeleporting && this.getX() + 20 > this.nextX && this.getX() - 20 < this.nextX) {
			if (this.getY() + 20 > this.nextY && this.getY() - 20 < this.nextY) {
				solidify = true;
			}
		}
		if (solidify) {
			this.solidify();
		}
	}
	
	public void solidify() {
		this.setXVel(0);
		this.setYVel(0);
		this.setImage("SolidTeleporter.png");
	}
/**
 * select a random loaction on the stage and move to it
 */
	public void teleport() {
		this.isTeleporting = true;
		Random random = new Random();
		this.nextX = random.nextFloat() * (FRAME_WIDTH - CELLWIDTHHEIGHT);
		this.nextY = random.nextFloat() * (FRAME_HEIGHT - CELLWIDTHHEIGHT * 2);
		
		
		updateDirection();
		
		

	}

	public void updateDirection() {

		double newXVel;
		double newYVel;
		if (nextX - this.getX() == 0) {
			newXVel = 0;
			newYVel = this.totalVel;
		} else {

			double angle = Math.atan((this.nextY - this.getY()) / (this.nextX - this.getX()));

			newXVel = this.totalVel * Math.cos(angle);
			newYVel = this.totalVel * Math.sin(angle);
			if (this.nextX < this.getX()) {
				newXVel *= -1;
			}
			if (this.nextX < this.getX() && this.nextY > this.getY()) {
				newYVel *= -1;
			}

			if (this.nextY < this.getY()) {
				newYVel *= -1;
			}
			if (this.nextY < this.getY() && this.nextX > this.getX()) {
				newYVel *= -1;
			}

		}
		this.setXVel(newXVel);
		this.setYVel(newYVel);
	}
	
	@Override
	public void tileCollision(Tile tile) {
		
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
		// TODO Auto-generated method stub

	}

	@Override
	public double[] shootDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void collidedWithHero() {
		// TODO Auto-generated method stub

	}
	
	

}
