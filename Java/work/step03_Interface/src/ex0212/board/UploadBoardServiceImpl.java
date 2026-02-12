package ex0212.board;

public class UploadBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("upload="+board);
		System.out.println(super.getClass().getSimpleName()+"insert call");
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("upload="+board);
		System.out.println(getClass().getSimpleName()+"update call");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(getClass().getSimpleName()+"selectByNo call");
		return new UploadBoard(30, "자료실 연습","삼순","파일첨부헤요","a.jpg");
	}

}
