package insam_re;
/**
 * 
 * @author chlmyeongkyu
 * 
 * This class is for implementing flat and walls.
 *
 */
public class check_Wall {
	int wall_count = 5;
	int wall[][] = new int [wall_count][4];
	moving_Test m1 = new moving_Test();
	int flat_count = 2;//�÷��� ����
	int flat[][] = new int [flat_count][4];
	
	
	int ice_Wall[][]= new int [8][];

	public int on_flat = 0;
	public int on_bottom = 0; 


	public int ff; 
/**
 * Calls the is_bottom () and in_flat () functions and flat the range of scaffolding.
 */
	public void check_Wall(){

		flat[0][0]= 200;
		flat[0][1]= 300;
		flat[0][2]= 388;
		flat[0][3]= 400;
		
		flat[1][0]= 400;
		flat[1][1]= 500;
		flat[1][2]= 228;
		flat[1][3]= 400;
		 ice_Wall[0]= new int [] {64,120,120, 164,240,120, 100,172,240 ,452,520,300 ,168,240,360, 232,300,436, 520,560,504 ,120,160,60 ,248,572,60, 0,52,300};
		 ice_Wall[1]= new int [] {100,172,128, 452,520,188, 168,240,256, 232,300,320, 520,560,384, 108,172,448, 56,92,508 ,184,572,508};
		 ice_Wall[2]= new int [] {120,60,112, 252,60,112 ,188,136,236, 540,204,292 ,248,268,368, 316,340,428 ,184,464,508 ,60,120,288, 60,372,508};
		 ice_Wall[3]= new int [] {156,60,112, 88,136,236, 440,204,292, 152,268,368, 216,340,428, 504,400,492 ,88,464,508 ,572,500,508, 572,188,384, 572,60,100};
		 ice_Wall[4]= new int [] {60,116, 120,60, 252,60};
		 ice_Wall[5]= new int [] {568,60, 216,376, 568,504};
		 ice_Wall[6]= new int [] {252,316, 60,508, 188,508};
		 ice_Wall[7]= new int [] {572,508 ,572,384};
	/*	 
		 ice_Wall[2][0]= new int [] {164,240,120,120};
		 ice_Wall[2][1]= new int [] {};
		 ice_Wall[2][2]= new int [] {252,252,60,112};
		 ice_Wall[2][3]= new int [] {156,156,60,112};
		 
		 ice_Wall[3][0]= new int [] {100,172,240,240};
		 ice_Wall[3][1]= new int [] {100,172,128,128};
		 ice_Wall[3][2]= new int [] {188,188,136,236};
		 ice_Wall[3][3]= new int [] {88,88,136,236};
		 
		 ice_Wall[4][0]= new int [] {452,520,300,300};
		 ice_Wall[4][1]= new int [] {452,520,188,188};
		 ice_Wall[4][2]= new int [] {540,540,204,292};
		 ice_Wall[4][3]= new int [] {440,440,204,292};
		 
		 ice_Wall[5][0]= new int [] {168,240,360,360};
		 ice_Wall[5][1]= new int [] {168,240,256,256};
		 ice_Wall[5][2]= new int [] {252,252,268,368};
		 ice_Wall[5][3]= new int [] {152,152,268,368};
		 
		 ice_Wall[6][0]= new int [] {232,300,438,438};
		 ice_Wall[6][1]= new int [] {232,300,320,320};
		 ice_Wall[6][2]= new int [] {316,316,340,428};
		 ice_Wall[6][3]= new int [] {216,216,340,428};
		 
		 ice_Wall[7][0]= new int [] {520,560,504,504};
		 ice_Wall[7][1]= new int [] {520,560,384,384};
		 ice_Wall[7][2]= new int [] {};
		 ice_Wall[7][3]= new int [] {504,504,400,492};
		 
		 ice_Wall[8][0]= new int [] {};
		 ice_Wall[8][1]= new int [] {108,172,448,484};
		 ice_Wall[8][2]= new int [] {188,188,464,508};
		 ice_Wall[8][3]= new int [] {88,88,464,508};
		 
		 ice_Wall[9][0]= new int [] {120,160,60,60};
		 ice_Wall[9][1]= new int [] {56,92,508,508};
		 ice_Wall[9][2]= new int [] {60,60,120,288};
		 ice_Wall[9][3]= new int [] {564,564,500,508};
		
		 ice_Wall[10][0]= new int [] {248,572,60,60};
		 ice_Wall[10][1]= new int [] {184,572,508,508};
		 ice_Wall[10][2]= new int [] {60,60,372,508};
		 ice_Wall[10][3]= new int [] {564,564,188,384};
			
		 ice_Wall[11][0]= new int [] {0,52,300,300};
		 ice_Wall[11][1]= new int [] {};
		 ice_Wall[11][2]= new int [] {};
		 ice_Wall[11][3]= new int [] {564,564,60,100};*/
	}
	/**
	 * Set gravity and set the position of the floor the character is stepping on.
	 */
	public void is_bottom() {
		if(on_flat==0) { 
			moving_Test.g_y = 468;
		}
		if(!moving_Test.try_jump) { 
		if(moving_Test.y>=moving_Test.g_y) { 
			on_bottom = 1; 
		}else {on_bottom = 0;}
		if(on_bottom==0) { 
			moving_Test.y+=16;
		}
		}
	}
	/**
	 * This function is used to distinguish whether or not the character is in the preset flat position.
	 */
	public void in_flat() { 
		for(int i = 0;i<flat_count;i++) { 
			if(flat[i][0]<moving_Test.x&&flat[i][1]>moving_Test.x&&flat[i][2]==moving_Test.y) { 

				on_flat=1; 
				ff=i; 
				moving_Test.g_y = flat[ff][2];
			}else if(flat[ff][0]>moving_Test.x||flat[ff][1]<moving_Test.x){
						on_flat=0; 
			}
		}
	}
	/**
	 * This function prevents the character from falling off the screen.
	 */
 public void on_Wall () {
 

	if(moving_Test.y<=48) {
		moving_Test.playerMove=false;
		moving_Test.not_Up=1;
	}
	if(moving_Test.y>=484) {
		moving_Test.playerMove=false;
		moving_Test.not_Down=2;
	}

	if(moving_Test.x<=24) {
		moving_Test.playerMove=false;
		moving_Test.not_Left=3;
	}

	if(moving_Test.x>=596) {
		moving_Test.playerMove=false;
		moving_Test.not_Right=4;
	}
	if(moving_Test.y>=48&&moving_Test.y<=484&&moving_Test.x<=596&&moving_Test.x>=24) {
		moving_Test.not_Up=0;
 		moving_Test.not_Down=0;
 		moving_Test.not_Left=0;
 		moving_Test.not_Right=0;
	} 
	
	
	}
 public void on_Iwall() {

	 for(int i=0;i<3;i++) {
		 if(moving_Test.x==ice_Wall[4][(2*i)+0]&&moving_Test.y==ice_Wall[4][(2*i)+2]) { 
				 
			 		moving_Test.not_Up=1;
			 		moving_Test.not_Down=0;
			 		moving_Test.not_Left=1;
			 		moving_Test.not_Right=0;
					
				 }
	}
		 for(int i=0;i<3;i++) {
		 if(moving_Test.x==ice_Wall[5][(2*i)+0]&&moving_Test.y==ice_Wall[5][(2*i)+2]) { 
				 
			 		moving_Test.not_Up=1;
			 		moving_Test.not_Down=0;
			 		moving_Test.not_Left=0;
			 		moving_Test.not_Right=1;
					
				 }
	}
		 for(int i=0;i<3;i++) {
		 if(moving_Test.x==ice_Wall[6][(2*i)+0]&&moving_Test.y==ice_Wall[6][(2*i)+2]) { 
				 
			 		moving_Test.not_Up=0;
			 		moving_Test.not_Down=1;
			 		moving_Test.not_Left=1;
			 		moving_Test.not_Right=0;
					
				 }
	}
		 for(int i=0;i<2;i++) {
		 if(moving_Test.x==ice_Wall[7][(2*i)+0]&&moving_Test.y==ice_Wall[7][(2*i)+2]) { 
				 
			 		moving_Test.not_Up=0;
			 		moving_Test.not_Down=1;
			 		moving_Test.not_Left=0;
			 		moving_Test.not_Right=1;
					
				 }
	}
	 for(int i=0;i<10;i++) {
	 if(moving_Test.x>ice_Wall[0][(3*i)+0]&&moving_Test.x<ice_Wall[0][(3*i)+1]&&moving_Test.y==ice_Wall[0][(3*i)+2]) { 
			 
				 moving_Test.not_Up=1;
				 moving_Test.not_Down=0;
				 moving_Test.not_Left=0;
				 moving_Test.not_Right=0;
			 }
}
	 for(int i=0;i<8;i++) {
	 if(moving_Test.x>ice_Wall[1][(3*i)+0]&&moving_Test.x<ice_Wall[1][(3*i)+1]&&moving_Test.y==ice_Wall[1][(3*i)+2]) { 
			 
		 		moving_Test.not_Up=0;
		 		moving_Test.not_Down=1;
		 		moving_Test.not_Left=0;
		 		moving_Test.not_Right=0;
				
			 }
}
	 for(int i=0;i<9;i++) {
	 if(moving_Test.x==ice_Wall[2][(3*i)+0]&&moving_Test.y>ice_Wall[2][(3*i)+1]&&moving_Test.y<ice_Wall[2][(3*i)+2]) { 
			 
		 		moving_Test.not_Up=0;
		 		moving_Test.not_Down=0;
		 		moving_Test.not_Left=1;
		 		moving_Test.not_Right=0;
				
			 }
}
	 for(int i=0;i<10;i++) {
	 if(moving_Test.x==ice_Wall[3][(3*i)+0]&&moving_Test.y>ice_Wall[3][(3*i)+1]&&moving_Test.y<ice_Wall[3][(3*i)+2]) { 
			 
		 		moving_Test.not_Up=0;
		 		moving_Test.not_Down=0;
		 		moving_Test.not_Left=0;
		 		moving_Test.not_Right=1;
				
			 }
}
 }
}
