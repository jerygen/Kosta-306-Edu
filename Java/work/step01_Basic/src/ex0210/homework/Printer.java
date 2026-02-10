package ex0210.homework;
/**
 * 16번,17번 문제풀이
 * 작성일: 2026.02.10
 * 작성자: 김미연
 * */
public class Printer {
	//17번 문제풀이
	public static void println(int i) {
		System.out.println(i);
	}
	public static void println(boolean bo) {
		System.out.println(bo);
	}
	public static void println(double dou) {
		System.out.println(dou);
	}
	public static void println(String s) {
		System.out.println(s);
	}
	
//16번 문제풀이
//	public void println(int i) {
//		System.out.println(i);
//	}
//	public void println(boolean bo) {
//		System.out.println(bo);
//	}
//	public void println(double dou) {
//		System.out.println(dou);
//	}
//	public void println(String s) {
//		System.out.println(s);
//	}
	
	public static void main(String[] args) {
		//16번 문제풀이
//		Printer printer = new Printer();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");
		
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}
}
