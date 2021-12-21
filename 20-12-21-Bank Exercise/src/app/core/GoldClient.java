package app.core;

public class GoldClient extends Client{

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
	}
	
	float commissionRate = 0.02F;
	float interestRate = 0.003F;
	
}
