package Locat;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class cat {
	public static boolean playerMove = false;
	public static int x, y; // �ɸ����� ���� ��ǥ�� ���� ����
	public static int g_x, g_y; // �߷��� üũ�ϱ� ���� ��ǥ
	public static int cnt; // ���� ������ ī���� �ϱ� ���� ����
	public static int moveStatus; // �ɸ��Ͱ� ��� �ٶ󺸴��� ������ ���� ����
	public static int jp1, jp2; // ���� cnt�� ����ϱ� ���� ��
	public static boolean try_jump = false;
	public static boolean[] ck= {true,true,true,true};
	public static boolean lck1 = true, lck2 = true, lck3 = true;
	public static int not_key = 0;
	public static int char_lo = 0;
//Ű�� �Է¹޾Ƽ� ĳ���Ͱ� �����̴� ��Ȳ���� true�� �ٲ�
	
	RpgGame_frame rg = new RpgGame_frame();
}

class RpgGame_frame extends JFrame implements Runnable, KeyListener {

	key k1 = new key();

	draw_image d1 = new draw_image();
	draw_image d2 = new draw_image();
	check_wall w1 = new check_wall();
	Ladder l = new Ladder();
	// puzzle_master z1 = new puzzle_master();

	Image buffimg;
	public ImageObserver Frame = this;

	public void init() {
		cat.x = 20;// �����Ҷ� ĳ������ ��ǥ
		cat.y = 400;// �����Ҷ� ĳ������ ��ǥ
		cat.moveStatus = 1;
//�ɸ��Ͱ� �����Ҷ� �ٶ󺸴� ������ �Ʒ����Դϴ�.
// 0 : ����, 1 : ������, 2 : �Ʒ���, 3 : ����

	}

	RpgGame_frame() {
		setTitle("�׽�Ʈ");
		setSize(main.SCREEN_WIDTH,main.SCREEN_HEIGHT);
		init();
		start();

		Dimension screen = tk.getScreenSize();

		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xpos, ypos);
		setLocationRelativeTo(null);//게임 창 정 중앙에 뜨도록 해줌
		setResizable(false);
		setVisible(true);

	}

	public void keyTyped(KeyEvent e) {
		k1.keyTyped(e);
	}

	public void keyReleased(KeyEvent e) {
		k1.keyReleased(e);
	}

	public void keyPressed(KeyEvent e) {
		k1.keyPressed(e);
	}

	public void paint(Graphics g) {
		buffimg = createImage(800, 600);
		d1.paint(g, buffimg, Frame);
	}

	public void update(Graphics g) {
		d1.update(g, buffimg, Frame);
	}

	public void DrawImg() {
		d1.DrawImg(Frame);
	}

	public void MoveImage(Image img, int x, int y, int width, int height) {
		d1.MoveImage(img, x, y, width, height, Frame);
	}

	public void draw_background() {
		d1.draw_background(Frame);
	}

	/*
	 * public void checkmark() { d1.checkmark(Frame); }
	 */

	public void in_flat() {
		w1.in_flat();
	}

	public void is_bottom() {
		w1.is_bottom();
	}

	public void on_wall() {
		w1.on_wall();
	}

	public boolean ck_check() {
		if (cat.ck[0] || cat.ck[1] || cat.ck[2]||cat.ck[3])
			return false;
		else
			return true;
	}

	public boolean lck_check() {
		if (cat.lck3)
			return false;
		else
			return true;
	}
	/*
	 * public void puzzle_master() { z1.find_load(); }
	 */

	Toolkit tk = Toolkit.getDefaultToolkit();

	Thread th;

	public void start() { // �⺻���� ���ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();
	}

	public void run() { // ������ �޼ҵ�, ���� ����
		while (true) {
			try {
				k1.keyProcess();
				repaint();
				on_wall();
//in_flat(); // ������ üũ�Ҽ��ִ� �Լ� check_wall()�� ���� �Ҽ�������
				Thread.sleep(20);
				cat.cnt++;
				l.on_Ladder();
//is_bottom(); // �߷°� �ٴ��� üũ�ϴ� �Լ� ,�Ʒ� w1. check_wall()�� ���� �Ҽ�������
				w1.wall_Check();
				if (lck_check()) {
				}
				// puzzle_master();
			} catch (Exception e) {
			}
		}
	}
}