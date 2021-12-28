package c;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTextToFileWithPrinter {

	public static void main(String[] args) {
		File directory = new File("c:/Wered/temp/a/b"); // folders to use/create
		if(!directory.exists()) { // if file doesn't exist
//			directory.mkdir(); // creates last folder of path
			directory.mkdirs(); // creates all missing folders
		}
		// destination file
		File file = new File(directory, "/file2.txt");
		
		// create object that can write text to file
		// use print writer so int & double can be printed easily
		try (PrintWriter out = new PrintWriter(new FileWriter(file, false));){ // boolean append, false clears file first
			out.println("this is the first line");
			out.println(8);
			out.println(8.3);
			
			System.out.println("text written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
