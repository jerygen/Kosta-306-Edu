package ex0206.array.strudent;

public class StudentTest {
	public static void main(String[] args) {
		System.out.println("***학생 관리 프로그램 시작합니다.******");
		
		String [][] data = new String [][] {
			{"희정","20","서울"},
			{"미미","26","경기도"},
			{"나영","30","대구"},
			{"효리","24","부산"},
			{"재석","29","강원도"}
		};
		
		StudentService service = new StudentService();//StudentService의 전역변수들이 초기화 
		service.init(data); // 초기치데이터 세팅
		
		//전체학생정보 출력
		Student[] stArr=service.selectAll();
		StudentEndView.printSelectAll(stArr);
		
		//등록하기
		System.out.println("--1. 등록하기 -----");
		Student student = new Student();
		student.setName("백조");
		student.setAge(25);
		student.setAddr("오리역");
		
		
		int result = service.insert(student); //Student 객체를 하나 생성해서 전달해야 함. 
		if(result==0) StudentEndView.printMessage(student.getName()+" 중복입니다. 등록 실패");
		else if(result==-1)
			StudentEndView.printMessage("인원이 초과하여 등록할 수 없습니다");
		else
			StudentEndView.printMessage("등록이 되었습니다.");
		
		System.out.println("--2. 전체검색 -----");
		StudentEndView.printSelectAll(service.selectAll());
		
		//이름으로 검색하기
		System.out.println("--3. 이름으로 검색 -----");
		Student st1 = service.selectByName("희정");
		if(st1!=null) StudentEndView.printSelectByName(st1);
		else StudentEndView.printMessage("해당 학생의 정보가 없습니다.");
		
		System.out.println("--이름이 없는경우----");
		Student st2 = service.selectByName("삼순이");
		if(st2!=null) StudentEndView.printSelectByName(st2);
		else StudentEndView.printMessage("해당 학생의 정보가 없습니다.");
		
		//수정하기 
		System.out.println("--4. 수정하기 -----");
		Student st3 =new Student();
		st3.setName("나영");//조건
		st3.setAge(23);
		st3.setAddr("대전");
		
		if(service.update(st3)) {
			StudentEndView.printMessage(st3.getName()+"의 정보를 수정했습니다");
		}
		else {
			StudentEndView.printMessage("수정되지 않았습니다.");
		}
		
		System.out.println("---변경후 ---");
		StudentEndView.printSelectAll(service.selectAll());
	}

}








