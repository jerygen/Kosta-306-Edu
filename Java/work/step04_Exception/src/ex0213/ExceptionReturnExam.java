package ex0213;

public class ExceptionReturnExam {
     public void aa(int i) throws Exception {
    	 System.out.println("----aa------");
    	 try {
	    	 if(i==0) {
	    		 //return ;//void는 리턴을 못하는 게 아니라 리턴에 해당하는 값을 못쓴다는 뜻. 이 경우는 프로그램을 빠져나가고 싶을 때 사용
	    		 //throw new RuntimeException("에외 발생"); //unchecked 예외 종류
	    		 //throw new Exception("예외발생"); //checked 예외
	    		 System.exit(0);//프로그램 종료, finally 실행하지 않음
	    	 }
	    	 System.out.println(i+"입니다.");
    	 }finally {
    	   System.out.println("----aa end------");//예외가 발생하더라도 실행한다.
    	 }
     }
	public static void main(String[] args) throws Exception{
		System.out.println("**메인 시작 **");
		
		//new ExceptionReturnExam().aa(5);
		new ExceptionReturnExam().aa(0);
		
		System.out.println("***메인 끝 ***");

	}

}
