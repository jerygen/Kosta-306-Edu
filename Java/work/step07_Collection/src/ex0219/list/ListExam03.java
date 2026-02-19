package ex0219.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp>{
	//초기치 사원정보 5명 추가
	public ListExam03() {
		//저장
		super.add(new Emp(20, "희정", 28, "서울"));
		this.add(new Emp(10, "나영", 35, "대구"));
		
		add(new Emp(50, "미미", 22, "제주도"));
		add(new Emp(40, "삼순", 26, "서울"));
		add(new Emp(30, "삼식", 30, "대구"));
	}
	
	/**
	 * 저장된 모든 사원 정보 리턴
	 * */
	public List<Emp> selectAll() {//인터페이스로 불러와야 함. 구현객체로 사용 X, 타입을 인터페이스 기반으로 작성(유연함을 갖추게 됨)
		return this;
	}
	/**
	 * 사원번호에 해당하는 사원정보 리턴
	 * */
	public Emp selectByEmpNo(int empNo) {//get으로는 어려움. 리스트 안에는 객체의 주소가 들어 있음. 그래서 주소 안에 가서 그 값에 해당하는 것을 찾아야 함
		for(Emp e:this) {
			if(e.getEmpNo()==empNo) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * 주소를 인수로 전달받아 동일한 주소인 모든 사원정보 리턴
	 * */
	public List<Emp> selectByAddr(String addr){
		List<Emp> findList = new ArrayList<Emp>();
		for(Emp e:this) {
			if(e.getAddr().equals(addr)) {
				findList.add(e);
			}
		}
		return findList;
	}
	
	/**
	 * 사원번호를 기준으로 정렬한 정보 리턴
	 * */
	public List<Emp> sortByEmpNo(){
		//원본을 바로 정렬하지 않음, 들어온 순서도 중요한 정보 중에 하나기 때문
		
		//정렬한 대상을 관리할 List를 선언
		List<Emp> shallowCopy = new ArrayList<>(this);//Collection을 인수로 갖는 생성자가 있음. 주소값들이 들어감
		
		//sort는 반드시 Comparable를 구현한 객체로만 이루어져 있어야 함
		//Collections.sort(shallowCopy); //List안의 모든 값들이 Comparable을 implements하고 있어야 한다. 
		
		Collections.sort(shallowCopy, (e1, e2)->e1.getEmpNo()-e2.getEmpNo());
		
		return shallowCopy;
	}
	
	/**
	 * 나이를 기준으로 정렬한 정보를 리턴 
	 * */
	public List<Emp> sortByAge(){
		List<Emp> shallowCopy = new ArrayList<>(this);
		
		//Collections.sort(shallowCopy, new Test());
		
		//익명 타입
		/*Collections.sort(shallowCopy, new Comparator<Emp>() {
			@Override
			public int compare(Emp o1, Emp o2) {
				return o1.getAge() - o2.getAge();
			}
		});*/
		
		//람다식 변경
		Collections.sort(shallowCopy, (e1, e2)->e1.getAge()-e2.getAge());
				
		return shallowCopy;
	}
	
	
	public static void main(String[] args) {
		ListExam03 e = new ListExam03();
		
		System.out.println("---1. 전체 검색----");
		List<Emp> list = e.selectAll();
		for(Emp emp:list) {
			System.out.println(emp);//emp.toString()
		}
		///////////////////////////
		System.out.println("---2. 사원 번호 검색----");
		Emp emp = e.selectByEmpNo(50);
		System.out.println(emp);
		////////////////////////////////
		System.out.println("---3. 주소로 검색----");
		list = e.selectByAddr("서울");
		if(list.size()==0) {
			System.out.println("주소에 해당하는 사원이 없습니다.");
		}else {
			System.out.println(list);
		}
		///////////////////////////////////////
		System.out.println("---\n4. 사원번호로 정렬----");
		list = e.sortByEmpNo();
		for(Emp em:list) {
			System.out.println(em);
		}
		//원본은 바뀌지 않음
		System.out.println("---1. 전체 검색----");
		list = e.selectAll();
		for(Emp em:list) {
			System.out.println(em);//emp.toString()
		}
		///////////////////////////////
		System.out.println("---\n5. 나이로 정렬----");
		list = e.sortByAge();
		for(Emp em:list) {
			System.out.println(em);
		}
	}

}
/////////////////////////////////////////////////
class Test implements Comparator<Emp>{
	@Override
	public int compare(Emp e1, Emp e2) {
		
		return e2.getAge()-e1.getAge();//음수 or 0 or 양수
	}
}



