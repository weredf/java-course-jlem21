package bank;

public class Log {
	
	private long timestamp;
	private int clientID;
	private String description;
	private float amount;
	
	public Log(long timestamp, int clientID, String description, float amount) {
		super();
		this.timestamp = timestamp;
		this.clientID = clientID;
		this.description = description;
		this.amount = amount;
	}
	
	public void getData() {
		return;
	}

}
