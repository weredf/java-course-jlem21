package a;

import java.util.Arrays;

public class Shape {
	
	private String color;
	
	public static final String[] COLORS = {"BLACK", "RED", "GREEN", "BLUE"};

	public Shape(String color) {
		super();
		this.color = color;
	}

	public Shape() {
		this("BLACK");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		for(int i = 0; i<COLORS.length; i++) {
			if(color.equals(COLORS[i])) {
				this.color = color;
				return;				
			}
			System.out.println(color + " is not valid. Valid values are: " + Arrays.toString(COLORS));
		}
	}
	
}
