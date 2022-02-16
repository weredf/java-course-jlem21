package app.core;

public class Bank {

	private int id;
	private String name;
	
	// singleton is the only instance of Bank
	private static Bank instance = new Bank();

	public Bank() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Bank getInstance() {
		return instance;
	}

	public static void setInstance(Bank instance) {
		Bank.instance = instance;
	}
	
	
}
