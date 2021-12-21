package e.loops;

import java.util.Scanner;

public class Demo6For7Boom {

	public static void main(String[] args) {
		// input 2 numbers
		Scanner sc = new Scanner(System.in);
		System.out.print("enter 1st number: ");
		int a = sc.nextInt();
		System.out.print("enter 2nd number: ");
		int b = sc.nextInt();
		sc.close(); // close the scanner (save system resources)
		// make sure a is smaller
		if(a>b) {
			int temp = a;
			a = b;
			b = temp;
		}
		// print a and b
		System.out.println(a + " - " + b);
		
		while(a < b) {
			if(a % 7 == 0) {
				System.out.println("BOOM");
			}else for(int i = a; (int)a%10 == 7; a++) {
				System.out.println("BOOM");
				i = (int)a/10;
			}
			System.out.println(a);
			a++;
		}
		while(b % 7 ==0) {
			if(a % 7 == 0) {
				System.out.println("BOOM");
			}else for(int i = b; (int)b%10 == 7; b++) {
			System.out.println("BOOM");
			i = (int)b/10;
			}
		}
		System.out.println(b);
	}

}
