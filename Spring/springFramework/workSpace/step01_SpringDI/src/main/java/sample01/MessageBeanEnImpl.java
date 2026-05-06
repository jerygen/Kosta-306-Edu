package sample01;

public class MessageBeanEnImpl implements MessageBean {

	public MessageBeanEnImpl() {
		System.out.println("MessageBeanEnImpl 호출");
	}
	@Override
	public void sayHello(String name) {
		System.out.println("Hello~~ "+name);

	}

}
