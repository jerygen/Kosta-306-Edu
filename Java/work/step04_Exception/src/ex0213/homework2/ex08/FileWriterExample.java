package ex0213.homework2.ex08;

import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) {		
		try (FileWriter fw = new FileWriter("file.txt");){
			fw.Writer("Java");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
