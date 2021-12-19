package g.objectMethods;

public class TestPoint1 {

	public static void main(String[] args) {

		Point p1 = new Point(3, 5);
		Point p2 = new Point(3, 5);
//		p1 = null;
//		System.out.println(p1.toString());
		System.out.println(p1); // the toString will be printed
		
		System.out.println(p1 == p2); // 2 different points with same value still have different hashcodes
		System.out.println(p1.equals(p2));
	}

}
