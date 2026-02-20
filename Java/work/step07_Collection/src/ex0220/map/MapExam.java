package ex0220.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {
	//Map<Integer, String> map = new HashMap<>();
	Map<Integer, String> map = new TreeMap<>();
	
	public MapExam() {
		//Map 추가
		map.put(20, "희정");
		map.put(10, "나영");
		map.put(40, "미미");
		map.put(20, "효리");
		map.put(10, "삼순");
		
		System.out.println("저장된 개수 = "+map.size());
		System.out.println("map = "+map.toString());//map.toString()
		
		//map에 들어있는 key와 value를 꺼내기(key와 value의 한 쌍 = Entry)
		
		//모든 key의 정보를 가져오는 작업 필요
		Set<Integer> keySet = map.keySet();//모둔 key값들을 set에 저장
		Iterator<Integer> it = keySet.iterator();//set안에 있는 요소들을 하나하나 꺼내올 준비
		
		while(it.hasNext()) {//요소가 있다면(꺼낼게 있다면)
			int key = it.next();//요소를 꺼낸다.
			String value = map.get(key);//꺼낸 키에 해당하는 value를 조회
			System.out.println(key+"와 "+value);
		}
		
		System.out.println("----개선된 for 문 사용--------");
		for(Integer key:map.keySet()) {
			String value = map.get(key);//꺼낸 키에 해당하는 value를 조회
			System.out.println(key+"와 "+value);
		}
		
		System.out.println("----Entry 형태로 조회하기-------");
		Set<Entry<Integer, String>> set = map.entrySet();
		for(Entry<Integer, String> e :set) {
			System.out.println(e.getKey()+" = "+e.getValue());
		}
		
		//삭제
		map.remove(20);
		System.out.println("삭제 후 = "+map);
		
	}
	
	public static void main(String[] args) {
		new MapExam();
		
	}

}
