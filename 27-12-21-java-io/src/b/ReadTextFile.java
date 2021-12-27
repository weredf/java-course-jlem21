package b;

import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main(String[] args) {
		
		try (FileReader in = new FileReader("c:/Wered/temp/File1.txt");){ // ARM close reader
			int c = in.read(); // reads first letter of text file as unicode number
			while (c!=-1) {
				System.out.print((char)c); // cast as character
				c= in.read(); // read the next character
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
