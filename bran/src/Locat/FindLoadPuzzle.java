package Locat;


/**
 * 
 * @author ChoiMyeongKyu
 * 
 *  A class for implementing findloadpuzzles.
 */
public class FindLoadPuzzle {
	private int temp;
	/**
	 * 
	 * This variable contains the coordinates of the mark.
	 */
	private int mark[][];
	/**
	 * This variable is used to check for passing marks.
	 */
	private int loadmark[];

	public FindLoadPuzzle() {
		temp = 100;
		mark = new int[10][4];
		
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
		
		loadmark = new int[] { 17, 71, 12, 21, 13, 31, 24, 42, 25, 52, 34, 43, 45, 54, 56, 65, 48, 84, 59, 95,
				70, 106, 78, 87, 89, 98, 90, 108 };
	}
	
	public void solvePuzzle() {
		findLoad();
		findLoadReset();
	}

	
	/**
	 * @author ChoiMyeongKyu
	 * This function uses the coordinates of the mark to change the associated
	 * variable whenever the character passes the mark.
	 */
	public void findLoad() {

		for (int i = 0; i < 10; i++) {
			if (Stage.x > mark[i][0] && Stage.x < mark[i][1] && Stage.y > mark[i][2]
					&& Stage.y < mark[i][3]) {
				Stage.charLocation = i;
				if (Stage.charLocation != temp) {
					Stage.fload2 = Stage.fload1;
					Stage.fload1 = i + 1;
				}
				temp = Stage.charLocation;
				if (Stage.fload2 != Stage.fload1) {
					Stage.fload3 = Stage.fload2 * 10 + Stage.fload1;
				}
			}
		}
	}
	/**
	 * @author ChoiMyeongKyu
	 * This function resets when the mark passes through a non-road.
	 */
	public void findLoadReset() {
		if (Stage.fload1 == 1) {
			if (Stage.fload2 == 7 || Stage.fload2 == 2 || Stage.fload2 == 3
					|| Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 2) {
			if (Stage.fload2 == 1 || Stage.fload2 == 4 || Stage.fload2 == 5
					|| Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 3) {
			if (Stage.fload2 == 1 || Stage.fload2 == 4 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 4) {
			if (Stage.fload2 == 2 || Stage.fload2 == 3 || Stage.fload2 == 5 || Stage.fload2 == 8
					|| Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 5) {
			if (Stage.fload2 == 2 || Stage.fload2 == 4 || Stage.fload2 == 6 || Stage.fload2 == 9
					|| Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 6) {
			if (Stage.fload2 == 5 || Stage.fload2 == 10 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 7) {
			if (Stage.fload2 == 1 || Stage.fload2 == 8 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 8) {
			if (Stage.fload2 == 4 || Stage.fload2 == 7 || Stage.fload2 == 9
					|| Stage.fload2 == 10 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 9) {
			if (Stage.fload2 == 5 || Stage.fload2 == 8 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
		if (Stage.fload1 == 10) {
			if (Stage.fload2 == 6 || Stage.fload2 == 8 || Stage.fload2 == 0) {

			} else {
				Stage.reset = true;
			}
		}
	}
}
