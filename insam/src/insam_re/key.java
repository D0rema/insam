package insam_re;

import java.awt.event.KeyEvent;

public class key{
	boolean keyUp = false; //Ű �Է¹޴°� �Է¹����� true�� �ٲ�
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean jump = false; // ���� ����

	private moving_test moving_test = null;
	
public void keyProcess(){
//���⼭�� �ܼ� �ɸ��Ͱ� �̵��ϴ� ��ǥ ����
//�ɸ����� ������ ���ι� ������ üũ �մϴ�.
moving_test.playerMove = false;

if ( keyUp &&moving_test.not_key!=1){
	moving_test.playerMove = true;
	moving_test.y -= 4;
	moving_test.moveStatus = 0;
}

if ( keyDown&&moving_test.not_key!=2){
	moving_test.y += 4;
	moving_test.moveStatus = 2;
	moving_test.playerMove = true;
}

if ( keyLeft&&moving_test.not_key!=3){
	moving_test.x -= 4;
moving_test.moveStatus = 3;
moving_test.playerMove = true;
}

if ( keyRight&&moving_test.not_key!=4){
	moving_test.x += 4;
moving_test.moveStatus = 1;
moving_test.playerMove = true;
}

if ( jump)
{

	moving_test.moveStatus = 1;
	moving_test.playerMove = true;

	if(moving_test.cnt<moving_test.jp1) { //ī��Ʈ�� ������ jp1��ŭ�� �ð��� �ö� 
		moving_test.y -= 16 ; //�ӵ��� ���Ҽ�����
	}
if(moving_test.cnt>moving_test.jp1) { // �� �ö󰡸� �Ʒ� try_jump�� false��Ű�鼭 �߷� ����
jump=false;
moving_test.try_jump=false;
}
	}

}
public void keyPressed(KeyEvent e) {

	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT :
		if(moving_test.not_key !=3) {
	keyLeft = true;
	}
	break;
	case KeyEvent.VK_RIGHT :
		if(moving_test.not_key !=4) {
	keyRight = true;
		}
	break;
	case KeyEvent.VK_UP :
		if(moving_test.not_key !=1) {
	keyUp = true;
		}
	break;
	case KeyEvent.VK_DOWN :
		if(moving_test.not_key !=2) {
	keyDown = true;
		}
	break;
	case KeyEvent.VK_SPACE :
		moving_test.jp1 = moving_test.cnt+20; // ����Ű�� ������ cnt�� 20�ö󰥸�ŭ �ö�
		moving_test.jp2 = moving_test.cnt+40;// ���� �̻��
		moving_test.try_jump=true; // �߷��� �������Ŵ
	jump = true;
	break;
	}
	}

	public void keyReleased(KeyEvent e) {
	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT :
	keyLeft = false;
	break;
	case KeyEvent.VK_RIGHT :
	keyRight = false;
	break;
	case KeyEvent.VK_UP :
	keyUp = false;
	break;
	case KeyEvent.VK_DOWN :
	keyDown = false;
	break;
	case KeyEvent.VK_SPACE :
	//jump = false;
	break;
	}
	}

public void keyTyped(KeyEvent e) {}
}
