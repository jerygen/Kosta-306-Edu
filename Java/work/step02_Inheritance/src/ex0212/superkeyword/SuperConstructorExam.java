package ex0212.superkeyword;

class Parent{
//	Parent(){
//		System.out.println(1);
//	}
	Parent(int i){
		//super(); -> Object의 생성자를 가리킴
		System.out.println(2);
	}
	Parent(String s){
		System.out.println(3);
	}
}
/////////////////////////////////////////////////
class Child extends Parent{//Child은 Parent, Object이다.
	Child(){
		//super();
		this(100);
		System.out.println(4);
	}
	Child(int i){
		//super();
		super(i);
		System.out.println(5);
	}
	Child(boolean b){
		//super();
		super("안녕");
		System.out.println(6);
	}
}
/////////////////////////////////////////////// 
public class SuperConstructorExam {
	
	public static void main(String[] args) {
		//new Child();//1 4
		//new Child(10);//1 5
		//new Child(true);//1 6
		/*모든 자식 생성자 구현부 첫 번째 줄에 super() 생략되어 있다.*/
		
		////////////////////////////////////////////////
		/*만약, 부모의 생성자가 없다면 */
		//new Child();//4
		//new Child(10);//5
		//생성자를 하나도 작성하지 않으면 기본 생성자를 자동으로 삽입한다.
		
		////////////////////////////////
		//만약, 부모의 기본 생성자 없고, 다른 생성자 추가했다면
		//Implicit super constructor Parent() is undefined. Must explicitly invoke another constructor
		//자식 생성자의 구현부 첫 번째 줄에서 다른 걸 호출해서 해결, this, super 활용
		new Child();
		
	}
}
