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
		

		pw.append("HEEHEEEHEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EHEEEEHEEE\n");
		pw.append("EEEEHEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEHEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEHEEEEEEE\n");
		pw.append("EEEEEEEEHE\n");
		pw.append("HEEEEEEEEE\n");

		pw.close();
	}
	
	public void createLevel2Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("HHHHHHHHHH\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EHEEEEHEEE\n");
		pw.append("EEEEHEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEHEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEHEEEEEEE\n");
		pw.append("EEEEEEEEHE\n");
		pw.append("HEEEEEEEEE\n");

		pw.close();
	}
	
	
	

}
