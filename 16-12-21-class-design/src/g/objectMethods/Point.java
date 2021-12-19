package g.objectMethods;

public class Point {

	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point(" + x + ", " + y + ");";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj; // casting
//		if (this.x == other.x && this.y == other.y) {    // longer way of writing last boolean part of method
//			return true;
//		} else {
//			return false;
//		}
		return this.x == other.x && this.y == other.y;   // shorter way of writing last boolean part of method
	}

}
