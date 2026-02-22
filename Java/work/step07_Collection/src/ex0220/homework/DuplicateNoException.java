package ex0220.homework;

/**
 * 모델번호가 중복되었을때 발생한 예외..
 * */
public class DuplicateNoException extends Exception{

	public DuplicateNoException() {}
	public DuplicateNoException(String message) {
		super(message);
	}
}
