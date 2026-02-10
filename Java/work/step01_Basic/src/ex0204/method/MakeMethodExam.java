package ex0204.method;


//MakeMethodExam.java
class MakeMethodExam{
	public static void main(String []args){
		MakeMethodExam mme=new MakeMethodExam(); // mme에 주소가 담김
		System.out.println("mme = "+mme);//class이름@hashcode
		// println이 객체를 만나면 toString 메소드가 호출됨. 어디의 toString이 나오느냐에 따라 달라짐
		System.out.println("mme = "+mme.toString());//class이름@hashcode
		// toString() 생략함
		int k=mme.methodExam01(33);
		System.out.println(k);
		mme.methodExam02();
		mme.methodExam03(42);
		String s = mme.methodExam04(17);
		System.out.println(s);

	}// main 메소드의 위치는 상관없음 보통은 main 메소드를 만드는 클래스 안에는 다른 메소드를 두지 않음
	// 메소드 호출 순서를 잘 알아야 함. 

/*
	Method이름 : methodExam01
	자기자신만 접근가능
	Return Type : 정수
	Parameter : 정수1개
	(구현부에서)하는일 : 
	인수로 받은(들어온)정수를 출력하고 인수에 2를 곱해 Return
*/
	// 제한자 리턴타입 메소드이름(매개변수, 매개변수, ...) {}
	private int methodExam01(int i) {
		//기능
		System.out.println("인수는 "+i);
		return i*2;
	}
/*
	Method이름 : methodExam02
	어디에서나 아무나 접근가능
	Return 안함	
	Parameter 없음
	(구현부에서)하는일 : 아무거나 출력
*/
	public void methodExam02() {
		System.out.println("메소드 2");
	}	
	
/*
	Method이름 : methodExam03
	같은pakage내에서 아무나 접근가능
	Return Type : Return 안함
	Parameter : 정수1개	
	(구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고
		그수가 짝수라면 "짝수",홀수라면"홀수" 출력
*/	
	void methodExam03(int i) {
		System.out.println("정수: "+i);
		
		if(i%2==0) System.out.println(i+"은/는 짝수");
		else System.out.println(i+"은/는 홀수");
	}
/*
	Method이름 : methodExam04
	상속관계라면 어디서나 접근가능
	Return Type : String타입
	Parameter : 정수1개	
	(구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고
		그수가 짝수라면 "짝수",홀수라면"홀수" 리턴
*/
	protected String methodExam04(int i) {
		System.out.println("정수: "+i);
		if(i%2==0) return "짝수";
		else return "홀수";
	}
	
}//classEnd

