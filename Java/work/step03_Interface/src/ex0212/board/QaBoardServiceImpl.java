package ex0212.board;
/**
 * QA 게시판 비지니스 로직 담당 클래스
 */
public class QaBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {//부모가 public abstract이므로 public 제거 불가
		System.out.println("qa="+board);
		System.out.println("QABoardServiceImpl의 insert call...");
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("qa="+board);
		System.out.println("QABoardServiceImpl의 update call...");
		return false;
	}

	@Override
	public Board selectByNo(int no) {//return 타입이 Board인데 가지고 나갈 때 QaBoard로 가능
		System.out.println("QABoardServiceImpl의 selectByNo call...");
		return new QaBoard(10,"연습중","희정","재미있다.",false);
	}

}
