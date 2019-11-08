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
		

		pw.append("EEEEDEEEEEEEDEEEEEE\n");
		pw.append("EEEEEEEEHEEEEEDEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEESEEEEE\n");
		pw.append("EEEETEEETTTTEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
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
		

		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEETEEEEE\n");
		pw.append("EEEETTTTEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEETTTEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("RRRRRRRRRRRRRRRRRRR\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	
	

}
