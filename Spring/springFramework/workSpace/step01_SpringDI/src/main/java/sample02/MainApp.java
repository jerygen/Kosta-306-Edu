package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*System.out.println("---------기존 방식-----------");
	
		MemberDAO dao = new MemberDAO();
		Member member = new Member("jang", "1234", 20, "서울");
		
		MemberService service = new MemberService(dao, member);
		service.selectInsert();*/
		
		System.out.println("---- spring Container 이용 ----");
		
		ApplicationContext application = new ClassPathXmlApplicationContext("sample02/springDI_Constructor.xml");
		//scope을 따로 주지 않았기 때문에 두 개의 생성자가 호출 되고 모두 기본 생성자로 호출 됨
		//<bean><constructor value=""/></bean> 으로 하면 기본 생성자가 아니라 인수를 가지는 생성자를 호출할 수 있다.
		
		System.out.println("----호출----");
		MemberService service = application.getBean("service", MemberService.class);
		service.selectInsert();
		
	}

}
