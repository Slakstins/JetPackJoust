import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tile {
	protected int width;
	protected int height;
	protected int xPos;
	protected int yPos;
	protected boolean isSolid;
	protected String filename;
	protected BufferedImage image;
	
	public Tile(int x, int y, int width, int height, String filename) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.filename = filename;
		
		this.setImage();
	}
	
	
	public void setImage() {
		try {
		    this.image = ImageIO.read(new File(filename));
		} catch (IOException e) {
		    throw new RuntimeException("Could not load image file " + this.filename);
		}
	}

}
