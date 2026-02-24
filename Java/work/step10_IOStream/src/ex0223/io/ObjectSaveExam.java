package ex0223.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
    public ObjectSaveExam() {
    	//객체를 파일에 저장해보자.
    	Student st1 = new Student("나영",20,"서울");
    	Student st2 = new Student("효리",22,"대구");
    	Student st3 = new Student("희정",27,"서울");
    	
    	//보조 스트림 ObjectOutputStream: 객체를 저장할 수 있게 해준다.
    	try(ObjectOutputStream oos =
    			new ObjectOutputStream(new FileOutputStream("src/ex0223/objSave.txt"))){
    		
//    		oos.writeObject(st1);
//    		oos.writeObject(st2);
    		
    		//자료구조 객체를 파일에 저장 
    		List<Student> list = List.of(st1,st2,st3, new Student("가현",22,"서울"));
//    		List<Student> list = new ArrayList<>();
//    		list.add(st1);
//    		list.add(st2);
//    		list.add(st3);
//    		list.add(new Student("가현",22,"서울"));
    		oos.writeObject(list);
		
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("--저장 완료~~~---");
    	
    }
	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}





