package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.service.LibraryServices;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		LibraryServices service = ctx.getBean(LibraryServices.class);

//		Library library = new Library(0, "AAA", "Jerusalem", null);
//		Book book = new Book(0, "aaa", "Aa", LocalDate.of(2020, 1, 1), null);

//		service.addLibrary(library);
//		service.addBook(book);
		/*
		 * Optional<Book> opt = service.findBookById(1);
		 * 
		 * if(opt.isPresent()) { Book book = opt.get(); System.out.println(opt);
		 * System.out.println(book); } else { System.out.println("book not found"); }
		 */

		// create libraries
		Library lib1 = new Library(0, "Jerusalem Library", "Jerusalem", null);
		Library lib2 = new Library(0, "Tel Aviv Library", "Tel Aviv", null);
		Library lib3 = new Library(0, "Haifa Library", "Haifa", null);
		Library[] libraries = { lib1, lib2, lib3 };

		String[] authors = { "Yael", "Mark", "Ruthi", "Nur", "Lenny" };

		// create books
		for (int i = 1; i <= 50; i++) {
//			String author = authors[(int) (Math.random()*authors.length)];
			int year = (int) (Math.random() * 21) + 2000;
			LocalDate publication = LocalDate.of(year, 1, 1);
			Book book = new Book(0, "book" + i, authors[i % authors.length], publication, null);
			// add book to library
			libraries[i % libraries.length].addBook(book);
		}

		// save libraries
		for (Library lib : libraries) {
			service.addLibrary(lib);
		}
	}

}
