package ex0205.array;

public class ArgsExam {
	
	public static void main(String[] args) {
		System.out.println("--시작하기---");
		System.out.println("args = "+args);
		System.out.println("args.length = "+args.length);
		
//		int len = args.length;
//		for(int i=0;i<len;i++) {
//			System.out.println("args["+i+"] = "+args[i]);
//		}
		
		// 만약 두 개의 숫자값이 전달되었다고 가정하고 합을 출력해라.
		System.out.println(args[0]+args[1]);
		int no1 = Integer.parseInt(args[0]);
		int no2 = Integer.parseInt(args[1]);
		System.out.println(no1+no2);
	}

}

/*
 * 실행
 * java ArgsExam 값 값 값 값 ....
 * **/
