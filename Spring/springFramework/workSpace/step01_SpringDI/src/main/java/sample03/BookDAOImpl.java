package sample03;

public class BookDAOImpl implements BookDAO {
	public BookDAOImpl() {
		System.out.println("BookDAOImpl() 호출");
	}
	
	@Override
	public void insert(BookVo bookVo) {
		System.out.println("책제목: "+bookVo.getSubject());
		System.out.println("작가: "+bookVo.getWriter());
		System.out.println("가격: "+bookVo.getPrice());
		System.out.println("날짜: "+bookVo.getDate());
	}

}
