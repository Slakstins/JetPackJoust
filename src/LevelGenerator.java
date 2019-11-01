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
		

		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEDEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEETEEEEE\n");
		pw.append("EEEETEEEEEEEEREEEEE\n");
		pw.append("EEEEEEEEEEETTTEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEREEEEEEEEEEEEEEEE\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

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
		

		pw.append("EREEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEDEEEEEEEEE\n");
		pw.append("EEEEEDEEEEEEEEEREEE\n");
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEETEEEEE\n");
		pw.append("EEEETTTTEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEETTTEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEREEEEEEEEEEEEEEEE\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	
	

}
