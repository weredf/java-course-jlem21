package e;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectToFile {

	public static void main(String[] args) {

		Person p = new Person(102, "Lea Cohen", 54, "45 Agrippas st. Jerusalem"); // class needs to implement Serializable
		File file = new File("files/person.obj");
		// object serialization
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));){
			out.writeObject(p);
			System.out.println("object written");
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
