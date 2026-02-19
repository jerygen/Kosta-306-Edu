package ex0219.lamda;

@FunctionalInterface //메소드가 단 한개
public interface AInterface {
	//추상 메소드는 무조건 한 개만 가능
	void aa();
	default void bb() {}; //재정의 안 해도 되는 메소드는 더 있어도 가능
	
}
