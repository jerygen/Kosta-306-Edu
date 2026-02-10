package ex0203.homework;

public class Homework08 {

	public static void main(String[] args) {
//		int x;
//		int y; 
//		for문 안에서만 변수를 사용하기 때문에 굳이 밖에서 선언할 필요없이 for문 내에서 선언과 함께 초기값을 지정하면 됨.
		
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				int sum = 4*x + 5*y;
				if(sum == 60) System.out.println("("+x+","+y+")");
			}
		}
		
	}

}
