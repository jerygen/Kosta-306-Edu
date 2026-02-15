package ex0213.homework.ch08.sec13;

public class ImplClass implements InterfaceC {

	@Override
	public void methodB() {
		System.out.println("methodA() 실행");

	}

	@Override
	public void methodA() {
		System.out.println("methodB() 실행");

	}

	@Override
	public void methodC() {
		System.out.println("methodC() 실행");

	}

}
