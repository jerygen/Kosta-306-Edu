package ex0212.board;
/**
 * 자유 게시판 속성을 관리하는 객체
 */
public class FreeBoard extends Board {
	public FreeBoard() {}

	public FreeBoard(int no, String subject, String writer, String content) {
		super(no, subject, writer, content);
	}
	
}
