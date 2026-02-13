package ex0213.shop;

public class ShoppingMall {
	
	public void ageLimit(int age) throws ExamException{
		if(age<18) {
			//ExamException e = new ExamException();
			//throw e;
			//이 예외는 체크 예외 -> 반드시 예외처리 필요
			throw new ExamException(age+"살 애들은 가라!");//throw 발생시킬 객체;
		}else {
			System.out.println(age+"세님 입장하신 걸 환영합니다.");
		}
	}
	
}
