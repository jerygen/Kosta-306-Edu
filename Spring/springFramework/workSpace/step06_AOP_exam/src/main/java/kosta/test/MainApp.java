package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.test.service.Player;

public class MainApp {
	public static void main(String[] args) {
		//context도 close해줘야 함.
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("springAOP.xml");

	
		//ConfigurableApplicationContext co = (ConfigurableApplicationContext) context;
		
//		ConfigurableApplicationContext context =
//				new ClassPathXmlApplicationContext("springAOP.xml");
		
		//closable, close가 자동호출, 자동 리소스 닫기
		try(ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("springAOP.xml")){
			
			//인터페이스 기반으로 생성
			Player p = context.getBean("tv", Player.class);
			p.start(10);
			p.pause();
			p.stop();
			
			System.out.println("-----------------------");
			p = context.getBean("audio", Player.class);
			p.start(20);
			p.pause();
			p.stop();
			
			System.out.println("-----------------------");
			p = context.getBean("video", Player.class);
			p.start(30);
			p.pause();
			p.stop();
			
		}
		
			//context.close();
		
	}

}









