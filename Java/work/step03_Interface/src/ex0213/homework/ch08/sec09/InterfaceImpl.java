package ex0213.homework.ch08.sec09;

public class InterfaceImpl implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("InterfaceImpl-MethodA() 실행");
	}

	@Override
	public void methodB() {
		System.out.println("InterfaceImpl-MethodB() 실행");
	}

	@Override
	public void methodC() {
		System.out.println("InterfaceImpl-MethodC() 실행");
	}

}
