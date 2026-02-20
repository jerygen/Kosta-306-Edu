package ex0220.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
//	Set<String> set = new HashSet<String>();
//	Set<String> set = new TreeSet<String>(); //정렬(오름차순)
	Set<String> set = new TreeSet<String>(Collections.reverseOrder()); //정렬(내림차순)
	
	public SetExam(String [] args) {
		//추가
		for(String s : args) {
			boolean re = set.add(s); //중복이 안 됨
			System.out.println(s+" 추가 결과 = "+re);
		}
		
		System.out.println("저장된 개수 = "+set.size());
		
		//저장된 정보를 조회(출력)
		System.out.println("----정보 출력-----");
		Iterator<String> it = set.iterator(); //Iterator 안에 들어있는 요소를 꺼내는 객체
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}//똑같은 객체가 만들어지면 꺼내는 순서가 같음. 
		
		System.out.println("\n--요소 제거----");
		boolean re = set.remove("상혁");
		System.out.println("제거 결과 = "+re);
		
		System.out.println("제거 후: "+set);//set.toString()
		
		System.out.println("\n--존재 여부----");
		re = set.contains("진주");
		System.out.println("결과 = "+re);
	}
	
	public static void main(String[] args) {
		new SetExam(args);

	}

}
