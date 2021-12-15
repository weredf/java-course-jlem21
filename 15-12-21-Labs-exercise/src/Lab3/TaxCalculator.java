package Lab3;

public class TaxCalculator {

	public static void main(String[] args) {
		int salBefore = (int) (Math.random() * 100_001) + 5000;
		int tax = 0;
		int salAfter = 0;
		System.out.println("Salary before tax: " + salBefore);
		
		// flat tax rate in each tax box
		if (salBefore<=23_000) {
			tax = (int)(salBefore*0.1);
			salAfter = (int)(salBefore-tax);
		}else if (salBefore<=50_000) {
			tax = (int)(salBefore*0.2);			
			salAfter = (int)(salBefore-tax);
		}else if (salBefore<=100_000) {
			tax = (int)(salBefore*0.3);			
			salAfter = (int)(salBefore-tax);
		}else {
			tax = (int)(salBefore*0.4);			
			salAfter = (int)(salBefore-tax);
		}
		System.out.println("Tax amount: " + tax);
		System.out.println("Salary after tax: " + salAfter);
	}

}
