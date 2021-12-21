package app.core.exceptions;

public class WithdrawException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	int clientId;
	float currentBalance;
	float withdrawAmount;
	
	public WithdrawException(String message, int clientId, float currentBalance, float withdrawAmount) {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public float getWithdrawAmount() {
		return withdrawAmount;
	}
	
}
