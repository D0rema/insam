package Locat;

/**
 * 
 * @author ChoiMyeongKyu
 *  A class for implementing iceloadpuzzles.
 */
public class IceLoadPuzzle {

	public void solvePuzzle() {
		slide();
	}
	/**
	 * 
	 * @author ChoiMyeongKyu
	 *  Sliding function when on ice
	 */
	public void slide() {
		if(Stage.x>800) {
			Stage.clearflag4=true;
		}
		if (Stage.x >= 60 && Stage.x <= 568 && Stage.y >= 60 && Stage.y <= 508) {
			if (Stage.notUp == 1 && Stage.notRight == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 2) {
					if (Stage.y < 508)
						Stage.y += 4;
				} else if (Stage.moveStatus == 3) {
					if (Stage.x > 60)
						Stage.x -= 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notUp == 1 && Stage.notLeft == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 1) {
					if (Stage.x < 568)
						Stage.x += 4;
				} else if (Stage.moveStatus == 2) {
					if (Stage.y < 508)
						Stage.y += 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notDown == 1 && Stage.notRight == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 1) {
					if (Stage.y > 60)
						Stage.y -= 4;
				} else if (Stage.moveStatus == 3) {
					if (Stage.x > 60)
						Stage.x -= 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notDown == 1 && Stage.notLeft == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 0) {
					if (Stage.y > 60)
						Stage.y -= 4;
				} else if (Stage.moveStatus == 1) {
					if (Stage.x < 568)
						Stage.x += 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notUp == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 1) {
					if (Stage.x < 568)
						Stage.x += 4;
					else if (Stage.y == 120 && Stage.x >= 568)
						Stage.x += 4;
				} else if (Stage.moveStatus == 2) {
					if (Stage.y < 508)
						Stage.y += 4;
				} else if (Stage.moveStatus == 3) {
					if (Stage.x > 60)
						Stage.x -= 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notDown == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 0) {
					if (Stage.y > 60)
						Stage.y -= 4;
				} else if (Stage.moveStatus == 1) {
					if (Stage.x < 568)
						Stage.x += 4;
				} else if (Stage.moveStatus == 3) {
					if (Stage.x > 60)
						Stage.x -= 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notRight == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 0) {
					if (Stage.y > 60)
						Stage.y -= 4;
				} else if (Stage.moveStatus == 2) {
					if (Stage.y < 508)
						Stage.y += 4;
				} else if (Stage.moveStatus == 3) {
					if (Stage.x > 60)
						Stage.x -= 4;
				} else
					Stage.sliding = true;
				return;
			}

			if (Stage.notLeft == 1) {

				Stage.sliding = false;

				if (Stage.moveStatus == 0) {
					if (Stage.y > 60)
						Stage.y -= 4;
				} else if (Stage.moveStatus == 1) {
					if (Stage.x < 568)
						Stage.x += 4;
				} else if (Stage.moveStatus == 2) {
					if (Stage.y < 508)
						Stage.y += 4;
				} else
					Stage.sliding = true;
				return;
			}
		} else if (Stage.y == 120 && Stage.x >= 568)
			Stage.x += 4;
	}

}
