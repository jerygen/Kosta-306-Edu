package ex0211.sample02;

public class PartTime extends Employee {
	private int timePay;
	
	public PartTime(){}
	public PartTime(int empNo, String eName, String job, int mgr, 
			String hiredate, String deptName, int timePay) {
		super.empNo = empNo;
		super.eName = eName;
		super.job = job;
		super.mgr = mgr;
		super.hiredate = hiredate;
		super.deptName = deptName;
		this.timePay = timePay;
	}
	public void message() {
		 System.out.println(eName+"사원은 비정규직입니다.");
	}
	
	public String toString() {
		return super.toString()+" | "+timePay;
	}
	
	public int getTimePay() {
		return timePay;
	}
	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	
}
