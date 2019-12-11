package Locat;

/**
 * 
 * @author chlmyeongkyu
 * 
 *         This class is for implementing flat and walls.
 *
 */
public class Wall {
	int iceWall[][] = new int[8][];
	public void solveWall() {
		checkWall();
		onIwall();
	}
	/**
	 * Calls the is_bottom () and in_flat () functions and flat the range of
	 * scaffolding.
	 */
	public void checkWall() {
		iceWall[0] = new int[] { 64, 120, 120, 164, 240, 120, 100, 172, 240, 452, 520, 300, 168, 240, 376, 232, 300,
				436, 520, 560, 504, 120, 160, 60, 252, 568, 60, 0, 52, 300 };
		iceWall[1] = new int[] { 100, 172, 128, 452, 520, 188, 168, 240, 256, 232, 300, 320, 520, 560, 384, 108, 172,
				448, 56, 88, 508, 188, 568, 508 };
		iceWall[2] = new int[] { 120, 60, 112, 252, 60, 112, 188, 136, 236, 540, 204, 292, 252, 268, 368, 316, 340,
				428, 188, 464, 508, 60, 120, 288, 60, 372, 508 };
		iceWall[3] = new int[] { 156, 60, 112, 88, 136, 236, 440, 204, 292, 152, 268, 368, 216, 340, 428, 504, 400,
				492, 88, 464, 508, 568, 500, 508, 568, 188, 384, 568, 60, 100 };
		iceWall[4] = new int[] { 60, 120, 120, 60, 252, 60 };
		iceWall[5] = new int[] { 568, 60, 216, 376, 568, 504, 156, 60 };
		iceWall[6] = new int[] { 252, 316, 60, 508, 188, 508, 252, 320 };
		iceWall[7] = new int[] { 88, 508, 568, 508, 568, 384 };
		
	}

	public void onIwall() {
		for (int i = 0; i < iceWall[4].length / 2; i++) {
			if (CatStage.x == iceWall[4][(2 * i) + 0] && CatStage.y == iceWall[4][(2 * i) + 1]) {
				CatStage.notUp = 1;
				CatStage.notDown = 0;
				CatStage.notLeft = 1;
				CatStage.notRight = 0;
				return;
			}
		}
		for (int i = 0; i < iceWall[5].length / 2; i++) {
			if (CatStage.x == iceWall[5][(2 * i) + 0] && CatStage.y == iceWall[5][(2 * i) + 1]) {
				CatStage.notUp = 1;
				CatStage.notDown = 0;
				CatStage.notLeft = 0;
				CatStage.notRight = 1;
				return;
			}
		}
		for (int i = 0; i < iceWall[6].length / 2; i++) {
			if (CatStage.x == iceWall[6][(2 * i) + 0] && CatStage.y == iceWall[6][(2 * i) + 1]) {
				CatStage.notUp = 0;
				CatStage.notDown = 1;
				CatStage.notLeft = 1;
				CatStage.notRight = 0;
				return;
			}
		}
		for (int i = 0; i < iceWall[7].length / 2; i++) {
			if (CatStage.x == iceWall[7][(2 * i) + 0] && CatStage.y == iceWall[7][(2 * i) + 1]) {
				CatStage.notUp = 0;
				CatStage.notDown = 1;
				CatStage.notLeft = 0;
				CatStage.notRight = 1;
				return;
			}
		}
		for (int i = 0; i < iceWall[0].length / 3; i++) {
			if (CatStage.x > iceWall[0][(3 * i) + 0] && CatStage.x < iceWall[0][(3 * i) + 1]
					&& CatStage.y == iceWall[0][(3 * i) + 2]) {
				CatStage.notUp = 1;
				CatStage.notDown = 0;
				CatStage.notLeft = 0;
				CatStage.notRight = 0;
				return;
			}
		}
		for (int i = 0; i < iceWall[1].length / 3; i++) {
			if (CatStage.x > iceWall[1][(3 * i) + 0] && CatStage.x < iceWall[1][(3 * i) + 1]
					&& CatStage.y == iceWall[1][(3 * i) + 2]) {
				CatStage.notUp = 0;
				CatStage.notDown = 1;
				CatStage.notLeft = 0;
				CatStage.notRight = 0;
				return;
			}
		}
		for (int i = 0; i < iceWall[2].length / 3; i++) {
			if (CatStage.x == iceWall[2][(3 * i) + 0] && CatStage.y > iceWall[2][(3 * i) + 1]
					&& CatStage.y < iceWall[2][(3 * i) + 2]) {
				CatStage.notUp = 0;
				CatStage.notDown = 0;
				CatStage.notLeft = 1;
				CatStage.notRight = 0;
				return;
			}
		}
		for (int i = 0; i < iceWall[3].length / 3; i++) {
			if (CatStage.x == iceWall[3][(3 * i) + 0] && CatStage.y > iceWall[3][(3 * i) + 1]
					&& CatStage.y < iceWall[3][(3 * i) + 2]) {
				CatStage.notUp = 0;
				CatStage.notDown = 0;
				CatStage.notLeft = 0;
				CatStage.notRight = 1;
				return;
			}
		}
	}
}
