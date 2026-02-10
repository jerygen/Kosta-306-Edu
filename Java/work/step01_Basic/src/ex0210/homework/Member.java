package ex0210.homework;
/**
 * 13,14번 문제풀이
 * 작성일: 2026.02.10
 * 작성자: 김미연
 * */
public class Member {
	String name;
	String id;
	String password;
	int age;
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		
		System.out.println("--------user1---------");
		System.out.println("name: "+user1.name+" | id: "+user1.id);
		System.out.println("password: "+user1.password+" | age: "+user1.age);
	}
}
