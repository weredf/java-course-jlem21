package c.lines;

public class Test {

	public static void main(String[] args) {

		Line line = new Line(5);
		System.out.println(line.getLength());
		line.print();
		
		line.setLength(10);
		System.out.println(line.getLength());
		line.print();
		
		WLine wline = new WLine(4,5);
		System.out.println(wline.getLength() + ", " + wline.getWidth());
		wline.print();
	}

}
