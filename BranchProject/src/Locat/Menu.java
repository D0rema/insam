package Locat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/startButtonBasic.png"));
	private ImageIcon continueButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/continueButtonEntered.png"));
	private ImageIcon continueButtonBasicImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/continueButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonBasic.png"));

	private JButton startButton = new JButton(startButtonBasicImage); // ��ư ��ü
	private JButton continueButton = new JButton(continueButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private Image screenImage;
	private Graphics screenGraphic; // ������۸��� ���� ��üȭ�鿡 ���� �̹����� ����
	private Image background = new ImageIcon(getClass().getClassLoader().getResource("images/backImage.png"))
			.getImage();// �̹����� ���� �� �ִ� ��ü ���� �� �̹��� ��������
	private int mouseX, mouseY;

	public Menu() {
		setSize(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT);
		setVisible(true); // â ���� �� �ְ� ����
		setBackground(new Color(0, 0, 0, 0)); // ����Ʈ ������Ʈ�� ������ ����� �Ͼ������ �ٲ�
		setLayout(null);// ��ư�� ���ϴ� ��ġ�� �����Ϸ���
		setFocusable(true);
		
		Music introMusic=new Music("introMusic.mp3",true);//���� ȭ�鿡�� ���� ����
		introMusic.start();
		setComponents();
	}
	
	public void setComponents() {
		setButton();
		setMenuBar();
	}

	public void setButton() { // ���ӽ���, ���ӷε�, �������ư ����
		startButton.setBounds(250, 330, 300, 50);
		startButton.setBorderPainted(false);// �⺻ ��ư�� ����� ���ֱ�
		startButton.setContentAreaFilled(false);// �⺻ ��� ���ֱ�
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺 �ö����� Ŀ���� �ո������ �ٲ�°�
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ���� �����̺�Ʈ ȭ�� ��ȯ
				MainFrame.currentStage = 1;
				Main.mainFrame.changePanel(MainFrame.currentStage); // ���ο� â���� ��ȯ
			}
		});
		add(startButton);

		continueButton.setBounds(246, 400, 300, 50);
		continueButton.setBorderPainted(false);// �⺻ ��ư�� ����� ���ֱ�
		continueButton.setContentAreaFilled(false);// �⺻ ��� ���ֱ�
		continueButton.setFocusPainted(false);
		continueButton.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {
				continueButton.setIcon(continueButtonEnteredImage);
				continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺 �ö����� Ŀ���� �ո������ �ٲ�°�
			}

			@Override
			public void mouseExited(MouseEvent e) {
				continueButton.setIcon(continueButtonBasicImage);
				continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ���� �ε��̺�Ʈ
			}
		});
		add(continueButton);

		exitButton.setBounds(246, 467, 300, 57);
		exitButton.setBorderPainted(false);// �⺻ ��ư�� ����� ���ֱ�
		exitButton.setContentAreaFilled(false);// �⺻ ��� ���ֱ�
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // ���콺 �ö����� Ŀ���� �ո������ �ٲ�°�
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);
	}

	private void setMenuBar() { // �޴��� ����
		JLabel menuBar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menuBar.png")));
		ImageIcon quitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/quitButton.png"));
		JButton quitButton = new JButton(quitButtonImage); // �޴��� ������ ��ư

		quitButton.setBounds(770, 0, 25, 25);
		quitButton.setBorderPainted(false);// �⺻ ��ư�� ����� ���ֱ�
		quitButton.setContentAreaFilled(false);// �⺻ ��� ���ֱ�
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);

		menuBar.setBounds(0, 0, 800, 20); // �޴���
		menuBar.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() { // ���콺 �̺�Ʈ ó��
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // �޴��� ��� �̵��Ҷ� â ��ġ ����
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) { // ����â�� ��ũ�� �̹��� �ҷ�����
		screenImage = createImage(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT); // ��ũ�� ũ�⸸ŭ �̹��� ����
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// ��ũ���� ����̹��� �׸���
		g.drawImage(screenImage, 0, 0, null);// ���� â�� ��ũ�� �̹��� �׸���
	}

	public void screenDraw(Graphics g) {// ��ũ���� ��ư�̹���, ��ũ�� �̹��� �׸���
		g.drawImage(background, 0, 0, null); // ��ũ���̹����� �̹��� �׷��ֱ� �Լ�
		paintComponents(g); // ��ư �̹��� �׷��ִ� �Լ�
		this.repaint(); // ��ü ȭ�� �̹����� �ż������� ��� �ݺ��ؼ� �׷��ִ� ��
	}
}
