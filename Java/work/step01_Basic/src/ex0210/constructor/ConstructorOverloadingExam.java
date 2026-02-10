package ex0210.constructor;
class Puppy3{
	/*String 타입 전역 변수 선언
	  int 타입 전역 변수 선언*/
	String name;
	int i;
	
	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"public Puppy3()호출되었습니다"출력
		전역변수 출력
	*/	
	public Puppy3() {
		name = "메리";
		System.out.println("public Puppy3() 호출되었습니다");
		System.out.println("name: "+name+" | "+"i:"+i);
	}
	
	/*String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"public Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
	public Puppy3(String st) {
		name = st;
		System.out.println("public Puppy3(String) 호출되었습니다");
		System.out.println("name: "+name+" | "+"i:"+i);
	}
	
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"public Puppy3()호출되었습니다"출력
	*/		
	public Puppy3(String st, String st2) {
		this(st+st2);
		System.out.println("public Puppy3(String, String) 호출되었습니다");
	}
	
	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"public Puppy3()호출되었습니다"  출력
	*/					
	public Puppy3(boolean bo) {
		this("쫑"+Boolean.toString(bo));
		System.out.println("public Puppy3(boolean) 호출되었습니다");
	}
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"public Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/			
	public Puppy3(char ch) {
		this();
		i = ch; //(int)를 할 필요 없음
		System.out.println("public Puppy3(char) 호출되었습니다");
		System.out.println("i: "+i);
	}
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/	
	public void printMemberVariable() {
		System.out.println("name: "+name);
		System.out.println("i: "+i);
	}

}

public class ConstructorOverloadingExam{
		//메인메소드에서
	public static void main(String [] args){
		//Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
		Puppy3 pup1 = new Puppy3();
		System.out.println();
		Puppy3 pup2 = new Puppy3("바보");
		System.out.println();
		Puppy3 pup3 = new Puppy3("크리","스마스");
		System.out.println();
		Puppy3 pup4 = new Puppy3(true);
		System.out.println();
		Puppy3 pup5 = new Puppy3('A');
		
		System.out.println("------주소값 출력--------");
		
		System.out.println("pup1="+pup1);
		System.out.println("pup2="+pup2);
		System.out.println("pup3="+pup3);
		System.out.println("pup4="+pup4);
		System.out.println("pup5="+pup5);
		
		System.out.println("-------결과 출력--------");
			
		//각 객체의 printMemberVariable메소드를 한번씩 호출		
		pup1.printMemberVariable();
		pup2.printMemberVariable();
		pup3.printMemberVariable();
		pup4.printMemberVariable();
		pup5.printMemberVariable();
			
	}
}