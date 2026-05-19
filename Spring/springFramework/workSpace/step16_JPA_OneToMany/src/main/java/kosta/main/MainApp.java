package kosta.main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.entity.Member;
import kosta.entity.Team;


public class MainApp {

	public static void main(String[] args) {
		System.out.println("----JPA Start----");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		//team 등록
		/*Team t1 = Team.builder().teamName("team01").build();
		Team t2 = Team.builder().teamName("team02").build();
		Team t3 = Team.builder().teamName("team03").build();
		
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);*/
		
		//Member 등록
		/*em.persist(Member.builder().name("효리").age(32).team(t1).build());
		em.persist(Member.builder().name("나영").age(22).team(t1).build());
		em.persist(Member.builder().name("지원").age(25).team(t1).build());
		
		em.persist(Member.builder().name("상순").age(20).team(t2).build());
		em.persist(Member.builder().name("영식").age(29).team(t2).build());*/
		
		
		//1. 검색
		/*Member member = em.find(Member.class, 4L);
		System.out.println("member="+member);
		
		System.out.println("회원의 팀 정보도 검색");
		Team team = member.getTeam(); //find랑 다름
		//System.out.println(team.getClass());
		System.out.println("team="+team);*/
		
		
		//2. 팀 검색 + 회원
		/*Team team = em.find(Team.class, 1L);
		System.out.println("team="+team);*/
		
		
		//3. 삭제(Member 즉 자식을 삭제해본다)
		/*Member member = em.find(Member.class, 4L);
		em.remove(member);*/
		
		
		//4. 삭제(Team 즉 부모를 삭제해본다)
		/*Team team = em.find(Team.class, 3L); //참조하고 있는 자식이 없는 경우
		em.remove(team);*/
		
		/*Team team = em.find(Team.class, 1L);
		em.remove(team);*/
		
		Team team = em.find(Team.class, 2L); 
		em.remove(team);
		
		
		
		System.out.println("-1----------------");
		transaction.commit();
		System.out.println("-2----------------");

		em.close();		
		emf.close();
		//System.out.println("team.getMemberList="+team.getMemberList()); //Proxy를 통해서 가져오는 거는 session 내에서만 가능, team이 Proxy객체일 때(LAZY)
		System.out.println("----JPA End------");

	}

}
