package sample06;

public class EmpService {
	
	public EmpService() {
		System.out.println("EmpService 기본 생성자!");
	}
	
	public void test(EmpDTO empDTO) {
		System.out.println("EmpService의 test 호출");
		System.out.println("empDTO="+empDTO);
	}
}
