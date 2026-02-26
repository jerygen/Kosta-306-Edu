package stream.ex02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {
	static int sum;
	public static void main(String[] args) {
		System.out.println("1.String Array Stream ------------");
		String [] strArr = {"희정","현준","정화","민지","경찬"};
		/*for(String s:strArr) { //자료구조의 Iterator를 이용한 방식
			System.out.println(s);
		}*/
		
		//Stream을 이용해서  출력해보자
		//1) 람다식
		System.out.println("----1. 람다식---------");
		Stream<String> stream = Arrays.stream(strArr);
		stream.forEach( (s)->System.out.println(s) );
		
		//2) 메소드 참조
		System.out.println("----2. 메소드 참조--------");
		Arrays.stream(strArr).forEach(System.out::println);//앞에서 사용한 stream은 못 쓴다. 새로 만들어서 사용, 그래서 stream 자체를 변수에 잘 안 담는다.
		
		//3) 한번 사용한 Stream을 다시 사용해보자(사용불가x)
		
		
		System.out.println("2.int Array Stream ------------");
		int [] intArr = {1,2,3,4,5,6,7,8,9};
		Arrays.stream(intArr)
			.filter(i->i%2==0)
			.forEach(System.out::println);
		
		
		System.out.println("3.range()  vs rangeClosed() ------------");
		IntStream.range(0,10).forEach(System.out::println);
		
		
		System.out.println("------------");
		IntStream.rangeClosed(0,10).forEach(System.out::println);
		
		//int sum;//--> (final int sum) //메소드 안에 클래스가 있고 메소드가 있는 것 그래서 sum을 여기서 선언하지 못하고 메소드 외부에서 선언
		//지역 변수를 익명 객체에서 사용하려면 final 필드여야 한다. 변하지 않는 값만 사용할 수 있는데, 
		//따라서 여기서 sum을 선언하면 자동으로 final 필드가 된다. 근데 여기서 sum을 축적하면서 수정하려고 했기 때문에 오류 발생 
		//결론: main 메소드 외부에서 선언해서 가져와야 함.
		
		IntStream.range(0,10)
		.forEach(a->sum+=a);
		System.out.println("총합: "+sum);
		
		int re = IntStream.range(0, 10).sum();
		System.out.println("re = "+re);
	}

}






