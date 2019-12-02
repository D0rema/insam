package Locat;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class ImageManager {
	Image img = new ImageIcon(getClass().getClassLoader().getResource("images/cat.png")).getImage();
	Image map = new ImageIcon(getClass().getClassLoader().getResource("images/stage1.png")).getImage();// *이미지 수정
	Image check = new ImageIcon(getClass().getClassLoader().getResource("images/check.png")).getImage();
	Image dog = new ImageIcon(getClass().getClassLoader().getResource("images/smdogL.png")).getImage();
	Image heart = new ImageIcon(getClass().getClassLoader().getResource("images/life.png")).getImage();
	Image heart_x = new ImageIcon(getClass().getClassLoader().getResource("images/life_x.png")).getImage();
	
	Obstacle dg1 = new Obstacle(150, 155);
	Obstacle dg2 = new Obstacle(550, 110);
	// 위에 이미지 이름이 바로 rpg.png입니다. 이미지를 불러옵니다
	// 더블버퍼링용 입니다.
	Graphics gc;


	public void paint(Graphics g, Image buffimg, ImageObserver Frame) { // 더블버퍼링을 사용합니다.

		gc = buffimg.getGraphics();
		draw_Background(Frame); // 배경을 그리는 함수
		checkmark(Frame, 20, 230, 0); // 특수효과를 그리는 함수
		checkmark(Frame, 400, 40, 1);
		checkmark(Frame, 750, 120, 2);
		checkmark(Frame, 740, 340, 3);
		draw_dog1(Frame, dg1.ox, dg1.oy, 100, dg1);
		draw_dog1(Frame, dg2.ox, dg2.oy, 70, dg2);
		draw_life(Frame, CatStage.lck[0], 740, 30);
		draw_life(Frame, CatStage.lck[1], 695, 30);
		draw_life(Frame, CatStage.lck[2], 650, 30);
		update(g, buffimg, Frame);

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
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(map, 0, 0, Frame);
	}
/**
 * The draw_dog1 method draws the Obstacle(dog) and contains the collision information
 *
 * @author ChagngSeok-Lee
 * @param Frame ImageObserver
 * @param dx int input of Obstacle(dog)'s x-coordinate
 * @param dy int input of Obstacle(dog)'s y-coordinate
 * @param distance int Determine how far you want to move
 * @param dg Obstacle An object with x and y coordinates
 */
	public void draw_dog1(ImageObserver Frame, int dx, int dy, int distance, Obstacle dg) {
		if ((dx - 10 <= CatStage.x && dx + 30 >= CatStage.x)
				&& (dy - 10 <= CatStage.y && dy + 10 >= CatStage.y)) {
			if (CatStage.x <= dx)
				CatStage.x = CatStage.x - 50;
			else
				CatStage.x = CatStage.x + 50;

			if (CatStage.lck[0])
				CatStage.lck[0] = false;
			else if (CatStage.lck[1])
				CatStage.lck[1] = false;
			else
				CatStage.lck[2] = false;
		}
		if ((CatStage.cnt / distance) % 2 == 0) {
			dg.ox = dg.ox + 2;
		} else
			dg.ox = dg.ox - 2;
		gc.drawImage(dog, dx, dy, Frame);
	}
/** 
 * The checkmark method draws a map based on the state of the item.
 * 
 * @author ChagngSeok-Lee
 * @param Frame ImageObserver
 * @param cx int input of item's x-coordinate
 * @param cy int input of item's y-coordinate
 * @param ckindex int Variable for identifying each item.
 */
	public void checkmark(ImageObserver Frame, int cx, int cy, int ckindex) {
		if ((cx - 15 <= CatStage.x && cx + 15 >= CatStage.x)
				&& (cy - 15 <= CatStage.y && cy + 15 >= CatStage.y)) {
			CatStage.ck[ckindex] = false;

		}

		if (CatStage.ck[ckindex] == true) {
			gc.drawImage(check, cx, cy, Frame);
		}
	}
/**
 * draw_life is a method of drawing a heart (life) based on its state.
 * 
 * @author ChagngSeok-Lee
 * @param Frame ImageObserver
 * @param lck boolean Variable to check if the life has decreased.
 * @param lx int The x-coordinate of the heart image.
 * @param ly int The y-coordinate of the heart image.
 */
	public void draw_life(ImageObserver Frame, boolean lck, int lx, int ly) {
		if (lck) {
			gc.drawImage(heart, lx, ly, Frame);
		} else
			gc.drawImage(heart_x, lx, ly, Frame);
	}
/**
 * setInit is a method that initializes the map when the life is reduced.
 * 
 * @author ChagngSeok-Lee
 */
	public void setInit() {

		CatStage.x = 20;
		CatStage.y = 400;
		for (int i = 0; i < 4; i++) {
			CatStage.ck[i] = true;
		}
		for (int j = 0; j < 3; j++) {
			CatStage.lck[j] = true;
		}
	}

}