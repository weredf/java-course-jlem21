package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Book;
import app.core.services.BookService;

@RestController
@RequestMapping("/book") // http://localhost:8080/book
public class BookController {

	@Autowired
	private BookService bookService;

	// Post (create)
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public int addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	// Get (read)
	// http://localhost:8080/book?bookId=125 // request parameter
	// http://localhost:8080/book/125 // path variable
	@GetMapping(path = "/{bookId}", produces = {"application/json", "application/xml"}) // or MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	public ResponseEntity<?> getBook(@PathVariable int bookId) {
//		return bookService.getBook(bookId);
		try {
			Book book = bookService.getBook(bookId);
			ResponseEntity<?> re = new ResponseEntity<>(book, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			ResponseEntity<?> re = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			return re;
		}
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAllBooks() {
		try {
			List<Book> books = bookService.getAllBooks();
			ResponseEntity<?> re = new ResponseEntity<>(books, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			ResponseEntity<?> re = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			return re;
		}
//		return bookService.getAllBooks();
	}
	
	// Put (update)
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		try {
			bookService.updateBook(book);
			return ResponseEntity.ok("book updated: " + book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	// Delete
	@DeleteMapping
	public ResponseEntity<?> deleteBook(@RequestParam int bookId) { // @RequestParam is a question mark (?)
		try {
			bookService.deleteBook(bookId);
			return ResponseEntity.ok("book deleted: " + bookId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
