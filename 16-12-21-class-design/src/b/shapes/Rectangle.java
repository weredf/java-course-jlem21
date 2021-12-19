package b.shapes;

public class Rectangle extends Shape {
	
	private double length;
	private double width;
	
	// CTOR 1 invokes super class
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}

	// CTOR 2 invokes CTOR 1
	public Rectangle(double length, double width) {
		this("Black", length, width);
		
	}
		
	public Rectangle() {
	}

	@Override
	public double getArea() {
		return length * width;
	}
	
}
