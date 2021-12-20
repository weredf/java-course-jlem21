package d.enums;

public class Test {
	
	public static void main(String[] args) {
		Color c1 = Color.GREEN;
		System.out.println(c1);
		System.out.println(c1.ordinal());	
		System.out.println("===============");
		
		Color[] colors = Color.values();
		for (Color color : colors) {
			System.out.println(color);
		}
		
	}

}
