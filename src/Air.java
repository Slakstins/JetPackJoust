import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Air extends Tile {

	public Air(int x, int y, int width, int height) {
		super(x, y, width, height, "Air.png");
		this.isSolid = false;
	}

	@Override
	public void setImage() {
		try {
		    this.image = ImageIO.read(new File(this.filename));
		} catch (IOException e) {
		    throw new RuntimeException("Could not load image file " + this.filename);
		}
	}
	
}

