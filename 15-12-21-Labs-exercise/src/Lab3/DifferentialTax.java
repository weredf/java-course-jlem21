package Lab3;

public class DifferentialTax {

	public static void main(String[] args) {
		int salBefore = (int) (Math.random() * 100_001) + 5000;
		int tax = 0;
		int salAfter = 0;
		int taxBox1 = 23_000;
		int taxBox2 = 50_000;
		int taxBox3 = 100_000;
		double taxRate1 = 0.1;
		double taxRate2 = 0.2;
		double taxRate3 = 0.3;
		double taxRate4 = 0.4;
		// by creating definitions their values can be adjusted and the rest of the code will still work
		
		System.out.println("Salary before tax: " + salBefore);
		if (salBefore<=taxBox1) {
			tax = (int)(salBefore*taxRate1);
			salAfter = (int)(salBefore-tax);
		}else if (salBefore<=taxBox2) {
			tax = ((int)(taxBox1*taxRate1))+((int)((salBefore-taxBox1)*taxRate2));
			salAfter = (int)(salBefore-tax);
		}else if (salBefore<=taxBox3) {
			tax = ((int)(taxBox1*taxRate1))+((int)((taxBox2-taxBox1)*taxRate2))+((int)((salBefore-taxBox2)*taxRate3));
			salAfter = (int)(salBefore-tax);
		}else {
			tax = ((int)(taxBox1*taxRate1))+((int)((taxBox2-taxBox1)*taxRate2))+((int)((taxBox3-taxBox2)*taxRate3))+((int)((salBefore-taxBox3)*taxRate4));			
			salAfter = (int)(salBefore-tax);
		}
		System.out.println("Tax amount: " + tax);
		System.out.println("Salary after tax: " + salAfter);
	}

}
