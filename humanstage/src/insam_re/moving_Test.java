package insam_re;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class moving_Test {
public static void main(String[] ar){
RpgGame_frame rg = new RpgGame_frame();
}
/**
 * It becomes a ture when the character has to move.
 */
public static boolean playerMove = false;
/**
 * The x y coordinate of the character.
 */
public static int x, y; 
/**
 * Coordinates of the floor.
 */
public static int g_x,g_y; 
/**
 * count.
 */
public static int cnt; 
/**
 * The direction the character looks
 */
public static int moveStatus; 
/**
 * 
Save the jump time.
 */
public static int jp1,jp2;
/**
 * 
Clear the gravity momentarily when jumping.
 */
public static boolean try_jump = false;
/**
 * True if the stage needs to be restarted.
 */
public static boolean reset= false;
/**
 * This variable prevents the character from moving anymore when hitting the wall.
 */
public static int not_Up = 0;
public static int not_Down = 0;
public static int not_Right = 0;
public static int not_Left = 0;
/**
 * This variable changes when the character reaches the required coordinates.
 */
public static int char_lo = 0;
/**
 * 
These are the variables needed for a puzzle.
 */
public static int fload1 = 0,fload2=0,fload3=0;
public static int iload = 0;







}
/**
 * 
 * @author chlau
 *The main class of the stage consists of the necessary methods and threads.
 */
class RpgGame_frame extends JFrame implements Runnable, 
KeyListener{
	
key k1 = new key();

draw_Image d1 = new draw_Image();

check_Wall w1 = new check_Wall();

puzzle_Master z1 = new puzzle_Master();

Image buffimg;
public ImageObserver Frame = this;
public void keyTyped(KeyEvent e) {
	k1.keyTyped(e);
}
public void keyReleased(KeyEvent e) {
	k1.keyReleased(e) ;
}
public void keyPressed(KeyEvent e) {
	k1.keyPressed(e);
}

public void paint(Graphics g){
	buffimg = createImage(800, 600);
    d1.paint(g,buffimg,Frame);
}
public void checkmark() {
	d1.checkmark(Frame);
}
public void in_flat() {
	w1.in_flat();
}
public void is_bottom() {
	w1.is_bottom();
}
public void on_Wall() {
	w1.on_Wall();//1스테이지에서 작동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//w1.on_Iwall();//2스테이지에서 작동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
}
public void check_Wall() {
	w1.check_Wall();
	
}
public void puzzle_Master() {
	z1.puzzle_Master();
}
public void init(){
	check_Wall();
	//moving_Test.x = 0;//2스테이지 시작위치@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	moving_Test.y = 316;//2스테이지 시작위치@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	moving_Test.x = 100;//1스테이지 시작위치@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	moving_Test.y = 100;//1스테이지 시작위치@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
moving_Test.moveStatus = 2;

  
}
RpgGame_frame(){
setTitle("test");
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



public int jumpy[] = {-8,-8,-8,8,8,8}; 
Toolkit tk = Toolkit.getDefaultToolkit();
 


 
Thread th;
 





public void start(){ 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.addKeyListener(this);
th = new Thread(this);
th.start();

}

public void run(){ 
while(true){
try{
	k1.keyProcess();
repaint();
on_Wall();
//in_flat(); 
Thread.sleep(20);
moving_Test.cnt++;
//is_bottom();
//w1 .check_Wall();
puzzle_Master();
checkmark();

}catch(Exception e){}
}
}
 

 
 


}

