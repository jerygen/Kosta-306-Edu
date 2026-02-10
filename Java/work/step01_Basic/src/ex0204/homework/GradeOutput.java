package ex0204.homework;

import java.util.Scanner;

// 주석을 다는 이유는 마우스로 클래스명이나 메소드명에 가져다 댔을 때 그 주석 내용이 보이기 때문에 하는 것!!!!
// 주석 줄바꿈 태그를 사용하거나 유니코드 사용하기

/**
 * 주제: 성적출력 프로그램
 * 작성일:26.02.04
 * 작성자: 김미연
 * */
class CalculateGrade {
	
	// 리턴 값이 있는 메소드명에는 get이 붙음.
	// 리터 값이 없는 메소드명에는 set을 붙임
	private int total(int kor, int eng, int math) { 
		int sum = kor + eng + math;
		return sum;
	}
	
	private double average(int sum, int j) {
		double avg = (int)(sum/j*100)*0.01;
		// 그냥 (double)(sum/j)해도 됨 작은 크기를 큰 크기 안에 담는 거라서 
		return avg;
	}
	
	private char grade(double avg) {
		char result = switch((int)avg/10) {
		case 9, 10 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};
		return result;
	}
	
	/**
	 * 성적 산출 결과 출력
	 * */
	public void output(String name, int kor, int eng, int math) { //메소드명을 printResult로 해도 될 듯
		CalculateGrade cg = new CalculateGrade();
		int sum = cg.total(kor, eng, math);
		double avg = cg.average(sum, 3);
		char grade = cg.grade(avg);
		
		System.out.println("이름: "+name);
		System.out.println("총점: "+sum);
		System.out.println("평균: "+avg);
		System.out.println("등급: "+grade);
	}
}

public class GradeOutput{
	public static void main(String [] args) {
		CalculateGrade res = new CalculateGrade();
		// 반복문 내에 넣을 필요 없음 넣으면 반복문을 사용할 때마다 GC(가비지 콜렉터)가 발생
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("\n---------------------");
			System.out.println("1. 성적표 구하기 | 2. 종료" );
			System.out.println("---------------------");
			System.out.print("선택> ");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("이름> ");
				String name = sc.next();
				System.out.print("국어 점수> ");
				int kor = sc.nextInt();
				System.out.print("영어 점수> ");
				int eng = sc.nextInt();
				System.out.print("수학 점수> ");
				int math = sc.nextInt();
				
				res.output(name, kor, eng, math);
				break;				
			case 2:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default: 
				System.out.println("1 또는 2만 입력하세요.");
				break;
			}
			
		}
		
	}
}
