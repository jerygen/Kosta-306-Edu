package ex0220.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	
	public MemberSetExam() {
		//회원 추가 
		set.add(new Member("희정1",10, "서울"));
		set.add(new Member("희정2",20, "대구"));
		//객체는 주소값을 비교하므로 주소만 다르면 다른 객체로 본다. 근데 우리가 봤을 때는 같은 객체임.
		set.add(new Member("희정1",20, "서울"));
		
		System.out.println("저장된 개수 = "+set.size());
		
	}
	public static void main(String[] args) {
		new MemberSetExam();
		
	}
}
