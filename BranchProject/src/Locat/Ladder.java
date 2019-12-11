package Locat;

public class Ladder {
	/** total of ladders */
	int ladder_Count = 3;
	/** ladderArray */
	int ladders[][][] = new int[2][ladder_Count][4];
	/** variable for checking character can use ladder */
	public static boolean on_Ladder_Flag = false;
	/** variable for checking character is using ladder */
	public static boolean using_Ladder = false;
	/** y value of top of ladder */
	public static int y_Upper;
	/** y value of bottom of ladder */
	public static int y_Under;

	/**
	 * set position of ladders
	 * 
	 * @author JiSeongChoi
	 */
	public Ladder() {
		ladders[0][0][0] = 176; // 사다리 시작 x좌표
		ladders[0][0][1] = 192; // 사다리 끝 x좌표
		ladders[0][0][2] = 316; // 사다리 시작 y좌표
		ladders[0][0][3] = 448; // 사다리 끝 y좌표

		ladders[0][1][0] = 256;
		ladders[0][1][1] = 268;
		ladders[0][1][2] = 148;
		ladders[0][1][3] = 316;

		ladders[0][2][0] = 352;
		ladders[0][2][1] = 368;
		ladders[0][2][2] = 28;
		ladders[0][2][3] = 148;

		ladders[1][0][0] = 252;
		ladders[1][0][1] = 264;
		ladders[1][0][2] = 364;
		ladders[1][0][3] = 520;

		ladders[1][1][0] = 304;
		ladders[1][1][1] = 316;
		ladders[1][1][2] = 52;
		ladders[1][1][3] = 184;

		ladders[1][2][0] = 508;
		ladders[1][2][1] = 524;
		ladders[1][2][2] = 244;
		ladders[1][2][3] = 400;
	}

	/**
	 * check if character can use ladder
	 * 
	 * @author JiSeongChoi
	 */
	public void on_Ladder() {
		
		for (int i = 0; i < ladder_Count; i++) {
			if (CatStage.x >= ladders[CatStage.stage-1][i][0] && CatStage.x <= ladders[CatStage.stage-1][i][1]
					&& CatStage.y >= ladders[CatStage.stage-1][i][2] && CatStage.y <= ladders[CatStage.stage-1][i][3]) {
				on_Ladder_Flag = true;
				y_Upper = ladders[CatStage.stage-1][i][2];
				y_Under = ladders[CatStage.stage-1][i][3];
				break;
			} else {
				on_Ladder_Flag = false;
			}
		}
	}
}
