package carfleet.app;

import java.util.Arrays;

public class Country {

	public static final int MAX = 5;
	Highway[] highways = new Highway[MAX];

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
			if (this.highways[i] == null) {
				this.highways[i] = highway;
				return;
			}
		}
	}

	public int getNumberOfCars() {
		int c = 0;
		for (Highway highway : highways) {
			if (highway != null) {
				c += highway.getNumberOfCars();
			}
		}
		return c;
	}

	@Override
	public String toString() {
		return "Country [highways=" + Arrays.toString(highways) + "]";
	}
}
