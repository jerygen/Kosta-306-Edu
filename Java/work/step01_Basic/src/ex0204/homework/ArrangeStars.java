package ex0204.homework;

public class ArrangeStars {

	public static void main(String[] args) {
		
		for(int i=1; i<=5 ; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("★");
				if(i<=j) break;
			}
			System.out.println();
		}
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
		for(int i=5; i>0 ; i--) {
			for(int j=1; j<=5; j++) {
				System.out.print("★");
				if(i==j) break;
			}
			System.out.println();
		}
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
		for(int i=5; i>0 ; i--) {
			for(int j=1; j<=5; j++) {
				if(i<=j) System.out.print("★");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
//		for(int i=1; i<=5 ; i++) {
//			for(int j=i; j<5; j++) {
//				System.out.print(" ");
//			}
//			for(int k=1; k<=i; k++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
//		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		
		for(int i=5; i>0 ; i--) {
			for(int j=5; j>0; j--) {
				if(i<j) System.out.print(" ");
				else System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
	}

}
