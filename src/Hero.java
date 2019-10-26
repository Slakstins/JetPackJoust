import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero extends Mob {
	
	
	

	public Hero(int xPos, int yPos) {
		super(xPos, yPos);
		setImage("heroImage.png");  // MAKE THIS WORK
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void setImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image not found of hero!!");
		}
		this.setImage(image);
		
		
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
