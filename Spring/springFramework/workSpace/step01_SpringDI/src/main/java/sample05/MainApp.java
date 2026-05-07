package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("sample05/springDI_Order.xml");
		
		//Impl이 아니라 인터페이스 타입으로 받아야 한다. (DIP)
		OrderMessage message = application.getBean("orderMessage", OrderMessage.class);
		message.getOrderMessage();
	}

}
