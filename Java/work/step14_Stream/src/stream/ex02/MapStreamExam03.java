package stream.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapStreamExam03 {
	public static void main(String[] args) {
		List<Student> list  = Arrays.asList(
		   new Student("희정", 22, 80, "컴퓨터"),
		   new Student("나영", 25, 60, "과학"),
		   new Student("미영", 21, 82, "컴퓨터"),
		   new Student("삼순", 30, 95, "국어"),
		   new Student("삼식", 22, 70, "수학"),
		   new Student("효경", 28, 80, "국어")
		);
		
		//1. 전체 출력
		System.out.println("1. 전체 출력------------");
		list.stream().forEach(System.out::println);
		
		
		//2.점수만 걸러내서 출력
		System.out.println("2.점수만 걸러내서 출력 ------");
		list.stream()
		.map(Student::getScore)//map((s)->s.getScore)
		.forEach(System.out::println);		
		
		List<Integer> listInt = list.stream()
		.map(Student::getScore)//map((s)->s.getScore)
		.toList();
		
		//3. 점수의 총점
		System.out.println("3.점수의 총점--------");
		int sum = list.stream()
				.mapToInt(Student::getScore) 
				.sum();//sum을 하려면 중간과정에서 리턴타입 자체가 int가 되는 메소드를 사용해야 한다.
		System.out.println("총점: "+ sum);
		
		//4. 점수의 평균
		System.out.println("4.점수의 평균--------");
		double avg = list.stream()
			.mapToInt(Student::getScore) 
			.average()
			.orElse(0.0);//Optional 클래스 사용, OptionalDouble //orElse, isPresent, ifPresent
		
		System.out.println("평균: "+avg);
		
		list.stream()
		.mapToInt(Student::getScore) 
		.average()
		.ifPresent(System.out::println);
		
		//5. 점수의 개수(인원수)
		System.out.println("5. 점수의 개수(인원수)--------");
		long count = list.stream().mapToInt(Student::getScore).count();
		System.out.println("개수: "+count);
		
		//점수가 80 이상인 학생들의 이름만 검색
		System.out.println("점수가 80 이상인 학생들의 이름만 검색--------");
		list.stream()
			.filter(s->s.getScore()>=80)
			.map(Student::getName)
			.forEach(System.out::println);
		

	}

}










