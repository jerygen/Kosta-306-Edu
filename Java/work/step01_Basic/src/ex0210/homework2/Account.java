package ex0210.homework2;

public class Account {
	String account;
	String name;
	int balance;
	
	public Account(String [] data) {
		account = data[0];
		name = data[1];
		if(balance>0) balance += Integer.parseInt(data[2]); 
	}
}
