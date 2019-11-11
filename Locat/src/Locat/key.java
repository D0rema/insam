package Locat;

import java.awt.event.KeyEvent;

public class key {
	boolean keyUp = false; // 키 입력받는거 입력받으면 true로 바뀜
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean jump = false; // 여기 까지

	public void keyProcess() {
//여기서는 단순 케릭터가 이동하는 좌표 말고도
//케릭터의 움직임 여부및 방향을 체크 합니다.
		gameFrame.playerMove = false;

		if (keyUp && gameFrame.not_key != 1) {
			gameFrame.playerMove = true;
			gameFrame.y -= 4;
			gameFrame.moveStatus = 0;
		}

		if (keyDown && gameFrame.not_key != 2) {
			gameFrame.y += 4;
			gameFrame.moveStatus = 2;
			gameFrame.playerMove = true;
		}

		if (keyLeft && gameFrame.not_key != 3) {
			gameFrame.x -= 4;
			gameFrame.moveStatus = 3;
			gameFrame.playerMove = true;
		}

		if (keyRight && gameFrame.not_key != 4) {
			gameFrame.x += 4;
			gameFrame.moveStatus = 1;
			gameFrame.playerMove = true;
		}

		if (jump) {

			gameFrame.moveStatus = 1;
			gameFrame.playerMove = true;

			if (gameFrame.cnt < gameFrame.jp1) { // 카운트가 지정된 jp1만큼의 시간만 올라감
				gameFrame.y -= 16; // 속도를 정할수있음
			}
			if (gameFrame.cnt > gameFrame.jp1) { // 다 올라가면 아래 try_jump를 false시키면서 중력 적용
				jump = false;
				gameFrame.try_jump = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (gameFrame.not_key != 3) {
				keyLeft = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (gameFrame.not_key != 4) {
				keyRight = true;
			}
			break;
		case KeyEvent.VK_UP:
			if (gameFrame.not_key != 1) {
				keyUp = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (gameFrame.not_key != 2) {
				keyDown = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			gameFrame.jp1 = gameFrame.cnt + 20; // 점프키를 누르면 cnt가 20올라갈만큼 올라감
			gameFrame.jp2 = gameFrame.cnt + 40;// 현재 미사용
			gameFrame.try_jump = true; // 중력을 미적용시킴
			jump = true;
			break;
		}
	}

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
			// jump = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}