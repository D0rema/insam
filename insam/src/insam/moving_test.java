package insam;

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
 
boolean keyUp = false;
boolean keyDown = false;
boolean keyLeft = false;
boolean keyRight = false; 
boolean playerMove = false;
boolean jump = false;
boolean try_jump = false;
int on_flat = 0;
int flat_count = 2;
int flat[][] = new int [flat_count][4];
int ff;
int on_bottom = 0;

int jumpy[] = {-8,-8,-8,8,8,8};
Toolkit tk = Toolkit.getDefaultToolkit();
 
Image img = new ImageIcon("images/rpg1.png").getImage();
//���� �̹��� �̸��� �ٷ� rpg.png�Դϴ�. �̹����� �ҷ��ɴϴ�
Image buffimg;// ������۸��� �Դϴ�.
Graphics gc;
 
Thread th;
 
int x, y; // �ɸ����� ���� ��ǥ�� ���� ����
int g_x,g_y;
int cnt; //���� ������ ī���� �ϱ� ���� ����
int moveStatus; //�ɸ��Ͱ� ��� �ٶ󺸴��� ������ ���� ����
int jp1,jp2;
RpgGame_frame(){
setTitle("�׽�Ʈ");
setSize(800, 600);
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
x = 100;
y = 100;
flat[0][0]= 200;
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
in_flat();
Thread.sleep(20);
cnt++;
is_bottom();
}catch(Exception e){}
}
}
 
public void paint(Graphics g){ //������۸��� ����մϴ�.
buffimg = createImage(800, 600);
gc = buffimg.getGraphics();
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

MoveImage(img, x, y, 100, 150);
//�ɸ��͸� �ɾ�� ����� ���� �߰��� ���� �޼ҵ� �Դϴ�.
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
public void is_bottom() {
	if(on_flat==0) {
	g_y = 460;
	}
	if(!try_jump) {
	if(y>=g_y) {
		on_bottom = 1;
	}else {on_bottom = 0;}
	if(on_bottom==0) {
		y+=16;
	}
	}
}
public void in_flat() {
	for(int i = 0;i<flat_count;i++) {
		if(flat[i][0]<x&&flat[i][1]>x&&flat[i][2]==y) {

			on_flat=1;
			ff=i;
			g_y = flat[ff][2];
		}else if(flat[ff][0]>x||flat[ff][1]<x){
				 

					on_flat=0;
				
		
		}
	}
}
 
public void keyProcess(){
//���⼭�� �ܼ� �ɸ��Ͱ� �̵��ϴ� ��ǥ ����
//�ɸ����� ������ ���ι� ������ üũ �մϴ�.
playerMove = false;

if ( keyUp ){
playerMove = true;
y -= 8;
moveStatus = 0;
}

if ( keyDown){
y += 8;
moveStatus = 2;
playerMove = true;
}

if ( keyLeft){
x -= 8;
moveStatus = 3;
playerMove = true;
}

if ( keyRight){
x += 8;
moveStatus = 1;
playerMove = true;
}
if ( jump)
{

	moveStatus = 1;
	playerMove = true;

	if(cnt<jp1) {
y -= 16 ;
	}
//	if(on_bottom==0&&jp1<cnt) {
//y += 8;
//	}
if(cnt>jp1) {
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
	 jp1 = cnt+20;
	 jp2 = cnt+40;
	 try_jump=true;
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