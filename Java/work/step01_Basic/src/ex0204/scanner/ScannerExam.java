package ex0204.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 키보드 입력
		Scanner sc = new Scanner(System.in); // ctrl + shift + o
		
		// 키보드 입력은 숫자, 문자열, 문자열(공백이 있는 문자열)
	    // 공백이 없는 문자열 공백이 있으면 공백 뒤는 무시 됨 ("\\n") 무시
		System.out.println("국어 ?");
		int kor = sc.nextInt();
		
		System.out.println("영어 ?");
		int eng = sc.nextInt();
		
		System.out.println("이름 ?");
		String name = sc.next();
		
		// nextLine은 /n에 관심이 있어서 앞에서 /n이 버퍼 공간에 남아있으면 그 값을 읽고 끝나버림
		// 그래서 nextInt, next 두 개와 nextLine을 같이 사용하지 않음. 
		sc.nextLine();
		
		System.out.println("이름 ?");
		String name2 = sc.nextLine();		
		
		System.out.println(name + "님 " + kor + "," + eng);
		
	}

}
