package app.core;

public class RegularClient extends Client{

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
	}
	
	float commissionRate = 0.03F;
	float interestRate = 0.001F;

}
