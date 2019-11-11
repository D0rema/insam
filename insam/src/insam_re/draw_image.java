package insam_re;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;

public class draw_image{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = new ImageIcon("images/rpg2.png").getImage();
	Image map = new ImageIcon("images/map.png").getImage();
	Image mark = new ImageIcon("images/mark.png").getImage();
	//���� �̹��� �̸��� �ٷ� rpg.png�Դϴ�. �̹����� �ҷ��ɴϴ�
	// ������۸��� �Դϴ�.
	Graphics gc;
	
	private moving_test moving_test = null;
	moving_test m1 = new moving_test();


	

	public void paint(Graphics g,Image buffimg,ImageObserver Frame){ //������۸��� ����մϴ�.
			
		gc = buffimg.getGraphics();
		draw_background(Frame); //����� �׸��� �Լ�
		checkmark(Frame); // Ư��ȿ���� �׸��� �Լ�
		update(g,buffimg,Frame);

		}

		public void update(Graphics g,Image buffimg,ImageObserver Frame){
		//���� ���۸��� �̿��� ���ۿ� �׷������� �����ɴϴ�.
		DrawImg(Frame);

		g.drawImage(buffimg, 0, 0, Frame);
		}

		public void DrawImg(ImageObserver Frame){
		gc.setFont(new Font("Default", Font.BOLD, 20));
		gc.drawString(Integer.toString(moving_test.cnt), 50, 50);
		gc.drawString(Integer.toString((moving_test.playerMove)?1:0),200, 50);
		gc.drawString(Integer.toString(moving_test.x),350, 50);
		gc.drawString(Integer.toString(moving_test.y),500, 50);
		gc.drawString(Integer.toString(moving_test.jp1),350, 100);
		gc.drawString(Integer.toString(moving_test.char_lo),500, 100);
		//gc.drawString(Integer.toString(on_bottom),500, 150);
		//gc.drawString(Integer.toString(on_flat),350, 150);

		//���� �ܼ��� ���ѷ��� ���뿩�ο� �ɸ��� ���� üũ�� ����
		//������ ���鼭 �׽�Ʈ�� �뵵�� ���̴� �ؽ�Ʈ ǥ���Դϴ�.

		MoveImage(img, moving_test.x, moving_test.y, 50, 75,Frame);
		//�ɸ��͸� �ɾ�� ����� ���� �߰��� ���� �޼ҵ� �Դϴ�.
	
		}
		public void MoveImage(Image img, int x, int y, int width, 
				int height,ImageObserver Frame){
				//�ɸ��� �̹���, �ɸ��� ��ġ, �ɸ��� ũ�⸦ �޽��ϴ�.
				//���� ���� �̿��ؼ� ���� �̹���Ĩ�¿��� �ɸ��͸� �߶�
				//ǥ���ϵ��� ����ϴ� �޼ҵ� �Դϴ�.

				gc.setClip(x  , y, width, height);
				//���� ��ǥ���� �ɸ����� ũ�� ��ŭ �̹����� �߶� �׸��ϴ�.

				if( moving_test.playerMove ){ // �ɸ����� ������ ���θ� �Ǵ��մϴ�.
				if ( moving_test.cnt / 10 % 4 == 0 ){ gc.drawImage(img,
				x - ( width * 0 ), y - ( height * moving_test.moveStatus ), Frame);

				}else  if(moving_test.cnt/10%4 == 1){ gc.drawImage(img,
				x - ( width * 1 ), y - ( height * moving_test.moveStatus ), Frame);

				}else  if(moving_test.cnt/10%4 == 2){  gc.drawImage(img,
				x - ( width * 2 ), y - ( height * moving_test.moveStatus ), Frame);

				}else  if(moving_test.cnt/10%4 == 3){ gc.drawImage(img,
				x - ( width * 1 ), y - ( height * moving_test.moveStatus ), Frame);
				}
				//�ɸ����� ���⿡ ���� �ɾ�� ����� ���ϴ� 
				//�ɸ��� �̹����� �ð����� �̿��� ���������� �׸��ϴ�.

				}else { gc.drawImage(img, x - ( width * 1 ), 
				y - ( height * moving_test.moveStatus ), Frame);
				//�ɸ��Ͱ� �������� ������ ������ �ɸ��͸� �׸��ϴ�.

				}
				}
		public void draw_background(ImageObserver Frame) {
			gc.clearRect(0, 0, 642, 639);
			gc.drawImage(map,0,0,Frame);
		}
		
		public void checkmark(ImageObserver Frame) {
			 if(moving_test.x<164&&moving_test.x>132&&moving_test.y<148&&moving_test.y>108) {
				 moving_test.ckmark1 = true;
				 
			 }
			 
			 if(moving_test.ckmark1==true) {
				 gc.drawImage(mark,135,105,Frame);
				 
					 if(moving_test.x<164&&moving_test.x>100) {
						
					 };//ĳ���Ͱ� ���� ������(148,116)
			 
			
		 }
		}
}

