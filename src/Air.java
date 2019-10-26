import javax.imageio.ImageIO;

public class Air extends Tile {

	public Air(int x, int y, int width, int height, String filename) {
		super(x, y, width, height, filename);
		this.isSolid = false;
	}

}
