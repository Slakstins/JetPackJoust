import javax.swing.JFrame;

public class Screen {
	final static int w = 1800; // screen width
	final static int h = 1000; // screen height
	
	public Screen() {
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		int frameWidth2 = w;
		int frameHeight2 = h;

		frame.setSize(frameWidth2, frameHeight2);
		frame.setTitle("Joust");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		
		
		frame.setVisible(true);
	}

}
