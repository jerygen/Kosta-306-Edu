package ex0211.sample01;

public class FullTime {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int salary;
	private int bonus;
	
	public FullTime() {}
	public FullTime(int empNo, String eName, String job, int mgr, 
			String hiredate, String deptName, int salary, int bonus) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public void message() {
		 System.out.println(eName+"사원은 정규직입니다.");
	}
	
//	public String toString() {//StringBuffer나 StringBuilder를 사용
//		return empNo+" | "+eName+" | "+job+" | "+mgr+" | "+hiredate+" | "+deptName+" | "+salary+" | "+bonus;
//	}	

	public int getEmpNo() {
		return empNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FullTime [empNo=");
		builder.append(empNo);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", deptName=");
		builder.append(deptName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");
		
		return builder.toString();
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
