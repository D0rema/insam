package Locat;

public class Ladder {
	int ladder_Count = 3;
	int ladders[][] = new int[ladder_Count][4];

	public static boolean on_Ladder_Flag = false;
	public static boolean using_Ladder = false;
	public static int y_Upper;
	public static int y_Under;

	public Ladder() {
		ladders[0][0] = 176; // ��ٸ� ���� x��ǥ
		ladders[0][1] = 192; // ��ٸ� �� x��ǥ
		ladders[0][2] = 316; // ��ٸ� ���� y��ǥ
		ladders[0][3] = 448; // ��ٸ� �� y��ǥ

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
