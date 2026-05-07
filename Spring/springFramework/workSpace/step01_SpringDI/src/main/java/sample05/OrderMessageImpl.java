package sample05;

public class OrderMessageImpl implements OrderMessage {
	private UserBean userBean;
	private ProductBean productBean;
	
	private int orderId;
	private String message;	
	
	public OrderMessageImpl() {
		System.out.println("OrderMessageImpl()");
	}
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void getOrderMessage() {
		System.out.println("orderId: "+getOrderId());
		System.out.println("name: "+getUserBean().getName());
		System.out.println("phone: "+getUserBean().getPhone());
		System.out.println("상품명: "+getProductBean().getPname());
		System.out.println("상품가격: "+getProductBean().getPrice());
		System.out.println("메세지: "+getMessage());
	}

}
