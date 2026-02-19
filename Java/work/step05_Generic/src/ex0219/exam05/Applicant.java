package ex0219.exam05;
/**
 * 신청 - 누가 신청을 하느냐?
 * */
public class Applicant<T> {
	private T kind; //사람, 직장인, 학생, 고등, 중등

	public Applicant(T kind) {//생성자, 기본 생성자 없이 -> 생성할 때 타입을 정해줘라
		this.kind = kind;
	}
	
	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
	
}
