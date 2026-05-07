package sample06;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	
	/**
	 * byType을 기준으로 객체를 찾아서 주입해줘 -> 만약 type이 같은 객체가 여러 개라면
	 * byName이 기준이 된다. (id 와 property=field 명이 같아야 한다.)
	 * */	
	@Autowired //byType을 기준으로 객체를 찾아서 주입
	private EmpDTO empDTO;
	
	@Autowired 
	@Qualifier("dto2") //id가 dto2인 객체를 찾아서 empDTO2에 주입
	private EmpDTO empDTO2; //가리키는 변수가 두 개인 거고 객체가 하나다. why? xml에서 생성한 객체가 하나이기 때문에
	//객체가 두 개라면? byType 다음으로 동일한 타입이라면 이름을 기준으로 구별, byName xml의 id와 필드 명이 같아야 함
	//No qualifying bean of type 'sample06.EmpDTO' available: expected single matching bean but found 2: dto,dto2
	
	@Autowired //set, 생성자 필요없음, 소스도 간결해 짐
	private EmpService empService;
	
	/*public EmpController() {
		System.out.println("EmpController 기본 생성자 호출!");
		
		System.out.println("empDTO="+empDTO);
		System.out.println("empService="+empService);
	}*/
	
	/**
	 * 주입은 객체가 생성 된 후에 주입 된다.
	 * @PostConstruct: 생성과 주입이 완료된 후에 해야 할 일이 있을 때
	 * 메소드 위에 선언하면 자동으로 호출된다.
	 * 
	 * <dependency>
	    <groupId>javax.annotation</groupId>
	    <artifactId>javax.annotation-api</artifactId>
	    <version>1.3.2</version>
	   </dependency>
	 * pom.xml에 추가해야 한다.
	 * */	
	/*@PostConstruct
	public void aa() {
		System.out.println("----aa 호출----");
		System.out.println("empDTO="+empDTO+", empno="+empDTO.getEmpno());
		System.out.println("empDTO2="+empDTO2+", empno="+empDTO2.getEmpno());
		System.out.println("empService="+empService);
	}*/
	
	public void test() {
		System.out.println("EmpController test call");
		empService.test(empDTO);
		empService.test(empDTO2);
	}
	
}
