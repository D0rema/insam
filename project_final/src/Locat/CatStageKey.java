package Locat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CatStageKey implements KeyListener {
	static boolean keyUp = false; // 키 입력받는거 입력받으면 true로 바뀜
	static boolean keyDown = false;
	static boolean keyLeft = false;
	static boolean keyRight = false;
	static boolean jump = false; // 여기 까지

	// int jump_Time_Schedule = 0; // 한번뛰면 일정시간만큼 점프 불가능

	/**
	 * Key Calibration
	 * 
	 * @author JiSeongChoi
	 */
	public static void keyProcess() {
		// 여기서는 단순 케릭터가 이동하는 좌표 말고도
		// 케릭터의 움직임 여부및 방향을 체크 합니다.
		Stage.playerMove = false;

		// up과 down은 사다리에서만 적용되도록
		if (keyUp && Stage.not_key != 1 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			Stage.playerMove = true;
			Stage.y -= 12;
			if (Stage.y == Ladder.y_Upper - 12)
				Ladder.using_Ladder = false;
			Stage.moveStatus = 0;
		}

		if (keyDown && Stage.not_key != 2 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			if (Stage.y < Ladder.y_Under)
				Stage.y += 12;
			if (Stage.y == Ladder.y_Under)
				Ladder.using_Ladder = false;
			Stage.moveStatus = 0;
			Stage.playerMove = true;
		}

		if (keyLeft && Stage.not_key != 3 && !Ladder.using_Ladder) {
			Stage.x -= 4;
			Stage.moveStatus = 3;
			Stage.playerMove = true;
		}

		if (keyRight && Stage.not_key != 4 && !Ladder.using_Ladder) {
			Stage.x += 4;
			Stage.moveStatus = 1;
			Stage.playerMove = true;
		}

		if (jump && !Ladder.on_Ladder_Flag) {

			// CatStage.moveStatus = 1;
			Stage.playerMove = true;

			if (Stage.cnt < Stage.jp1) { // 카운트가 지정된 jp1만큼의 시간만 올라감
				Stage.y -= 12; // 속도를 정할수있음
			}
			if (Stage.cnt > Stage.jp1) { // 다 올라가면 아래 try_jump를 false시키면서 중력 적용
				jump = false;
				Stage.try_jump = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (Stage.not_key != 3) {
				keyLeft = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (Stage.not_key != 4) {
				keyRight = true;
			}
			break;
		case KeyEvent.VK_UP:
			if (Stage.not_key != 1) {
				keyUp = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (Stage.not_key != 2) {
				keyDown = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			if (Stage.cnt > Stage.jp2) {
				Stage.jp1 = Stage.cnt + 8; // 점프키를 누르면 cnt가 20올라갈만큼 올라감
				Stage.jp2 = Stage.cnt + 40;// 현재 미사용
				Stage.try_jump = true; // 중력을 미적용시킴
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