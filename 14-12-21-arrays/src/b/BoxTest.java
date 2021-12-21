package b;

public class BoxTest {

	public static void main(String[] args) {
		
		Box b1 = new Box(100, 20, 5);
		System.out.println("length: " + b1.getLength());
		System.out.println("width: " + b1.getWidth());
		System.out.println("heigth: " + b1.getHeight());
		System.out.println("============");
		
		// declaration of new array of Box elements
		Box[] boxArr = new Box[2];
		// populate array with 2 Box objects - dynamic initialization
		boxArr[0] = new Box(1, 1, 1);
		boxArr[1] = new Box(2, 3, 4);
		
		// use the boxes from the array with a new reference
		Box b = boxArr[0];
		System.out.println(b.getLength());

		// use the boxes from the array directly
		System.out.println(boxArr[0].getLength());
		System.out.println("============");
		System.out.println(boxArr.length);

	}

}
