package kosta.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "team")
@Getter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long memberId;
	private String name;
	private Integer age;
	
	/**
	 * 한 명의 Member는 하나의 팀에 참여할 수 있다.
	 * team 기준으로 관계 정의
	 * embedded와 달리 Team도 CRUD 가능
	 * */
	//@ManyToOne //기본이 fetch = FetchType.EAGER(즉시로딩) -> 조인O, letf outer join
	@ManyToOne(fetch = FetchType.LAZY) //지연로딩, 의도가 발견될 때 내부적으로 알아서 뜻을 파악해서 처리해준다. Proxy -> 조인X, 각각 select
	@JoinColumn(name="tid") //FK 컬럼이름
	private Team team;
	
}
