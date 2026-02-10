package ex0205.array;

class MultiArray{
//정수형 2차원 배열 8*9
	int arr [][] = new int [8][9];
	
//메소드이름 :array99
//8행 9열 배열 방에 구구단의 결과값	
	//for loop 를 사용하여 
	//배열에 곱한 (구구단)결과저장
	//배열에 결과를 꺼내출력
	public void array99() {
		int a = arr.length;
		for(int row=0;row<a;row++) {
			int b = arr[row].length;
			for(int col=0;col<b;col++) {
				arr[row][col] = (row+2)*(col+1); 
				System.out.printf("%3d",arr[row][col]);
			}
			System.out.println();
		}
		for(int [] row:arr) { // 행에 해당하는 배열을 가져오는 것
			for(int col:row) { // 행에서 열의 값들을 가져오는 것
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
			
}

public class MemoryApart{
//main메소드에서 
//MultiArray객체의 array99메소드호출
	public static void main(String [] args) {
		MultiArray a = new MultiArray();
		a.array99();
	}
}


