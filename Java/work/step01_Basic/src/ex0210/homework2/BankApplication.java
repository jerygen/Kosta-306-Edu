package ex0210.homework2;

import java.util.Scanner;

public class BankApplication {
	private Account [] arr = new Account[100];
	
	Scanner sc = new Scanner(System.in);
	
	public void printMenu() {
		
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			
			System.out.print("선택> ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				createAccount();
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
	
    // 1. 계좌 생성
    public void createAccount() {
        System.out.println("------");
        System.out.println("계좌생성");
        System.out.println("------");

        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();

        System.out.print("계좌주: ");
        String owner = sc.nextLine();

        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(sc.nextLine());

        Account newAccount = new Account(accountNo, owner, balance);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = newAccount;
                break;
            }
        }

        System.out.println("결과: 계좌가 생성되었습니다.");
    }
    
    // 2. 계좌 목록
    public void accountList() {
        System.out.println("------");
        System.out.println("계좌목록");
        System.out.println("------");

        for (Account account : arr) {
            if (account != null) {
                System.out.println(
                        account.getAccountNo() + "\t" +
                        account.getOwner() + "\t" +
                        account.getBalance());
            }
        }
    }
	
    // 계좌 찾기
    public Account findAccount(String accountNo) {
        for (Account account : arr) {
            if (account != null) {
                if (account.getAccountNo().equals(accountNo)) {
                    return account;
                }
            }
        }
        return null;
    }
    
    // 3. 예금
    public void deposit() {
        System.out.println("------");
        System.out.println("예금");
        System.out.println("------");

        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();

        System.out.print("예금액: ");
        int money = Integer.parseInt(sc.nextLine());

        Account account = findAccount(accountNo);

        if (account != null) {
            account.deposit(money);
            System.out.println("결과: 예금이 성공되었습니다.");
        } else {
            System.out.println("결과: 해당 계좌가 없습니다.");
        }
    }

    // 4. 출금
    public void withdraw() {
        System.out.println("------");
        System.out.println("출금");
        System.out.println("------");

        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();

        System.out.print("출금액: ");
        int money = Integer.parseInt(sc.nextLine());

        Account account = findAccount(accountNo);

        if (account != null) {
            boolean result = account.withdraw(money);
            if (result) {
                System.out.println("결과: 출금이 성공되었습니다.");
            } else {
                System.out.println("결과: 잔액이 부족합니다.");
            }
        } else {
            System.out.println("결과: 해당 계좌가 없습니다.");
        }
    }
	
	

}
