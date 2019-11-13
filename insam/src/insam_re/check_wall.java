package insam_re;

public class check_wall {
	// int wall_count = 5;
	// int wall[][] = new int[wall_count][4];
	moving_test m1 = new moving_test();
	int flat_count = 9;// �÷��� ����
	int flat[][] = new int[flat_count][4];// �÷��� �Լ� [0] ������ ����x�� [1] ������ �� x�� [2] ������ y�� [3] �켱 y���ε� ���� ��������� ����

	public int on_flat = 0;// ������ ������ ture�� �Ǿ� �ٴ��� ������ y������ ����
	public int on_bottom = 0; // �⺻���� �ٴ� ���⼭�� 472�� ����

	public int ff; // ���� ��� �ִ� ������ y���� �����ϱ� ���� �ʿ��� �Լ�

	public check_wall() {
		flat[0][0] = 144;// ���� �׽�Ʈ �ϱ� ���� ���� ����
		flat[0][1] = 288;
		flat[0][2] = 316;
		flat[0][3] = 400;

		flat[1][0] = 0;
		flat[1][1] = 82;
		flat[1][2] = 220;
		flat[1][3] = 400;

		flat[2][0] = 68;
		flat[2][1] = 212;
		flat[2][2] = 448;
		flat[2][3] = 400;

		flat[3][0] = 144;
		flat[3][1] = 380;
		flat[3][2] = 148;
		flat[3][3] = 400;

		flat[4][0] = 270;
		flat[4][1] = 504;
		flat[4][2] = 28;
		flat[4][3] = 400;

		flat[5][0] = 532;
		flat[5][1] = 750;
		flat[5][2] = 112;
		flat[5][3] = 400;

		flat[6][0] = 404;
		flat[6][1] = 504;
		flat[6][2] = 244;
		flat[6][3] = 400;

		flat[7][0] = 552;
		flat[7][1] = 604;
		flat[7][2] = 304;
		flat[7][3] = 400;

		flat[8][0] = 664;
		flat[8][1] = 750;
		flat[8][2] = 328;
		flat[8][3] = 400;
	}

	public void wall_Check() {
		is_bottom();
		in_flat();
	}

	public void is_bottom() { // �߷��� ����� ���� �Լ�
		System.out.println(on_bottom);
		if (on_flat == 0) { // ���ǿ� ���� �������� �׻� �ٴ��� 472

			moving_test.g_y = 472;
		}
		if (!moving_test.try_jump || Ladder.on_Ladder_Flag) { // �����Ҷ��� �߷� ���� x
			if (moving_test.y >= moving_test.g_y) { // g_y �����϶� �ٲ�� �ֱ⶧���� ������ ����
				on_bottom = 1; // ĳ���Ͱ� �ٴڿ� ������� 1
			} else if (moving_test.y < moving_test.g_y && Ladder.on_Ladder_Flag) {
				if(Ladder.using_Ladder)
				on_bottom = 1;
				else
					on_bottom = 0;
			} else {
				on_bottom = 0;
			}
			if (on_bottom == 0) { // �ٴڿ� ���� �ʾ������� �׻� ������
				Ladder.using_Ladder = false;
				moving_test.y += 12;
			}
		}
	}

	public void in_flat() { // �����϶� üũ�ϴ� �Լ�
		for (int i = 0; i < flat_count; i++) { // ��� ������ üũ
			if (flat[i][0] < moving_test.x && flat[i][1] > moving_test.x && flat[i][2] == moving_test.y) { // ���� ĳ������
																											// ��ǥ�� ���� ��ǥ
																											// �ȿ� �ִ��� üũ
																											// i�� ��� ����
																											// üũ

				on_flat = 1; // ���� ��ǥ �ȿ� ������ ������ ��� ������ 1
				ff = i; // �׶��� ���� ������ �Ʒ��� ���
				moving_test.g_y = flat[ff][2]; // ���� ����ִ� ������ y���� �ٴ����� ���
			} else if (flat[ff][0] > moving_test.x || flat[ff][1] < moving_test.x) {
				on_flat = 0; // ����(ff�� ����) ��� �ִ� ������ x���� ����� ������ ��� ���� ���������� ó��
			}
		}
	}

	public void on_wall() {
		if (moving_test.y <= 0) {
			moving_test.playerMove = false;
			moving_test.not_key = 1;
		}
		if (moving_test.y >= 472) {
			moving_test.playerMove = false;
			moving_test.not_key = 2;
		}

		if (moving_test.x <= 16) {
			moving_test.playerMove = false;
			moving_test.not_key = 3;
		}

		if (moving_test.x >= 744) {
			moving_test.playerMove = false;
			moving_test.not_key = 4;
		}
		if (moving_test.y >= 48 && moving_test.y <= 484 && moving_test.x <= 744 && moving_test.x >= 16) {
			moving_test.not_key = 0;
		}

	}
}
