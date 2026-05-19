package kosta.main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.entity.ContactInfo;
import kosta.entity.Member;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("----JPA Start----");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		//Member 등록
		/*em.persist(Member.builder()
						 .name("효리")
						 .contactInfo(ContactInfo.builder()
								 				 .companyPhone("031-1111-1111")
								 				 .mobilePhone("010-2222-2222")
								 				 .housePhone("031-3333-3333")
								 				 .build())
						 .build());*/
		
		transaction.commit();

		em.close();		
		emf.close();
		System.out.println("----JPA End------");

	}

}
