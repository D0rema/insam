package Locat;


/**
 * 
 * @author chlau A class for implementing puzzles.
 */
public class FindLoadPuzzle {
	private int temp;
	/**
	 * 
	 * This variable contains the coordinates of the mark.
	 */
	private int mark[][];
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
	 * This function uses the coordinates of the mark to change the associated
	 * variable whenever the character passes the mark.
	 */
	public void findLoad() {

		for (int i = 0; i < 10; i++) {
			if (CatStage.x > mark[i][0] && CatStage.x < mark[i][1] && CatStage.y > mark[i][2]
					&& CatStage.y < mark[i][3]) {
				CatStage.charLocation = i;
				if (CatStage.charLocation != temp) {
					CatStage.fload2 = CatStage.fload1;
					CatStage.fload1 = i + 1;
				}
				temp = CatStage.charLocation;
				if (CatStage.fload2 != CatStage.fload1) {
					CatStage.fload3 = CatStage.fload2 * 10 + CatStage.fload1;
				}
			}
		}
	}

	public void findLoadReset() {
		if (CatStage.fload1 == 1) {
			if (CatStage.fload2 == 7 || CatStage.fload2 == 2 || CatStage.fload2 == 3
					|| CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 2) {
			if (CatStage.fload2 == 1 || CatStage.fload2 == 4 || CatStage.fload2 == 5
					|| CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 3) {
			if (CatStage.fload2 == 1 || CatStage.fload2 == 4 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 4) {
			if (CatStage.fload2 == 2 || CatStage.fload2 == 3 || CatStage.fload2 == 5 || CatStage.fload2 == 8
					|| CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 5) {
			if (CatStage.fload2 == 2 || CatStage.fload2 == 4 || CatStage.fload2 == 6 || CatStage.fload2 == 9
					|| CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 6) {
			if (CatStage.fload2 == 5 || CatStage.fload2 == 10 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 7) {
			if (CatStage.fload2 == 1 || CatStage.fload2 == 8 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 8) {
			if (CatStage.fload2 == 4 || CatStage.fload2 == 7 || CatStage.fload2 == 9
					|| CatStage.fload2 == 10 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 9) {
			if (CatStage.fload2 == 5 || CatStage.fload2 == 8 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
		if (CatStage.fload1 == 10) {
			if (CatStage.fload2 == 6 || CatStage.fload2 == 8 || CatStage.fload2 == 0) {

			} else {
				CatStage.reset = true;
			}
		}
	}
}
