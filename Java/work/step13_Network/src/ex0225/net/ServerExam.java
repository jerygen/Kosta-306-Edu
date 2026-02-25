package ex0225.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	
	public ServerExam() {
		try(ServerSocket server = new ServerSocket(8000)) {
			while(true) {
				System.out.println("클라이언트 접속을 대기 중입니다.");
				
				Socket sk = server.accept();//접속 대기중
				String ip = sk.getInetAddress().toString();
				System.out.println(ip+"님 접속되었습니다.");
				
				//클라이언트가 보내온 내용을 읽기 - 
				BufferedReader br = new BufferedReader(new InputStreamReader( sk.getInputStream() ));
				String clientData = br.readLine();//읽으려고 준비 중
				System.out.println("클라이언트가 보내온 내용 = "+clientData);
				
				//클라이언트에게 데이터를 보내기=전송 
				PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
				pw.println("서버에 입장하신 것을 환영합니다~~");//엔터를 쳐야 autoFlush가 일어난다. 그냥 print로 하면 전송이 안 됨
				
				System.out.println();
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerExam();

	}

}
