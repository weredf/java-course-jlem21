package b.shapes;

public class Shape {

	private String color;
	
	public Shape(String color) {
		this.color = color;
	}
	
	public Shape() {
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return -1;		// -1 indicates impossible value purposefully
	}

	

}
