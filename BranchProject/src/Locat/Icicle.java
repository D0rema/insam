package Locat;
/**
 * The Icicle class is for giving coordinates to Icicle.
 * 
 * @author ChangSeok-Lee
 *
 */
public class Icicle extends Obstacle {
	/**The coordinate of icicle*/
	int ix, iy, initX,initY;
	int distance;
/**
 * 
 * Constructor Description of Icicle
 * 
 * @param ix The initial x coordinate of the Icicle.
 * @param iy The initial x coordinate of the Icicle.
 * @param distance Set the distance to move
 */
	Icicle(int ix, int iy, int distance) {
		this.ix = ix;
		this.iy = iy;
		this.initX =ix;
		this.initY = iy;
		this.distance = distance;
	}
	/**
	 * Determine if the cat and the obstacle have hit
	 */
	public void move() {
		
		iy+=2;
		if(iy > initY+distance) {
			iy=initY;
		}
		
	}
	/**
	 * Change Icicle's coordinates
	 */
	public void crush() {
		if ((ix - 30 <= CatStage.x && ix + 15 >= CatStage.x)
				&& (iy - 20 <= CatStage.y && iy + 10 >= CatStage.y)) {
			if (CatStage.x <= ix)
				CatStage.x = CatStage.x - 50;
			else
				CatStage.x = CatStage.x + 50;

			if (CatStage.life[0])
				CatStage.life[0] = false;
			else if (CatStage.life[1])
				CatStage.life[1] = false;
			else
				CatStage.life[2] = false;
		}
		
		
	}
}
