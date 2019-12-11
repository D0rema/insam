package Locat;
/**
 * The Dog class is for giving coordinates to Dogs.
 * 
 * @author ChagngSeok-Lee
 *
 */
public class Dog extends Obstacle {
	/**The coordinate of the Dog.*/
	int ox, oy;
	int distance;
/**
 * Constructor Description of Dog
 * 
 * @author ChangSeok-Lee
 * @param ox The initial x coordinate of the Dog.
 * @param oy The initial y coordinate of the Dog.
 * @parm distance Set the distance to move
 */
	public Dog(int ox, int oy, int distance) {
		
		this.ox = ox;
		this.oy = oy;
		this.distance=distance;
	}
	/**
	 * Determine if the cat and the obstacle have hit
	 */
	public void crush() {
		if ((ox - 10 <= CatStage.x && ox + 30 >= CatStage.x)
				&& (oy - 10 <= CatStage.y && oy + 10 >= CatStage.y)) {
			if (CatStage.x <= ox)
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
	/**
	 * Change Dog's coordinates
	 */
	public void move() {
		if ((CatStage.cnt / distance) % 2 == 0) {
			ox = ox + 2;
		} else
			ox = ox - 2;
	}
}