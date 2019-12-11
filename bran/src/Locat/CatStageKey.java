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
		CatStage.playerMove = false;

		// up과 down은 사다리에서만 적용되도록
		if (keyUp && CatStage.not_key != 1 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			CatStage.playerMove = true;
			CatStage.y -= 12;
			if (CatStage.y == Ladder.y_Upper - 12)
				Ladder.using_Ladder = false;
			CatStage.moveStatus = 0;
		}

		if (keyDown && CatStage.not_key != 2 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			if (CatStage.y < Ladder.y_Under)
				CatStage.y += 12;
			if (CatStage.y == Ladder.y_Under)
				Ladder.using_Ladder = false;
			CatStage.moveStatus = 0;
			CatStage.playerMove = true;
		}

		if (keyLeft && CatStage.not_key != 3 && !Ladder.using_Ladder) {
			CatStage.x -= 4;
			CatStage.moveStatus = 3;
			CatStage.playerMove = true;
		}

		if (keyRight && CatStage.not_key != 4 && !Ladder.using_Ladder) {
			CatStage.x += 4;
			CatStage.moveStatus = 1;
			CatStage.playerMove = true;
		}

		if (jump && !Ladder.on_Ladder_Flag) {

			// CatStage.moveStatus = 1;
			CatStage.playerMove = true;

			if (CatStage.cnt < CatStage.jp1) { // 카운트가 지정된 jp1만큼의 시간만 올라감
				CatStage.y -= 12; // 속도를 정할수있음
			}
			if (CatStage.cnt > CatStage.jp1) { // 다 올라가면 아래 try_jump를 false시키면서 중력 적용
				jump = false;
				CatStage.try_jump = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (CatStage.not_key != 3) {
				keyLeft = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (CatStage.not_key != 4) {
				keyRight = true;
			}
			break;
		case KeyEvent.VK_UP:
			if (CatStage.not_key != 1) {
				keyUp = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (CatStage.not_key != 2) {
				keyDown = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			if (CatStage.cnt > CatStage.jp2) {
				CatStage.jp1 = CatStage.cnt + 8; // 점프키를 누르면 cnt가 20올라갈만큼 올라감
				CatStage.jp2 = CatStage.cnt + 40;// 현재 미사용
				CatStage.try_jump = true; // 중력을 미적용시킴
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