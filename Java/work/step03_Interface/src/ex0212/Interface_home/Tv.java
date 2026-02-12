package ex0212.Interface_home;

public class Tv extends Elec implements ElecFunction {
	private int channel;
	
	public Tv() {}
	public Tv(int channel) {
		this.channel=channel;
	}
	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel=channel;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Tv [channel=");
		builder.append(channel);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void start() {
		System.out.println(super.getCode()+"제품 TV를 "+channel+"을 본다.");
	}

	@Override
	public void stop() {

	}

	@Override
	public void display() {
		
	}

}
