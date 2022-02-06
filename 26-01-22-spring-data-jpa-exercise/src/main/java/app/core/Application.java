package app.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.service.LibraryService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		LibraryService service = ctx.getBean(LibraryService.class);
		
		Library library1 = new Library(0, "Library1", "Jerusalem", null);
		Library library2 = new Library(0, "Library2", "Tel Aviv", null);
		
		List<Book> books = new ArrayList<>();
		for (int i = 1; i <=10; i++) {
			LocalDate date = LocalDate.of(2021, (int) (Math.random() *12)+1, i);
			Book book = new Book(0, "Book"+i, "Writer"+i, date, null);
			books.add(book);
		}

		for (Book book : books) {
			library1.addBook(book);
			library2.addBook(book);
		}
			
		// only save to database after having created complete objects (added books to libraries etc)
		service.addLibrary(library1);
		service.addLibrary(library2);

		System.out.println(library1.getName());
		System.out.println(service.getAllBooksInLibrary(library1.getId()));
		System.out.println(library2.getName());
		System.out.println(service.getAllBooksInLibrary(library2.getId()));
	}

}
