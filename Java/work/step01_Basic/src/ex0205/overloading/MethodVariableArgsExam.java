package ex0205.overloading;

class Test{
	public void aa(int ... i ) {//매개값을 0개 이상 허용, 배열처럼 사용, 타입은 중요!!!!! 
		//모든 타입을 포용하는 조상 Object는 가능
		System.out.println("aa 호출...");
		System.out.println("i = "+i);
		
		for(int a:i) {
			System.out.println(a+" ");
		}
		System.out.println("------------------------------");
	}
	
	//The variable argument type int of the method bb must be the last parameter
	public void bb(int i, String ... name) {// 두 개 이상은 불가, 어디까지가 그 타입으로 하는 건 지 모르기 때문
		// 또한 앞에 변수에서는 안 되고, 마지막에서만 사용가능, 한 번만 사용가능
		
	}
}

public class MethodVariableArgsExam {

	public static void main(String[] args) {
		// 메소드 호출
		Test t = new Test();
		t.aa(7);
		t.aa(3,4,6);
		t.aa();
		t.aa(2,4,6,7,9,8);
		/////////////////////////
		t.bb(4, "aaa", "ㅍ", "ㅇ");
				
		
	}

}
