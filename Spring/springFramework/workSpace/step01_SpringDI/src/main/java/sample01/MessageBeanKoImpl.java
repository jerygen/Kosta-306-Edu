package sample01;

public class MessageBeanKoImpl implements MessageBean {

	public MessageBeanKoImpl() {
		System.out.println("MessageBeanKoImpl 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 반가워요~");
	}

}
