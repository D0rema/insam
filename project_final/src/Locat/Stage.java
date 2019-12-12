package Locat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 
 * Stage class
 * 
 * @author -------------------------------------
 *
 */
public class Stage extends JPanel implements Runnable {
	/**stage number*/
	public static int stage = 1;
	/** variable for checking character direction */
	public static boolean playerMove = false;
	/** character position */
	public static int x, y; 
	/** gravity variable */
	public static int g_y; 
	/** thread time counter */
	public static int cnt; 
	/** variable for checking character is moving */
	public static int moveStatus; 
	/** jumping variable */
	public static int jp1, jp2; 
	/** jumping variable */
	public static boolean try_jump = false;
	/** status of items */
	public static boolean[][] item = { { true, true, true, true }, { true, true, true, true, true, true } };
	/** -------------------------------- */
	public static int charLocation = 0;
	/** status of life */
	public static boolean[] life = { true, true, true };
	/**prevent keypressed*/
	public static int not_key = 0;
	/**prevent upkey*/
	public static int notUp = 1;
	/**prevent Downkey*/
	public static int notDown = 1;
	/**prevent rightkey*/
	public static int notRight = 0;
	/**prevent leftkey*/
	public static int notLeft = 1;
	/**findload stage character location*/
	public static int char_lo = 0;
	/**findload stage character mark check 
	 * fload1 = current loaction
	 * fload2 = past loction
	 * fload3 = fload2*10+fload1
	 * fload4 = past fload3
	 * fload5 = current fload3*/
	public static int fload1 = 0, fload2 = 0, fload3 = 0, fload4 = 0, fload5;
	/**human stage clear flag*/
	public static boolean clearflag3 = false, clearflag4 = false;
	/**human stage When it fails or when the key is pressed reset=true*/
	public static boolean reset = false;
	/**iceload puzzle boolean */
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
	public Stage() {
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
			x = 20;
			y = 436;
		}
		if (stage == 3) {
			x = 528;
			y = 124;
		}
		if (stage == 4) {
			x = 0;
			y = 316;
		}

		
	}
	public void paint(Graphics g) {
		buffimg = createImage(800, 600);
		imageManager.paint(g, buffimg, this);
	}

	public void update(Graphics g) {
		imageManager.update(g, buffimg, this);
	}
	/**
	 * prevent character leaving boundary
	 *
	 * @author JiSeongChoi
	 */
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
	/**
	 * prevent character leaving boundary
	 *
	 * @author ChoiMyeongKyu
	 */
	public void humanCheckBoundary() {

		if (y <= 60) {
			playerMove = false;
			notUp = 1;
		}

		if (y >= 508) {
			playerMove = false;
			notDown = 1;
		}

		if (x <= 60) {
			playerMove = false;
			notLeft = 1;
		}

		if (x >= 568) {
			playerMove = false;
			notRight = 1;
		}
		if (stage == 3) {
			if (y > 60 && y < 508 && x < 568 && x > 60) {
				notUp = 0;
				notDown = 0;
				notLeft = 0;
				notRight = 0;
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
	}

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
	}

	private Thread th;

	/**
	 * start is a method for simple order
	 * 
	 * @author All
	 */
	public void start() { 
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
			x = 20;
			y = 436;
		}
		if (stage == 3) {
			x = 528;
			y = 124;
		}
		if (stage == 4) {
			x = 0;
			y = 316;
		}
		for (int i = 0; i < item[stage - 1].length; i++) {
			item[stage - 1][i] = true;
		}
		for (int j = 0; j < 3; j++) {
			life[j] = true;
		}
	}

	/**
	 * running thread
	 * 
	 * @author All
	 */
	public void run() { 
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