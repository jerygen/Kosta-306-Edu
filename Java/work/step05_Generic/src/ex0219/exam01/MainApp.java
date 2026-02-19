package ex0219.exam01;

public class MainApp {

	public static void main(String[] args) {
		//제너릭을 사용하지 않은 경우
		/*Box box = new Box();
		box.setContent("상품1");
		if(box.getContent() instanceof String s) {
			//s 접근...
		}
		
		box.setContent(new Board());
		Board board = (Board)box.getContent();*/
		
		/////////////Box에 제너릭을 사용한 경우 - 제너릭 타입///////////////////
		//제네릭을 사용하는 경우(타입을 정하고 그걸로만 사용하고 싶으면 굳이 형변환을 하지 않도록)
		Box<String> box = new Box<>();
		box.setContent("상품1");
		
		String str = box.getContent();
		
		Box<Board> box2 = new Box<>();
		box2.setContent(new Board());
		
		Board b = box2.getContent();
		/////////////////////////
		Box box3 = new Box();
		box3.setContent(new Board());
		Board b2 = (Board)box3.getContent();
		
		
		
		
	}	

}
