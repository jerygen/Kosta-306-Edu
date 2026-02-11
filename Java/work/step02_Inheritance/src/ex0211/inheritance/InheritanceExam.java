package ex0211.inheritance;

class Car{//Object 상속
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}
//////////////////////////////////////////////////////////////////////
//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
//각 클래스에 인수를 받지않는 생성자 작성
//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
//부모를 공유하는 게 아니라 각각 부모를 갖는 것
class EfSonata extends Car{//EfSonata is a Car
	int i=100;
	EfSonata(){
		carname = "EfSonata";
		this.cost = 3000;
	}
}
	
class Excel extends Car{
	Excel(){
		carname = "Excel";
		cost = 100;
	}
}

class Carnival extends Car{
	Carnival(){
		carname = "Carnival";
		super.cost = 5000;
	}
}
	
/////////////////////////////////////////////////
public class InheritanceExam{
	//메인메소드에서 
	public static void main(String[] args) {
		//Car, EfSonata, Excel, Carnival 네개의 객체를 생성
		// 각 클래스에서 Car class에 있는 printAttributes()메소드를 호출할수있다.
		Car car = new Car();
		EfSonata efsonata = new EfSonata();
		Excel excel = new Excel();
		Carnival carnival = new Carnival();
		
		System.out.println("--------------------------");
		System.out.println("car="+car);
		System.out.println("efsonata="+efsonata);
		System.out.println("excel="+excel);
		System.out.println("carnival="+carnival);
		
		//재사용성
		System.out.println("--------------------------");
		car.printAttributes();
		efsonata.printAttributes();
		excel.printAttributes();
		carnival.printAttributes();
		
	}
	
}

