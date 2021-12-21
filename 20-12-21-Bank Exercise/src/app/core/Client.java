package app.core;

import java.lang.reflect.Array;

public abstract class Client {

	private int id;
	private String name;
	private float balance;
	Account[] accounts = new Account[5];
	protected float commissionRate = 0;
	protected float interestRate = 0;
	Logger logger;

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		Logger.log(log);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getBalance() {
		return balance;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void addAccount(Account) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				accounts[i] = Account;
				Logger.log();
				}
			}	
	}
	public Account getAccount(int id) {
		return accounts[id];
	}
	public void removeAccount (int id) {
		balance += (accounts[id].getBalance());
		for (int i = 0; i < accounts.length; i++) {
			if(i == id) {
				accounts[i] = null;
				Logger.log();
				}
			}	
	}
	public void deposit (float amount) {
		balance += amount;
		commissionRate;
		Logger.log();
		
	}
	public void withdraw (float amount) {
		balance -= amount;
		commissionRate;
		Logger.log();
	}
	public void autoUpdateAccounts() {
		interestRate;
	}
	public float getFortune() {
		float fortune = balance;
		for (int j = 0; j <= accounts.length; j++) {
			fortune+=accounts[j].getBalance();
		}
		return (fortune + getAccount(i)); // array?
	}
}
