package ex0223.io;

class Test implements AutoCloseable{
	
	@Override
	public void close() {
		System.out.println("Test의 close 호출 됨!");
	}
}

public class AutoClosableExam {
	
	public static void main(String[] args) {
		System.out.println("---------시작합니다.-----------");
		try(Test t = new Test()) {//try() 안에 넣어야 시행됨. try resources with, 그래야 try를 빠져나갈 때 종료가 됨.
			//Test t = new Test() -> 이때는 시행 안 됨.
			System.out.println("오늘은 월요일!!");
			//try를 빠져나가는 순간 자동으로 close를 호출해서 시행한다.
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("---------끝-----------");

	}

}
