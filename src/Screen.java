import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;


public abstract class Screen {
	final private int w = 1000; // screen width
	final private int h = 1000; // screen height
	private String title;
	public abstract void drawEverything(Graphics2D g2);
	
	public Screen(String title) {
		this.title = title;
	}
	
	
	
	
	

	//each level has the data to create a frame this way. Is that bad?
	//each level will also have its own drawComponent which is duplication
	//moved code to main
//	public void main(String[] args) {
//		JFrame frame = new JFrame();
//		int frameWidth2 = w;
//		int frameHeight2 = h;
//
//		frame.setSize(frameWidth2, frameHeight2);
//		ScreenComponent component = new ScreenComponent();
//		
//		
//	
//		frame.add(component);
//		frame.setTitle(this.title);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocation(0, 0);
//		
//		
//		frame.setVisible(true);
}


