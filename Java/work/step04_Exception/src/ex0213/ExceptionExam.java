package ex0213;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("*** 메인 시작 ***");
		System.out.println("args="+args);
		try {
			System.out.println("args[0]="+args[0]);
			
			int convertNo = Integer.parseInt(args[0]);
			System.out.println("변환 값="+convertNo); //NumberFormatException
			
			int result = 100/convertNo;
			System.out.println("나눈 결과="+result);
			
		//catch 불록을 여러 개 작성할 때 반드시 서브 클래스부터 작성한다.
		}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			//예외가 발생했을 때 해야 할 일
			System.out.println("인수를 전달해주세요. "+e);//e.toString() class이름:메세지
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력해주세요 => "+e.getMessage());//e.getMessage()는 메세지 내용만 나옴
		}catch(Exception e) {//Unreachable catch block for NumberFormatException. It is already handled by the catch block for Exception
			//이 외의 모든 예외는 여기서 처리한다.
			System.out.println("예외가 발생했어요.");
			
			//중요!!!!!!!!!!!!!!!!!!!!
			//개발자가 개발할 때 예외에 대한 정보를 추적(디버깅) 할 때 사용한다.
			//반드시 배포(production 환경)에서는 제거해야 한다.
			e.printStackTrace();//예외 정보를 detail하게 stack에서 꺼내서 출력해준다.
		}finally {
			System.out.println("finally영역은 예외 상관없이 항상 실행해요");
		}
		System.out.println("*** 메인 끝 ****");
	}

}
