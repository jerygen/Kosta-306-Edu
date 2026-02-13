package ex0213;

class Test{
	public void aa(int i) throws ArithmeticException{
		try {
		System.out.println("aa시작...");
		//{
			this.bb(i);
		//}catch(ArithmeticException e) {
		//	System.out.println("0으로 나누면 안돼요 = "+e.getMessage());
		//}
		}finally {
		System.out.println("aa 끝 ...");
		}
	}
	public void bb(int i) throws ArithmeticException {
		try{
			System.out.println("bb 시작...");
			int result = 100/i;//ArithmeticException 가능성이 있는 코드, ArithmeticException: / by zero
			System.out.println("result="+result);
		}finally {
			System.out.println("bb 끝...");
		}
	}
}


public class ThrowsExam {

	public static void main(String[] args) {
		System.out.println("---메인 시작---");
		
		try{
			new Test().aa(0);
		}catch(ArithmeticException e){
			System.out.println("예외 발생"+e.getMessage());
		}
		
		System.out.println("---메인 끝 ----");
		
	}

}
