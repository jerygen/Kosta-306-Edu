package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //<bean class="BoardServiceImpl" id="boardServiceImpl" />
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardMyBatisDAOImpl")
	private BoardDAO boardMyBatisDaoImpl;
	
	@Autowired
	private BoardDAO boardOracleDAO;
	
	@PostConstruct
	public void init() {
		System.out.println("boardMyBatisDAOImpl="+boardMyBatisDaoImpl);
		System.out.println("boardOracleDAOImpl="+boardOracleDAO);
	}
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl() 생성자 호출");
	}
	
	@Override
	public void select() {
		System.out.println("BoardServiceImpl 호출");
		
		boardMyBatisDaoImpl.select();
		boardOracleDAO.select();
	}

}
