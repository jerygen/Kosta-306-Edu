package ex0205.homework;

import java.util.Scanner;

/**
 * 주제:학생 점수 분석하는 프로그램(학생수, 점수입력, 점수리스트, 분석, 종료)
 * 작성일: 26.02.05
 * 작성자: 김미연
 */
public class Exercise04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true; 
		int students = 0;
		int [] scores = null; //초기화
		int len = 0;
		int max = 0;
		int sum = 0;
		
		while(run) {
			System.out.println("\n---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");
			
			int choice = sc.nextInt();
			switch(choice) { 			
			case 1: 
				System.out.print("학생 수> ");
				students = sc.nextInt();
				scores = new int [students];
				break;
			case 2:
				len = scores.length;
				for(int i=0;i<len;i++) {
					System.out.print("scores["+i+"]> ");
					scores[i] = sc.nextInt();
				}
				System.out.println();
				break;
			case 3:
				for(int i:scores) {
					int j = 0;
					System.out.println("scores["+j+"]: "+i);
					j++;
				}
				//j를 쓸거면 굳이 개선된 for 문으로 할 필요없이 원래 for 문으로 사용하는 게 더 좋음 
				//개선된 for 문을 사용할 필요가 없기 때문
				//순서대로 입력하지 않을 경우도 고려해서 코드를 짜는 연습하기
				//지금이라면 if(scores!=null)일 때 정상 출력되고, else이면 먼저 1번을 입력하라는 문장을 출력해서 사용
				//나머지도 그런 식으로 예외처리하기
				break;
			case 4:
				for(int i=0;i<len;i++) {
					if(max<scores[i]) max=scores[i];
					sum += scores[i];
				}
				double avg = (double)sum/len;
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+avg);
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("1~5까지의 숫자만 입력하세요");
				break;
			}
		}
					
	}

}
