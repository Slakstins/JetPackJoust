import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent{
	private int level;
	public ScreenComponent() {
		this.level = 1;
	}
	public void addLevel() {
		level += 1;
		
	}
	
	public void removeLevel() {
		level -= 1;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Get the 2D graphics object
		Graphics2D g2 = (Graphics2D) g;
		// need a BETTER WAY to access level info for drawing in screen.
		//is there a way to do this without putting level1 in Main and DrawComponent?
		if (level == 0) {
//			Screen level1 = new StartScreen("Title, 0");
		}
		
		if (level == 1) {
			Screen level1 = new Level("Title", 1);
			level1.drawEverything(g2);
			
		}
	
		if (level == 2) {
			Screen level2 = new Level("Title", 2);
			level2.drawEverything(g2);
		}
		
		
		
	}
	
}
