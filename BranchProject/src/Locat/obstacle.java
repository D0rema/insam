package Locat;
/**
 * The obstacle class is for giving coordinates to obstacles.
 * 
 * @author ChagngSeok-Lee
 *
 */
public class Obstacle {
	/**The coordinate of the obstacle.*/
	int ox, oy;
	int distance;
/**
 * Constructor Description of obstacle
 * 
 * @author ChangSeok-Lee
 * @param ox The x coordinate of the obstacle.
 * @param oy The y coordinate of the obstacle.
 * 
 */
	public Obstacle(int ox, int oy, int distance) {
		
		this.ox = ox;
		this.oy = oy;
		this.distance=distance;
	}
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
	public void move() {
		if ((CatStage.cnt / distance) % 2 == 0) {
			ox = ox + 2;
		} else
			ox = ox - 2;
	}
}