package lamda.methodRef; 
import java.util.function.BiFunction; 
 
public class SpecificInstanceMethod03 { 
    public static void main(String[] args) {      
    //기존방식 
    BiFunction<String, String, Boolean> beforeEquals = new BiFunction<>() {	
		@Override
		public Boolean apply(String s1, String s2) {
			return s1.equals(s2);
		}
	};
   
	
     //1. 람다식변경해보자
	BiFunction<String, String, Boolean > lambdaEquals = (s1, s2)->s1.equals(s2);
	
	 //2. 메소드 참조로 변경해보자
	BiFunction<String, String, Boolean > instanceRefEquals = String::equals;
 
	 //3. 호출해보자
     System.out.println(beforeEquals.apply("Hello","Hello"));
     System.out.println(lambdaEquals.apply("Hello","Java"));
     System.out.println(instanceRefEquals.apply("Hello","Hello"));
    } 
} 


