package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//1. 기존방식
		/*Student student = new Student();
		student.setNo(1);
		student.setAddr("서울");
		student.setName("희정");
		student.setPhone("1111-2222");
		
		StudentService service = new StudentServiceImpl();
		
		StudentDAO studentDAO = new StudentDAOImpl();
		StudentServiceImpl serviceImpl = (StudentServiceImpl) service;
		serviceImpl.setStudentDAO(studentDAO);
		
		StudentController controller = new StudentController();
		
		//주입
		controller.setStudent(student);
		controller.setStudentService(service);
		
		controller.insert();*/
		
		//////////////////////////////////////////////////
		//2. setter 주입
		ApplicationContext application = new ClassPathXmlApplicationContext("sample04/springDI_Setter.xml");
		
		System.out.println("---호출---");
		StudentController controller = application.getBean("controller", StudentController.class);
		controller.insert();

	}

}
