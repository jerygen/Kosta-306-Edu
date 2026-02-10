package ex0210.homework;
/**
 * 19번 문제풀이
 * 작성일: 2026.02.10
 * 작성자: 김미연
 * */
public class Account {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance>=0&&balance<=1000000) {
			this.balance += balance;
		}
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(1000);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: "+account.getBalance());
		
		account.setBalance(300000);
		System.out.println("현재 잔고: "+account.getBalance());
	}
}
