import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LevelGenerator {
	
	//List of letters corresponding to mobs:
	// T = tile
	// - = empty
	// H = hero
	// D = diver
	// C = chicken
	// R = ranger
	// J = jumper
	// P = teleporter
	// M = multiplyer
	//
	//
	//
	//
	
	
	
	
	
	public void createLevels() {
		createGameOverScript();
		createLevel1Script();
		createLevel2Script();
		createLevel3Script();
		createLevel4Script();
		createLevel5Script();
		createLevel6Script();
		createLevel7Script();
		createLevel8Script();
		createLevel9Script();
		createLevel10Script();
		createLevel11Script();
		createLevel12Script();
		createLevel13Script();
		createLevel14Script();
		createLevel15Script();
		createLevel16Script();

		createLevel17Script();

		createLevel18Script();

		createLevel19Script();
		createLevel20Script();


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
		

		pw.append("T---T--------------\n");
		pw.append("-T-T--TTT--T-T-----\n");
		pw.append("--T---T-T--T-T-----\n");
		pw.append("--T---TTT--TTT-----\n");
		pw.append("T-------------TTT--\n");
		pw.append("T---TTT-TTT--T-----\n");
		pw.append("T---T-T---T--TTT---\n");
		pw.append("TTT-TTT-TTT--T-----\n");
		pw.append("-------------TTT---\n");
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
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");

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
		

		pw.append("-------------------\n");
		pw.append("-------------P-----\n");
		pw.append("-------TTT---------\n");
		pw.append("-------------------\n");
		pw.append("---------H---------\n");
		pw.append("----T---TTTT-------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("---D---------------\n");
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
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-----R-------T-----\n");
		pw.append("----TTTT----H------\n");
		pw.append("-----------TTT-----\n");
		pw.append("-------------------\n");
		pw.append("--D----------------\n");
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
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("------------R------\n");
		pw.append("-----------TTT-----\n");
		pw.append("--R--TTT-----------\n");
		pw.append("TTTT-------TTT-----\n");
		pw.append("-------------------\n");
		pw.append("-D------H---------D\n");
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
		

		pw.append("-----R------D------\n");
		pw.append("---TTT-------------\n");
		pw.append("-----------------D-\n");
		pw.append("--T----------------\n");
		pw.append("--------H----------\n");
		pw.append("-------TTTT--------\n");
		pw.append("---------------D---\n");
		pw.append("-----------TTT-----\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel5Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level5.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-----R-------------\n");
		pw.append("-----T-----R-------\n");
		pw.append("-----------T-------\n");
		pw.append("---R------------D--\n");
		pw.append("---T---------------\n");
		pw.append("-------------------\n");
		pw.append("-D---------------R-\n");
		pw.append("-----------------T-\n");
		pw.append("---------H----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel6Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level6.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("-------P-----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("----------------P--\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("---------H---------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel7Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level7.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("--R------------P---\n");
		pw.append("--T-------TT-------\n");
		pw.append("----P--------------\n");
		pw.append("--------------D----\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-----H-------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel8Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level8.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("----TTTT------------\n");
		pw.append("-------C---------C-\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("------------H------\n");
		pw.append("-----------TTT-----\n");
		pw.append("-----C-------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel9Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level9.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("------D------------\n");
		pw.append("--------------R----\n");
		pw.append("--C------R---TTTTTT\n");
		pw.append("---------T---------\n");
		pw.append("----------T------P-\n");
		pw.append("------------T------\n");
		pw.append("--R----------------\n");
		pw.append("--TTTT-------------\n");
		pw.append("-----------H-------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel10Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level10.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("----C--------------\n");
		pw.append("-R-----R-----R-----\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("---C-------C-------\n");
		pw.append("-R------R----R-----\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("-------------------\n");
		pw.append("------H------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel11Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level11.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("---------H----------\n");
		pw.append("--------TTTT--M-----\n");
		pw.append("---M---------------\n");
		pw.append("-------------------\n");
		pw.append("-----------M-------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("--M----------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel12Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level12.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("---TTT---------J---\n");
		pw.append("--------------TTTTT-\n");
		pw.append("-----TTT----J------\n");
		pw.append("-----------TTT-----\n");
		pw.append("------J---------TT-\n");
		pw.append("-----TTT-----------\n");
		pw.append("--J---------H------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel13Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level13.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("--------M----------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-R--R-------R--R---\n");
		pw.append("TTTTTTTT--TTTTTTTTT\n");
		pw.append("---------------H---\n");
		pw.append("--------------TT---\n");
		pw.append("----M--------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel14Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level14.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------J-----------\n");
		pw.append("------TTT----------\n");
		pw.append("-------------------\n");
		pw.append("------------J------\n");
		pw.append("-TTT-TTT----TTT-TTT\n");
		pw.append("----T----------T---\n");
		pw.append("---CC----H-----CC--\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	public void createLevel15Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level15.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("---C--------C------\n");
		pw.append("-------------------\n");
		pw.append("----J---------P----\n");
		pw.append("---TTT-------------\n");
		pw.append("-P------P----------\n");
		pw.append("--------------J----\n");
		pw.append("----J--------TTT---\n");
		pw.append("---TTT-------------\n");
		pw.append("----------H--------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	public void createLevel16Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level16.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("T------TTT---------\n");
		pw.append("---TTT----TTTTTT--T\n");
		pw.append("T------------------\n");
		pw.append("----TTTTT----------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");
		pw.append("-------------------\n");
		pw.append("-J--J-J--H---J-J-J-\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	public void createLevel17Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level17.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel18Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level18.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	public void createLevel19Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level19.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	public void createLevel20Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("level20.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		

		pw.append("----R-------R------\n");
		pw.append("---RTR-----RTR-----\n");
		pw.append("--RT-TR---RT-TR----\n");
		pw.append("-RT---TR-RT---TR----\n");
		pw.append("RT-----TRT-----TR--\n");
		pw.append("T-------T-------TR-\n");
		pw.append("-----------------TR\n");
		pw.append("T-----------------T\n");
		pw.append("--------H----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}
	
	
	

}
