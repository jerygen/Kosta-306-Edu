package ex0213.shop;

import java.util.Random;

public class Shopping {

	public static void main(String[] args) {
		ShoppingMall sm  = new ShoppingMall();
		
		//난수 발생 전용 클래스
		Random r = new Random();
		int age = r.nextInt(55);// 0부터 54까지 int age = r.nextInt(55)+1;
		
		for(int i=0;i<10;i++) {
			try {
				int nansu = (int)(Math.random()*55)+1;//Math.random()메소드가 10번 발생해야 함.
				sm.ageLimit(nansu);
			} catch (ExamException e) {
				System.out.println(e.getMessage());//super(message)한 값을 가져오는 것
			}	
		}
		
		System.out.println("예외 발생 횟수: "+ExamException.count);
	}

}
