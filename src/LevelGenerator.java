import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LevelGenerator {

	// List of letters corresponding to mobs:
	// T = tile
	// F = floating tile
	// - = empty
	// H = hero
	// D = diver
	// C = chicken
	// R = ranger
	// J = jumper
	// P = teleporter
	// M = multiplier
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
		createWinScreen();

	}

	public void createGameOverScript() {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level-1.txt");
		} catch (FileNotFoundException e) {
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
			pw = new PrintWriter("./levels/level0.txt");
		} catch (FileNotFoundException e) {
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
			pw = new PrintWriter("./levels/level1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------P-----\n");
		pw.append("-------FFF---------\n");
		pw.append("-------------------\n");
		pw.append("---------H---------\n");
		pw.append("----F---FFFF-------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("---D---------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel2Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-----R-------F-----\n");
		pw.append("----FFFF----H------\n");
		pw.append("-----------FFF-----\n");
		pw.append("-------------------\n");
		pw.append("--D----------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel3Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("------------R------\n");
		pw.append("-----------FFF-----\n");
		pw.append("--R--FFF-----------\n");
		pw.append("FFFF-------FFF-----\n");
		pw.append("-------------------\n");
		pw.append("-D------H---------D\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel4Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level4.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("------------D------\n");
		pw.append("---FRF-------------\n");
		pw.append("----F------------D-\n");
		pw.append("--FF---------------\n");
		pw.append("--------H----------\n");
		pw.append("-------FFFF--------\n");
		pw.append("---------------D---\n");
		pw.append("-----------FFF-----\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel5Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level5.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-----R-------------\n");
		pw.append("-----F-----R-------\n");
		pw.append("-----------F-------\n");
		pw.append("---R------------D--\n");
		pw.append("---F---------------\n");
		pw.append("-------------------\n");
		pw.append("-D---------------R-\n");
		pw.append("-----------------F-\n");
		pw.append("---------H----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel6Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level6.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("----------------R--\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("-------P----R------\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("-----D----------P--\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("---------H---------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel7Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level7.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("--R------------P---\n");
		pw.append("--F-------FF-------\n");
		pw.append("----P--------------\n");
		pw.append("--------------D----\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-----H-------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel8Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level8.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("----FRF------------\n");
		pw.append("-----F-D-----------\n");
		pw.append("----------FFF------\n");
		pw.append("-------------------\n");
		pw.append("------------H------\n");
		pw.append("-----------FFF-----\n");
		pw.append("-----D-------------\n");
		pw.append("-------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel9Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level9.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("------D------------\n");
		pw.append("--------------R----\n");
		pw.append("--D------R---FFFFFF\n");
		pw.append("---------F---------\n");
		pw.append("----------F------P-\n");
		pw.append("------------F------\n");
		pw.append("--R----------------\n");
		pw.append("--FFFF-------------\n");
		pw.append("-----------H-------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel10Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level10.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("---------H---------\n");
		pw.append("--------FFFF--M----\n");
		pw.append("---M---------------\n");
		pw.append("-------------------\n");
		pw.append("-----------M-------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("--M----------------\n");
		pw.append("------------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel11Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level11.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("---FFF---------J---\n");
		pw.append("--------------FFFF-\n");
		pw.append("-----FFF----J------\n");
		pw.append("-----------FFF-----\n");
		pw.append("------J---------FF-\n");
		pw.append("-----FFF-----------\n");
		pw.append("--J---------H------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel12Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level12.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("--------M----------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-R--R-------R--R---\n");
		pw.append("FFFFFFFF--FFFFFFFFF\n");
		pw.append("---------------H---\n");
		pw.append("--------------FF---\n");
		pw.append("----M--------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel13Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level13.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("-------------------\n");
		pw.append("-------J-----------\n");
		pw.append("------FFF----------\n");
		pw.append("-------------------\n");
		pw.append("------------J------\n");
		pw.append("-FFF-FFF----FFF-FFF\n");
		pw.append("----F----------F---\n");
		pw.append("---DD----H-----DD--\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel14Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level14.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("---D--------D------\n");
		pw.append("-------------------\n");
		pw.append("----J---------P----\n");
		pw.append("---FFF-------------\n");
		pw.append("-P------P----------\n");
		pw.append("--------------J----\n");
		pw.append("----J--------FFF---\n");
		pw.append("---FFF-------------\n");
		pw.append("----------H--------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel15Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level15.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-----------M-------\n");
		pw.append("F------FFF---------\n");
		pw.append("---FFF----FFFFFF--F\n");
		pw.append("F------------------\n");
		pw.append("----FFFFF----------\n");
		pw.append("-------------------\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("-------------------\n");
		pw.append("-J--J-J--H---J-J-J-\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel16Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level16.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("---M---------------\n");
		pw.append("-------R-----------\n");
		pw.append("-----FFFFF---------\n");
		pw.append("---------D-----J---\n");
		pw.append("--------------FFFFF\n");
		pw.append("--H----------------\n");
		pw.append("-FFFFF-------------\n");
		pw.append("----------------J--\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel17Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level17.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("----D----D-----D---\n");
		pw.append("-R-----R-----R-----\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("---D-------D---D---\n");
		pw.append("-R------R----R-----\n");
		pw.append("FFFFFFFFFFFFFFFFFFF\n");
		pw.append("-------------------\n");
		pw.append("------H------------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel18Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level18.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("----R-------R------\n");
		pw.append("----F-------F------\n");
		pw.append("--RF-FR---RF-FR----\n");
		pw.append("--F---F---F---F-----\n");
		pw.append("RF-----FRF-----FR--\n");
		pw.append("F-------F-------F--\n");
		pw.append("-----------------FR\n");
		pw.append("F-----------------F\n");
		pw.append("--------H----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createLevel19Script() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level19.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("-------------------\n");
		pw.append("---------H---------\n");
		pw.append("--------FFF--------\n");
		pw.append("-FFF---------------\n");
		pw.append("--------------FFF--\n");
		pw.append("--FFF--------------\n");
		pw.append("---------------FFF-\n");
		pw.append("F--F-------FFF-----\n");
		pw.append("--------C----------\n");
		pw.append("TTTTTTTTTTTTTTTTTTT\n");

		pw.close();
	}

	public void createWinScreen() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("./levels/level20.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		pw.append("--T---T------------\n");
		pw.append("---T-T-TTT-T-T-----\n");
		pw.append("----T--T-T-T-T-----\n");
		pw.append("----T--TTT-TTT-----\n");
		pw.append("--------H----------\n");
		pw.append("--T-T-T-T-TTT------\n");
		pw.append("--T-T-T-T-T-T------\n");
		pw.append("--TTTTT-T-T-T------\n");
		pw.append("-------------------\n");
		pw.append("-------------------\n");

		pw.close();
	}

}
