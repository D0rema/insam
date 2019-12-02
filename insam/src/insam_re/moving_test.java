package insam_re;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class moving_test {
public static void main(String[] ar){
RpgGame_frame rg = new RpgGame_frame();
}
}

class RpgGame_frame extends JFrame implements Runnable, 
KeyListener{
 
boolean keyUp = false; //Ű �Է¹޴°� �Է¹����� true�� �ٲ�
boolean keyDown = false;
boolean keyLeft = false;
boolean keyRight = false;
boolean jump = false; // ���� ����

boolean ckmark1 = false;
boolean playerMove = false; //Ű�� �Է¹޾Ƽ� ĳ���Ͱ� �����̴� ��Ȳ���� true�� �ٲ�
boolean try_jump = false; // ������ �Ҷ� �߷��� ��
int on_flat = 0;//������ ������ ture�� �Ǿ� �ٴ��� ������ y������ ����
int on_bottom = 0; //�⺻���� �ٴ� ���⼭�� 468�� ����
int flat_count = 2;//�÷��� ����
int flat[][] = new int [flat_count][4];//�÷��� �Լ� [0] ������ ����x�� [1] ������ �� x�� [2] ������ y�� [3] �켱 y���ε� ���� ��������� ����
int ff; //���� ��� �ִ� ������ y���� �����ϱ� ���� �ʿ��� �Լ�


int jumpy[] = {-8,-8,-8,8,8,8}; //�𸣰���
Toolkit tk = Toolkit.getDefaultToolkit();
 
Image img = new ImageIcon("images/rpg2.png").getImage();
Image map = new ImageIcon("images/map.png").getImage();
Image mark = new ImageIcon("images/mark.png").getImage();
//���� �̹��� �̸��� �ٷ� rpg.png�Դϴ�. �̹����� �ҷ��ɴϴ�
Image buffimg;// ������۸��� �Դϴ�.
Graphics gc;
 
Thread th;
 
int x, y; // �ɸ����� ���� ��ǥ�� ���� ����
int g_x,g_y; //�߷��� üũ�ϱ� ���� ��ǥ 
int cnt; //���� ������ ī���� �ϱ� ���� ����
int moveStatus; //�ɸ��Ͱ� ��� �ٶ󺸴��� ������ ���� ����
int jp1,jp2; //���� cnt�� ����ϱ� ���� ��
RpgGame_frame(){
setTitle("�׽�Ʈ");
setSize(642, 639);
init();
start();
  
Dimension screen = tk.getScreenSize();
  
int xpos = (int)(screen.getWidth() / 2 - getWidth() / 2);
int ypos = (int)(screen.getHeight() / 2 - getHeight() / 2);
setLocation(xpos, ypos);
setResizable(false);
setVisible(true);
}

public void init(){
x = 100;//�����Ҷ� ĳ������ ��ǥ
y = 100;//�����Ҷ� ĳ������ ��ǥ
flat[0][0]= 200;// ���� �׽�Ʈ �ϱ� ���� ���� ����
flat[0][1]= 300;
flat[0][2]= 388;
flat[0][3]= 400;
flat[1][0]= 400;
flat[1][1]= 500;
flat[1][2]= 228;
flat[1][3]= 400;
moveStatus = 2;
//�ɸ��Ͱ� �����Ҷ� �ٶ󺸴� ������ �Ʒ����Դϴ�.
// 0 : ����, 1 : ������, 2 : �Ʒ���, 3 : ����
  
}

public void start(){ // �⺻���� ���ó��
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.addKeyListener(this);
th = new Thread(this);
th.start();

}

public void run(){ // ������ �޼ҵ�, ���� ����
while(true){
try{
keyProcess();
repaint();
//in_flat(); // ������ üũ�Ҽ��ִ� �Լ�
Thread.sleep(20);
cnt++;
//is_bottom(); // �߷°� �ٴ��� üũ�ϴ� �Լ�

}catch(Exception e){}
}
}
 
public void paint(Graphics g){ //������۸��� ����մϴ�.
	
buffimg = createImage(800, 600);
gc = buffimg.getGraphics();
draw_background(); //����� �׸��� �Լ�
checkmark(); // Ư��ȿ���� �׸��� �Լ�
update(g);

}
public void update(Graphics g){
//���� ���۸��� �̿��� ���ۿ� �׷������� �����ɴϴ�.
DrawImg();

g.drawImage(buffimg, 0, 0, this);
}

public void DrawImg(){
gc.setFont(new Font("Default", Font.BOLD, 20));
gc.drawString(Integer.toString(cnt), 50, 50);
gc.drawString(Integer.toString((playerMove)?1:0),200, 50);
gc.drawString(Integer.toString(x),350, 50);
gc.drawString(Integer.toString(y),500, 50);
gc.drawString(Integer.toString(jp1),350, 100);
gc.drawString(Integer.toString(jp2),500, 100);
gc.drawString(Integer.toString(on_bottom),500, 150);
gc.drawString(Integer.toString(on_flat),350, 150);

//���� �ܼ��� ���ѷ��� ���뿩�ο� �ɸ��� ���� üũ�� ����
//������ ���鼭 �׽�Ʈ�� �뵵�� ���̴� �ؽ�Ʈ ǥ���Դϴ�.

MoveImage(img, x, y, 50, 75);
//�ɸ��͸� �ɾ�� ����� ���� �߰��� ���� �޼ҵ� �Դϴ�.
}

 public void checkmark() {
	 if(x<164&&x>132&&y<148&&y>108) {
		 ckmark1 = true;
		 
	 }
	 if(ckmark1==true) {
		 gc.drawImage(mark,135,105,this);//ĳ���Ͱ� ���� ������(148,116)
	 }
	
 }
 
public void MoveImage(Image img, int x, int y, int width, 
int height){
//�ɸ��� �̹���, �ɸ��� ��ġ, �ɸ��� ũ�⸦ �޽��ϴ�.
//���� ���� �̿��ؼ� ���� �̹���Ĩ�¿��� �ɸ��͸� �߶�
//ǥ���ϵ��� ����ϴ� �޼ҵ� �Դϴ�.

gc.setClip(x  , y, width, height);
//���� ��ǥ���� �ɸ����� ũ�� ��ŭ �̹����� �߶� �׸��ϴ�.

if( playerMove ){ // �ɸ����� ������ ���θ� �Ǵ��մϴ�.
if ( cnt / 10 % 4 == 0 ){ gc.drawImage(img,
x - ( width * 0 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 1){ gc.drawImage(img,
x - ( width * 1 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 2){  gc.drawImage(img,
x - ( width * 2 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 3){ gc.drawImage(img,
x - ( width * 1 ), y - ( height * moveStatus ), this);
}
//�ɸ����� ���⿡ ���� �ɾ�� ����� ���ϴ� 
//�ɸ��� �̹����� �ð����� �̿��� ���������� �׸��ϴ�.

}else { gc.drawImage(img, x - ( width * 1 ), 
y - ( height * moveStatus ), this);
//�ɸ��Ͱ� �������� ������ ������ �ɸ��͸� �׸��ϴ�.

}
}
public void is_bottom() { // �߷��� ����� ���� �Լ�
	if(on_flat==0) { // ���ǿ� ���� �������� �׻� �ٴ��� 468
	g_y = 468;
	}
	if(!try_jump) { // �����Ҷ��� �߷� ���� x
	if(y>=g_y) { //g_y �����϶� �ٲ�� �ֱ⶧���� ������ ����
		on_bottom = 1; //ĳ���Ͱ� �ٴڿ� ������� 1 
	}else {on_bottom = 0;}
	if(on_bottom==0) { // �ٴڿ� ���� �ʾ������� �׻� ������
		y+=16;
	}
	}
}
public void in_flat() { //�����϶� üũ�ϴ� �Լ�
	for(int i = 0;i<flat_count;i++) { // ��� ������ üũ 
		if(flat[i][0]<x&&flat[i][1]>x&&flat[i][2]==y) { // ���� ĳ������ ��ǥ�� ���� ��ǥ �ȿ� �ִ��� üũ i�� ��� ���� üũ

			on_flat=1; // ���� ��ǥ �ȿ� ������ ������ ��� ������ 1
			ff=i; //�׶��� ���� ������ �Ʒ��� ���
			g_y = flat[ff][2]; // ���� ����ִ� ������ y���� �ٴ����� ���
		}else if(flat[ff][0]>x||flat[ff][1]<x){
					on_flat=0; // ����(ff�� ����) ��� �ִ� ������ x���� ����� ������ ��� ���� ���������� ó�� 
		}
	}
}
 
public void keyProcess(){
//���⼭�� �ܼ� �ɸ��Ͱ� �̵��ϴ� ��ǥ ����
//�ɸ����� ������ ���ι� ������ üũ �մϴ�.
playerMove = false;

if ( keyUp ){
playerMove = true;
y -= 4;
moveStatus = 0;
}

if ( keyDown){
y += 4;
moveStatus = 2;
playerMove = true;
}

if ( keyLeft){
x -= 4;
moveStatus = 3;
playerMove = true;
}

if ( keyRight){
x += 4;
moveStatus = 1;
playerMove = true;
}

if ( jump)
{

	moveStatus = 1;
	playerMove = true;

	if(cnt<jp1) { //ī��Ʈ�� ������ jp1��ŭ�� �ð��� �ö� 
y -= 16 ; //�ӵ��� ���Ҽ�����
	}
if(cnt>jp1) { // �� �ö󰡸� �Ʒ� try_jump�� false��Ű�鼭 �߷� ����
jump=false;
try_jump=false;
}
	}

}
 
public void keyPressed(KeyEvent e) {

switch(e.getKeyCode()){
case KeyEvent.VK_LEFT :
keyLeft = true;
break;
case KeyEvent.VK_RIGHT :
keyRight = true;
break;
case KeyEvent.VK_UP :
keyUp = true;
break;
case KeyEvent.VK_DOWN :
keyDown = true;
break;
case KeyEvent.VK_SPACE :
	 jp1 = cnt+20; // ����Ű�� ������ cnt�� 20�ö󰥸�ŭ �ö�
	 jp2 = cnt+40;// ���� �̻��
	 try_jump=true; // �߷��� �������Ŵ
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
public void draw_background() {
	gc.clearRect(0, 0, 642, 639);
	gc.drawImage(map,0,0,this);
}
}