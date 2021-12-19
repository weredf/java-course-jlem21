package lab1;

public class Big {

	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 101);
		int num2 = (int) (Math.random() * 101);
		
		if (num1>num2) {
			System.out.println(num1);				
		}else {
			System.out.println(num2);
		}
	}

}
