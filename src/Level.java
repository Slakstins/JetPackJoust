import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Level extends Screen {
	

	
	ArrayList<Mob> mobsToDraw;
	ArrayList<Tile> tilesToDraw;
	private int levelNum;
	public final int cellWidthHeight = 100;
	
	

	public Level(String title, int levelNum) {
		super(title);
		this.levelNum = levelNum;
		mobsToDraw = new ArrayList<Mob>();
		tilesToDraw = new ArrayList<Tile>();
		
		readLevelFile();
	}

	private void readLevelFile() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("level" + levelNum + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("level" + levelNum + ".txt not found");
			//e.printStackTrace();
			return;
		}
		int posY = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char toBuild = line.charAt(i);
				if (toBuild == 'H' || toBuild == 'M') {
					System.out.println("Mob drawn! @" + i + ' ' + posY);
					Mob newMob;
					if (toBuild == 'H') {
						newMob = new Hero(i * this.cellWidthHeight, posY* this.cellWidthHeight);
						
					}
					
				}
				
				if (toBuild == 'T') {
					System.out.println("Tile drawn! @" + i + ' ' + posY);
				}
				else if (toBuild =='E') {
					System.out.println("Empty space drawn! @" + i + ' ' + posY);
					tilesToDraw.add(new Air(i * 100, posY, 100, 100));
				}
				
				// i gives posX
				//posY gives y value(0 at top of page)
			}
			
			
			posY++;
			
			
			
			System.out.println(line);
			
			
			
			//PUT METHOD HERE THAT BUILDS CHARACTERS AND BLOCKS FROM CHAR USING DRAW
			
		}
		scanner.close();
		
	}
	
	
	public void drawEverything(Graphics2D g2) {
		
		for (int i = 0; i < this.mobsToDraw.size(); i ++) {
			ImageObserver observer = null; // is this a problem????
			g2.drawImage(this.mobsToDraw.get(i).getImage(), this.mobsToDraw.get(i).getX(), 
					this.mobsToDraw.get(i).getY(), observer);
		}
	}
	//MasterList SOMEWHERE! for letters
	// H is = Hero

	

}
