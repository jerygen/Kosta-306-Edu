package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*System.out.println("---기존 방식---");
		
		MessageBean bean = new MessageBeanEnImpl();
		bean.sayHello("miyeon");
		
		bean = new MessageBeanKoImpl();
		bean.sayHello("미연");*/
		//////////////////////
		System.out.println("Spring Container가 bean을 관리 ");
		
		ApplicationContext application = new ClassPathXmlApplicationContext("sample01/applicationContext.xml");
		
		System.out.println("==============================");
		
		MessageBean bean = application.getBean("en", MessageBean.class);
		// MessageBeanKoImpl 또는 MessageBeanEnImpl을 사용해도 되지만 그렇게 되면 계속 수정이 필요하다.
		bean.sayHello("miyeon");
		
		bean = application.getBean("ko", MessageBean.class);
		bean.sayHello("미연");
		
		//싱글톤으로 관리
		MessageBean bean2 = application.getBean("ko", MessageBean.class);
		bean2.sayHello("미미");
		
		System.out.println("bean = " + bean);
		System.out.println("bean2 = " + bean2);
		
		/** 
		 Spring Ioc Container의 ApplicationContext는 BeanFactory상속 받은 것으로
		 객체들의 생성, 의존관계주입, 생명주기를 관리한다.(다국어지원도 가능 , 부가기능 더 있다)
		
		 Spring Ioc Container는 객체를 사전초기화 하기때문에 scope="singleton" 으로 관리된다.
		 동일한 id로 getBean을 여러번 해도 항상 동일한 객체를 사용한다.
		
		 만약 bean설정에서 scope="prototype" 설정하면 객체를 미리 만들지 않고
		 필요할때(getBean)마다 새로운 객체를 생성해준다
		 * */
		
	}

}
