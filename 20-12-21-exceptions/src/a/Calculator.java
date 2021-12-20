package a;

public class Calculator {
	
	public int div(int a, int b) {
		if(b != 0) {
			// return - all is good
			return a/b;
		}else {
			// throw - something went wrong
			RuntimeException e = new RuntimeException("error");
			throw e;
		}
	}

}
