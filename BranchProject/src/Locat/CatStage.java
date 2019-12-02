package Locat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class CatStage extends JPanel implements Runnable {
	/** variable for checking character direction */
	public static boolean playerMove = false;
	/** character position */
	public static int x, y; // 케릭터의 현재 좌표를 받을 변수
	/** gravity variable */
	public static int g_y; // 중력을 체크하기 위한 좌표
	/** thread time counter */
	public static int cnt; // 무한 루프를 카운터 하기 위한 변수
	/** variable for checking character direction */
	public static int moveStatus; // 케릭터가 어디를 바라보는지 방향을 받을 변수
	/** jumping variable */
	public static int jp1, jp2; // 점프 cnt를 계산하기 위한 값
	/** jumping variable */
	public static boolean try_jump = false;// 점프할 때 중력 상태를 받을 변수
	/** status of items */
	public static boolean[] ck = { true, true, true, true };// 획득해야하는 아이템들의 상태
	/** status of life */
	public static boolean[] lck = { true, true, true };// 라이프 체크를 위한 변수
	public static int not_key = 0;
	public static int char_lo = 0;

	ImageManager imageManager = new ImageManager();
	Block block = new Block();
	Ladder ladder = new Ladder();
	Image buffimg;

	/**
	 * Constructor of Frame
	 *
	 * @author All
	 */
	public CatStage() {// 새로운 프레임생성
		setSize(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT);
		init();
		addKeyListener(new CatStageKey());
		setFocusable(true);
		start();
	}
	
	/**
	 * set initial values of character
	 *
	 * @author JiSeongChoi
	 */
	public void init() {
		x = 20;// 시작할때 캐릭터의 좌표
		y = 436;// 시작할때 캐릭터의 좌표
		moveStatus = 1;
		// 0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽
	}


	public void paint(Graphics g) {
		buffimg = createImage(800, 600);
		imageManager.paint(g, buffimg, this);
	}

	public void update(Graphics g) {
		imageManager.update(g, buffimg, this);
	}

	/**
	 * ck_check is a method that checks if all items are eaten.
	 * 
	 * @author ChagngSeok-Lee
	 * @return True if the item has been consumed otherwise returns false.
	 */

	public boolean ck_check() {
		if (ck[0] || ck[1] || ck[2] || ck[3])
			return false;
		else
			return true;
	}// 아이템을 모두 먹었는지 확인하는 메소드

	/**
	 * lck_check is a method that checks if all life is exhausted.
	 * 
	 * @author ChagngSeok-Lee
	 * @return True if the life is exhausted, false otherwise.
	 */
	public boolean lck_check() {
		if (lck[2])
			return false;
		else
			return true;
	}// 라이프가 모두 떨어졌는지 확인하는 함수
	/*
	 * public void puzzle_master() { z1.find_load(); }
	 */

	private Thread th;

	/**
	 * start is a method for simple order
	 * 
	 * @author All
	 */
	public void start() { // 기본적인 명령처리
		th = new Thread(this);
		th.start();
	}

	/**
	 * running thread
	 * 
	 * @author All
	 */
	public void run() { // 스레드 메소드, 무한 루프
		while (true) {
			try {
				CatStageKey.keyProcess();
				repaint();
				
				block.check();
				block.checkBoundary();
				
				Thread.sleep(20);
				cnt++;
				
				ladder.on_Ladder();
				
				if (lck_check()) {
					imageManager.setInit();
				}
				
				if (ck_check()) {
					MainFrame.currentStage = 0;
					Main.mainFrame.changePanel(MainFrame.currentStage);
					ck[0]=false;
				}
				// puzzle_master();
			} catch (Exception e) {
			}
		}
	}
}