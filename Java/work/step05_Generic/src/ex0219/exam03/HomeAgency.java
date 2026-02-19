package ex0219.exam03;
//인터페이스는 구현할 때 객체가 정해져야 함. 생성될 때가 아니라
public class HomeAgency implements Rentable<Home> {

	@Override
	public Home rent() {
		return new Home();
	}
	
}
