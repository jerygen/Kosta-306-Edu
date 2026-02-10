package ex0203.homework;

public class Homework01 {

	public static void main(String[] args) {
		String name = "미연"; // 그냥 선언만 하라고 했음. 틀린 건 아님, 지금은 선언과 동시에 값을 초기화
		int kor, eng, mat, total;
		double avg;
		char grade;
		
		kor = (int)(Math.random()*56 + 45);
		eng = (int)(Math.random()*56 + 45);
		mat = (int)(Math.random()*56 + 45);
		
		total = kor + eng + mat;
		avg = total/3.0; // promotion을 사용해도 됨
		
		//삼항연산자 -> 조건식 ? 참일경우 : 거짓일경우;
//		grade = avg >= 90 ? 'A' : 'F';
		
		// if문
//		if(avg >= 90) grade = 'A';
//		else if(avg >= 80) grade = 'B'; 
		// if문의 특징은 위에서부터 내려오므로 이미 첫 번째 줄 조건을 만족하지 않아서 내려오는 것이므로 불필요하게 <90을 넣을 필요 없음
//		else if(avg >= 70) grade = 'C';
//		else if(avg >= 60) grade = 'D';
//		else score = 'E';
		
		
		//switch문	
		switch((int)avg) {
		case 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 -> grade = 'A';
		case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 -> grade = 'B';
		case 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 -> grade = 'C';
		case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 -> grade = 'D';
		default -> grade = 'F';
		}
		
		// 선생님 풀이
		// 스위치 인자는 실수형으로 못 씀
		// 스위치는 범위를 못 나타냄 
		// 등급을 알려면 십의 자리 숫자만 알면 됨.
//		grade = switch((int)avg/10) {
//		case 9,10 -> 'A';
//		case 8 -> 'B';
//		case 7 -> 'C';
//		case 6 -> 'D';
//		default -> 'F';
//		};
		
		System.out.println(name+"님 성적표");
		System.out.println("국어: "+kor+"점");
		System.out.println("영어: "+eng+"점");
		System.out.println("수학: "+mat+"점");
		System.out.println("총점: "+total+"점");
		System.out.println("평균: "+avg+"점"); 
		// (int)(avg*100)*0.01 -> 소수점 두 번째 자리까지 출력
		System.out.println("등급: "+grade);
	}

}
