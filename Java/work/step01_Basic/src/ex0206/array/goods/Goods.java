package ex0206.array.goods;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public Goods(String [] data) {
		this.code = data[0];
		this.name = data[1];
		if(Integer.parseInt(data[2])>0) {
			this.price = Integer.parseInt(data[2]);
		}
		this.explain = data[3];
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