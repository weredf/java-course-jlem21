package b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileBuffered {

	public static void main(String[] args) {
		
		try (BufferedReader in = new BufferedReader(new FileReader(new File("c:/Wered/temp/File1.txt")));) {
			String line = in.readLine(); // reads whole line instead of just one character
			while (line!=null) { // reads whole document until no more lines of text
				System.out.println(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
