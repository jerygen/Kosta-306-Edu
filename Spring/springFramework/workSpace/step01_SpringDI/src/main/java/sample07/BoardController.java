package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class BoardController {
	
	@Autowired
	private BoardDTO boardDTO;
	
	@Autowired
	private BoardDTO boardDTO2;
	
	@Autowired
	private BoardService boardService;
	
	@PostConstruct
	public void init() {
		System.out.println("boardDTO="+boardDTO);
		System.out.println("boardDTO2="+boardDTO2);
	}
	
	public BoardController() {
		System.out.println("BoardController() 생성자 호출");
	}
	
	public void test() {
		System.out.println("----test 호출----");		
		boardService.select();
	}
	
}
