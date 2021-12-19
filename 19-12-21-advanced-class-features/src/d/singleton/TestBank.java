package d.singleton;

public class TestBank {

	public static void main(String[] args) {
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		Bank bank3 = Bank.getInstance(); // all of them will refer to the same instance
		
		bank1.addCustomer();
		bank1.addCustomer();
		bank1.addCustomer();

		bank2.removeCustomer();
		
		System.out.println(bank3.getNumberOfCustomers());
	}

}
