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
		setUndecorated(true);// ��üȭ�� (�޴��پ��ֱ�)
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setTitle("Lost Cat");
		setResizable(false);// ���� â ũ�� ����
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0)); // ����Ʈ ������Ʈ�� ������ ����� �Ͼ������ �ٲ�
		setLayout(null);// ��ư�� ���ϴ� ��ġ�� �����Ϸ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(menu);
		panelNumber = 0;

		setVisible(true); // â ���� �� �ְ� ����
	}

	/** 
	 * change Panel in Frame
	 * 
	 * @author JiSeongChoi
	 * 
	 * @param num number of current stage
	 */
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