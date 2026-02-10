package ex0205.overloading;

import java.util.Calendar;
import java.util.GregorianCalendar;

class  PrintfExam{
	public static void main(String[] args) {
		System.out.printf("%d%d%n",20,30); //"출력할 포맷"은 빠질 수 없음 반드시 넣어야 함.
		System.out.printf("%d , %d%n",20,30); //%n은 줄바꿈, 공백도 인식
		System.out.println();
		
		System.out.printf("가격 : %,d원%n",25320000);
		System.out.printf("%5.2f%n",35.33333);
		System.out.println();
		
		System.out.printf("%d년  %d월 %d일%n",2009,5,3);
		//$는 파라미터의 순서를 지정
		System.out.printf("%2$d년 %3$d월 %1$d일%n",1, 2005, 3);

		//현재 시스템의 날짜와 시간 가져오기: Calendar.getInstance();
		Calendar now= Calendar.getInstance();
		System.out.println("\nYear=>"+now.get(Calendar.YEAR));
		System.out.println("month=>"+ (now.get(Calendar.MONTH)+1) );
		System.out.println("date=>"+now.get(Calendar.DATE) +"\n");
		
		//System.out.println(now);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 : %1$tM분 : %1$tS초%n" , now); 
		// 1$가 없으면 now가 그 갯수만큼 존재해야 함. 근데 간단하게 하려고 첫 번재 now에서 년,월,일,시,분,초를 가져오는 것
		System.out.println();
		
		System.out.printf("%3d %-10s %-8s %-5d%n",1,"jang","장희정",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",22,"hee","정효욱",03);
		System.out.printf("%3d %-10s %-8s %-5d%n",3,"rew97","장정희",20);
		System.out.printf("%3d %-10s %-8s %-5d%n",4,"jang","장희정",20);
		// 양수는 오른쪽 정렬, 음수는 왼쪽 정렬
	}
}
