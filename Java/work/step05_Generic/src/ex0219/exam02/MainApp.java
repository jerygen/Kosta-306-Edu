package ex0219.exam02;

public class MainApp {

	public static void main(String[] args) {
		//상품생성
		Product<Tv, String> p1 = new Product<>();
		p1.setKind(new Tv());
		p1.setModel("삼성tv");
		
		Tv tv = p1.getKind();
		/////////////////////////////////////////
		//기본형은 쓸 수 없음. 객체 타입만 들어갈 수 있어. 랩퍼 클래스? 기본형을 객체타입으로 변환 시켜주는 클래스
		Product<Video, Integer> p2 = new Product<>();
		p2.setKind(new Video());
		p2.setModel(100);//Autoboxing 
		
		Video v = p2.getKind();
		int it = p2.getModel(); //Unboxing
		
	}

}
