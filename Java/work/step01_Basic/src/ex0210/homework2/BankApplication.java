package ex0210.homework2;

import java.util.Scanner;

public class BankApplication {
	Account [] arr = new Account[100];
	Account account;
	
	Scanner sc = new Scanner(System.in);
	
	public void printMenu() {
		//account = new Account();
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			
			System.out.print("선택> ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				System.out.println("---------");
				System.out.println("계좌생성");
				System.out.println("---------");
				
				break;
			case 2:
				System.out.println("---------");
				System.out.println("계좌목록");
				System.out.println("---------");
				break;
			case 3:
				System.out.println("---------");
				System.out.println("예금");
				System.out.println("---------");
				break;
			case 4:
				System.out.println("---------");
				System.out.println("출금");
				System.out.println("---------");
				break;
			case 5:
				System.out.println("프로그램 종료");
				System.exit(0);
			default: 
				System.out.println("1~5까지의 숫자만 입력하세요");
				break;
			}
		}
	}
	

}
