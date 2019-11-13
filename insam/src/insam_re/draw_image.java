package insam_re;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class draw_image {
	Image img = new ImageIcon("images/rpg2.png").getImage();
	Image map = new ImageIcon("images/stage1.png").getImage();//*�̹��� ����
	Image check = new ImageIcon("images/check.png").getImage();
	Image dog = new ImageIcon("images/smdogL.png").getImage();
	Image heart = new ImageIcon("images/life.png").getImage();
	Image heart_x = new ImageIcon("images/life_x.png").getImage();
	
	obstacle dg1=new obstacle(150,155);
	obstacle dg2=new obstacle(550,110);
	// ���� �̹��� �̸��� �ٷ� rpg.png�Դϴ�. �̹����� �ҷ��ɴϴ�
	// ������۸��� �Դϴ�.
	Graphics gc;

	private moving_test moving_test = null;

	
 	public void paint(Graphics g, Image buffimg, ImageObserver Frame) { // ������۸��� ����մϴ�.

		gc = buffimg.getGraphics();
		draw_background(Frame); // ����� �׸��� �Լ�
		checkmark1(Frame,20,230); // Ư��ȿ���� �׸��� �Լ�
		checkmark2(Frame,400,40);
		checkmark3(Frame,750,120);
		draw_dog1(Frame, dg1.ox,dg1.oy);
		draw_dog2(Frame, dg2.ox,dg2.oy);
		draw_life(Frame, moving_test.lck1,740,30);
		draw_life(Frame, moving_test.lck2,695,30);
		draw_life(Frame, moving_test.lck3,650,30);
		update(g, buffimg, Frame);
		

		
	}

	public void update(Graphics g, Image buffimg, ImageObserver Frame) {
		// ���� ���۸��� �̿��� ���ۿ� �׷������� �����ɴϴ�.
		DrawImg(Frame);

		g.drawImage(buffimg, 0, 0, Frame);
	}

	public void DrawImg(ImageObserver Frame) {
		gc.setFont(new Font("Default", Font.BOLD, 20));
		gc.drawString(Integer.toString(moving_test.cnt), 50, 50);
		gc.drawString(Integer.toString((moving_test.playerMove) ? 1 : 0), 200, 50);
		gc.drawString(Integer.toString(moving_test.x), 350, 50);
		gc.drawString(Integer.toString(moving_test.y), 500, 50);
		gc.drawString(Integer.toString(moving_test.jp1), 350, 100);
		gc.drawString(Integer.toString(moving_test.char_lo), 500, 100);
		// gc.drawString(Integer.toString(on_bottom),500, 150);
		// gc.drawString(Integer.toString(on_flat),350, 150);

		// ���� �ܼ��� ���ѷ��� ���뿩�ο� �ɸ��� ���� üũ�� ����
		// ������ ���鼭 �׽�Ʈ�� �뵵�� ���̴� �ؽ�Ʈ ǥ���Դϴ�.

		MoveImage(img, moving_test.x, moving_test.y, 50, 75, Frame);
		// �ɸ��͸� �ɾ�� ����� ���� �߰��� ���� �޼ҵ� �Դϴ�.

	}

	public void MoveImage(Image img, int x, int y, int width, int height, ImageObserver Frame) {
		// �ɸ��� �̹���, �ɸ��� ��ġ, �ɸ��� ũ�⸦ �޽��ϴ�.
		// ���� ���� �̿��ؼ� ���� �̹���Ĩ�¿��� �ɸ��͸� �߶�
		// ǥ���ϵ��� ����ϴ� �޼ҵ� �Դϴ�.

		gc.setClip(x, y, width, height);
		// ���� ��ǥ���� �ɸ����� ũ�� ��ŭ �̹����� �߶� �׸��ϴ�.

		if (moving_test.playerMove) { // �ɸ����� ������ ���θ� �Ǵ��մϴ�.
			if (moving_test.cnt / 10 % 4 == 0) {
				gc.drawImage(img, x - (width * 0), y - (height * moving_test.moveStatus), Frame);

			} else if (moving_test.cnt / 10 % 4 == 1) {
				gc.drawImage(img, x - (width * 1), y - (height * moving_test.moveStatus), Frame);

			} else if (moving_test.cnt / 10 % 4 == 2) {
				gc.drawImage(img, x - (width * 2), y - (height * moving_test.moveStatus), Frame);

			} else if (moving_test.cnt / 10 % 4 == 3) {
				gc.drawImage(img, x - (width * 1), y - (height * moving_test.moveStatus), Frame);
			}
			// �ɸ����� ���⿡ ���� �ɾ�� ����� ���ϴ�
			// �ɸ��� �̹����� �ð����� �̿��� ���������� �׸��ϴ�.

		} else {
			gc.drawImage(img, x - (width * 1), y - (height * moving_test.moveStatus), Frame);
			// �ɸ��Ͱ� �������� ������ ������ �ɸ��͸� �׸��ϴ�.

		}
	}
	public void draw_background(ImageObserver Frame) {
		gc.clearRect(0, 0, 800, 600);
		gc.drawImage(map, 0, 0, Frame);
	}
	public void draw_dog1(ImageObserver Frame, int dx, int dy) {
		if ((dx-10<=moving_test.x && dx+30>=moving_test.x) && 
				(dy-10<=moving_test.y && dy+10>=moving_test.y)) {
			if(moving_test.x<=dx)moving_test.x=moving_test.x-50;
			else 
				moving_test.x=moving_test.x+50;
			
			if(moving_test.lck1)
				moving_test.lck1=false;
			else if(moving_test.lck2)
				moving_test.lck2=false;
			else moving_test.lck3=false;
		}
		if((moving_test.cnt/110)%2==0) {
			dg1.ox=dg1.ox+2;
		}
		else
			dg1.ox=dg1.ox-2;
		gc.drawImage(dog, dx, dy, Frame);
	}
	public void draw_dog2(ImageObserver Frame, int dx, int dy) {
		if ((dx-10<=moving_test.x && dx+30>=moving_test.x) && 
				(dy-10<=moving_test.y && dy+10>=moving_test.y)) {
			if(moving_test.x<=dx)moving_test.x=moving_test.x-50;
			else
				moving_test.x=moving_test.x+50;
			
			if(moving_test.lck1)
				moving_test.lck1=false;
			else if(moving_test.lck2)
				moving_test.lck2=false;
			else moving_test.lck3=false;
		}
		if((moving_test.cnt/70)%2==0) {
			dg2.ox=dg2.ox+3;
		}
		else
			
			dg2.ox=dg2.ox-3;
		gc.drawImage(dog, dx, dy, Frame);
	}

	public void checkmark1(ImageObserver Frame,int cx,int cy) {
		if ((cx-10<=moving_test.x && cx+10>=moving_test.x) && 
				(cy-10<=moving_test.y && cy+10>=moving_test.y)) {
			moving_test.ck1 = false;

		}

		if (moving_test.ck1 == true) {
			gc.drawImage(check, cx, cy, Frame);
		}
	}
	
	public void checkmark2(ImageObserver Frame,int cx,int cy) {
		if ((cx-15<=moving_test.x && cx+15>=moving_test.x) && 
				(cy-15<=moving_test.y && cy+15>=moving_test.y)) {
			moving_test.ck2 = false;

		}

		if (moving_test.ck2 == true) {
			gc.drawImage(check, cx, cy, Frame);
		}
	}
	
	public void checkmark3(ImageObserver Frame,int cx,int cy) {
		if ((cx-10<=moving_test.x && cx+10>=moving_test.x) && 
				(cy-10<=moving_test.y && cy+10>=moving_test.y)) {
			moving_test.ck3 = false;
			

		}

		if (moving_test.ck3 == true) {
			gc.drawImage(check, cx, cy, Frame);
		}
	}
	public void draw_life(ImageObserver Frame,boolean lck , int lx, int ly) {
		if(lck) {
			gc.drawImage(heart,lx, ly,Frame );
		}
		else
			gc.drawImage(heart_x,lx,ly,Frame);
	}
}
