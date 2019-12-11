package Locat;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class ImageManager {
	Image img = new ImageIcon(getClass().getClassLoader().getResource("images/cat.png")).getImage();
	Image map;// *이미지 수정
	Image check = new ImageIcon(getClass().getClassLoader().getResource("images/check.png")).getImage();
	Image dog = new ImageIcon(getClass().getClassLoader().getResource("images/smdogL.png")).getImage();
	Image heart = new ImageIcon(getClass().getClassLoader().getResource("images/life.png")).getImage();
	Image heart_x = new ImageIcon(getClass().getClassLoader().getResource("images/life_x.png")).getImage();

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
		// gc.drawString(Integer.toString(on_bottom),500, 150);
		// gc.drawString(Integer.toString(on_flat),350, 150);

		// 위는 단순히 무한루프 적용여부와 케릭터 방향 체크를 위해
		// 눈으로 보면서 테스트할 용도로 쓰이는 텍스트 표출입니다.

		MoveImage(img, CatStage.x, CatStage.y, 50, 75, Frame);
		// 케릭터를 걸어가게 만들기 위해 추가로 만든 메소드 입니다.

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

}
