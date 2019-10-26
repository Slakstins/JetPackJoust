import javax.swing.JFrame;

public class Screen {
	final private int w = 1800; // screen width
	final private int h = 1000; // screen height
	private String title;
	
	public Screen(String title) {
		this.title = title;
	}
	
	public void main(String[] args) {
		JFrame frame = new JFrame();
		int frameWidth2 = w;
		int frameHeight2 = h;

		frame.setSize(frameWidth2, frameHeight2);
		frame.setTitle(this.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		
		frame.setVisible(true);
	}

}
