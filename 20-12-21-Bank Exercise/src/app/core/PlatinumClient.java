package app.core;

public class PlatinumClient extends Client{

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
	}
	
	float commissionRate = 0.01F;
	float interestRate = 0.005F;
	
	
	
}
