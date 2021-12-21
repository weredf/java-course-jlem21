package e.loops;

public class Demo5For {

	public static void main(String[] args) {
		
		// print all numbers from 101-110 inclusive
		for (int i = 101; i <= 110; i++) {
			System.out.println(i);
		}
		System.out.println("==============");
		
		// print all numbers from 100 - 50 inclusive
		for (int i = 100; i >= 50; i--) {
			System.out.println(i);
		}
		System.out.println("==============");
		
		// print all even numbers from 100 - 200 inclusive
		for (int i = 100; i <= 200; i += 2) {
			System.out.println(i);
		}
		
		System.out.println("==============");
		
//		// print all numbers from 0 - 100 that divide by 7
		for (int i = 0; i <= 100; i+=7) {
			System.out.println(i);
		}
		System.out.println("==============");
		
		// print all characters from A - Z
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c + " - " + (int)c);
		}
		System.out.println("==============");
		
		// print the following using for loop
		// 0 - 10
		// 1 - 9
		// 2 - 8
		// ...
		// 10 - 0
		
		// option 1 - within print
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " - " + (10 - i));
						
		}
		// option 2 - declared separate variable
//		int c = 10;
//		for (int i = 0; i <= 10; i++) {
//			System.out.println(i + " - " + c);
//			c--;
//		}
		// option 3 - declared 2 variables within the same for loop
//		for (int i = 0, j = 10; i <=10; i++, j--) {
//			System.out.println(i + " - " + j);
//		}
			
		
	}

}
