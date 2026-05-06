package sample03;

public class BookVo {
	private String subject;
	private String writer;
	private int price;
	private String date;
	
	public BookVo() {
		System.out.println("BookVo() 호출");
	}
	
	public BookVo(String subject, String writer, int price, String date) {
		this.subject = subject;
		this.writer = writer;
		this.price = price;
		this.date = date;
	}
	
	public String getSubject() {
		return subject;
	}
	public String getWriter() {
		return writer;
	}
	public int getPrice() {
		return price;
	}
	public String getDate() {
		return date;
	}
		
	
}
