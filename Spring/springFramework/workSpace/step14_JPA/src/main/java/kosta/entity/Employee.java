package kosta.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee extends BaseEntity{
	
	@Id //pk, String인 경우 generatedValue는 지원 불가
	private String empno;
	private String job;
	
	
}
