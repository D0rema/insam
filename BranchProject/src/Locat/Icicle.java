package Locat;

public class Icicle {
	int ix, iy, initX,initY;
	int distance;

	Icicle(int ix, int iy, int distance) {
		this.ix = ix;
		this.iy = iy;
		this.initX =ix;
		this.initY = iy;
		this.distance = distance;
	}
	public void move() {
		
		iy+=2;
		if(iy > initY+distance) {
			iy=initY;
		}
		
	}
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
