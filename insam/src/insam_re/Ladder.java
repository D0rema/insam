package insam_re;

public class Ladder {
	int ladder_Count = 3;
	int ladders[][] = new int[ladder_Count][4];

	public static boolean on_Ladder_Flag = false;
	public static boolean using_Ladder = false;
	public static int y_Upper;
	public static int y_Under;

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

	public void on_Ladder() {
		System.out.println(y_Under);
		for (int i = 0; i < ladder_Count; i++) {
			if (moving_test.x >= ladders[i][0] && moving_test.x <= ladders[i][1] && moving_test.y >= ladders[i][2]
					&& moving_test.y <= ladders[i][3]) {
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
