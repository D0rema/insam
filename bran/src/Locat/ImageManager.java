package Locat;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class ImageManager {
	
	Image img = new ImageIcon(getClass().getClassLoader().getResource("images/cat.png")).getImage();
	Image img2 = new ImageIcon(getClass().getClassLoader().getResource("images/rpg2.png")).getImage();
	Image map;// *이미지 수정
	Image check = new ImageIcon(getClass().getClassLoader().getResource("images/check.png")).getImage();
	Image dog = new ImageIcon(getClass().getClassLoader().getResource("images/smdogL.png")).getImage();
	Image heart = new ImageIcon(getClass().getClassLoader().getResource("images/life.png")).getImage();
	Image heart_x = new ImageIcon(getClass().getClassLoader().getResource("images/life_x.png")).getImage();
	Image mark = new ImageIcon(getClass().getClassLoader().getResource("images/O.PNG")).getImage();
	Image map2 = new ImageIcon(getClass().getClassLoader().getResource("images/stage2.png")).getImage();
	Image icicle = new ImageIcon(getClass().getClassLoader().getResource("images/icicle.png")).getImage();
	
	
	Dog st1_Dog1 = new Dog(150, 155, 100);
	Dog st1_Dog2 = new Dog(560, 110, 80);
	//stage1
	
	Dog st2_Dog1 = new Dog(100, 355, 80);
	Dog st2_Dog2 = new Dog(67, 50, 70);
	Dog st2_Dog3 = new Dog(605, 150, 65);
	Dog st2_Dog4 = new Dog(515, 395, 75);
	Icicle icicle1 = new Icicle(135,255,125);
	Icicle icicle2 = new Icicle(180,130,70);
	Icicle icicle3 = new Icicle(420,140,110);
	Icicle icicle4 = new Icicle(575,315,100);
	public int c[] = { 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999,
			999, 999, 999, 999, 999, 999, 999, 999, 999, };

	private int ftemp = 0;

	/**
	 * The m is used to draw a mark that checks the way through.
	 */
	public int m[] = new int[14];
	private int cc1 = 0;
	/**
	 * 
	 * The x and y contain the coordinates of the mark that checks the path.
	 */
	public int x[] = { 88, 256, 152, 344, 440, 248, 392, 492, 300, 440, 536, 168, 352, 372 };
	public int y[] = { 272, 152, 216, 216, 216, 280, 280, 280, 344, 344, 384, 412, 408, 472 };

	//stage2
	
	// 위에 이미지 이름이 바로 rpg.png입니다. 이미지를 불러옵니다
	// 더블버퍼링용 입니다.
	Graphics gc;

	public void paint(Graphics g, Image buffimg, ImageObserver Frame) { // 더블버퍼링을 사용합니다.

		
		gc = buffimg.getGraphics();
		switch(CatStage.stage) {
		case 1:{
			paintStage1(Frame);
			break;
		}
		case 2:{
			paintStage2(Frame);
			break;
		}
		case 3:{
			draw_Background(Frame); // 배경을 그리는 함수
			checkMark(Frame);
			checkReset();
			resetMark();
			clearStage1();
			
			
			break;
		}
		case 4:{
			draw_Background(Frame); // 배경을 그리는 함수
			break;
		}
		}
		update(g, buffimg, Frame);

	}
	
	public void paintStage1(ImageObserver Frame) {
		draw_Background(Frame); // 배경을 그리는 함수
		drawItem(Frame, 20, 230, 0); // 특수효과를 그리는 함수
		drawItem(Frame, 400, 40, 1);
		drawItem(Frame, 750, 120, 2);
		drawItem(Frame, 740, 340, 3);
		drawDog(Frame, st1_Dog1.ox, st1_Dog1.oy, st1_Dog1);
		drawDog(Frame, st1_Dog2.ox, st1_Dog2.oy, st1_Dog2);
		drawLife(Frame, CatStage.life[0], 740, 30);
		drawLife(Frame, CatStage.life[1], 695, 30);
		drawLife(Frame, CatStage.life[2], 650, 30);
	}
	
	public void paintStage2(ImageObserver Frame) {
		draw_Background(Frame); // 배경을 그리는 함수
		drawItem(Frame, 110, 370, 0); // 특수효과를 그리는 함수
		drawItem(Frame, 10, 138, 1);
		drawItem(Frame, 200, 66, 2);
		drawItem(Frame, 500, 55, 3);
		drawItem(Frame, 750, 160, 4);
		drawItem(Frame, 750, 345, 5);
		drawDog(Frame, st2_Dog1.ox, st2_Dog1.oy, st2_Dog1);
		drawDog(Frame, st2_Dog2.ox, st2_Dog2.oy, st2_Dog2);
		drawDog(Frame, st2_Dog3.ox, st2_Dog3.oy, st2_Dog3);
		drawDog(Frame, st2_Dog4.ox, st2_Dog4.oy, st2_Dog4);
		drawIcicle(Frame, icicle1.ix, icicle1.iy, icicle1);
		drawIcicle(Frame, icicle2.ix, icicle2.iy, icicle2);
		drawIcicle(Frame, icicle3.ix, icicle3.iy, icicle3);
		drawIcicle(Frame, icicle4.ix, icicle4.iy, icicle4);
		drawLife(Frame, CatStage.life[0], 740, 30);
		drawLife(Frame, CatStage.life[1], 695, 30);
		drawLife(Frame, CatStage.life[2], 650, 30);
	}

	

	public void update(Graphics g, Image buffimg, ImageObserver Frame) {
		// 더블 버퍼링을 이용해 버퍼에 그려진것을 가져옵니다.
		DrawImg(Frame);

		g.drawImage(buffimg, 0, 0, Frame);
	}

	public void DrawImg(ImageObserver Frame) {
		gc.setFont(new Font("Default", Font.BOLD, 20));
		gc.drawString(Integer.toString(CatStage.cnt), 50, 50);
		gc.drawString(Integer.toString((CatStage.playerMove) ? 1 : 0), 200, 50);
		gc.drawString(Integer.toString(CatStage.x), 350, 50);
		gc.drawString(Integer.toString(CatStage.y), 500, 50);
		gc.drawString(Integer.toString(CatStage.jp1), 350, 100);
		gc.drawString(Integer.toString(CatStage.char_lo), 500, 100);
		gc.drawString(Integer.toString(CatStage.notUp),350, 150);
		gc.drawString(Integer.toString(CatStage.notDown),400, 150);
		gc.drawString(Integer.toString(CatStage.notLeft),450, 150);
		gc.drawString(Integer.toString(CatStage.notRight),500, 150);

		// 위는 단순히 무한루프 적용여부와 케릭터 방향 체크를 위해
		// 눈으로 보면서 테스트할 용도로 쓰이는 텍스트 표출입니다.
		if(CatStage.stage==1||CatStage.stage==2) {
		MoveImage(img, CatStage.x, CatStage.y, 50, 75, Frame);
	// 케릭터를 걸어가게 만들기 위해 추가로 만든 메소드 입니다.
		}
		if(CatStage.stage==3||CatStage.stage==4) {
			MoveImage(img2, CatStage.x, CatStage.y, 50, 75, Frame);
		}

	}

	public void MoveImage(Image img, int x, int y, int width, int height, ImageObserver Frame) {
		// 케릭터 이미지, 케릭터 위치, 케릭터 크기를 받습니다.
		// 받은 값을 이용해서 위의 이미지칩셋에서 케릭터를 잘라내
		// 표출하도록 계산하는 메소드 입니다.

		gc.setClip(x, y, width, height);
		// 현재 좌표에서 케릭터의 크기 만큼 이미지를 잘라 그립니다.

		if (CatStage.playerMove) { // 케릭터의 움직임 여부를 판단합니다.
			if (CatStage.cnt / 10 % 4 == 0) {
				gc.drawImage(img, x - (width * 0), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 1) {
				gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 2) {
				gc.drawImage(img, x - (width * 2), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 3) {
				gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);
			}
			// 케릭터의 방향에 따라 걸어가는 모션을 취하는
			// 케릭터 이미지를 시간차를 이용해 순차적으로 그립니다.

		} else {
			gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);
			// 케릭터가 움직이지 않으면 정지한 케릭터를 그립니다.

		}
	}

	public void draw_Background(ImageObserver Frame) {
		map = new ImageIcon(getClass().getClassLoader().getResource("images/stage"+CatStage.stage+".png")).getImage();
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(map, 0, 0, Frame);
	}

	/**
	 * The drawDog method draws the Obstacle(Dog) and contains the collision
	 * information
	 *
	 * @author ChagngSeok-Lee
	 * @param Frame    ImageObserver
	 * @param dx       int input of Obstacle(dog)'s x-coordinate
	 * @param dy       int input of Obstacle(dog)'s y-coordinate
	 * @param distance int Determine how far you want to move
	 * @param dg       Obstacle An object with x and y coordinates
	 */
	public void drawDog(ImageObserver Frame, int dx, int dy, Dog dg) {
		dg.crush();
		dg.move();
		gc.drawImage(dog, dx, dy, Frame);
	}
	/**
	 * The drawDog method draws the Obstacle(Icicle) and contains the collision
	 * 
	 * @author ChagngSeok-Lee
	 */
	public void drawIcicle(ImageObserver Frame, int dx, int dy, Icicle ice) {
		ice.crush();
		ice.move();
		gc.drawImage(icicle, dx, dy, Frame);
	}

	/**
	 * The drawItem method draws a map based on the state of the item.
	 * 
	 * @author ChagngSeok-Lee
	 * @param Frame   ImageObserver
	 * @param cx      int input of item's x-coordinate
	 * @param cy      int input of item's y-coordinate
	 * @param ckindex int Variable for identifying each item.
	 */
	public void drawItem(ImageObserver Frame, int cx, int cy, int ckindex) {
		if ((cx - 15 <= CatStage.x && cx + 15 >= CatStage.x) && (cy - 15 <= CatStage.y && cy + 15 >= CatStage.y)) {
			CatStage.item[CatStage.stage-1][ckindex] = false;
		}
		if (CatStage.item[CatStage.stage-1][ckindex] == true) {
			gc.drawImage(check, cx, cy, Frame);
		}
	}

	/**
	 * draw_life is a method of drawing a heart (life) based on its state.
	 * 
	 * @author ChagngSeok-Lee
	 * @param Frame ImageObserver
	 * @param lck   boolean Variable to check if the life has decreased.
	 * @param lx    int The x-coordinate of the heart image.
	 * @param ly    int The y-coordinate of the heart image.
	 */
	public void drawLife(ImageObserver Frame, boolean lck, int lx, int ly) {
		if (lck) {
			gc.drawImage(heart, lx, ly, Frame);
		} else
			gc.drawImage(heart_x, lx, ly, Frame);
	}

	public void checkMark(ImageObserver Frame) {
		for (int i = 0; i < 14; i++) {
			if (m[i] == 1) {
				
				gc.drawImage(mark, x[i], y[i], Frame);// 1-7
			}
		}
		// if(CatStage.ckmark1==true) {

		// gc.drawImage(mark,135,105,Frame);
		if (CatStage.fload3 != ftemp) {
			CatStage.fload5 = CatStage.fload4;
			CatStage.fload4 = CatStage.fload3;
		}
		ftemp = CatStage.fload3;

		if (CatStage.fload3 == 17 || CatStage.fload3 == 71) {
			m[0] = 1;
		}
		if (CatStage.fload5 == 17 || CatStage.fload5 == 71) {
			c[0] = 17;
			c[1] = 71;
		}

		if (CatStage.fload3 == 12 || CatStage.fload3 == 21) {
			m[1] = 1;
		}
		if (CatStage.fload5 == 12 || CatStage.fload5 == 21) {
			c[2] = 12;
			c[3] = 21;
		}
		if (CatStage.fload3 == 13 || CatStage.fload3 == 31) {
			m[2] = 1;

		}
		if (CatStage.fload5 == 13 || CatStage.fload5 == 31) {
			c[4] = 13;
			c[5] = 31;
		}
		if (CatStage.fload3 == 24 || CatStage.fload3 == 42) {

			m[3] = 1;

		}
		if (CatStage.fload5 == 24 || CatStage.fload5 == 42) {
			c[6] = 24;
			c[7] = 42;
		}
		if (CatStage.fload3 == 25 || CatStage.fload3 == 52) {

			m[4] = 1;
		}
		if (CatStage.fload5 == 25 || CatStage.fload5 == 52) {
			c[8] = 25;
			c[9] = 52;
		}
		if (CatStage.fload3 == 34 || CatStage.fload3 == 43) {
			m[5] = 1;
		}
		if (CatStage.fload5 == 34 || CatStage.fload5 == 43) {
			c[10] = 34;
			c[11] = 43;
		}
		if (CatStage.fload3 == 45 || CatStage.fload3 == 54) {
			m[6] = 1;
		}
		if (CatStage.fload5 == 45 || CatStage.fload5 == 54) {
			c[12] = 45;
			c[13] = 54;
		}
		if (CatStage.fload3 == 56 || CatStage.fload3 == 65) {
			m[7] = 1;
		}
		if (CatStage.fload5 == 56 || CatStage.fload5 == 65) {
			c[14] = 56;
			c[15] = 65;
		}
		if (CatStage.fload3 == 48 || CatStage.fload3 == 84) {
			m[8] = 1;
		}
		if (CatStage.fload5 == 48 || CatStage.fload5 == 84) {
			c[16] = 48;
			c[17] = 84;
		}
		if (CatStage.fload3 == 59 || CatStage.fload3 == 95) {
			m[9] = 1;
		}
		if (CatStage.fload5 == 59 || CatStage.fload5 == 95) {
			c[18] = 59;
			c[19] = 95;
		}
		if (CatStage.fload3 == 70 || CatStage.fload3 == 106) {
			m[10] = 1;
		}
		if (CatStage.fload5 == 70 || CatStage.fload5 == 106) {
			c[20] = 106;
			c[21] = 70;
		}
		if (CatStage.fload3 == 78 || CatStage.fload3 == 87) {
			m[11] = 1;
		}
		if (CatStage.fload5 == 78 || CatStage.fload5 == 87) {
			c[22] = 78;
			c[23] = 87;
		}
		if (CatStage.fload3 == 89 || CatStage.fload3 == 98) {
			m[12] = 1;
		}
		if (CatStage.fload5 == 89 || CatStage.fload5 == 98) {
			c[24] = 89;
			c[25] = 98;
		}
		if (CatStage.fload3 == 90 || CatStage.fload3 == 108) {
			m[13] = 1;
		}
		if (CatStage.fload5 == 90 || CatStage.fload5 == 108) {
			c[26] = 90;
			c[27] = 108;
		}

	}

	public void checkReset() {
		for (int i = 0; i < 28; i++) {
			if (c[i] == CatStage.fload3) {
				CatStage.reset = true;
			}
		}
	}

	public void clearStage1() {
		cc1 = m[0] * m[1] * m[2] * m[3] * m[4] * m[5] * m[6] * m[7] * m[8] * m[9] * m[10] * m[11] * m[12] * m[13];
		if (cc1 == 1) {
			CatStage.clearflag3=true;
			for(int i =0;i<14;i++) {
				m[i]=0;
			}
			System.out.println("clear");
		}
	}

	public void resetMark() {
		if (CatStage.reset == true) {
			for (int i = 0; i < 14; i++) {
				
				m[i] = 0;
			}
			
			CatStage.fload1 = 0;
			CatStage.fload2 = 0;
			CatStage.fload3 = 0;
			CatStage.fload4 = 0;
			CatStage.fload5 = 0;
			for (int i = 0; i < 28; i++) {
				c[i] = 999;
			}
			System.out.println("reset");
			CatStage.x = 528;
			CatStage.y = 124;
			CatStage.reset = false;
		}
	}

}
