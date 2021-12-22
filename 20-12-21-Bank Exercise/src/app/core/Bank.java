package app.core;

import java.util.Arrays;

public class Bank {
	
	Client[] clients = new Client[100];
	private float balance; // bank monies from charged commissions
//	accountUpdater;
	Logger logger;
	
	private Bank() {
		super();
		Client[] clients = new Client[100];
		Log log = new Log(0, 0, null, balance);
		logger.log(log);
		System.out.println(log.getData());
	}
	
	private static Bank instance = new Bank();
	
	public static Bank getInstance() {
		return instance;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public float getTotalFortune() {
		float totalFortune = 0;
		for (int i = 0; i < clients.length; i++) {
			totalFortune += clients[i].getFortune();		
		}
		return totalFortune;
	}
	
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i] == null) {
				clients[i] = client;
				Log log = new Log(System.currentTimeMillis(), clients[i].getId(), "client added", clients[i].getBalance());
				logger.log(log);
				System.out.println(log.getData());
				}
			}
	}
	
	public void removeClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if(clients[i] == client) {
				Log log = new Log(System.currentTimeMillis(), clients[i].getId(), "client removed", clients[i].getBalance());
				logger.log(log);
				clients[i] = null;
				System.out.println(log.getData());
				}
			}
	}

	public Client[] getClients() {
		return clients;
	}
	
	public Log viewLogs() {
		// print all logs that are stored in the logger
	}
	
	public void startAccountUpdater() {
		
	}
	
	public void addCommission(float) {
//		for (Log.getLogs(); description == withdraw;) {
//			balance+=withdraw.commission;			
//		}
	}
	
	public void printClientList() {
		System.out.println(Arrays.toString(clients));
	}
}
