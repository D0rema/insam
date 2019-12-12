package Locat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author chlau This class handles everything about keystrokes.
 */
public class HumanStageKey implements KeyListener {
	static boolean keyUp = false; // 키 입력받는거 입력받으면 true로 바뀜
	static boolean keyDown = false;
	static boolean keyLeft = false;
	static boolean keyRight = false;

	/**
	 * Sets a variable according to key input.
	 */
	public static void keyProcess() {

		Stage.playerMove = false;

		if (keyUp && Stage.notUp != 1) {
			Stage.playerMove = true;
			Stage.y -= 4;
			Stage.moveStatus = 0;
		}

		if (keyDown && Stage.notDown != 1) {
			Stage.y += 4;
			Stage.moveStatus = 2;
			Stage.playerMove = true;
		}

		if (keyLeft && Stage.notLeft != 1) {
			Stage.x -= 4;
			Stage.moveStatus = 3;
			Stage.playerMove = true;
		}

		if (keyRight && Stage.notRight != 1) {
			Stage.x += 4;
			Stage.moveStatus = 1;
			Stage.playerMove = true;
		}

	}

	/**
	 * This function sets the variables required when a key is pressed.
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if(Stage.sliding) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (Stage.notLeft != 1) {
					keyLeft = true;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (Stage.notRight != 1) {
					keyRight = true;
				}
				break;
			case KeyEvent.VK_UP:
				if (Stage.notUp != 1) {
					keyUp = true;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (Stage.notDown != 1) {
					keyDown = true;
				}
				break;
			case KeyEvent.VK_SPACE:
				Stage.reset = true;
				break;
			}
		}
	}

	/**
	 * This function sets the variables required when a key is Released.
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:		
				keyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
				keyRight = false;
			break;
		case KeyEvent.VK_UP:
				keyUp = false;
			break;
		case KeyEvent.VK_DOWN:
				keyDown = false;
			break;
		case KeyEvent.VK_SPACE:
			Stage.reset = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
