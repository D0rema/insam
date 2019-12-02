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
 
boolean keyUp = false; //키 입력받는거 입력받으면 true로 바뀜
boolean keyDown = false;
boolean keyLeft = false;
boolean keyRight = false;
boolean jump = false; // 여기 까지

boolean ckmark1 = false;
boolean playerMove = false; //키가 입력받아서 캐릭터가 움직이는 상황에는 true로 바뀜
boolean try_jump = false; // 점프를 할때 중력을 끔
int on_flat = 0;//발판을 밟을때 ture가 되어 바닥이 발판의 y값으로 변함
int on_bottom = 0; //기본적인 바닥 여기서는 468로 고정
int flat_count = 2;//플랫의 갯수
int flat[][] = new int [flat_count][4];//플랫의 함수 [0] 발판의 시작x값 [1] 발판의 끝 x값 [2] 발판의 y값 [3] 우선 y값인데 미정 사라질수도 있음
int ff; //현재 밟고 있는 발판의 y값을 지정하기 위해 필요한 함수


int jumpy[] = {-8,-8,-8,8,8,8}; //모르겟음
Toolkit tk = Toolkit.getDefaultToolkit();
 
Image img = new ImageIcon("images/rpg2.png").getImage();
Image map = new ImageIcon("images/map.png").getImage();
Image mark = new ImageIcon("images/mark.png").getImage();
//위에 이미지 이름이 바로 rpg.png입니다. 이미지를 불러옵니다
Image buffimg;// 더블버퍼링용 입니다.
Graphics gc;
 
Thread th;
 
int x, y; // 케릭터의 현재 좌표를 받을 변수
int g_x,g_y; //중력을 체크하기 위한 좌표 
int cnt; //무한 루프를 카운터 하기 위한 변수
int moveStatus; //케릭터가 어디를 바라보는지 방향을 받을 변수
int jp1,jp2; //점프 cnt를 계산하기 위한 값
RpgGame_frame(){
setTitle("테스트");
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
x = 100;//시작할때 캐릭터의 좌표
y = 100;//시작할때 캐릭터의 좌표
flat[0][0]= 200;// 현재 테스트 하기 위해 만든 발판
flat[0][1]= 300;
flat[0][2]= 388;
flat[0][3]= 400;
flat[1][0]= 400;
flat[1][1]= 500;
flat[1][2]= 228;
flat[1][3]= 400;
moveStatus = 2;
//케릭터가 시작할때 바라보는 방향은 아래쪽입니다.
// 0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽
  
}

public void start(){ // 기본적인 명령처리
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.addKeyListener(this);
th = new Thread(this);
th.start();

}

public void run(){ // 스레드 메소드, 무한 루프
while(true){
try{
keyProcess();
repaint();
//in_flat(); // 발판을 체크할수있는 함수
Thread.sleep(20);
cnt++;
//is_bottom(); // 중력과 바닥을 체크하는 함수

}catch(Exception e){}
}
}
 
public void paint(Graphics g){ //더블버퍼링을 사용합니다.
	
buffimg = createImage(800, 600);
gc = buffimg.getGraphics();
draw_background(); //배경을 그리는 함수
checkmark(); // 특수효과를 그리는 함수
update(g);

}
public void update(Graphics g){
//더블 버퍼링을 이용해 버퍼에 그려진것을 가져옵니다.
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

//위는 단순히 무한루프 적용여부와 케릭터 방향 체크를 위해
//눈으로 보면서 테스트할 용도로 쓰이는 텍스트 표출입니다.

MoveImage(img, x, y, 50, 75);
//케릭터를 걸어가게 만들기 위해 추가로 만든 메소드 입니다.
}

 public void checkmark() {
	 if(x<164&&x>132&&y<148&&y>108) {
		 ckmark1 = true;
		 
	 }
	 if(ckmark1==true) {
		 gc.drawImage(mark,135,105,this);//캐릭터가 위에 있을때(148,116)
	 }
	
 }
 
public void MoveImage(Image img, int x, int y, int width, 
int height){
//케릭터 이미지, 케릭터 위치, 케릭터 크기를 받습니다.
//받은 값을 이용해서 위의 이미지칩셋에서 케릭터를 잘라내
//표출하도록 계산하는 메소드 입니다.

gc.setClip(x  , y, width, height);
//현재 좌표에서 케릭터의 크기 만큼 이미지를 잘라 그립니다.

if( playerMove ){ // 케릭터의 움직임 여부를 판단합니다.
if ( cnt / 10 % 4 == 0 ){ gc.drawImage(img,
x - ( width * 0 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 1){ gc.drawImage(img,
x - ( width * 1 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 2){  gc.drawImage(img,
x - ( width * 2 ), y - ( height * moveStatus ), this);

}else  if(cnt/10%4 == 3){ gc.drawImage(img,
x - ( width * 1 ), y - ( height * moveStatus ), this);
}
//케릭터의 방향에 따라 걸어가는 모션을 취하는 
//케릭터 이미지를 시간차를 이용해 순차적으로 그립니다.

}else { gc.drawImage(img, x - ( width * 1 ), 
y - ( height * moveStatus ), this);
//케릭터가 움직이지 않으면 정지한 케릭터를 그립니다.

}
}
public void is_bottom() { // 중력을 만들기 위한 함수
	if(on_flat==0) { // 발판에 닿지 않을때는 항상 바닥은 468
	g_y = 468;
	}
	if(!try_jump) { // 점프할때는 중력 적용 x
	if(y>=g_y) { //g_y 발판일때 바뀔수 있기때문에 변수로 생성
		on_bottom = 1; //캐릭터가 바닥에 닿았을때 1 
	}else {on_bottom = 0;}
	if(on_bottom==0) { // 바닥에 닿지 않았을때는 항상 떨어짐
		y+=16;
	}
	}
}
public void in_flat() { //발판일때 체크하는 함수
	for(int i = 0;i<flat_count;i++) { // 모든 발판을 체크 
		if(flat[i][0]<x&&flat[i][1]>x&&flat[i][2]==y) { // 현재 캐릭터의 좌표가 발판 좌표 안에 있는지 체크 i로 모든 발판 체크

			on_flat=1; // 발판 좌표 안에 있으면 발판을 밟고 있을때 1
			ff=i; //그때의 값을 저장해 아래에 사용
			g_y = flat[ff][2]; // 현재 밝고있는 발판의 y값을 바닥으로 사용
		}else if(flat[ff][0]>x||flat[ff][1]<x){
					on_flat=0; // 현재(ff로 구분) 밟고 있는 발판의 x값에 벗어나면 발판을 밟고 있지 않은것으로 처리 
		}
	}
}
 
public void keyProcess(){
//여기서는 단순 케릭터가 이동하는 좌표 말고도
//케릭터의 움직임 여부및 방향을 체크 합니다.
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

	if(cnt<jp1) { //카운트가 지정된 jp1만큼의 시간만 올라감 
y -= 16 ; //속도를 정할수있음
	}
if(cnt>jp1) { // 다 올라가면 아래 try_jump를 false시키면서 중력 적용
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
	 jp1 = cnt+20; // 점프키를 누르면 cnt가 20올라갈만큼 올라감
	 jp2 = cnt+40;// 현재 미사용
	 try_jump=true; // 중력을 미적용시킴
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