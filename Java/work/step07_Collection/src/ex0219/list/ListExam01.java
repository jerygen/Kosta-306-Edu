package ex0219.list;

import java.util.ArrayList;
import java.util.Collections;
//상속으로 접근
public class ListExam01 extends ArrayList<Integer>{
	public ListExam01() {
		super(5);//int형 인수를 받는 부모생성자
		
		//추가
		super.add(10);
		this.add(5);
		add(20);
		super.add(10);
		super.add(7);
		this.add(5);
		
		//list에 저장된 객체 수 출력
		System.out.println("저장된 개수 = "+super.size());
		
		//저장된 정보를 출력하기
		for(int i=0;i<size();i++) {
			int no = super.get(i);
			System.out.println("no = "+no);
		}
		System.out.println("--------개선 된 for문-----------");
		for(int no:this) {//this는 독립적으로 사용 가능, 현재 내가 곧 리스트니깐 this 사용, super는 독립적으로 사용 불가
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
		System.out.println("정렬 전: "+this);//this.toString()
		
		//Collections.sort(this);//기본 올림차순 정렬
		
		//내림차순 정렬
		Collections.sort(this, Collections.reverseOrder());
		System.out.println("정렬 후: "+this);//this.toString()
		
		
	}
	
	public static void main(String[] args) {
		new ListExam01();
	}
}
