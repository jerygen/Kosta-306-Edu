package ex0210.homework;

public class Main {

	public static void main(String[] args) {
		//15번
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		//19번
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
