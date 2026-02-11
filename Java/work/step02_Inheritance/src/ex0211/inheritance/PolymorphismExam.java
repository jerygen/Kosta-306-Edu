package ex0211.inheritance;

class CarCenter{
	//매개변수를 이용한 다형성 -> 접근 범위 제약, Car 타입 부분만 접근 가능
	public void engineer(Car cd){
		System.out.println("cd주소="+cd);
		//System.out.println("cd.i="+cd.i);//부모타입으로는 자식부분 접근 불가
		
		//접근 가능하도록 자식타입이 아니었기 때문이므로 부모타입을 자식 타입으로 형 변환을 하면 됨
		//EfSonata efs = cd; //부모 > 자식
		
		//ObjectDownCasting을 한다.
		if(cd instanceof EfSonata) {
			System.out.println("------------------");
			EfSonata efs = (EfSonata)cd;//ClassCastException
			System.out.println("efs주소="+efs);
			System.out.println("efs.i="+efs.i);
			System.out.println("------------------");
		}
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}
//////////////////////////////////////////////////////////
public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		Car c= new Car();
		
		cc.engineer(c);//
		System.out.println("ef주소="+ef);
		System.out.println("ef.i="+ef.i);
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		
	
	}
}
