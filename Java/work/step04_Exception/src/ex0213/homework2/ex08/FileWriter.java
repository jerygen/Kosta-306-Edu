package ex0213.homework2.ex08;

import java.io.IOException;

public class FileWriter implements AutoCloseable {
	public FileWriter(String filePath) {
		System.out.println(filePath+" 파일을 엽니다.");
	}
	
	public void Writer(String data) {
		System.out.println(data+"를 파일에 저장합니다.");
	}
	@Override
	public void close() throws Exception {
		System.out.println("파일을 닫습니다.");
	}

}
