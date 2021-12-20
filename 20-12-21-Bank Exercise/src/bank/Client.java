package bank;

public class Client {

	private int id;
	private String name;
	private float balance;
	Account[] accounts = new Account[5];
	private float commissionRate = 0;
	private float interestRate = 0;
	Logger logger;

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		logger.log();
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

	public void addAccount() {
		accounts[null]= new Account;
		Logger.log();
	}
	public Account getAccount(int id) {
		return accounts[id];
	}
	public void removeAccount (int id) {
		balance += accounts[id];
		accounts[id] = null;
		Logger.log();
	}
	public void deposit (float) {
		add amount;
		commission charge at commissionRate;
		Logger.log();
		
	}
	public void withdraw (float) {
		remove amount;
		commission charge at commissionRate;
		Logger.log();
	}
	public void autoUpdateAccounts() {
		interestRate;
	}
	public float getFortune() {
		return (Client.balance + accounts);
	}
}
