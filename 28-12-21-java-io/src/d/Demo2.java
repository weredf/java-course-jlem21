package d;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) {

		// 1. define a file to read from
		File file = new File("files/primitives.data");

		// 2. create a DataInputStream object
		try (DataInputStream in = new DataInputStream(new FileInputStream(file));){
			// 3. read the data - different formats
			System.out.println("int n1: " + in.readInt());
			System.out.println("byte n2: " + in.readByte());
			System.out.println("double n3: " + in.readDouble());
			System.out.println("long n4: " + in.readLong());
			System.out.println("boolean b: " + in.readBoolean()); // have to read in the same order as written in Demo1!
		} catch (IOException e) {
			throw new RuntimeException("getStoredResult failed");
		}
	}

}
