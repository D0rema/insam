package Locat;

public class Ladder {
	/** total of ladders */
	int ladder_Count = 3;
	/** ladderArray */
	int ladders[][] = new int[ladder_Count][4];
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
		ladders[0][0] = 176; // 사다리 시작 x좌표
		ladders[0][1] = 192; // 사다리 끝 x좌표
		ladders[0][2] = 316; // 사다리 시작 y좌표
		ladders[0][3] = 448; // 사다리 끝 y좌표
		ladders[1][0] = 256;
		ladders[1][1] = 268;
		ladders[1][2] = 148;
		ladders[1][3] = 316;

		ladders[2][0] = 352;
		ladders[2][1] = 368;
		ladders[2][2] = 28;
		ladders[2][3] = 148;
	}
	
	/**
	 * check if character can use ladder
	 * 
	 * @author JiSeongChoi
	 */
	public void on_Ladder() {
		System.out.println(y_Under);
		for (int i = 0; i < ladder_Count; i++) {
			if (cat.x >= ladders[i][0] && cat.x <= ladders[i][1] && cat.y >= ladders[i][2]
					&& cat.y <= ladders[i][3]) {
				on_Ladder_Flag = true;
				y_Upper = ladders[i][2];
				y_Under = ladders[i][3];
				break;
			} else {
				on_Ladder_Flag = false;
			}
		}
		System.out.println(on_Ladder_Flag);
	}

}
