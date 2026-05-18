package kosta.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JPA가 관리하는 객체

@Entity
@Table(name="cus")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@DynamicUpdate
@DynamicInsert
public class Customer extends BaseEntity{//테이블이름은 엔티티 이름 기반으로 생성
	@Id //pk 대상
	//@GeneratedValue(strategy = GenerationType.AUTO) // 쓰기 지연 가능
	@GeneratedValue(strategy = GenerationType.IDENTITY) //쓰기 지연 불가
	private Long id; //대문자 Long인 이유: Spring data JPA의 JPARepository<??> -> 제너릭은 객체 밖에 선언되지 않기 때문, 미리 매핑하는 것, int를 사용하려면 Integer로 사용 
	
	@Column(name = "user_name", unique=true, length=30)
	private String userName;
	
	@Column(name = "user_age", nullable=true)
	private Integer age;
	
	//@Transient //DB 컬럼으로 관리되지 않는다.
	private String addr;
	
	private String etc;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDay; //DB에 date or datetime(timestamp) or time
	//Temporal -> 날짜 형식으로 쓰겠다는 뜻, 자동으로 관리 X
	
	/*//등록일
	@CreationTimestamp
	private LocalDateTime insertDate;
	//자동으로 날짜를 관리해줌 
	
	//수정일
	@UpdateTimestamp
	private LocalDateTime updateDate;*/
	
}
