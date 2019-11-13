package Locat;

public class check_wall {
	// int wall_count = 5;
	// int wall[][] = new int[wall_count][4];
	
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

			cat.g_y = 472;
		}
		if (!cat.try_jump || Ladder.on_Ladder_Flag) { // �����Ҷ��� �߷� ���� x
			if (cat.y >= cat.g_y) { // g_y �����϶� �ٲ�� �ֱ⶧���� ������ ����
				on_bottom = 1; // ĳ���Ͱ� �ٴڿ� ������� 1
			} else if (cat.y < cat.g_y && Ladder.on_Ladder_Flag) {
				if(Ladder.using_Ladder)
				on_bottom = 1;
				else
					on_bottom = 0;
			} else {
				on_bottom = 0;
			}
			if (on_bottom == 0) { // �ٴڿ� ���� �ʾ������� �׻� ������
				Ladder.using_Ladder = false;
				cat.y += 12;
			}
		}
	}

	public void in_flat() { // �����϶� üũ�ϴ� �Լ�
		for (int i = 0; i < flat_count; i++) { // ��� ������ üũ
			if (flat[i][0] < cat.x && flat[i][1] > cat.x && flat[i][2] == cat.y) { // ���� ĳ������
																											// ��ǥ�� ���� ��ǥ
																											// �ȿ� �ִ��� üũ
																											// i�� ��� ����
																											// üũ

				on_flat = 1; // ���� ��ǥ �ȿ� ������ ������ ��� ������ 1
				ff = i; // �׶��� ���� ������ �Ʒ��� ���
				cat.g_y = flat[ff][2]; // ���� ����ִ� ������ y���� �ٴ����� ���
			} else if (flat[ff][0] > cat.x || flat[ff][1] < cat.x) {
				on_flat = 0; // ����(ff�� ����) ��� �ִ� ������ x���� ����� ������ ��� ���� ���������� ó��
			}
		}
	}

	public void on_wall() {
		if (cat.y <= 0) {
			cat.playerMove = false;
			cat.not_key = 1;
		}
		if (cat.y >= 472) {
			cat.playerMove = false;
			cat.not_key = 2;
		}

		if (cat.x <= 16) {
			cat.playerMove = false;
			cat.not_key = 3;
		}

		if (cat.x >= 744) {
			cat.playerMove = false;
			cat.not_key = 4;
		}
		if (cat.y >= 48 && cat.y <= 484 && cat.x <= 744 && cat.x >= 16) {
			cat.not_key = 0;
		}

	}
}
