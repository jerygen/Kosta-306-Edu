package lamda.constructorRef; 
import java.util.function.Function;
import java.util.function.Supplier; 
 
class User { 
    String name; 
    public User() {
    	System.out.println("기본 생성자");
    }
    public User(String name) { 
        this.name = name; 
    } 
     
    public void printName() { 
        System.out.println("User 이름: " + name); 
    } 
} 
 //////////////////////////////////////////////////
public class ConstructorReferenceWithParams02 { 
    public static void main(String[] args) { 
    
    	//기존방식
    	Function<String, User> beforeUser = new Function<String, User>() {
			@Override
			public User apply(String name) {
				return new User(name);
			}
		};
		
		//1. 람다식으로 변경해보자
		Function<String, User> lambdaUser = (str) -> new User(str);
		
		//2. 생성자 참조로 변경해보자
		Function<String, User> constructorRefUser = User::new; //만약 기본 생성자가 있다면? 그래도 매개값이 <String, User>이기 때문에 
		//기본 생성자를 하고 싶었다면 Supplier<User> s = User::new;으로 하면된다.
		
        //3. 호출해보자  
		User u1 = beforeUser.apply("java");
		u1.printName();
		
		User u2 = lambdaUser.apply("hello");
		u2.printName();
		
		User u3 = constructorRefUser.apply("hi");
		u3.printName();
		
		Supplier<User> s = User::new;
		s.get();
    } 
}