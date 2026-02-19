package ex0219.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
//생성으로 접근
public class ListExam02 {
	List<Integer> list = new ArrayList<>(5);
	//ArrayList<Integer> list = new ArrayList<Integer>();//생성은 구현 객체로 하지만, 접근할 때는 반드시 인터페이스로 접근해야 한다. 
	
	//List<Integer> list = new Vector<>();
	//List<Integer> list = new LinkedList<Integer>();
	//주로 사용하는 기능들은 모두 같다. add, size, get 등등
	
 	public ListExam02() {		
		//추가
		list.add(10);
		list.add(5);
		list.add(20);
		list.add(10);
		list.add(7);
		list.add(5);
		
		//list에 저장된 객체 수 출력
		System.out.println("저장된 개수 = "+list.size());
		
		//저장된 정보를 출력하기
		for(int i=0;i<list.size();i++) {
			int no = list.get(i);
			System.out.println("no = "+no);
		}
		System.out.println("--------개선 된 for문-----------");
		for(int no:list) {//this는 독립적으로 사용 가능, 현재 내가 곧 리스트니깐 this 사용, super는 독립적으로 사용 불가
			System.out.println("no = "+no);
		}
		
		/////////////////////////////////
		//제거
		/*int i = this.remove(2);//3번째 제거
		System.out.println("제거 후 = "+i);//제거 된 객체 값*/
		
		/*boolean b = this.remove((Object)20);
		System.out.println("b = "+b);
		
		System.out.println("--------제거 후 for문-----------");
		for(int no:this) {//this는 독립적으로 사용 가능, 현재 내가 곧 리스트니깐 this 사용, super는 독립적으로 사용 불가
			System.out.println("no = "+no);
		}*/
		
		System.out.println("------정렬 하기--------");
		System.out.println("정렬 전: "+list);//this.toString()
		
		//Collections.sort(this);//기본 올림차순 정렬
		
		//내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("정렬 후: "+list);//this.toString()
		
		
	}
	
	public static void main(String[] args) {
		new ListExam02();
	}
}
