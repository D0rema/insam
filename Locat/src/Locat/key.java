package Locat;

import java.awt.event.KeyEvent;

public class key {
	boolean keyUp = false; // Ű �Է¹޴°� �Է¹����� true�� �ٲ�
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean jump = false; // ���� ����

//	int jump_Time_Schedule = 0; // �ѹ��ٸ� �����ð���ŭ ���� �Ұ���

	public void keyProcess() {
		// ���⼭�� �ܼ� �ɸ��Ͱ� �̵��ϴ� ��ǥ ����
		// �ɸ����� ������ ���ι� ������ üũ �մϴ�.
		cat.playerMove = false;

		// up�� down�� ��ٸ������� ����ǵ���
		if (keyUp && cat.not_key != 1 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			cat.playerMove = true;
			cat.y -= 12;
			if (cat.y == Ladder.y_Upper - 12)
				Ladder.using_Ladder = false;
			cat.moveStatus = 0;
		}

		if (keyDown && cat.not_key != 2 && Ladder.on_Ladder_Flag) {
			Ladder.using_Ladder = true;
			if (cat.y < Ladder.y_Under)
				cat.y += 12;
			if (cat.y == Ladder.y_Under)
				Ladder.using_Ladder = false;
			cat.moveStatus = 0;
			cat.playerMove = true;
		}

		if (keyLeft && cat.not_key != 3 && !Ladder.using_Ladder) {
			cat.x -= 4;
			cat.moveStatus = 3;
			cat.playerMove = true;
		}

		if (keyRight && cat.not_key != 4 && !Ladder.using_Ladder) {
			cat.x += 4;
			cat.moveStatus = 1;
			cat.playerMove = true;
		}

		if (jump && !Ladder.on_Ladder_Flag) {

			// cat.moveStatus = 1;
			cat.playerMove = true;

			if (cat.cnt < cat.jp1) { // ī��Ʈ�� ������ jp1��ŭ�� �ð��� �ö�
				cat.y -= 12; // �ӵ��� ���Ҽ�����
			}
			if (cat.cnt > cat.jp1) { // �� �ö󰡸� �Ʒ� try_jump�� false��Ű�鼭 �߷� ����
				jump = false;
				cat.try_jump = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (cat.not_key != 3) {
				keyLeft = true;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (cat.not_key != 4) {
				keyRight = true;
			}
			break;
		case KeyEvent.VK_UP:
			if (cat.not_key != 1) {
				keyUp = true;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (cat.not_key != 2) {
				keyDown = true;
			}
			break;
		case KeyEvent.VK_SPACE:
			if (cat.cnt > cat.jp2) {
				cat.jp1 = cat.cnt + 12; // ����Ű�� ������ cnt�� 20�ö󰥸�ŭ �ö�
				cat.jp2 = cat.cnt + 40;// ���� �̻��
				cat.try_jump = true; // �߷��� �������Ŵ
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