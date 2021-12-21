package app.core;

public class Bank {
	
	Client[] clients = new Client[100];
	private float balance;
	accountUpdater;
	Logger logger;
	
	private Bank(Client[] clients, Logger logger) {
		super();
		this.clients = clients;
		this.logger = logger;
	}
	
	private static Bank instance = new Bank(Bank.getClients, Bank.getLogs);
	
	public static Bank getInstance() {
		return instance;
	}
	
	public float getBalance() {
		
	}
	
	public float getTotalFortune() {
		Client.getFortune(Client.getBalance()+Client.account.getBalance);
	}
	
	public void addClient(Client) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i] == null) {
				clients[i] = Client;
				}
			}
	}
	
	public void removeClient(Client) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i] == Client) {
				clients[i] = null;
				}
			}
	}

	public Client[] getClients() {
		return clients;
	}
	
	public String printString(logs) {
		
	}
	
	public void startAccountUpdater() {
		
	}
	
	public void addCommission(float) {
		this.balance+=deposit.commission;
		this.balance+=withdraw.commission;
	}
	
	public void printClientList() {
		
	}
}
