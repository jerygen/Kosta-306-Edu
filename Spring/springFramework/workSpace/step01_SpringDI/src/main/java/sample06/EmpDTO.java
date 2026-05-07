package sample06;

import org.springframework.beans.factory.annotation.Value;

public class EmpDTO {
	@Value("50") // set or 생성자 필요없다. xml과 자바소스가 간결해짐
	private int empno;

	@Value("희정")
	private String ename;
	
	@Value("${job}") //외부의 환경변수 or properties 파일에 있는 key
	private String job;
	
//	public EmpDTO() {
//		System.out.println("EmpDTO 기본 생성자 호출!");
//	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getEmpno() {
		return this.empno;
	}

//	@Override
//	public String toString() {
//		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + "]";
//	}
	
}
