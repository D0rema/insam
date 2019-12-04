package insam_re;

import java.awt.*;
import java.awt.image.*;

import javax.swing.ImageIcon;
/**
 * 
 * @author cholmyeongkyu
 * 
*This class is related to drawing. Most of them take arguments of Graphics and ImageObserver
 *
 */
public class draw_Image{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img = new ImageIcon("images/rpg2.png").getImage();
	Image map = new ImageIcon("images/map1.png").getImage();
	//map1�� 1�뒪�뀒�씠吏� map2�뒗 2�뒪�뀒�씠吏�
	Image mark = new ImageIcon("images/O.png").getImage();
	
	Graphics gc;
	
	private moving_Test moving_Test = null;
	moving_Test m1 = new moving_Test();
	/**
	 * The m is used to draw a mark that checks the way through.
	 */
	public int m[] = new int [14];
	private int cc1 = 0;
	/**
	 * 
The x and y contain the coordinates of the mark that checks the path.
	 */
	public int x[] = {88,256,152,344,440,248,392,492,300,440,536,168,352,372};
	public int y[] = {272,152,216,216,216,280,280,280,344,344,384,412,408,472};
		
/**
 * The paint method is a method that in turn calls the methods to be implemented.
 * 
 * 
 * 
 */
	public void paint(Graphics g,Image buffimg,ImageObserver Frame){ 
			
		gc = buffimg.getGraphics();
		draw_background(Frame); 
		checkmark(Frame);//1�뒪�뀒�씠吏��뿉�꽌 �옉�룞@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		reset_mark();//1�뒪�뀒�씠吏��뿉�꽌 �옉�룞@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		update(g,buffimg,Frame);
		clear_Stage1();

		}
	/**
	 *  This method is necessary for double buffering.
	 */
		public void update(Graphics g,Image buffimg,ImageObserver Frame){
		
		DrawImg(Frame);

		g.drawImage(buffimg, 0, 0, Frame);
		}
		/**
		 *  It includes a function that displays the text required for the test and a character image.
		 */
		public void DrawImg(ImageObserver Frame){
		gc.setFont(new Font("Default", Font.BOLD, 20));
		gc.drawString(Integer.toString(moving_Test.cnt), 50, 50);
		gc.drawString(Integer.toString((moving_Test.reset)?1:0),200, 100);
		gc.drawString(Integer.toString(moving_Test.x),350, 100);
		gc.drawString(Integer.toString(moving_Test.y),500, 100);
		gc.drawString(Integer.toString(moving_Test.fload1),350, 150);
		gc.drawString(Integer.toString(moving_Test.fload2),400, 150);
		gc.drawString(Integer.toString(moving_Test.fload3),450, 150);
		
		

		MoveImage(img, moving_Test.x, moving_Test.y, 50, 75,Frame);
		/**
		 * This method cuts and draws the character in context from the character chipset.
		 */
	
		}
		public void MoveImage(Image img, int x, int y, int width, 
				int height,ImageObserver Frame){
				

				gc.setClip(x  , y, width, height);
				

				if( moving_Test.playerMove ){
				if ( moving_Test.cnt / 10 % 4 == 0 ){ gc.drawImage(img,
				x - ( width * 0 ), y - ( height * moving_Test.moveStatus ), Frame);

				}else  if(moving_Test.cnt/10%4 == 1){ gc.drawImage(img,
				x - ( width * 1 ), y - ( height * moving_Test.moveStatus ), Frame);

				}else  if(moving_Test.cnt/10%4 == 2){  gc.drawImage(img,
				x - ( width * 2 ), y - ( height * moving_Test.moveStatus ), Frame);

				}else  if(moving_Test.cnt/10%4 == 3){ gc.drawImage(img,
				x - ( width * 1 ), y - ( height * moving_Test.moveStatus ), Frame);
				}
				
				}else { gc.drawImage(img, x - ( width * 1 ), 
				y - ( height * moving_Test.moveStatus ), Frame);
				

				}
				}
		/**
		 * 
		 * This method draws a background image.
		 */
		public void draw_background(ImageObserver Frame) {
			gc.clearRect(0, 0, 642, 639);
			gc.drawImage(map,0,0,Frame);
		}
		
		
	//	public void Find_Load(ImageObserver Frame) {
	//		checkmark(Frame);
	//	}
		/**
		 * 
		 * This method draws a mark as the character passes by using the variable fload3.
		 */
		public void checkmark(ImageObserver Frame) {
			
			 if(moving_Test.x<164&&moving_Test.x>132&&moving_Test.y<148&&moving_Test.y>108) {
				 //moving_Test.ckmark1 = true;
				 
			 }
			
			 for(int i = 0,sum = 0;i<14;i++) {
				 sum+=m[i];
				 if(sum==1) {
			
				 }
					if(m[i]==1) {
						gc.drawImage(mark,x[i],y[i],Frame);//1-7

					}
				}
			// if(moving_Test.ckmark1==true) {
				 
				// gc.drawImage(mark,135,105,Frame);
				 if(moving_Test.fload3==17||moving_Test.fload3==71) {
					 m[0]=1;
					 
				 }
				 if(moving_Test.fload3==12||moving_Test.fload3==21) {
					 m[1]=1;
					 
				 }
				 if(moving_Test.fload3==13||moving_Test.fload3==31) {
					 m[2]=1;
					
				 }
				 if(moving_Test.fload3==24||moving_Test.fload3==42) {
					 
					 m[3]=1;
				 }
				 if(moving_Test.fload3==25||moving_Test.fload3==52) {
					 
					 m[4]=1;
				 }
				 if(moving_Test.fload3==34||moving_Test.fload3==43) {
					 m[5]=1;
					 
				 }
				 if(moving_Test.fload3==45||moving_Test.fload3==54) {
					 m[6]=1;
					 
				 }
				 if(moving_Test.fload3==56||moving_Test.fload3==65) {
					 m[7]=1;
					 
				 }
				 if(moving_Test.fload3==48||moving_Test.fload3==84) {
					 m[8]=1;
					 
				 }
				 if(moving_Test.fload3==59||moving_Test.fload3==95) {
					 
					 m[9]=1;
				 }
				 if(moving_Test.fload3==70||moving_Test.fload3==106) {
					 m[10]=1;
					 
				 }
				 if(moving_Test.fload3==78||moving_Test.fload3==87) {
					 m[11]=1;
					 
				 }
				 if(moving_Test.fload3==89||moving_Test.fload3==98) {
					 m[12]=1;
					 
				 }
				 if(moving_Test.fload3==90||moving_Test.fload3==108) {
					 m[13]=1;
				 }
				 
				 
			 
			
		 }
		public void clear_Stage1() {
			cc1=m[0]*m[1]*m[2]*m[3]*m[4]*m[5]*m[6]*m[7]*m[8]*m[9]*m[10]*m[11]*m[12]*m[13];
			if(cc1==1) {
				System.out.println("clear");
			}
		}
		public void reset_mark() {
			if(moving_Test.reset==true) {
				for(int i =0;i<14;i++) {
					moving_Test.fload1=0;
					moving_Test.fload2=0;
					moving_Test.fload3=0;
					m[i]=0;
				}
					System.out.println("reset");
					 moving_Test.x=528;
					 moving_Test.y=124;
					 moving_Test.reset=false;
			}
		}
			 
		
	//	}

}
