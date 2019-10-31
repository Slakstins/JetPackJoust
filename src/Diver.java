import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diver extends Mob {
	private Hero hero;

	public Diver(int xPos, int yPos) {
		super(xPos, yPos);
		this.hero = hero;
		this.setImage("Diver.png");
		this.setYAccel(0);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image not found of Mob!!");
		}
		this.setImage(image);
		
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	@Override
	public void updateMovement() {
		this.updateDirection();
		this.posUpdate();
		
		
	}
	
	public void updateDirection() {
		this.setXVel((this.hero.getX() - 100 - this.getX()) / 100);
		this.setYVel((this.hero.getY() + 100 - this.getY()) / 100);
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

}
