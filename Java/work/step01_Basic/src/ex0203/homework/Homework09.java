package ex0203.homework;

import java.util.Scanner;

public class Homework09 {

	public static void main(String[] args) {
		boolean run = true; // 상태변수 역할, 반복문 실행 여부를 판단하는 변수
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("\n--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.println("선택> ");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("예금액> ");
				int plusMoney = scanner.nextInt();
				// int i = Integer.parseInt(String str) 문자열을 int형으로 변환
				// 
				balance += plusMoney;
				break; // 스위치의 break, 반복문의 break가 아님
			case 2:
				System.out.print("출금> ");
				int minusMoney = scanner.nextInt();
				balance -= minusMoney;
				break;
			case 3:
				System.out.print("잔고> "+balance);
				break;
			default: 
				System.out.print("프로그램 종료");
				run = false;
				//System.exit(0);
				
//			default: 
//				System.out.println("1~4 사이의 숫자만 입력해주세요.");
//				break;
			}// switch의 끝
			
		}//while의 끝

	}

}
