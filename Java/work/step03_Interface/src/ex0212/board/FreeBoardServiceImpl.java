package ex0212.board;
/**
 * 자유게시판 비지니스 로직 담당
 * */
public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("free="+board);
		System.out.println(super.getClass().getSimpleName()+"insert call");//이때의 super는 Object
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("free="+board);
		System.out.println(getClass().getSimpleName()+"update call");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(getClass().getSimpleName()+"selectByNo call");
		return new FreeBoard(20, "수업중", "미미","재미있어요.");
	}
	
	@Override
	public int delete(int no) {
		System.out.println(super.getClass().getSimpleName()+"delete call");
		return 10;
	}

}
