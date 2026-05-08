package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller("controller")
@RequiredArgsConstructor // final 필드 또는 @NonNull 이 선언된 필드를 기준으로 생성자로 만든다.
public class BoardController {
	
	private final BoardDTO boardDTO;//final필드는 초기화 필수(명시적 초기화 or 생성자를 이용 -> 권장)
	
	@Autowired
	private BoardDTO boardDTO2;
	
	@Autowired
	private BoardService boardService;
	
	@PostConstruct
	public void init() {
		System.out.println("boardDTO="+boardDTO);
		System.out.println("boardDTO2="+boardDTO2);
	}
	
//	public BoardController(BoardDTO boardDTO) {
//		System.out.println("BoardController() 생성자 호출");
//		this.boardDTO = boardDTO;
//	}
	
	public void test() {
		System.out.println("----test 호출----");		
		boardService.select();
	}
	
}
