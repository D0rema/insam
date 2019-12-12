package Locat;

/**
 * class to check block
 *
 * @author JiSeongChoi
 */
public class Block {
	/** Array of number Of Blocks in each Stages */
	int block_Count[] = { 9, 12 };// 블록의 갯수
	/** Maximum number in block_Count */
	final int MAXBLOCKCOUNT = 12;
	/** block Array */
	int blocks[][][]; // 블록들의 주소가 저장된 배열

	/** variable for checking if character is floating air */
	public int on_Block = 0;// 발판을 밟을때 ture가 되어 바닥이 발판의 y값으로 변함
	/** variable for checking if character is on block */
	public int on_Bottom = 0; // 기본적인 바닥 여기서는 508로 고정
	/** y value of current block */
	public int currentBlock; // 현재 밟고 있는 발판의 y값을 지정하기 위해 필요한 함수

	/**
	 * set position of blocks
	 * 
	 * @author JiSeongChoi
	 */
	public Block() {
		blocks = new int[2][MAXBLOCKCOUNT][3];

		blocks[0][0][0] = 144; // x시작
		blocks[0][0][1] = 288; // x끝
		blocks[0][0][2] = 316; // y

		blocks[0][1][0] = 0;
		blocks[0][1][1] = 82;
		blocks[0][1][2] = 220;

		blocks[0][2][0] = 68;
		blocks[0][2][1] = 212;
		blocks[0][2][2] = 448;

		blocks[0][3][0] = 144;
		blocks[0][3][1] = 380;
		blocks[0][3][2] = 148;

		blocks[0][4][0] = 270;
		blocks[0][4][1] = 504;
		blocks[0][4][2] = 28;

		blocks[0][5][0] = 532;
		blocks[0][5][1] = 750;
		blocks[0][5][2] = 112;

		blocks[0][6][0] = 404;
		blocks[0][6][1] = 504;
		blocks[0][6][2] = 244;

		blocks[0][7][0] = 552;
		blocks[0][7][1] = 604;
		blocks[0][7][2] = 304;

		blocks[0][8][0] = 664;
		blocks[0][8][1] = 750;
		blocks[0][8][2] = 328;

		blocks[1][0][0] = 72;
		blocks[1][0][1] = 276;
		blocks[1][0][2] = 364;

		blocks[1][1][0] = 286;
		blocks[1][1][1] = 364;
		blocks[1][1][2] = 292;

		blocks[1][2][0] = 356;
		blocks[1][2][1] = 440;
		blocks[1][2][2] = 232;

		blocks[1][3][0] = 92;
		blocks[1][3][1] = 324;
		blocks[1][3][2] = 184;

		blocks[1][4][0] = 0;
		blocks[1][4][1] = 68;
		blocks[1][4][2] = 124;

		blocks[1][5][0] = 72;
		blocks[1][5][1] = 244;
		blocks[1][5][2] = 52;

		blocks[1][6][0] = 288;
		blocks[1][6][1] = 416;
		blocks[1][6][2] = 64;

		blocks[1][7][0] = 460;
		blocks[1][7][1] = 544;
		blocks[1][7][2] = 40;

		blocks[1][8][0] = 608;
		blocks[1][8][1] = 750;
		blocks[1][8][2] = 148;

		blocks[1][9][0] = 488;
		blocks[1][9][1] = 584;
		blocks[1][9][2] = 244;

		blocks[1][10][0] = 488;
		blocks[1][10][1] = 684;
		blocks[1][10][2] = 400;

		blocks[1][11][0] = 680;
		blocks[1][11][1] = 750;
		blocks[1][11][2] = 340;
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
		if (on_Block == 0) { // 발판에 닿지 않을때는 항상 바닥은 472
			Stage.g_y = 520;
		}
		if (!Stage.try_jump || Ladder.on_Ladder_Flag) { // 점프할때는 중력 적용 x
			if (Stage.y >= Stage.g_y) { // g_y 발판일때 바뀔수 있기때문에 변수로 생성
				on_Bottom = 1; // 캐릭터가 바닥에 닿았을때 1
			} else if (Stage.y < Stage.g_y && Ladder.on_Ladder_Flag) {
				if (Ladder.using_Ladder)
					on_Bottom = 1;
				else
					on_Bottom = 0;
			} else {
				on_Bottom = 0;
			}
			if (on_Bottom == 0) { // 바닥에 닿지 않았을때는 항상 떨어짐
				Ladder.using_Ladder = false;
				Stage.y += 12;
			}
		}
	}

	/**
	 * check if character is on blocks
	 * 
	 * @author JiSeongChoi
	 */
	public void on_Block() { // 발판일때 체크하는 함수
		for (int i = 0; i < block_Count[Stage.stage - 1]; i++) { // 모든 발판을 체크
			if (blocks[Stage.stage - 1][i][0] < Stage.x && blocks[Stage.stage - 1][i][1] > Stage.x
					&& blocks[Stage.stage - 1][i][2] == Stage.y) {
				// 현재 캐릭터의
				// 좌표가 발판 좌표
				// 안에 있는지 체크
				// i로 모든 발판
				// 체크

				on_Block = 1; // 발판 좌표 안에 있으면 발판을 밟고 있을때 1
				currentBlock = i; // 그때의 값을 저장해 아래에 사용
				Stage.g_y = blocks[Stage.stage - 1][currentBlock][2]; // 현재 밝고있는 발판의 y값을 바닥으로 사용
			} else if (blocks[Stage.stage - 1][currentBlock][0] > Stage.x
					|| blocks[Stage.stage - 1][currentBlock][1] < Stage.x) {
				on_Block = 0;// 현재(ff로 구분) 밟고 있는 발판의 x값에 벗어나면 발판을 밟고 있지 않은것으로 처리
			}
		}
	}
}