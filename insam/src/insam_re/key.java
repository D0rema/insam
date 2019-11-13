package insam_re;

import java.awt.event.KeyEvent;

public class key {
	boolean keyUp = false; // 키 입력받는거 입력받으면 true로 바뀜
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean jump = false; // 여기 까지

//	int jump_Time_Schedule = 0; // 한번뛰면 일정시간만큼 점프 불가능

	private moving_test moving_test = null;

	public void keyProcess() {
		// 여기서는 단순 케릭터가 이동하는 좌표 말고도
		// 케릭터의 움직임 여부및 방향을 체크 합니다.
		moving_test.playerMove = false;

		// up과 down은 사다리에서만 적용되도록
		if (keyUp && moving_test.not_key != 1 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			moving_test.playerMove = true;
			moving_test.y -= 12;
			if (moving_test.y == Ladder.y_Upper - 12)
				Ladder.using_Ladder = false;
			moving_test.moveStatus = 0;
		}

		if (keyDown && moving_test.not_key != 2 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			if (moving_test.y < Ladder.y_Under)
				moving_test.y += 12;
			if (moving_test.y == Ladder.y_Under)
				Ladder.using_Ladder = false;
			moving_test.moveStatus = 0;
			moving_test.playerMove = true;
		}

		if (keyLeft && moving_test.not_key != 3 && !Ladder.using_Ladder) {
			moving_test.x -= 4;
			moving_test.moveStatus = 3;
			moving_test.playerMove = true;
		}

		if (keyRight && moving_test.not_key != 4 && !Ladder.using_Ladder) {
			moving_test.x += 4;
			moving_test.moveStatus = 1;
			moving_test.playerMove = true;
		}

		if (jump && !Ladder.on_Ladder_Flag) {

			// moving_test.moveStatus = 1;
			moving_test.playerMove = true;

			if (moving_test.cnt < moving_test.jp1) { // 카운트가 지정된 jp1만큼의 시간만 올라감
				moving_test.y -= 12; // 속도를 정할수있음
			}
			if (moving_test.cnt > moving_test.jp1) { // 다 올라가면 아래 try_jump를 false시키면서 중력 적용
				jump = false;
				moving_test.try_jump = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (moving_test.not_key != 3) {
				keyLeft = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (moving_test.not_key != 4) {
				keyRight = true;
			}
			break;
		case KeyEvent.VK_UP:
			if (moving_test.not_key != 1) {
				keyUp = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (moving_test.not_key != 2) {
				keyDown = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			if (moving_test.cnt > moving_test.jp2) {
				moving_test.jp1 = moving_test.cnt + 12; // 점프키를 누르면 cnt가 20올라갈만큼 올라감
				moving_test.jp2 = moving_test.cnt + 40;// 현재 미사용
				moving_test.try_jump = true; // 중력을 미적용시킴
				jump = true;
				break;
			}
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