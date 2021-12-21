package g.random;

public class Demo1 {

	public static void main(String[] args) {
		
	int r1 = (int) (Math.random() * 11); // 0 - 10 don't forget (int), random = double
	int r2 = (int) (Math.random() * 11) + 10; // 10 - 20

	
	int a = 10;
	int b = 20;
	int r3 = (int) (Math.random() * (b - a + 1) + a); // 10 - 20
	double r4 = (Math.random() * ((b - a) + 1) + a); // 10 - 20
	
	System.out.println(r1);
	System.out.println(r2);
	System.out.println(r3);
	System.out.println(r4);
	
	int x = (int) (Math.random() * 6) + 7; // 7 - 12
	System.out.println(x);

	int y = (int) (Math.random() * 3) + 23; // 23 - 25
	System.out.println(y);
	}
}
