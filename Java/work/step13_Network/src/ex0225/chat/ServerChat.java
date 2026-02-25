package ex0225.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import ex0225.net.SendThread;

/**
 * 클라이언트와 1 : 1 채팅을 위한 Server
 * */
public class ServerChat {
	public ServerChat() {
		try {
			ServerSocket server = new ServerSocket(8001);
			System.out.println("클라이언트 접속 대기 중입니다.....");
			Socket sk = server.accept();
			System.out.println(sk.getInetAddress().toString()+"님과 대화 시작합니다.");
			
			
			//읽기
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						BufferedReader br = 
								new BufferedReader(new InputStreamReader( sk.getInputStream() ));
						while(true) {
							String readData = br.readLine();
							
							if(readData.equals("exit")) break; //읽기만 종료되고, 쓰기 스레드는 아직 종료되지 않음
							
							System.out.println(readData);
						}
						System.out.println("Server 받는 스레드 종료");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("서버 읽기 스레드 catch입니다.");
					}finally {
						System.out.println("---------모든 프로그램 종료-------");
						System.exit(0);
					}
				}
					
			}).start();
			
			
			
			//쓰기=전송
			new SendThread(sk, "[SERVER]").start();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerChat();

	}

}
