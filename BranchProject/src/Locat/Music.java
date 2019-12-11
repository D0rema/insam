package Locat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player; // 자바 줌에 있는 mp3 읽어 오는 라이브러리
	private volatile boolean isLoop;// 노래반복 여부
	private InputStream fis;
	private BufferedInputStream bis;
	private String name;
	private volatile boolean running = true;
	private volatile boolean paused = false;
	private final Object pauseLock = new Object();

	public Music(String name, boolean isLoop) {// 곡 이름, 반복여부
		try {// 오류 발생시 catch
			this.name = name;
			
			this.isLoop = isLoop;
			fis = getClass().getClassLoader().getResourceAsStream("music/" + name); // 노래 가져오기
			bis = new BufferedInputStream(fis); // 노래를 버퍼에서 담아 읽어올 수 있게
			player = new Player(bis); // 버퍼 가져오기

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
public void getPaused() {
	System.out.println(paused);
}
	public int getTime() {// 실행되고 있는 음악이 어떤 위치에서 실행되는지 알려줌
		if (player == null)
			return 0;
		return player.getPosition();
	}

	public void pause() {
		// you may want to throw an IllegalStateException if !running
		paused = true;
	}

	public void playback() {
		 synchronized (pauseLock) {
	            paused = false;
	            pauseLock.notifyAll(); // Unblocks thread
	        }
	}

	public void close() {// 음악이 언제 실행되고 있던 간에 항상 종료할 수 있도록
		isLoop = false;
		player.close();
		this.interrupt();// 음악 쓰레드 중지
	}

	@Override
	public void run() {// 쓰레드 상속받으면 무조건 사용하는 함수
		try {

			do {
				player.play();
				fis = getClass().getClassLoader().getResourceAsStream("music/" + name);
				bis = new BufferedInputStream(fis); // 노래를 버퍼에서 담아 읽어올 수 있게
				player = new Player(bis); // 버퍼 가져오기
			} while (isLoop); // isLoop가 true면 무한반복

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
