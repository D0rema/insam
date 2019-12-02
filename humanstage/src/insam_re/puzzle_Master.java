package insam_re;
/**
 * 
 * @author chlau
 *A class for implementing puzzles.
 */
public class puzzle_Master {
	int iceNotKey = 0 ;
	public void puzzle_Master() {
		find_load();//1스테이지에서 작동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//ice_Load();//2스테이지에서 작동@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		find_Load_Reset();
	}
	/**
	 * 
This variable contains the coordinates of the mark.
	 */
private int mark[][] = new int [10][4];
private int loadmark[] = new int[] {17,71,12,21,13,31,24,42,25,52,34,43,45,54,56,65,48,84,59,95,70,106,78,87,89,98,90,108};
/**
 * This function uses the coordinates of the mark to change the associated variable whenever the character passes the mark.
 */
		public void find_load() {
			mark[0] = new int[] { 132,164,100,132 };
			mark[1] = new int[] { 328,360,100,132 };
			mark[2] = new int[] { 132,164,232,264 };
			mark[3] = new int[] { 328,360,232,264 };
			mark[4] = new int[] { 424,456,232,264 };
			mark[5] = new int[] { 516,548,232,264 };
			mark[6] = new int[] { 68,100,360,392 };
			mark[7] = new int[]{ 232,264,360,392 };
			mark[8] = new int[] { 424,456,360,392 };
			mark[9] = new int[] { 484,516,416,448 };
				
			for(int i = 0;i<10;i++) {
				if(moving_Test.x>mark[i][0]&&moving_Test.x<mark[i][1]&&moving_Test.y>mark[i][2]&&moving_Test.y<mark[i][3]) {
					moving_Test.char_lo=i;
					moving_Test.fload2 = moving_Test.fload1;
					moving_Test.fload1 = i+1;
					
					if(moving_Test.fload2!=moving_Test.fload1) {
						
					moving_Test.fload3 = moving_Test.fload2*10+moving_Test.fload1;
					}
					
				}
			}

			
			
			
		}
	
	
			public void ice_Load() {
				if(moving_Test.x>60&&moving_Test.x<572&&moving_Test.y>60&&moving_Test.y<508) {
			/*		if(moving_Test.moveStatus==0&&moving_Test.not_key!=1) {
						moving_Test.y-=4;
					}
					if(moving_Test.moveStatus==1&&moving_Test.not_key!=4) {
						moving_Test.x+=4;
					}
					if(moving_Test.moveStatus==2&&moving_Test.not_key!=2) {
						moving_Test.y+=4;
					}
					if(moving_Test.moveStatus==3&&moving_Test.not_key!=3) {
						moving_Test.x-=4;
					}*/
				}
			}
			 public void find_Load_Reset() {
				 switch(moving_Test.fload1) {
				 case 1: if(moving_Test.fload3==21||moving_Test.fload3==31||moving_Test.fload3==71) {
					 
				 }else {moving_Test.reset=true;};
				 case 2 :if(moving_Test.fload3==42||moving_Test.fload3==52||moving_Test.fload3==12) {
					 
				 }else {moving_Test.reset=true;};
				 case 3 :if(moving_Test.fload3==13||moving_Test.fload3==43) {
					 
				 }else {moving_Test.reset=true;};
				 }
				 if(moving_Test.reset==true) {
				//	 moving_Test.x=100;
				//	 moving_Test.y=100;
					 moving_Test.reset=false;
					 
				 }
			 }
		}

