package Locat;

/**
 * 
 * @author chlau A class for implementing puzzles.
 */
public class IceLoadPuzzle {

	public void solvePuzzle() {
		slide();
	}
	
	public void slide() {
		if(CatStage.x>800) {
			CatStage.clearflag4=true;
		}
		if (CatStage.x >= 60 && CatStage.x <= 568 && CatStage.y >= 60 && CatStage.y <= 508) {
			if (CatStage.notUp == 1 && CatStage.notRight == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 2) {
					if (CatStage.y < 508)
						CatStage.y += 4;
				} else if (CatStage.moveStatus == 3) {
					if (CatStage.x > 60)
						CatStage.x -= 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notUp == 1 && CatStage.notLeft == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 1) {
					if (CatStage.x < 568)
						CatStage.x += 4;
				} else if (CatStage.moveStatus == 2) {
					if (CatStage.y < 508)
						CatStage.y += 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notDown == 1 && CatStage.notRight == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 1) {
					if (CatStage.y > 60)
						CatStage.y -= 4;
				} else if (CatStage.moveStatus == 3) {
					if (CatStage.x > 60)
						CatStage.x -= 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notDown == 1 && CatStage.notLeft == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 0) {
					if (CatStage.y > 60)
						CatStage.y -= 4;
				} else if (CatStage.moveStatus == 1) {
					if (CatStage.x < 568)
						CatStage.x += 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notUp == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 1) {
					if (CatStage.x < 568)
						CatStage.x += 4;
					else if (CatStage.y == 120 && CatStage.x >= 568)
						CatStage.x += 4;
				} else if (CatStage.moveStatus == 2) {
					if (CatStage.y < 508)
						CatStage.y += 4;
				} else if (CatStage.moveStatus == 3) {
					if (CatStage.x > 60)
						CatStage.x -= 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notDown == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 0) {
					if (CatStage.y > 60)
						CatStage.y -= 4;
				} else if (CatStage.moveStatus == 1) {
					if (CatStage.x < 568)
						CatStage.x += 4;
				} else if (CatStage.moveStatus == 3) {
					if (CatStage.x > 60)
						CatStage.x -= 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notRight == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 0) {
					if (CatStage.y > 60)
						CatStage.y -= 4;
				} else if (CatStage.moveStatus == 2) {
					if (CatStage.y < 508)
						CatStage.y += 4;
				} else if (CatStage.moveStatus == 3) {
					if (CatStage.x > 60)
						CatStage.x -= 4;
				} else
					CatStage.sliding = true;
				return;
			}

			if (CatStage.notLeft == 1) {

				CatStage.sliding = false;

				if (CatStage.moveStatus == 0) {
					if (CatStage.y > 60)
						CatStage.y -= 4;
				} else if (CatStage.moveStatus == 1) {
					if (CatStage.x < 568)
						CatStage.x += 4;
				} else if (CatStage.moveStatus == 2) {
					if (CatStage.y < 508)
						CatStage.y += 4;
				} else
					CatStage.sliding = true;
				return;
			}
		} else if (CatStage.y == 120 && CatStage.x >= 568)
			CatStage.x += 4;
	}

}
