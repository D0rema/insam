package Locat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class CatStage extends JPanel implements Runnable {
	public static int stage = 1;
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
	public static boolean[][] item = { { true, true, true, true }, { true, true, true, true, true, true } };// ȹ���ؾ��ϴ�
																											// �����۵���
																											// ����
	public static int charLocation = 0;
	/** status of life */
	public static boolean[] life = { true, true, true };// ������ üũ�� ���� ����
	public static int not_key = 0;
	public static int notUp = 1;
	public static int notDown = 1;
	public static int notRight = 0;
	public static int notLeft = 1;
	public static int char_lo = 0;
	public static int fload1 = 0, fload2 = 0, fload3 = 0, fload4 = 0, fload5;
	public static boolean clearflag1 = false, clearflag2 = false, clearflag3 = false, clearflag4 = false;
	public static boolean reset = false;
	public static boolean sliding = true;

	ImageManager imageManager = new ImageManager();
	FindLoadPuzzle findLoadPuzzle = new FindLoadPuzzle();
	IceLoadPuzzle iceLoadPuzzle = new IceLoadPuzzle();
	Wall wall = new Wall();
	Block block = new Block();
	Ladder ladder = new Ladder();
	Image buffimg;

	/**
	 * Constructor of Frame
	 *
	 * @author All
	 */
	public CatStage() {// ���ο� �����ӻ���
		gameSave.save();
		setSize(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT);
		init();

		addKeyListener(new CatStageKey());

		addKeyListener(new HumanStageKey());

		setFocusable(true);
		start();
	}

	/**
	 * set initial values of character
	 *
	 * @author JiSeongChoi
	 */
	public void init() {
		if (stage == 1 || stage == 2) {
			x = 20;// �����Ҷ� ĳ������ ��ǥ
			y = 436;// �����Ҷ� ĳ������ ��ǥ
		}
		if (stage == 3) {
			x = 528;// �����Ҷ� ĳ������ ��ǥ
			y = 124;// �����Ҷ� ĳ������ ��ǥ
		}
		if (stage == 4) {
			x = 0;// �����Ҷ� ĳ������ ��ǥ
			y = 316;// �����Ҷ� ĳ������ ��ǥ
		}

		// 0 : ����, 1 : ������, 2 : �Ʒ���, 3 : ����
	}

	public void paint(Graphics g) {
		buffimg = createImage(800, 600);
		imageManager.paint(g, buffimg, this);
	}

	public void update(Graphics g) {
		imageManager.update(g, buffimg, this);
	}

	public void checkBoundary() {
		if (y <= 0) {
			playerMove = false;
			not_key = 1;
		}
		if (y >= 520) {
			playerMove = false;
			not_key = 2;
		}

		if (x <= 16) {
			playerMove = false;
			not_key = 3;
		}

		if (x >= 744) {
			playerMove = false;
			not_key = 4;
		}
		if (y >= 48 && y <= 484 && x <= 744 && x >= 16) {
			not_key = 0;
		}

	}

	public void humanCheckBoundary() {

		if (CatStage.y <= 60) {
			CatStage.playerMove = false;
			CatStage.notUp = 1;
		}

		if (CatStage.y >= 508) {
			CatStage.playerMove = false;
			CatStage.notDown = 1;
		}

		if (CatStage.x <= 60) {
			CatStage.playerMove = false;
			CatStage.notLeft = 1;
		}

		if (CatStage.x >= 568) {
			CatStage.playerMove = false;
			CatStage.notRight = 1;
		}
		if (stage == 3) {
			if (CatStage.y > 60 && CatStage.y < 508 && CatStage.x < 568 && CatStage.x > 60) {
				CatStage.notUp = 0;
				CatStage.notDown = 0;
				CatStage.notLeft = 0;
				CatStage.notRight = 0;
			}
		}
	}

	/**
	 * itemCheck is a method that checks if all items are eaten.
	 * 
	 * @author ChagngSeok-Lee
	 * @return True if the item has been consumed otherwise returns false.
	 */

	public boolean itemCheck() {
		boolean checkItem = item[stage - 1][0];

		for (int i = 1; i < item[stage - 1].length; i++) {
			checkItem = checkItem || item[stage - 1][i];
		}
		if (!checkItem)
			return false;
		else
			return true;
	}// �������� ��� �Ծ����� Ȯ���ϴ� �޼ҵ�

	/**
	 * lifeCheck is a method that checks if all life is exhausted.
	 * 
	 * @author ChagngSeok-Lee
	 * @return True if the life is exhausted, false otherwise.
	 */
	public boolean lifeCheck() {
		if (life[2])
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
	 * setInit is a method that initializes the map when the life is reduced.
	 * 
	 * @author ChagngSeok-Lee
	 */
	public void setInit() {
		gameSave.save();
		if (stage == 1 || stage == 2) {
			x = 20;// �����Ҷ� ĳ������ ��ǥ
			y = 436;// �����Ҷ� ĳ������ ��ǥ
		}
		if (stage == 3) {
			x = 528;// �����Ҷ� ĳ������ ��ǥ
			y = 124;// �����Ҷ� ĳ������ ��ǥ
		}
		if (stage == 4) {
			x = 0;// �����Ҷ� ĳ������ ��ǥ
			y = 316;// �����Ҷ� ĳ������ ��ǥ
		}
		for (int i = 0; i < item[stage - 1].length; i++) {
			CatStage.item[stage - 1][i] = true;
		}
		for (int j = 0; j < 3; j++) {
			CatStage.life[j] = true;
		}
	}

	/**
	 * running thread
	 * 
	 * @author All
	 */
	public void run() { // ������ �޼ҵ�, ���� ����
		while (true) {
			try {
				if (stage == 1 | stage == 2) {
					CatStageKey.keyProcess();
				}
				if (stage == 3 | stage == 4) {
					HumanStageKey.keyProcess();
				}
				repaint();
				if (stage == 1) {
					block.check();
					ladder.on_Ladder();
					checkBoundary();
					if (lifeCheck()) {
						setInit();
					}

					if (!itemCheck()) {
						stage = 2;
						setInit();
						cnt = 0;
						jp1 = 0;
						jp2 = 0;

					}
				}
				if (stage == 2) {
					block.check();
					ladder.on_Ladder();
					checkBoundary();
					if (lifeCheck()) {
						setInit();
					}

					if (!itemCheck()) {
						stage = 3;
						setInit();
						cnt = 0;
						jp1 = 0;
						jp2 = 0;

					}
				}
				if (stage == 3) {
					findLoadPuzzle.solvePuzzle();
					humanCheckBoundary();
					if (clearflag3 == true) {
						stage = 4;
						setInit();
						cnt = 0;
						jp1 = 0;
						jp2 = 0;

						clearflag3 = false;
					}
				}
				if (stage == 4) {
					iceLoadPuzzle.solvePuzzle();
					wall.solveWall();
					if (clearflag4 == true) {
						stage = 1;
						setInit();
						cnt = 0;
						jp1 = 0;
						jp2 = 0;

					}
				}

				Thread.sleep(20);
				cnt++;

				// puzzle_master();
			} catch (Exception e) {
			}
		}
	}
}