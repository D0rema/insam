package Locat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class startFrame extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //더블버퍼링을 위해 전체화면에 대한 이미지를 담음 
	private Image background=new ImageIcon(main.class.getResource("../images/backImageex.jpg")).getImage();//이미지를 담을 수 있는 객체 선언 후 이미지 가져오기
	
	private JLabel menuBar = new JLabel(new ImageIcon(main.class.getResource("../images/menuBar.png")));
	private ImageIcon quitButtonImage = new ImageIcon(main.class.getResource("../images/quitButton.png"));
	
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(main.class.getResource("../images/startButtonEntered.png")); //버튼 이미지
	private ImageIcon startButtonBasicImage = new ImageIcon(main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon continueButtonEnteredImage = new ImageIcon(main.class.getResource("../images/continueButtonEntered.png"));
	private ImageIcon continueButtonBasicImage = new ImageIcon(main.class.getResource("../images/continueButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(main.class.getResource("../images/exitButtonBasic.png"));
	
	private JButton quitButton = new JButton(quitButtonImage); //메뉴바 나가기 버튼
	private JButton startButton = new JButton(startButtonBasicImage); //버튼 객체
	private JButton continueButton = new JButton( continueButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX,mouseY;
	
	public startFrame() {
		setUndecorated(true);//전체화면 (메뉴바없애기)
		setTitle("Lost Cat");
		setSize(main.SCREEN_WIDTH,main.SCREEN_HEIGHT);
		setResizable(false);//게임 창 크기 고정
		setLocationRelativeTo(null);//게임 창 정 중앙에 뜨도록 해줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 종료할때 프로그램도 종료할 수 있도록
		setVisible(true); //창 보일 수 있게 설정
		setBackground(new Color(0,0,0,0)); //페인트 컴포넌트를 했을때 배경이 하얀색으로 바뀜
		setLayout(null);//버튼을 원하는 위치에 삽입하려고
		
		Music introMusic=new Music("introMusic.mp3",true);//메인 화면에서 음악 시작
		introMusic.start();
		
		quitButton.setBounds(1245,0,30,30);
		quitButton.setBorderPainted(false);//기본 버튼의 모양을 없애기
		quitButton.setContentAreaFilled(false);//기본 모양 없애기
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) { 
				System.exit(0);
			}
		});
		add(quitButton);
		
		menuBar.setBounds(0,0,1280,25); //메뉴바
		menuBar.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) { 
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseDragged(MouseEvent e) { 
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY); //메뉴바 잡고 이동할때 창 위치 변경
			}
		});
		add(menuBar);
		
		startButton.setBounds(428,350,500,100);
		startButton.setBorderPainted(false);//기본 버튼의 모양을 없애기
		startButton.setContentAreaFilled(false);//기본 모양 없애기
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 올라갔을때 커서가 손모양으로 바뀌는거
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				//게임 시작이벤트 화면 전환
				setVisible(false);
				new gameFrame(); //새로운 창으로 전환
			}
		});
		add(startButton);
		
		
		continueButton.setBounds(400,450,500,100);
		continueButton.setBorderPainted(false);//기본 버튼의 모양을 없애기
		continueButton.setContentAreaFilled(false);//기본 모양 없애기
		continueButton.setFocusPainted(false);
		continueButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				continueButton.setIcon(continueButtonEnteredImage);
				continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 올라갔을때 커서가 손모양으로 바뀌는거
			}
			@Override
			public void mouseExited(MouseEvent e) {
				continueButton.setIcon(continueButtonBasicImage);
				continueButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				//게임 로딩이벤트
			}
		});
		add(continueButton);
		
		exitButton.setBounds(386,550,500,100);
		exitButton.setBorderPainted(false);//기본 버튼의 모양을 없애기
		exitButton.setContentAreaFilled(false);//기본 모양 없애기
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() { //마우스 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 올라갔을때 커서가 손모양으로 바뀌는거
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
	public void paint(Graphics g) {
		screenImage=createImage(main.SCREEN_WIDTH,main.SCREEN_HEIGHT); //스크린 크기만큼 이미지 생성
		screenGraphic=screenImage.getGraphics();
		screenDraw(screenGraphic);//스크린그래픽에 이미지 그리기
		g.drawImage(screenImage,0,0,null);//게임 창에 스크린 이미지 그리기
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background,0,0,null); //스크린이미지에 이미지 그려넣기 함수
		paintComponents(g); //버튼 이미지 그려넣는 함수
		this.repaint(); //전체 화면 이미지를 매순간마다 계속 반복해서 그려주는 것
	}

}
