package ex0219.list;
/**
 * 사원정보
 * */
public class Emp /*implements Comparable<Emp>*/{
	private int empNo;
	private String empName;
	private int age;
	private String addr;
	
	public Emp() {}

	public Emp(int empNo, String empName, int age, String addr) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.age = age;
		this.addr = addr;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empNo=");
		builder.append(empNo);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Returns:
          a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
         5 - 2  = 3
         5 - 5  = 0
         5 - 7 = -2
         */
	/*@Override
	public int compareTo(Emp o) {
		
		return o.getEmpNo()-empNo;//내림차순, empNo - o.getEmpNo(): 오름차순
	}*/
	
}
