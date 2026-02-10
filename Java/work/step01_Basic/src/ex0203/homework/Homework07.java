package ex0203.homework;

public class Homework07 {

	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			int s1 = (int)(Math.random()*6 + 1);
			int s2 = (int)(Math.random()*6 + 1);
			
			int sum = s1+s2;
			
			if(sum != 5) continue; // break문을 통해서 while 문을 빠져 나올 수 있음
			else {
				run = false;
				System.out.println(s1);
				System.out.println(s2);
			}
		}
	}

}
