package Locat;

/**
 * class to check block and if character leaves map
 *
 * @author JiSeongChoi
 */
public class Block {
	// int wall_count = 5;
	// int wall[][] = new int[wall_count][4];
	/** total of blocks */
	int block_Count = 9;// 플랫의 갯수
	/** blockArray */
	int blocks[][] = new int[block_Count][4];// 플랫의 함수 [0] 발판의 시작x값 [1] 발판의 끝 x값 [2] 발판의 y값 [3] 우선 y값인데 미정 사라질수도 있음

	/** variable for checking if character is floating air */
	public int on_block = 0;// 발판을 밟을때 ture가 되어 바닥이 발판의 y값으로 변함
	/** variable for checking if character is on block */
	public int on_bottom = 0; // 기본적인 바닥 여기서는 472로 고정
	/** current block */
	public int currentBlock; // 현재 밟고 있는 발판의 y값을 지정하기 위해 필요한 함수

	/**
	 * set position of blocks
	 * 
	 * @author JiSeongChoi
	 */
	public Block() {
		blocks[0][0] = 144;// 현재 테스트 하기 위해 만든 발판
		blocks[0][1] = 288;
		blocks[0][2] = 316;
		blocks[0][3] = 400;

		blocks[1][0] = 0;
		blocks[1][1] = 82;
		blocks[1][2] = 220;
		blocks[1][3] = 400;

		blocks[2][0] = 68;
		blocks[2][1] = 212;
		blocks[2][2] = 448;
		blocks[2][3] = 400;

		blocks[3][0] = 144;
		blocks[3][1] = 380;
		blocks[3][2] = 148;
		blocks[3][3] = 400;

		blocks[4][0] = 270;
		blocks[4][1] = 504;
		blocks[4][2] = 28;
		blocks[4][3] = 400;

		blocks[5][0] = 532;
		blocks[5][1] = 750;
		blocks[5][2] = 112;
		blocks[5][3] = 400;

		blocks[6][0] = 404;
		blocks[6][1] = 504;
		blocks[6][2] = 244;
		blocks[6][3] = 400;

		blocks[7][0] = 552;
		blocks[7][1] = 604;
		blocks[7][2] = 304;
		blocks[7][3] = 400;

		blocks[8][0] = 664;
		blocks[8][1] = 750;
		blocks[8][2] = 328;
		blocks[8][3] = 400;
		}

	/**
	 * check if character is floating air
	 * 
	 * @author JiSeongChoi
	 */
	public void check() {
		is_bottom();
		on_Block();
	}

	/**
	 * check if gravity is needed
	 * 
	 * @author JiSeongChoi
	 */
	public void is_bottom() { // 중력을 만들기 위한 함수
		if (on_block == 0) { // 발판에 닿지 않을때는 항상 바닥은 472
			CatStage.g_y = 520;
		}
		if (!CatStage.try_jump || Ladder.on_Ladder_Flag) { // 점프할때는 중력 적용 x
			if (CatStage.y >= CatStage.g_y) { // g_y 발판일때 바뀔수 있기때문에 변수로 생성
				on_bottom = 1; // 캐릭터가 바닥에 닿았을때 1
			} else if (CatStage.y < CatStage.g_y && Ladder.on_Ladder_Flag) {
				if(Ladder.using_Ladder)
				on_bottom = 1;
				else
					on_bottom = 0;
			} else {
				on_bottom = 0;
			}
			if (on_bottom == 0) { // 바닥에 닿지 않았을때는 항상 떨어짐
				Ladder.using_Ladder = false;
				CatStage.y += 12;
			}
		}
	}

	/**
	 * check if character is on blocks 
	 * 
	 * @author JiSeongChoi
	 */
	public void on_Block() {  // 발판일때 체크하는 함수
		for (int i = 0; i < block_Count; i++) {  // 모든 발판을 체크
			if (blocks[i][0] < CatStage.x && blocks[i][1] > CatStage.x && blocks[i][2] == CatStage.y) { // 현재 캐릭터의
                // 좌표가 발판 좌표
                // 안에 있는지 체크
                // i로 모든 발판
                // 체크

				on_block = 1;  // 발판 좌표 안에 있으면 발판을 밟고 있을때 1
				currentBlock = i;  // 그때의 값을 저장해 아래에 사용
				CatStage.g_y = blocks[currentBlock][2]; // 현재 밝고있는 발판의 y값을 바닥으로 사용
			} else if (blocks[currentBlock][0] > CatStage.x || blocks[currentBlock][1] < CatStage.x) {
				on_block = 0;// 현재(ff로 구분) 밟고 있는 발판의 x값에 벗어나면 발판을 밟고 있지 않은것으로 처리
			}
		}
	}

	/**	
	 * check if character leaves map 
	 *
	 * @author JiSeongChoi
	 */
	
	public void checkBoundary() {
		if (CatStage.y <= 0) {
			CatStage.playerMove = false;
			CatStage.not_key = 1;
		}
		if (CatStage.y >= 520) {
			CatStage.playerMove = false;
			CatStage.not_key = 2;
		}

		if (CatStage.x <= 16) {
			CatStage.playerMove = false;
			CatStage.not_key = 3;
		}

		if (CatStage.x >= 744) {
			CatStage.playerMove = false;
			CatStage.not_key = 4;
		}
		if (CatStage.y >= 48 && CatStage.y <= 484 && CatStage.x <= 744 && CatStage.x >= 16) {
			CatStage.not_key = 0;
		}

	}
}
