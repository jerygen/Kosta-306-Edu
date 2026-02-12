package ex0212.superkeyword;

class Animal{
	int age=5;
	String bodyColor;
	public void sound() {
		System.out.println("super의 sound call..");
	}
	public void eat() {
		System.out.println("super의 eat call..");
	}
}
/////////////////////////////////////////// 
class Cat extends Animal{//Cat is a Animal 성립
	int age=10;
	int weight;
	
	@Override
	public void sound() {
		System.out.println("Cat의 sound call..");
	}
	
	public void run() {
		System.out.println("Cat의 run call..");
	}
	
	public void test() {
		System.out.println("**필드 test*******");
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		System.out.println("-----------------");
		
		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		System.out.println("-----------------");
		
		System.out.println(weight);
		System.out.println(this.weight);
		//System.out.println(super.weight);//부모는 자식 것을 불러오지 못함
		System.out.println("-----------------");
		
		System.out.println(this);
		//System.out.println(super);//super은 단독으로 못 씀, 참조 변수가 아님
		
		System.out.println("***메소드****");
		sound();
		this.sound();
		super.sound();
		System.out.println("-----------------");
		
		eat();
		this.eat();
		super.eat();
		System.out.println("-----------------");
		
		run();
		this.run();
		//super.run();//부모에서 자식 걸을 가져오지 못 함
		System.out.println("-----------------");
	}
}

public class SuperFieldMethodExam {

	public static void main(String[] args) {
		//new Cat().test();
		
		System.out.println("--외부에서 객체 생성해서 접근 ----");
		Cat cat = new Cat();
		System.out.println(cat.age);
		System.out.println(cat.bodyColor);
		System.out.println(cat.weight);
		
		cat.sound();
		cat.eat();
		cat.run();
		
		System.out.println("================");
		Animal an = new Cat();//다형성, Animal 부분만 접근 가능
		System.out.println(an.age);
		System.out.println(an.bodyColor);
		//System.out.println(an.weight); //부모타입으로는 자식부분 접근 불가
		
		an.sound(); //재정의된 메소드는 부모타입으로 접근해도 재정의된 메소드 

		an.eat();
		//an.run();//부모타입으로는 자식부분 접근 불가 
		
		System.out.println("an= "+an);//Animal 타입이지만 Cat 전체를 가지고 있음
		
		//an으로 접근할 수 없는 자식 부분을 접근하기 위해서 
		//ObjectDownCasting이 필요하다.
		if(an instanceof Cat) {
			Cat c = (Cat)an; //부모>자식
			System.out.println("c= "+c);
			System.out.println(c.weight);
			c.run();
		}
		System.out.println("================");
		
		Animal a = new Animal();
		if(a instanceof Cat) {
			
			Cat cc = (Cat)a;//문법적으로 틀리지 않음, 실행도중에 ClassCastException 발생
		}
		System.out.println("**End****");
	}

}
