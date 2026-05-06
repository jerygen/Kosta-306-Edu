package sample03;

public class BookController {
	private BookDAOImpl bookDAO;
	private BookVo bookVo;
	
	public BookController() {
		System.out.println("BookController() 호출");
	}
	
	public BookController(BookDAOImpl bookDAO, BookVo bookVo) {
		this.bookDAO = bookDAO;
		this.bookVo = bookVo;
	}
	
	public void bookInsert() {
		System.out.println("bookInsert() 호출");
		bookDAO.insert(bookVo);
	}
}
