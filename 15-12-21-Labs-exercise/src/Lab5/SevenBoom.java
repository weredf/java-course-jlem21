package Lab5;

public class SevenBoom {

	public static void main(String[] args) {
		
		int num = (int)(Math.random()*100)+1;
		
		if(num % 7 == 0) {
		System.out.println("BOOM");
		}else if (num%10 == 7) {
			System.out.println("BOOM");
		}else {
			System.out.println(num);
		}
									
	}

}
