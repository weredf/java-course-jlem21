package b.shapes;

public class Test {

	public static void main(String[] args) {
		// both circle and rectangle are subclasses of shape, could go in an array of shapes
		Shape shape = new Shape(); 
		shape.setColor("Red");
		
		System.out.println(shape.getColor());
		
		shape.setColor("Blue");
		System.out.println(shape.getColor());
		
		shape = new Rectangle("Yellow", 2, 3);
		System.out.println("Rectangle color: " + shape.getColor());
		System.out.println("Rectangle area: " + shape.getArea());
		
		shape = new Circle("Purple", 2);
		System.out.println("Circle: " + shape.getColor() + ", " + shape.getArea());

		// if no values set for area, get -1
//		System.out.println("area: " + shape.getArea());
	}

}
