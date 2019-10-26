import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LevelGenerator {
	
	
	
	
	
	
	public void createLevel1Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEHEEEEEEE\n");

		pw.close();
	}
	
	
	

}
