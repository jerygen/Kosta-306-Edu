package ex0211.overriding.goods;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public Goods() {} //상속 관계를 고려해서 기본 생성자를 넣어 주는 것이 좋음
	//source -> using field
	public Goods(String code, String name, int price, String explain) {
		this(code, price, explain); //재사용성을 높임
		this.name = name;
	}
	public Goods(String code, int price, String explain) {
		this.code = code;
		this.price = price;
		this.explain = explain;
	}
	
	@Override
	public String toString() {
		return code+" | "+price+" | "+name+" | "+explain;
	}
	//setXxx
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		if(price > 0)
			this.price = price;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}

	//getXxx
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getExplain() {
		return explain;
	}

}