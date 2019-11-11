package Locat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player; //자바 줌에 있는 mp3 읽어 오는 라이브러리
	private boolean isLoop;//노래반복 여부
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name,boolean isLoop) {//곡 이름, 반복여부
		try {//오류 발생시 catch
			this.isLoop=isLoop;
			file=new File(main.class.getResource("../music/"+name).toURI()); //노래 가져오기
			fis =new FileInputStream(file);
			bis=new BufferedInputStream(fis); //노래를 버퍼에서 담아 읽어올 수 있게
			player =new Player(bis); // 버퍼 가져오기
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() {//실행되고 있는 음악이 어떤 위치에서 실행되는지 알려줌
		if(player==null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {//음악이 언제 실행되고 있던 간에 항상 종료할 수 있도록
		isLoop=false;
		player.close();
		this.interrupt();//음악 쓰레드 중지
	}
	
	@Override
	public void run() {//쓰레드 상속받으면 무조건 사용하는 함수
		try {
			do {//곡 실행
				player.play();
				fis =new FileInputStream(file);
				bis=new BufferedInputStream(fis); //노래를 버퍼에서 담아 읽어올 수 있게
				player =new Player(bis); // 버퍼 가져오기
			}while(isLoop); //isLoop가 true면 무한반복
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
