package carfleet.app;

import java.util.Arrays;

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
		for (int i = 0; i < highways.length; i++) {
			if(this.highways[i] == null) {
				this.highways[i] = highway;
				return;
			}
		}
	}
	
	

	@Override
	public String toString() {
		return "Country [highways=" + Arrays.toString(highways) + "]";
	}
}
