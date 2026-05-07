package sample07;

import org.springframework.stereotype.Repository;

@Repository("boardOracleDAO") //생성 <bean class="sample07.BoardOracleDAOImpl" id="boardOracleDAOImpl"/> 동일
public class BoardOracleDAOImpl implements BoardDAO {

	public BoardOracleDAOImpl() {
		System.out.println("BoardOracleDAOImpl() 생성자 호출");
	}
	
	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl 호출");
	}

}
