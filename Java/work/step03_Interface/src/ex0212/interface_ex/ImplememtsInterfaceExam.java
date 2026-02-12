package ex0212.interface_ex;
//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00{
	abstract void interfaceExam00();
}

// 인터페이스 내의 모든 변수와 메소드는 자동으로 public static final, public abstract 이 된다. 제한자를 써도 되고, 안 써도 됨
interface InterfaceExam01 extends InterfaceExam00{
	final int i = 767;
	/*protected*/public int k = 999;//안 쓰면 자동으로 protected 가 되고, 오히려 쓰면 오류가 난다.
	
	void interfaceExam01(int i, int k);
}



interface InterfaceExam02{
	int j =747;
	/*private*/ int privateInt = 8; 
	/*private*/ void interfaceExam02(int j); 
	
}



class SuperClassExam{
	String superString = "Super";

	String superMethod(){
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01{

	@Override
	public void interfaceExam00() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interfaceExam01(int i, int k) {
		// TODO Auto-generated method stub
		
	}
	
}


//클래스가 인터페이스를 implements할 때는 상속 관계에 있는 모든 abstract 메소드를 가지고와서 재정의하거나 클래스가 abstract여야 한다.
class SubClassExam02 extends SuperClassExam 
				implements InterfaceExam01, InterfaceExam02{

	@Override
    public void interfaceExam00() {
    // TODO Auto-generated method stub
    
    }

    @Override
    public void interfaceExam02(int j) {
    // TODO Auto-generated method stub
    
    }

    @Override
    public void interfaceExam01(int i, int k) {
    // TODO Auto-generated method stub
    
    }
	 
}

//abstract이 있으면 재정의하지 않아도 됨
abstract class SubClassExam03 extends SuperClassExam
			implements InterfaceExam01, InterfaceExam02{} //SuperClassExam는 인터페이스가 아니므로 implements할 수 없고 extends만 가능하다.
			

class SubClassExam04 extends SubClassExam02{
	//여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00(){}
	public void interfaceExam01(int i, int k){}
	public void interfaceExam02(int j){}

	SubClassExam04(){
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = "+i);
		System.out.println(" j = "+j);
	}
	SubClassExam04(String s1, String s2){
		System.out.println(s1+" 타입 "+"subClassExam04("+s2+") 객체 생성");
		
	}
	void printSuperString(){
		InterfaceExam01 ie01 /*= new InterfaceExam01()*/; //타입은 가능하지만 생성 불가
		

		System.out.println(" superString = "+superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam{ 
	public static void main(String args[]){	
		//다형성
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam  superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		
		sub04.interfaceExam00();
		sub04.interfaceExam01(1,7);
		sub04.superMethod();
	}
}

