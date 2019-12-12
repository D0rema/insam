package Locat;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static int panelNumber;

	Menu menu = new Menu();

	public MainFrame() {
		setUndecorated(true);// 전체화면 (메뉴바없애기)
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setTitle("Lost Cat");
		setResizable(false);// 게임 창 크기 고정
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0)); // 페인트 컴포넌트를 했을때 배경이 하얀색으로 바뀜
		setLayout(null);// 버튼을 원하는 위치에 삽입하려고
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(menu);
		panelNumber = 0;

		setVisible(true); // 창 보일 수 있게 설정
	}

	public void changePanel(int num) {
		switch (num) {
		case 0: {
			getContentPane().removeAll();
			setContentPane(menu);
			menu.setButton();
			getContentPane().requestFocus();
			invalidate();
			repaint();
			
			
			Stage.clearflag4=false;
			break;
		}
		case 1: {
			getContentPane().removeAll();
			setContentPane(new Stage());
			getContentPane().requestFocus();
			invalidate();
			repaint();
			break;
		}
		}

	}
}