package ex0211.final_field;

public class FinalFieldExam {
	int i; //인스턴스 필드
	
	//final field는 명시적 초기화 필수(자동 초기화 안 됨)
	//객체를 생성하는 사용자가 객체를 생성할 때 값을 초기화 할 수 있다.
	//생성자를 통해서 값을 지정하는 게 가능
	final int j; //인스턴스 필드
	public FinalFieldExam() {
		j=10;
	}
	public FinalFieldExam(int j) {
		this.j=j;
	}
	
	//어떻게 객체를 생성하든 즉 누가 사용하던 항상 동일한 값
	static final int k; //static 필드, 생성자에서 초기화 불가
	
	static {
		k=10;
	}
	
	public static void main(String[] args) {
		//static 필드 접근
		System.out.println(FinalFieldExam.k);
		
		FinalFieldExam fe = new FinalFieldExam(200);
		System.out.println(fe.i);
		System.out.println(fe.j);
		System.out.println(fe.k);
		
		//final은 고정값으로 변경 불가
		fe.i = 20;
		//fe.j = 100;//The final field FinalFieldExam.j cannot be assigned
		//fe.k = 60;//The final field FinalFieldExam.k cannot be assigned
		
		
	}

}
