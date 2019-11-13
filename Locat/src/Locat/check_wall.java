package Locat;

public class check_wall {
	// int wall_count = 5;
	// int wall[][] = new int[wall_count][4];
	
	int flat_count = 9;// 플랫의 갯수
	int flat[][] = new int[flat_count][4];// 플랫의 함수 [0] 발판의 시작x값 [1] 발판의 끝 x값 [2] 발판의 y값 [3] 우선 y값인데 미정 사라질수도 있음

	public int on_flat = 0;// 발판을 밟을때 ture가 되어 바닥이 발판의 y값으로 변함
	public int on_bottom = 0; // 기본적인 바닥 여기서는 472로 고정

	public int ff; // 현재 밟고 있는 발판의 y값을 지정하기 위해 필요한 함수

	public check_wall() {
		flat[0][0] = 144;// 현재 테스트 하기 위해 만든 발판
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

	public void is_bottom() { // 중력을 만들기 위한 함수
		System.out.println(on_bottom);
		if (on_flat == 0) { // 발판에 닿지 않을때는 항상 바닥은 472
			
			cat.g_y = 472;
		}
		if (!cat.try_jump || Ladder.on_Ladder_Flag) { // 점프할때는 중력 적용 x
			if (cat.y >= cat.g_y) { // g_y 발판일때 바뀔수 있기때문에 변수로 생성
				on_bottom = 1; // 캐릭터가 바닥에 닿았을때 1
			} else if (cat.y < cat.g_y && Ladder.on_Ladder_Flag) {
				if(Ladder.using_Ladder)
				on_bottom = 1;
				else
					on_bottom = 0;
			} else {
				on_bottom = 0;
			}
			if (on_bottom == 0) { // 바닥에 닿지 않았을때는 항상 떨어짐
				Ladder.using_Ladder = false;
				cat.y += 12;
			}
		}
	}

	public void in_flat() {  // 발판일때 체크하는 함수
		for (int i = 0; i < flat_count; i++) {  // 모든 발판을 체크
			if (flat[i][0] < cat.x && flat[i][1] > cat.x && flat[i][2] == cat.y) { // 현재 캐릭터의
                // 좌표가 발판 좌표
                // 안에 있는지 체크
                // i로 모든 발판
                // 체크

				on_flat = 1;  // 발판 좌표 안에 있으면 발판을 밟고 있을때 1
				ff = i;  // 그때의 값을 저장해 아래에 사용
				cat.g_y = flat[ff][2]; // 현재 밝고있는 발판의 y값을 바닥으로 사용
			} else if (flat[ff][0] > cat.x || flat[ff][1] < cat.x) {
				on_flat = 0;// 현재(ff로 구분) 밟고 있는 발판의 x값에 벗어나면 발판을 밟고 있지 않은것으로 처리
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
