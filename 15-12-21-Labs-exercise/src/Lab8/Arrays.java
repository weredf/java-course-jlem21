package Lab8;

public class Arrays {

	public static void main(String[] args) {
		int[] random = new int[10];
		random[0] = (int)(Math.random()*101);
		random[1] = (int)(Math.random()*101);
		random[2] = (int)(Math.random()*101);
		random[3] = (int)(Math.random()*101);
		random[4] = (int)(Math.random()*101);
		random[5] = (int)(Math.random()*101);
		random[6] = (int)(Math.random()*101);
		random[7] = (int)(Math.random()*101);
		random[8] = (int)(Math.random()*101);
		random[9] = (int)(Math.random()*101);
		
		// print all elements on new line
		System.out.println(random[0]);
		System.out.println(random[1]);
		System.out.println(random[2]);
		System.out.println(random[3]);
		System.out.println(random[4]);
		System.out.println(random[5]);
		System.out.println(random[6]);
		System.out.println(random[7]);
		System.out.println(random[8]);
		System.out.println(random[9]);
		
		// print all elements on new line
		System.out.println(random[0] +", " + random[1]+", " + random[2]);
		
	}

}
