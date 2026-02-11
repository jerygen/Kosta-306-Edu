package ex0210.homework2;

public class Account {
	private String accountNo;
	private String owner;
	private int balance;
	
	public Account(String accountNo, String owner, int balance) {
		this.accountNo = accountNo;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
	
	
}
