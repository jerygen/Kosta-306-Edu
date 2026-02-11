package ex0210.homework;
/**
 * 15번 문제풀이
 * 작성일: 2026.02.10
 * 작성자: 김미연
 * */
public class MemberService {

	public boolean login(String id, String password) {
		//1번 더 권장하는 방법 -> 자바 코딩 가이드북(검색)
		//hong과 12345는 null일 수가 없음. 사용자 입력값은 사용자가 잘 못 넣을 가능성이 존재
		//따라서 입력값이 null이어도 괜찮다.
		if("hong".equals(id)&&"12345".equals(password)) {}
		//2번
		//null 이라는 값이 들어와서 .메소드이면 nullpointexception이 발생할 수 있음
		//예외 예측을 할 줄 알아야 함
		if(id.equals("hong")&&password.equals("12345")) return true;
		return false;
	}
	public void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다.");
	}
	
//	public static void main(String[] args) {
//		MemberService memberService = new MemberService();
//		boolean result = memberService.login("hong", "12345");
//		if(result) {
//			System.out.println("로그인 되었습니다.");
//			memberService.logout("hong");
//		}else {
//			System.out.println("id 또는 password가 올바르지 않습니다.");
//		}
//	}
}
