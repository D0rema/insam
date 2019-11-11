package Locat;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class gameFrame {
	
	public static boolean playerMove = false;
	public static int x, y; // 케릭터의 현재 좌표를 받을 변수
	public static int g_x, g_y; // 중력을 체크하기 위한 좌표
	public static int cnt; // 무한 루프를 카운터 하기 위한 변수
	public static int moveStatus; // 케릭터가 어디를 바라보는지 방향을 받을 변수
	public static int jp1, jp2; // 점프 cnt를 계산하기 위한 값
	public static boolean try_jump = false;
	public static boolean ckmark1 = false;
	public static int not_key = 0;
	public static int char_lo = 0;
//키가 입력받아서 캐릭터가 움직이는 상황에는 true로 바뀜
	
	RpgGame_frame rg=new RpgGame_frame();
	}


class RpgGame_frame extends JFrame implements Runnable, KeyListener {

	key k1 = new key();

	draw_image d1 = new draw_image();

	check_wall w1 = new check_wall();

	puzzle_master z1 = new puzzle_master();

	Image buffimg;
	public ImageObserver Frame = this;

	public void init() {
		gameFrame.x = 100;// 시작할때 캐릭터의 좌표
		gameFrame.y = 100;// 시작할때 캐릭터의 좌표
		gameFrame.moveStatus = 2;
//케릭터가 시작할때 바라보는 방향은 아래쪽입니다.
// 0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽

	}

	RpgGame_frame() {
		setTitle("테스트");
		setSize(642, 639);
		init();
		start();

		Dimension screen = tk.getScreenSize();

		int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);
		setLocation(xpos, ypos);
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

	public void checkmark() {
		d1.checkmark(Frame);
	}

	public void in_flat() {
		w1.in_flat();
	}

	public void is_bottom() {
		w1.is_bottom();
	}

	public void on_wall() {
		w1.on_wall();
	}

	public void puzzle_master() {
		z1.find_load();
	}

	public int jumpy[] = { -8, -8, -8, 8, 8, 8 }; // 모르겟음
	Toolkit tk = Toolkit.getDefaultToolkit();

	Thread th;

	public void start() { // 기본적인 명령처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();

	}

	public void run() { // 스레드 메소드, 무한 루프
		while (true) {
			try {
				k1.keyProcess();
				repaint();
				on_wall();
//in_flat(); // 발판을 체크할수있는 함수 check_wall()로 통합 할수도있음
				Thread.sleep(20);
				gameFrame.cnt++;
//is_bottom(); // 중력과 바닥을 체크하는 함수 ,아래 w1. check_wall()로 통합 할수도있음
				w1.check_wall();
				puzzle_master();
			} catch (Exception e) {
			}
		}
	}

}
