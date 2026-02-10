package ex0205.array;
//1차원 배열
class ArrayValue{
	//정수형 10개 저장하는 배열선언(선언과 동시에 임의값 지정)
	int arr [] = new int [] {1,2,3,4,5,6,7,8,9,10};
	//int arr [] = {1,2,3,4,5,6,7,8,9,10}; 축약 가능
//	int [] arr2; // 이때는 아직 배열이 만들어져서 할당되어 있지 않기 때문에 출력 값은 sy...(arr2) -> null
//	int [] arr3 = new int [10]; // 이제는 배열이 만들어져서 할당 된 상태이므로  sy...(arr3) -> 주소값이 출력됨
	
   /*printArrayvalue 메소드작성
       => 메소드 안에서 위에 선언된 배열방의 값을 출력한다.
	*/
	public void printArrayvalue() {
		int j = arr.length;
		for(int i=0;i<j;i++) {
			System.out.printf("%4d",arr[i]);					
		}
		arr[5] = 100;
		
		System.out.println("-----향상된 for문-----");
		for(int i:arr) {
			System.out.println(i);
		}
	}
}

/////////////////////////////////////////////////
class ArrayValueExam{
	public static void main(String args []){
        // ArrayValue에 있는 printArrayvalue메소드 호출
		ArrayValue a = new ArrayValue();
		a.printArrayvalue();
		
		//new ArrayValue().printArrayvalue();//딱 한 번만 사용 가능
		
		
	}
}