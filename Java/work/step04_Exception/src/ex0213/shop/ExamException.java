package ex0213.shop;
//체크 예외라면 반드시 예외처리 해야 함. 
//비체크 예외라면 예외처리 선택
public class ExamException extends Exception {
	static int count;//static을 붙여야 누적된 count를 가져올 수 있음!!!!
	public ExamException() {
		
	}
	public ExamException(String message) {
		super(message);
		count++;
	}
}