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
		pw.append("EHEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEDEEDEEE\n");
		pw.append("EEEEETTEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("TTTTTTTTTT\n");

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
		

		pw.append("EEEEEEEEET\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEETE\n");
		pw.append("EEEEHEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEDEE\n");
		pw.append("EEEEDTEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("EEEEEEEEEE\n");
		pw.append("TTTTTTTTTT\n");

		pw.close();
	}
	
	
	

}
