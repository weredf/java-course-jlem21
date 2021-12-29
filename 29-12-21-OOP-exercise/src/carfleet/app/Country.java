package carfleet.app;

public class Country {

	Highway[] highways = new Highway[5];

	public Country() {
		super();
	}

	public Country(Highway[] highways) {
		super();
		this.highways = highways;
	}
	

	public Highway[] getHighways() {
		return highways;
	}

	public void setHighways(Highway[] highways) {
		this.highways = highways;
	}

	public void addHighways(Highway highway) {
		
	}

	public void showCountry() {
		System.out.println("==============================");
		System.out.println("Country: ");
		System.out.println("Highways: ");
		for (int i = 0; i<highways.length; i++) {
			System.out.println(highways[i].getName());
		}
		System.out.println("==============================");
	}
	
}
