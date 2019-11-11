package Locat;

import javax.swing.JFrame;

public class main {

	public static final int SCREEN_WIDTH=1280;
	public static final int SCREEN_HEIGHT=720;
	
	public static void main(String[] args) {
		 new startFrame();
	}
}
//그냥 이미지만 불러오는 방식을 이용하면 버퍼링이 심함 그래서 더블버퍼링이용
//현재 프로그램에 전체화면의 크기에 맞는 이미지를 매순간마다 생성해서 원하는 컴포넌트만 화면에 출력 
//버퍼에 이미지를 담아 매순간마다 이미지 갱신