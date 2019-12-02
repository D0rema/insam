package insam_re;

import java.awt.event.KeyEvent;
/**
 * 
 * @author chlau
 *This class handles everything about keystrokes.
 */
public class key{
	boolean keyUp = false; 
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;
	boolean jump = false; 

	private moving_Test moving_Test = null;
	/**
	 * Sets a variable according to key input.
	 */
public void keyProcess(){

moving_Test.playerMove = false;

if ( keyUp &&moving_Test.not_Up!=1){
	moving_Test.playerMove = true;
	moving_Test.y -= 4;
	moving_Test.moveStatus = 0;
}

if ( keyDown&&moving_Test.not_Down!=1){
	moving_Test.y += 4;
	moving_Test.moveStatus = 2;
	moving_Test.playerMove = true;
}

if ( keyLeft&&moving_Test.not_Left!=1){
	moving_Test.x -= 4;
moving_Test.moveStatus = 3;
moving_Test.playerMove = true;
}

if ( keyRight&&moving_Test.not_Right!=1){
	moving_Test.x += 4;
moving_Test.moveStatus = 1;
moving_Test.playerMove = true;
}

if ( jump)
{

	moving_Test.moveStatus = 1;
	moving_Test.playerMove = true;

	if(moving_Test.cnt<moving_Test.jp1) { 
		moving_Test.y -= 16 ; 	}
if(moving_Test.cnt>moving_Test.jp1) {
jump=false;
moving_Test.try_jump=false;
}
	}

}
/**
 * This function sets the variables required when a key is pressed.
 * 
 */
public void keyPressed(KeyEvent e) {

	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT :
		if(moving_Test.not_Left !=1) {
	keyLeft = true;
	}
	break;
	case KeyEvent.VK_RIGHT :
		if(moving_Test.not_Right !=1) {
	keyRight = true;
		}
	break;
	case KeyEvent.VK_UP :
		if(moving_Test.not_Up !=1) {
	keyUp = true;
		}
	break;
	case KeyEvent.VK_DOWN :
		if(moving_Test.not_Down !=1) {
	keyDown = true;
		}
	break;
	case KeyEvent.VK_SPACE :
		moving_Test.jp1 = moving_Test.cnt+20; 
		moving_Test.jp2 = moving_Test.cnt+40;
		moving_Test.try_jump=true; 
	//jump = true;
	moving_Test.reset = true;
	break;
	}
	}
/**
 * This function sets the variables required when a key is Released.
 * 
 */
	public void keyReleased(KeyEvent e) {
	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT :
	if(moving_Test.iload==0) {
	keyLeft = false;
	}
	break;
	case KeyEvent.VK_RIGHT :
		if(moving_Test.iload==0) {
	keyRight = false;
		}
	break;
	case KeyEvent.VK_UP :
		if(moving_Test.iload==0) {
	keyUp = false;
		}
	break;
	case KeyEvent.VK_DOWN :
		if(moving_Test.iload==0) {
	keyDown = false;
		}
	break;
	case KeyEvent.VK_SPACE :
	//jump = false;
		moving_Test.reset = false;
	break;
	}
	}

public void keyTyped(KeyEvent e) {}

}

