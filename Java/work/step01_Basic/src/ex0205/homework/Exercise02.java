package ex0205.homework;
/**
 * 주제: 배열 항목에서 최댓값 출력
 * 작성일: 26.02.05
 * 작성자: 김미연
 * */
public class Exercise02 {
	public static void main(String[] args) {
		int array [] = {1,5,3,8,2};
		int len = array.length;
		int max=array[0]; // Integer.min_value 
		
		for(int i=1;i<len;i++) { // 이미 0번째 값을 꺼내왔기 때문에 1부터 시작해도 좋을 듯, 필요없는 과정은 줄이는 게 좋음
			if(max < array[i]) max = array[i]; 
		}
		System.out.println(max);
	}
}
