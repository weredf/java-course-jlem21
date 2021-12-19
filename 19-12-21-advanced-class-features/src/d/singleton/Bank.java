package d.singleton;

public class Bank {
	
	//============ singleton design pattern =========
	// 1. private CTOR
	private Bank() {
	}
	
	// 2. private static instance of Bank
	private static Bank instance = new Bank(); // can only use new instance within the same class bc of private modifier
	
	// 3. public static get method for Bank
	public static Bank getInstance() {
		return instance;
	}
	
	//============ bank business logic =============
	private int numberOfCustomers;
	
	public void addCustomer() {
		numberOfCustomers++;
	}

	public void removeCustomer() {
		numberOfCustomers--;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;

	}
	

}
