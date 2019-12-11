package Locat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

	private JButton startButton = new JButton(startButtonBasicImage); // 버튼 객체
	private JButton continueButton = new JButton(continueButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);

	ImageIcon musicImage = new ImageIcon(getClass().getClassLoader().getResource("images/music.png"));
	ImageIcon musicMuteImage = new ImageIcon(getClass().getClassLoader().getResource("images/musicMute.png"));
	JCheckBox bgmMute = new JCheckBox(musicImage);
	Music introMusic;
	
	private Image screenImage;
	private Graphics screenGraphic; // 더블버퍼링을 위해 전체화면에 대한 이미지를 담음
	private Image background = new ImageIcon(getClass().getClassLoader().getResource("images/backImage.png"))
			.getImage();// 이미지를 담을 수 있는 객체 선언 후 이미지 가져오기
	private int mouseX, mouseY;

	public Menu() {
		setSize(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT);
		setVisible(true); // 창 보일 수 있게 설정
		setBackground(new Color(0, 0, 0, 0)); // 페인트 컴포넌트를 했을때 배경이 하얀색으로 바뀜
		setLayout(null);// 버튼을 원하는 위치에 삽입하려고
		setFocusable(true);
		
		introMusic=new Music("introMusic.mp3",true);//메인 화면에서 음악 시작
		introMusic.start();
		setComponents();
	}
	
	public void setComponents() {
		setButton();
		setMenuBar();
	}

	public void setButton() { // 게임시작, 게임로딩, 나가기버튼 설정
		bgmMute.setBounds(30,30,50,50);
        bgmMute.setSelectedIcon(musicMuteImage);
        bgmMute.setBorderPainted(false);// �⺻ ��ư�� ����� ���ֱ�
        bgmMute.setContentAreaFilled(false);// �⺻ ��� ���ֱ�
        bgmMute.setFocusPainted(false);
        bgmMute.addItemListener(new ItemListener() {
           //@SuppressWarnings("deprecation")
           public void itemStateChanged(ItemEvent e) {
              if(e.getStateChange() == ItemEvent.SELECTED) {
                 introMusic.close();
              }
              else  {
                 introMusic=new Music("introMusic.mp3",true);
                 introMusic.start();
              }
           }
        });
        add(bgmMute);
		startButton.setBounds(250, 330, 300, 50);
		startButton.setBorderPainted(false);// 기본 버튼의 모양을 없애기
		startButton.setContentAreaFilled(false);// 기본 모양 없애기
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { // 마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 올라갔을때 커서가 손모양으로 바뀌는거
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 게임 시작이벤트 화면 전환
				MainFrame.currentStage = 1;
				Main.mainFrame.changePanel(MainFrame.currentStage); // 새로운 창으로 전환
			}
		});
		add(startButton);

		continueButton.setBounds(246, 400, 300, 50);
		continueButton.setBorderPainted(false);// 기본 버튼의 모양을 없애기
		continueButton.setContentAreaFilled(false);// 기본 모양 없애기
		continueButton.setFocusPainted(false);
		continueButton.addMouseListener(new MouseAdapter() { // 마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				continueButton.setIcon(continueButtonEnteredImage);
				continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 올라갔을때 커서가 손모양으로 바뀌는거
			}

			@Override
			public void mouseExited(MouseEvent e) {
				continueButton.setIcon(continueButtonBasicImage);
				continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 게임 로딩이벤트
			}
		});
		add(continueButton);

		exitButton.setBounds(246, 467, 300, 57);
		exitButton.setBorderPainted(false);// 기본 버튼의 모양을 없애기
		exitButton.setContentAreaFilled(false);// 기본 모양 없애기
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() { // 마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 올라갔을때 커서가 손모양으로 바뀌는거
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

	private void setMenuBar() { // 메뉴바 설정
		JLabel menuBar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menuBar.png")));
		ImageIcon quitButtonImage = new ImageIcon(getClass().getClassLoader().getResource("images/quitButton.png"));
		JButton quitButton = new JButton(quitButtonImage); // 메뉴바 나가기 버튼

		quitButton.setBounds(770, 0, 25, 25);
		quitButton.setBorderPainted(false);// 기본 버튼의 모양을 없애기
		quitButton.setContentAreaFilled(false);// 기본 모양 없애기
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() { // 마우스 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);

		menuBar.setBounds(0, 0, 800, 20); // 메뉴바
		menuBar.addMouseListener(new MouseAdapter() { // 마우스 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() { // 마우스 이벤트 처리
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Main.mainFrame.setLocation(x - mouseX, y - mouseY); // 메뉴바 잡고 이동할때 창 위치 변경
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) { // 게임창에 스크린 이미지 불러오기
		screenImage = createImage(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT); // 스크린 크기만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// 스크린에 배경이미지 그리기
		g.drawImage(screenImage, 0, 0, null);// 게임 창에 스크린 이미지 그리기
	}

	public void screenDraw(Graphics g) {// 스크린에 버튼이미지, 스크린 이미지 그리기
		g.drawImage(background, 0, 0, null); // 스크린이미지에 이미지 그려넣기 함수
		paintComponents(g); // 버튼 이미지 그려넣는 함수
		this.repaint(); // 전체 화면 이미지를 매순간마다 계속 반복해서 그려주는 것
	}
}
