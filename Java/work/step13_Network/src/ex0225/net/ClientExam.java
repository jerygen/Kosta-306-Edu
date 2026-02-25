package ex0225.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {

	public ClientExam() {
		try(Socket sk = new Socket("192.168.0.38", 8000)) {//자기 주소를 지정할 때 172.0.0.1 사용
			//서버에게 데이터 전송, 서버에서 클라이언트가 내용을 보내주기를 기다리는 중
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			pw.println("서버에 접속할게요."); //server의 br.readLine()으로 간다.
			
			//서버가 보내온 내용을 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader( sk.getInputStream() ));
			String data = br.readLine();
			System.out.println("서버가 보내 온 내용 = "+data);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ClientExam();
		

	}

}
