package b.ui;

public class Calculator {
	
	// to do - add exceptions
	
	private double res;
	
	public void add(double val) {
//		if (val = String) {
//			throw new CalculatorException("add failed - invalid value");
//		}
		res += val;
	}
	
	public void sub(double val) {
		res -= val;
	}
	
	public void mul(double val) {
		res*= val;
	}

	public void div(double val) {
		res/= val;
	}
	
	public void clear() {
		res = 0;
	}
	
	public double getRes() {
		return res;
	}

}
