package ex0223.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterExam {
	
	public BufferedReaderWriterExam() {
		try(BufferedReader br = new BufferedReader(new FileReader("src/ex0223/test.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0223/jang.txt"))){
			//한 문자 읽기
			/*int i = 0;
			while((i=br.read()) != -1) {
				System.out.println(i+" = "+(char)i);
			}*/
			
			//한 줄 읽기, byte에는 없음. 문자 단위의 버퍼드가 있어서 사용가능
			String data=null;
			while((data=br.readLine())!=null) {
				System.out.println(data);
				bw.write(data);
				bw.newLine();//개행, 파일 카피는 inputStream이 더 적합하다. 왜냐면 파일 크기가 달라짐. 무조건 이 줄이 하나 더 들어가니깐
				bw.flush();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void main(String[] args) {
		new BufferedReaderWriterExam();

	}

}
