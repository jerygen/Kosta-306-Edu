package ex0223.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutExam {
	public FileInputOutExam() {//IO는 반드시 사용 후 close()를 해야 한다!!!
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//byte 단위 파일 읽기 (InputStream -> FileInputStream)
			fis = new FileInputStream("src/ex0223/test.txt");
			/*while(true) {
				int i = fis.read();//1byte씩 읽기, 한글은 제대로 표현이 안 되어 있음
				if(i==-1)break;
				System.out.println(i+" = "+(char)i);
			}*/
			//////byte 배열의 크기만큼 읽기/////////////////////
			/// 
			int len = fis.available();//읽을 수 있는 byte 수 반환
			System.out.println("len = "+len);
			
			//byte b [] = new byte[len];
			byte b [] = new byte[1024];
			int re =0;
			
			while((re = fis.read(b))!= -1) {
//				re = fis.read(b);//읽어드린 byte 수가 리턴 됨
				
				System.out.println("re ="+re);
				//System.out.println("b ="+b);
				
				//byte 배열을 -> String 으로 변환!
				String data = new String(b);
				System.out.println("data = "+data);
			}
			///////////////////////////////
			//파일에 저장=출력
			//fos = new FileOutputStream("src/ex0223/write.txt");//없으면 새로 생성하고, 있으면 덮어쓰기한다.(default)
			fos = new FileOutputStream("src/ex0223/write.txt", true); //true가 이어쓰기 
			fos.write(72);
			fos.write(65);
			fos.write(13);
			fos.write(10);
			fos.write(75);
			
			String str = "배고프다 뭐먹지?";
			//String --> byte 배열로 변환
			fos.write(str.getBytes());
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//닫기
				if(fis!=null)fis.close();
				if(fos!=null)fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new FileInputOutExam();

	}

}
