package c.lines;

public class WLine extends Line{
	
	private int width;

	public WLine(int length, int width) {
		super(length);
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	// print with super referring to print in superclass (or version in notes with nested loop)
	@Override
	public void print() {
		System.out.println();
		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < getLength(); j++) {
//				System.out.print("*");		
//				}
			super.print();
//			System.out.println();		
		}
	}

}
