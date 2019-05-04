package input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputUtility {
	
	private static boolean space = false;
	private static boolean attack = false;

	public static boolean isSpace() {
		return space;
	}

	public static boolean isAttack() {
		return attack;
	}

	public static void setAttack(boolean attack) {
		InputUtility.attack = attack;
	}

	public static void setSpace(boolean space) {
		InputUtility.space = space;
	}
	
	public static void keyPressed(KeyEvent e) {
		if (e.getCode() == KeyCode.SPACE && space == false) {
			InputUtility.setSpace(true);
		}
		if(e.getCode() == KeyCode.A && attack == false) {
			InputUtility.setAttack(true);
		}
	}
	
	public static void keyRelease(KeyEvent e) {
		if (e.getCode() == KeyCode.SPACE) {
			InputUtility.setSpace(false);
		}
		if (e.getCode() == KeyCode.A) {
			InputUtility.setAttack(false);
		}
	}
}
