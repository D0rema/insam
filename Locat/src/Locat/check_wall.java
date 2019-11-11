package Locat;

public class check_wall {
	int wall_count = 5;
	int wall[][] = new int[wall_count][4];
	int flat_count = 2;// 플랫의 갯수
	int flat[][] = new int[flat_count][4];// 플랫의 함수 [0] 발판의 시작x값 [1] 발판의 끝 x값 [2] 발판의 y값 [3] 우선 y값인데 미정 사라질수도 있음

	public int on_flat = 0;// 발판을 밟을때 ture가 되어 바닥이 발판의 y값으로 변함
	public int on_bottom = 0; // 기본적인 바닥 여기서는 468로 고정

	public int ff; // 현재 밟고 있는 발판의 y값을 지정하기 위해 필요한 함수

	public void check_wall() {
		is_bottom();
		in_flat();
		flat[0][0] = 200;// 현재 테스트 하기 위해 만든 발판
		flat[0][1] = 300;
		flat[0][2] = 388;
		flat[0][3] = 400;

		flat[1][0] = 400;
		flat[1][1] = 500;
		flat[1][2] = 228;
		flat[1][3] = 400;
	}

	public void is_bottom() { // 중력을 만들기 위한 함수
		if (on_flat == 0) { // 발판에 닿지 않을때는 항상 바닥은 468
			gameFrame.g_y = 468;
		}
		if (!gameFrame.try_jump) { // 점프할때는 중력 적용 x
			if (gameFrame.y >= gameFrame.g_y) { // g_y 발판일때 바뀔수 있기때문에 변수로 생성
				on_bottom = 1; // 캐릭터가 바닥에 닿았을때 1
			} else {
				on_bottom = 0;
			}
			if (on_bottom == 0) { // 바닥에 닿지 않았을때는 항상 떨어짐
				gameFrame.y += 16;
			}
		}
	}

	public void in_flat() { // 발판일때 체크하는 함수
		for (int i = 0; i < flat_count; i++) { // 모든 발판을 체크
			if (flat[i][0] < gameFrame.x && flat[i][1] > gameFrame.x && flat[i][2] == gameFrame.y) { // 현재 캐릭터의
																											// 좌표가 발판 좌표
																											// 안에 있는지 체크
																											// i로 모든 발판
																											// 체크

				on_flat = 1; // 발판 좌표 안에 있으면 발판을 밟고 있을때 1
				ff = i; // 그때의 값을 저장해 아래에 사용
				gameFrame.g_y = flat[ff][2]; // 현재 밝고있는 발판의 y값을 바닥으로 사용
			} else if (flat[ff][0] > gameFrame.x || flat[ff][1] < gameFrame.x) {
				on_flat = 0; // 현재(ff로 구분) 밟고 있는 발판의 x값에 벗어나면 발판을 밟고 있지 않은것으로 처리
			}
		}
	}

	public void on_wall() {
		if (gameFrame.y <= 48) {
			gameFrame.playerMove = false;
			gameFrame.not_key = 1;
		}
		if (gameFrame.y >= 484) {
			gameFrame.playerMove = false;
			gameFrame.not_key = 2;
		}

		if (gameFrame.x <= 24) {
			gameFrame.playerMove = false;
			gameFrame.not_key = 3;
		}

		if (gameFrame.x >= 596) {
			gameFrame.playerMove = false;
			gameFrame.not_key = 4;
		}
		if (gameFrame.y >= 48 && gameFrame.y <= 484 && gameFrame.x <= 596 && gameFrame.x >= 24) {
			gameFrame.not_key = 0;
		}

	}
}
