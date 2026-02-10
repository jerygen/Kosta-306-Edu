package ex0203.제어문;

public class SwitchExample01 {
	public static void main(String[] args) {
		//1~12 사이의 난수를 발생한다
		double nansu = (int)(Math.random()*12 + 1);
		System.out.println("난수 = "+nansu);
		
		int month = (int)nansu;
		System.out.println("변환 = "+month);
		// 그 난수는 월이라고 생각하고 월에 해당하는 마지막 일수를 출력한다.

// ===================== if ===================		
/*		int day = 0;
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			day = 31;
		}else if(month==2) {
			day = 28;
		}else day = 30;
		System.out.println(month+"월은 "+day+"일까지 있습니다.");*/
		// 일수가 31일인 달이 많으니깐 else or default 로 작성, 코드를 간결하게 하는 방법
		
		int endDay = 31;
//		if(month==2) endDay=28;
//		else if(month==4 || month==6 || month== 9 || month==11) endDay=30;
//		// else endDay=31;
//		System.out.println(month+"월은 "+endDay+"일까지 있습니다.");
		
// ==================== switch ===================
//		switch(month) {
//		case 2 -> endDay = 28;
//		case 4, 6, 9, 11 -> endDay = 30;
//		default: endDay=31;
//		}

//		switch(month) {
//		case 2: endDay=28; break;
//		case 4: case 6: case 9: case 11: endDay=30; break;
//		default: endDay=31;
//		}

		endDay=switch(month) {
		case 2 -> 28;
		case 4,6,9,11 -> {
			System.out.println("안녕");
			yield 30;
		}
		default -> 31;
		};
		
		System.out.println(month+"월은 "+endDay+"일까지 있습니다.");
		
	}
}
