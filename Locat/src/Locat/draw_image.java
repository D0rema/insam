package Locat;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class draw_image {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = new ImageIcon(main.class.getResource("../images/rpg2.png")).getImage();
	Image map = new ImageIcon(main.class.getResource("../images/map.png")).getImage();
	Image mark = new ImageIcon(main.class.getResource("../images/mark.png")).getImage();
	// 위에 이미지 이름이 바로 rpg.png입니다. 이미지를 불러옵니다
	// 더블버퍼링용 입니다.
	Graphics gc;

	public void paint(Graphics g, Image buffimg, ImageObserver Frame) { // 더블버퍼링을 사용합니다.

		gc = buffimg.getGraphics();
		draw_background(Frame); // 배경을 그리는 함수
		checkmark(Frame); // 특수효과를 그리는 함수
		update(g, buffimg, Frame);

	}

	public void update(Graphics g, Image buffimg, ImageObserver Frame) {
		// 더블 버퍼링을 이용해 버퍼에 그려진것을 가져옵니다.
		DrawImg(Frame);

		g.drawImage(buffimg, 0, 0, Frame);
	}

	public void DrawImg(ImageObserver Frame) {
		gc.setFont(new Font("Default", Font.BOLD, 20));
		gc.drawString(Integer.toString(gameFrame.cnt), 50, 50);
		gc.drawString(Integer.toString((gameFrame.playerMove) ? 1 : 0), 200, 50);
		gc.drawString(Integer.toString(gameFrame.x), 350, 50);
		gc.drawString(Integer.toString(gameFrame.y), 500, 50);
		gc.drawString(Integer.toString(gameFrame.jp1), 350, 100);
		gc.drawString(Integer.toString(gameFrame.char_lo), 500, 100);
		// gc.drawString(Integer.toString(on_bottom),500, 150);
		// gc.drawString(Integer.toString(on_flat),350, 150);

		// 위는 단순히 무한루프 적용여부와 케릭터 방향 체크를 위해
		// 눈으로 보면서 테스트할 용도로 쓰이는 텍스트 표출입니다.

		MoveImage(img, gameFrame.x, gameFrame.y, 50, 75, Frame);
		// 케릭터를 걸어가게 만들기 위해 추가로 만든 메소드 입니다.

	}

	public void MoveImage(Image img, int x, int y, int width, int height, ImageObserver Frame) {
		// 케릭터 이미지, 케릭터 위치, 케릭터 크기를 받습니다.
		// 받은 값을 이용해서 위의 이미지칩셋에서 케릭터를 잘라내
		// 표출하도록 계산하는 메소드 입니다.

		gc.setClip(x, y, width, height);
		// 현재 좌표에서 케릭터의 크기 만큼 이미지를 잘라 그립니다.

		if (gameFrame.playerMove) { // 케릭터의 움직임 여부를 판단합니다.
			if (gameFrame.cnt / 10 % 4 == 0) {
				gc.drawImage(img, x - (width * 0), y - (height * gameFrame.moveStatus), Frame);

			} else if (gameFrame.cnt / 10 % 4 == 1) {
				gc.drawImage(img, x - (width * 1), y - (height * gameFrame.moveStatus), Frame);

			} else if (gameFrame.cnt / 10 % 4 == 2) {
				gc.drawImage(img, x - (width * 2), y - (height * gameFrame.moveStatus), Frame);

			} else if (gameFrame.cnt / 10 % 4 == 3) {
				gc.drawImage(img, x - (width * 1), y - (height * gameFrame.moveStatus), Frame);
			}
			// 케릭터의 방향에 따라 걸어가는 모션을 취하는
			// 케릭터 이미지를 시간차를 이용해 순차적으로 그립니다.

		} else {
			gc.drawImage(img, x - (width * 1), y - (height * gameFrame.moveStatus), Frame);
			// 케릭터가 움직이지 않으면 정지한 케릭터를 그립니다.

		}
	}

	public void draw_background(ImageObserver Frame) {
		gc.clearRect(0, 0, 642, 639);
		gc.drawImage(map, 0, 0, Frame);
	}

	public void checkmark(ImageObserver Frame) {
		if (gameFrame.x < 164 && gameFrame.x > 132 && gameFrame.y < 148 && gameFrame.y > 108) {
			gameFrame.ckmark1 = true;

		}

		if (gameFrame.ckmark1 == true) {
			gc.drawImage(mark, 135, 105, Frame);

			if (gameFrame.x < 164 && gameFrame.x > 100) {

			}
			;// 캐릭터가 위에 있을때(148,116)

		}
	}
}
