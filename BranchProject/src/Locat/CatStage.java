package Locat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class CatStage extends JPanel implements Runnable {
	/** variable for checking character direction */
	public static boolean playerMove = false;
	/** character position */
	public static int x, y; // �ɸ����� ���� ��ǥ�� ���� ����
	/** gravity variable */
	public static int g_y; // �߷��� üũ�ϱ� ���� ��ǥ
	/** thread time counter */
	public static int cnt; // ���� ������ ī���� �ϱ� ���� ����
	/** variable for checking character direction */
	public static int moveStatus; // �ɸ��Ͱ� ��� �ٶ󺸴��� ������ ���� ����
	/** jumping variable */
	public static int jp1, jp2; // ���� cnt�� ����ϱ� ���� ��
	/** jumping variable */
	public static boolean try_jump = false;// ������ �� �߷� ���¸� ���� ����
	/** status of items */
	public static boolean[] ck = { true, true, true, true };// ȹ���ؾ��ϴ� �����۵��� ����
	/** status of life */
	public static boolean[] lck = { true, true, true };// ������ üũ�� ���� ����
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
	public CatStage() {// ���ο� �����ӻ���
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
		x = 20;// �����Ҷ� ĳ������ ��ǥ
		y = 436;// �����Ҷ� ĳ������ ��ǥ
		moveStatus = 1;
		// 0 : ����, 1 : ������, 2 : �Ʒ���, 3 : ����
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
	}// �������� ��� �Ծ����� Ȯ���ϴ� �޼ҵ�

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
	}// �������� ��� ���������� Ȯ���ϴ� �Լ�
	/*
	 * public void puzzle_master() { z1.find_load(); }
	 */

	private Thread th;

	/**
	 * start is a method for simple order
	 * 
	 * @author All
	 */
	public void start() { // �⺻���� ���ó��
		th = new Thread(this);
		th.start();
	}

	/**
	 * running thread
	 * 
	 * @author All
	 */
	public void run() { // ������ �޼ҵ�, ���� ����
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