package ex0219.lamda;

public class MainApp {
	public static void main(String[] args) {
		//1. 기존 방식
		/*AInterface ai = new Test();
		ai.aa();*/
		
		//2. AnonymousInner type 으로 작성(익명 타입 선언)
		//AInterface ai = new AI() {//재정의};//생성 X, body를 연 것(구현), 재사용 불가
		/*AInterface ai = new AInterface() {	
			@Override
			public void aa() {
				System.out.println("AnonymousInner aa 호출됨!");	
			}
		};
		ai.aa();*/
		
		//3. 람다식
		// default나 static은 제외하고 추상 메소드만
		//AInterface ai = () -> {기능};
		
		/*AInterface ai = ()->{
			System.out.println("인수와 리턴 없는 람다식");
		};
		ai.aa();*/
		
		//기능이 한 문장일 때는 {} 생략
		/*AInterface ai = ()->System.out.println("인수와 리턴 없는 람다식");
		ai.aa();*/
		
		//인수가 있는 람다식
		/*BInterface bi = (int a) -> System.out.println("전달 된 a = "+a);
		bi.bb(5);*/
		
		//인수와 리턴값이 있는 람다식
		/*CInterface ci = (a, b) -> a*b;
		int re = ci.cc(4, 5);
		System.out.println("re = "+re);*/
		
		CInterface ci = (a, b) -> {return a*b;}; //두 문장, return 이랑 a*b 따라서 이럴려면 {}를 사용해야 함
		int re = ci.cc(4, 5);
		System.out.println("re = "+re);
		
	}

}
///////////////////////////////////
class Test implements AInterface{
	@Override
	public void aa() {
		System.out.println("Test의 aa 구현 메소드입니다.");
	}
}