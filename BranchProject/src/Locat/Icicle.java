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
}
