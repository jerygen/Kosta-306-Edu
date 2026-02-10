package ex0206.array.strudent;

/**
 * 사용자 요청의 결과를 모니터에 출력하는 클래스
 * 성공/실패(DML, 메세지로 출력): 등록, 수정, 삭제 
 * 조회: 전체 검색, 부분 검색
 * */
public class StudentEndView {
	/**
	 * 전체 검색 결과 출력
	 * 끝단 더이상 요청해서 보내는 게 아니니 리턴 타입 없음
	 * */
	public static void printSelectAll(Student [] stArr) {
		System.out.println("------학생의 정보 ("+StudentService.count+")명------");
		for(int i=0;i<StudentService.count;i++) {
			System.out.printf("이름: %s|",stArr[i].getName()); //주소값 stArr[i]
			System.out.printf("나이: %d|",stArr[i].getAge());
			System.out.printf("주소: %s%n",stArr[i].getAddr());
		}
	}
	
	/**
	 * 이름에 해당하는 학생 정보 출력
	 * */
	public static void printSelectByName(Student student) {
		System.out.printf("이름: %s|",student.getName());
		System.out.printf("나이: %d|",student.getAge());
		System.out.printf("주소: %s%n",student.getAddr());
	}
	
	
	/**
	 * 요청 결과의 성공여부 메세지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
}
