/*package Locat;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class ImageManager2 {
	Image img = new ImageIcon(getClass().getClassLoader().getResource("images/cat.png")).getImage();
	Image map2 = new ImageIcon(getClass().getClassLoader().getResource("images/stage2.png")).getImage();// *�̹��� ����
	Image check = new ImageIcon(getClass().getClassLoader().getResource("images/check.png")).getImage();
	Image dog = new ImageIcon(getClass().getClassLoader().getResource("images/smdogL.png")).getImage();
	Image icicle = new ImageIcon(getClass().getClassLoader().getResource("images/icicle.png")).getImage();
	Image heart = new ImageIcon(getClass().getClassLoader().getResource("images/life.png")).getImage();
	Image heart_x = new ImageIcon(getClass().getClassLoader().getResource("images/life_x.png")).getImage();

	Obstacle dg1 = new Obstacle(100, 355, 80);
	Obstacle dg2 = new Obstacle(67, 50, 70);
	Obstacle dg3 = new Obstacle(605, 150, 65);
	Obstacle dg4 = new Obstacle(515, 395, 75);
	Icicle icicle1 = new Icicle(135,255,125);
	Icicle icicle2 = new Icicle(180,130,70);
	Icicle icicle3 = new Icicle(420,140,110);
	Icicle icicle4 = new Icicle(575,315,100);
	
	// ���� �̹��� �̸��� �ٷ� rpg.png�Դϴ�. �̹����� �ҷ��ɴϴ�
	
	// ������۸��� �Դϴ�.
	Graphics gc;
	
	

	public void paint(Graphics g, Image buffimg, ImageObserver Frame) { // ������۸��� ����մϴ�.

		gc = buffimg.getGraphics();
		draw_Background(Frame); // ����� �׸��� �Լ�
		drawItem(Frame, 110, 370, 0); // Ư��ȿ���� �׸��� �Լ�
		drawItem(Frame, 10, 138, 1);
		drawItem(Frame, 200, 70, 2);
		drawItem(Frame, 500, 55, 3);
		drawItem(Frame, 750, 165, 4);
		drawItem(Frame, 750, 345, 5);
		drawDog(Frame, dg1.ox, dg1.oy, dg1);
		drawDog(Frame, dg2.ox, dg2.oy, dg2);
		drawDog(Frame, dg3.ox, dg3.oy, dg3);
		drawDog(Frame, dg4.ox, dg4.oy, dg4);
		drawIcicle(Frame, icicle1.ix, icicle1.iy, icicle1);
		drawIcicle(Frame, icicle2.ix, icicle2.iy, icicle2);
		drawIcicle(Frame, icicle3.ix, icicle3.iy, icicle3);
		drawIcicle(Frame, icicle4.ix, icicle4.iy, icicle4);
		drawLife(Frame, CatStage.life[0], 740, 30);
		drawLife(Frame, CatStage.life[1], 695, 30);
		drawLife(Frame, CatStage.life[2], 650, 30);
		update(g, buffimg, Frame);

	}

	public void update(Graphics g, Image buffimg, ImageObserver Frame) {
		// ���� ���۸��� �̿��� ���ۿ� �׷������� �����ɴϴ�.
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

		// ���� �ܼ��� ���ѷ��� ���뿩�ο� �ɸ��� ���� üũ�� ����
		// ������ ���鼭 �׽�Ʈ�� �뵵�� ���̴� �ؽ�Ʈ ǥ���Դϴ�.

		MoveImage(img, CatStage.x, CatStage.y, 50, 75, Frame);
		// �ɸ��͸� �ɾ�� ����� ���� �߰��� ���� �޼ҵ� �Դϴ�.

	}

	public void MoveImage(Image img, int x, int y, int width, int height, ImageObserver Frame) {
		// �ɸ��� �̹���, �ɸ��� ��ġ, �ɸ��� ũ�⸦ �޽��ϴ�.
		// ���� ���� �̿��ؼ� ���� �̹���Ĩ�¿��� �ɸ��͸� �߶�
		// ǥ���ϵ��� ����ϴ� �޼ҵ� �Դϴ�.

		gc.setClip(x, y, width, height);
		// ���� ��ǥ���� �ɸ����� ũ�� ��ŭ �̹����� �߶� �׸��ϴ�.

		if (CatStage.playerMove) { // �ɸ����� ������ ���θ� �Ǵ��մϴ�.
			if (CatStage.cnt / 10 % 4 == 0) {
				gc.drawImage(img, x - (width * 0), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 1) {
				gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 2) {
				gc.drawImage(img, x - (width * 2), y - (height * CatStage.moveStatus), Frame);

			} else if (CatStage.cnt / 10 % 4 == 3) {
				gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);
			}
			// �ɸ����� ���⿡ ���� �ɾ�� ����� ���ϴ�
			// �ɸ��� �̹����� �ð����� �̿��� ���������� �׸��ϴ�.

		} else {
			gc.drawImage(img, x - (width * 1), y - (height * CatStage.moveStatus), Frame);
			// �ɸ��Ͱ� �������� ������ ������ �ɸ��͸� �׸��ϴ�.

		}
	}

	public void draw_Background(ImageObserver Frame) {
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(map2, 0, 0, Frame);
	}

	/**
	 * The draw_dog1 method draws the Obstacle(dog) and contains the collision
	 * information
	 *
	 * @author ChagngSeok-Lee
	 * @param Frame    ImageObserver
	 * @param dx       int input of Obstacle(dog)'s x-coordinate
	 * @param dy       int input of Obstacle(dog)'s y-coordinate
	 * @param distance int Determine how far you want to move
	 * @param dg       Obstacle An object with x and y coordinates
	 */
	/*public void drawDog(ImageObserver Frame, int dx, int dy, Obstacle dg) {
		dg.crush();
		dg.move();
		gc.drawImage(dog, dx, dy, Frame);
	}
	public void drawIcicle(ImageObserver Frame, int dx, int dy, Icicle ice) {
		ice.move();
		gc.drawImage(icicle, dx, dy, Frame);
	}

	/**
	 * The checkmark method draws a map based on the state of the item.
	 * 
	 * @author ChagngSeok-Lee
	 * @param Frame   ImageObserver
	 * @param cx      int input of item's x-coordinate
	 * @param cy      int input of item's y-coordinate
	 * @param ckindex int Variable for identifying each item.
	 */
	/*public void drawItem(ImageObserver Frame, int cx, int cy, int ckindex) {
		if ((cx - 15 <= CatStage.x && cx + 15 >= CatStage.x) && (cy - 15 <= CatStage.y && cy + 15 >= CatStage.y)) {
			CatStage.item[ckindex] = false;

		}

		if (CatStage.item[ckindex] == true) {
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
	/*public void drawLife(ImageObserver Frame, boolean lck, int lx, int ly) {
		if (lck) {
			gc.drawImage(heart, lx, ly, Frame);
		} else
			gc.drawImage(heart_x, lx, ly, Frame);
	}

}

*/