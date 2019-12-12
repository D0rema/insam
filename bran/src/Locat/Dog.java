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
		if ((ox - 10 <= Stage.x && ox + 30 >= Stage.x)
				&& (oy - 10 <= Stage.y && oy + 10 >= Stage.y)) {
			if (Stage.x <= ox)
				Stage.x = Stage.x - 50;
			else
				Stage.x = Stage.x + 50;

			if (Stage.life[0])
				Stage.life[0] = false;
			else if (Stage.life[1])
				Stage.life[1] = false;
			else
				Stage.life[2] = false;
		}
		
	}
	/**
	 * Change Dog's coordinates
	 */
	public void move() {
		if ((Stage.cnt / distance) % 2 == 0) {
			ox = ox + 2;
		} else
			ox = ox - 2;
	}
}