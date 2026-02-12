package ex0211.sample02;


public class FullTime extends Employee {
	private int salary;
	private int bonus;
	
	public FullTime() {}
	public FullTime(int empNo, String eName, String job, int mgr, 
			String hiredate, String deptName, int salary, int bonus) {
		super.empNo = empNo;
		super.eName = eName;
		super.job = job;
		super.mgr = mgr;
		super.hiredate = hiredate;
		super.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public void message() {
		 System.out.println(eName+"은 정규직입니다.");
	}
	
	public String toString() {
		return super.toString()+" | "+salary+" | "+bonus;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
}
