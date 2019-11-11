import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LevelGenerator {
	
	public void createLevels() {
		createGameOverScript();
		createLevel1Script();
		createLevel2Script();
		createLevel3Script();
		createLevel4Script();
	}
	public void createGameOverScript() {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level-1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("TEEETEEEEEEEEEEEEEE\n");
		pw.append("ETETEETTTEETETEEEEE\n");
		pw.append("EETEEETETEETETEEEEE\n");
		pw.append("EETEEETTTEETTTEEEEE\n");
		pw.append("TEEEEEEEEEEEEETTTEE\n");
		pw.append("TEEETTTETTTEETEEEEE\n");
		pw.append("TEEETETEEETEETTTEEE\n");
		pw.append("TTTETTTETTTEETEEEEE\n");
		pw.append("EEEEEEEEEEEEETTTEEE\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel0Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level0.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");

		pw.close();
	}
	
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
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("EEEEEEETTTEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEPEEEEEREEEEEEED\n");
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
		

		pw.append("EEEEDEEEEDEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("EEEEEREEEEEEETEEEEE\n");
		pw.append("EEEETTTTEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEETTTEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel3Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level3.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEEEEEEEEEE\n");
		pw.append("EEEEEEEEEEETTTEEEEE\n");
		pw.append("EEETTTTTEEEEEEEEEEE\n");
		pw.append("TTTTEEEEEEETTTEEEEE\n");
		pw.append("TEEEEEEEEEEEEEEEEEE\n");
		pw.append("TEEEEEEEHEEEEEEEEER\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel4Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level4.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("EEEEREEEEEEEREEEEEE\n");
		pw.append("EEERTREEEEERTREEEEE\n");
		pw.append("EERTETREEERTETREEEE\n");
		pw.append("ERTEEETRERTEEETREEEE\n");
		pw.append("RTEEEEETRTEEEEETREE\n");
		pw.append("TEEEEEEETEEEEEEETRE\n");
		pw.append("EEEEEEEEEEEEEEEEETR\n");
		pw.append("TEEEEEEEEEEEEEEEEET\n");
		pw.append("EEEEEEEEHEEEEEEEEEE\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	
	

}
