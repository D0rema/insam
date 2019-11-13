package Locat;

public class puzzle_master {
	private int mark[][] = new int[10][4];
	public void find_load() {
		mark[0] = new int[] { 132, 164, 100, 132 };
		mark[1] = new int[] { 328, 360, 100, 132 };
		mark[2] = new int[] { 132, 164, 232, 264 };
		mark[3] = new int[] { 328, 360, 232, 264 };
		mark[4] = new int[] { 424, 456, 232, 264 };
		mark[5] = new int[] { 516, 548, 232, 264 };
		mark[6] = new int[] { 68, 100, 360, 392 };
		mark[7] = new int[] { 232, 264, 360, 392 };
		mark[8] = new int[] { 424, 456, 360, 392 };
		mark[9] = new int[] { 484, 516, 416, 448 };

		for (int i = 0; i < 10; i++) {
			if (cat.x > mark[i][0] && cat.x < mark[i][1] && cat.y > mark[i][2]
					&& cat.y < mark[i][3]) {
				cat.char_lo = i;
			}
		}
	}
}
