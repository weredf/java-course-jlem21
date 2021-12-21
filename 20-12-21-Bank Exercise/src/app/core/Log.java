package app.core;

public class Log {
	
	private long timestamp = 0;
	private int clientID = 0;
	private String description = "a";
	private float amount = 0;
	
	public Log(long timestamp, int clientID, String description, float amount) {
		super();
		this.timestamp = timestamp;
		this.clientID = clientID;
		this.description = description;
		this.amount = amount;
	}

	public String getData() {
		return "Log [timestamp=" + timestamp + ", clientID=" + clientID + ", description=" + description + ", amount="
				+ amount + "]";
	}
	
	

}
