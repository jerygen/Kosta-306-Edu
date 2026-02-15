package ex0213.homework.ch08.sec08;

public class MultiInterfaceImplExample {

	public static void main(String[] args) {
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		Searchable se = new SmartTelevision();
		
		se.search("https:www.youtube.com");
	}

}
