package app.core;

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
		Log log = new Log(System.currentTimeMillis(), id, name, balance);
		logger.log(log);
		System.out.println(log.getData());
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

	// add Account to accounts array
	public void addAccount (int id) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				Account account = new Account(id, balance);
				accounts[i] = account;
				Log log = new Log(System.currentTimeMillis(), id, "account added", accounts[i].getBalance());
				logger.log(log);
				System.out.println(log.getData());
				}
			}	
	}
	
	// returns the account of the specified id or null
	public Account getAccount(int id) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) {
				return accounts[i];
			}
		} return null;
		
	}
	
	// remove Account from accounts array
	public void removeAccount (int id) {
		balance += (accounts[id].getBalance());
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getId() == id) {
				accounts[i] = null;
				Log log = new Log(System.currentTimeMillis(), id, "account removed", accounts[id].getBalance());
				logger.log(log);
				System.out.println(log.getData());
				}
			}	
	}
	
	// deposit amount, charge commission
	public void deposit (float amount) {
		balance += amount;
		float commission = commissionRate*amount;
		balance -= commission;
		Log log = new Log(System.currentTimeMillis(), id, "deposit", amount);
		logger.log(log);
		System.out.println(log.getData());
		
	}
	
	// withdraw amount, charge commission
	public void withdraw (float amount) {
		balance -= amount;
		float commission = commissionRate*amount;
		balance -= commission;
		Log log = new Log(System.currentTimeMillis(), id, "withdraw", amount);
		logger.log(log);
		System.out.println(log.getData());
	}
	
	// add interest to each account
	public void autoUpdateAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			float interest = interestRate*accounts[i].getBalance();
			accounts[i].setBalance(accounts[i].getBalance() + interest);
			Log log = new Log(System.currentTimeMillis(), id, "interest", interest);
			logger.log(log);
			System.out.println(log.getData());
		}
	}
	
	// sum of client balance + total account balance
	public float getFortune() {
		float fortune = balance;
		for (int j = 0; j <= accounts.length; j++) {
			fortune+=accounts[j].getBalance();
		}
		return fortune;
	}
}
