import javax.imageio.ImageIO;

public class Air extends Tile {

	public Air(int x, int y, int width, int height) {
		super(x, y, width, height, "airTile.png");
		this.isSolid = false;
	}

	@Override
	public void setImage() {
	
	}
}
