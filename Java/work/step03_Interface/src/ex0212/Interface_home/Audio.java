package ex0212.Interface_home;

public class Audio extends Elec implements ElecFunction {
	private int volumn;
	
	public Audio() {}
	public Audio(int volumn) {
		this.volumn=volumn;
	}	
	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn=volumn;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Audio [volumn=");
		builder.append(volumn);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void start() {
		System.out.println(super.getCode()+"제품의 Audio를 "+volumn+"으로 듣는다.");
	}

	@Override
	public void stop() {

	}

	@Override
	public void display() {

	}

}
