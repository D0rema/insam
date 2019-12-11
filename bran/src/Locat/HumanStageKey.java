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

		CatStage.playerMove = false;

		if (keyUp && CatStage.notUp != 1) {
			CatStage.playerMove = true;
			CatStage.y -= 4;
			CatStage.moveStatus = 0;
		}

		if (keyDown && CatStage.notDown != 1) {
			CatStage.y += 4;
			CatStage.moveStatus = 2;
			CatStage.playerMove = true;
		}

		if (keyLeft && CatStage.notLeft != 1) {
			CatStage.x -= 4;
			CatStage.moveStatus = 3;
			CatStage.playerMove = true;
		}

		if (keyRight && CatStage.notRight != 1) {
			CatStage.x += 4;
			CatStage.moveStatus = 1;
			CatStage.playerMove = true;
		}

	}

	/**
	 * This function sets the variables required when a key is pressed.
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if(CatStage.sliding) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (CatStage.notLeft != 1) {
					keyLeft = true;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (CatStage.notRight != 1) {
					keyRight = true;
				}
				break;
			case KeyEvent.VK_UP:
				if (CatStage.notUp != 1) {
					keyUp = true;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (CatStage.notDown != 1) {
					keyDown = true;
				}
				break;
			case KeyEvent.VK_SPACE:
				CatStage.reset = true;
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
			CatStage.reset = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
