package ex0206.array.strudent;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	
	//학생의 정보를 저장할 배열 선언
	Student stArr [] = new Student [10];//우선 최대 10명으로 설정
	public static int count; //배열에 저장된 객체를 체크하는 필드, 실제 얻은 객체 수
	//서비스는 싱글톤이기 때문에 static을 해도 괜찮다.
	
	/**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	public void init(String [][] data) {
		for(int i=0;i<data.length;i++) {
			stArr[count++] = this.create(data[i]); //data 이차원 배열의 1차원 값(행) 전달
		}
		System.out.println("-----초기화 완료------");
//		for(int i=0;i < count;i++) {
//			System.out.println(stArr[i]);
//		}
	}
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */
	 private Student create(String [] row) { 
		//한 행의 값을 가지고 와서 각 열의 값들을 제 위치에 전달
		Student st = new Student();
		st.setName(row[0]);
		st.setAge(Integer.parseInt(row[1]));
		st.setAddr(row[2]);
		return st;
	 }
	//내부에서만 사용하므로 private 붙임
	

	 /**
	   학생의 정보 등록하기 (새로 등록)
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다. 메시지출력.
	      이름이 중복되면 등록 안 됨.
	      추가가 성공하면 "등록되었습니다" 메시지를 출력
	      
	     @return: 1이면 성공, 0이면 중복, -1 이면 배열 경계 벗어남
	  **/
	 public int insert(Student student) {//이미 생성된 객체를 넣는것
		 //메세지 출력은 view에서만 한다. 여기서는 판단만 한다
		 //성공, 중복 실패, 배열 벗어나서 실패 -> 인덱스로 관리
		 
		 //배열크기 체크
		 if(stArr.length == count) {
			 return -1;
		 }
		 //중복체크
		 if(this.selectByName(student.getName()) != null) return 0; 
		 
		 //예외 상황이 아니라면 정상
		 stArr[count++] = student;
		 return 1;
	 }
	 
	
	/**
	 * 전체 학생의 정보 조회하기
	 * @return 전체 배열
	 * */
	 public Student[] selectAll() {
		 return stArr;
	 }
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 "찾는정보가 없습니다." 출력한다.
	 *     
	 *     @return: 찾은 학생의 정보(이름, 나이, 주소) Student리턴
	 *     			없으면 null 리턴
	 * */
	 public Student selectByName(String name) {
		 //중복체크
		 for(int i=0;i<count;i++) {
			 Student searchedSt = stArr[i];
			 if(searchedSt.getName().equals(name)){
				 return searchedSt;
			 }
		 }
		 //못 찾았다.
		 return null;
		 
	 }
	 
	
	
	/**
	 * 이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 false 반환
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고 true 반환
	 *   메세지 출력은 메인 메소드에서 EndView로 전달
	 *   @param : Student
	 *   @return : boolean
	 * */
	 public boolean update(Student student) {
		 //이미 이름에 해당하는 객체를 찾는 메소드를 만들었으므로 이걸 활용하기!!!
		 Student findStudent = this.selectByName(student.getName());
		 if(findStudent!=null) {
			 findStudent.setAddr(student.getAddr());
			 findStudent.setAge(student.getAge());
			 return true;
		 }
		 //내가 작성한 코드
//		 for(int i=0;i<count;i++) {
//			 if(stArr[i].getName().equals(student.getName())) { 
//				 stArr[i].setAge(student.getAge());
//				 stArr[i].setAddr(student.getAddr());
//				 return true;
//			 }
//		 }
		 
		 return true;
	 }
	 
	 
	 

}

