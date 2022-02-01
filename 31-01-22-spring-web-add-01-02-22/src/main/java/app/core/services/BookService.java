package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.repos.BookRepo;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	// Create
	public int addBook(Book book) {
		return bookRepo.save(book).getId();
	}
	
	// Read
	public Book getBook(int bookId) throws RuntimeException {
		Optional<Book> opt = bookRepo.findById(bookId);
		if(opt.isPresent()) { 
			return opt.get();
		}else {
			throw new RuntimeException("getBook failed - not found");
		}
	}

	public List<Book> getAllBooks() {
		Optional<List<Book>> opt = Optional.of(bookRepo.findAll());
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("getAllBooks failed - not found");
		}
//		return bookRepo.findAll();
	}
	
	// Update
	public void updateBook(Book book) {
		if(bookRepo.existsById(book.getId())) {
			bookRepo.save(book);
		} else {
			throw new RuntimeException("updateBook failed - book id " + book.getId() + " not found");
		}
	}
	
	// Delete
	public void deleteBook(int bookId) {
		if(bookRepo.existsById(bookId)) {
			bookRepo.deleteById(bookId);
		} else {
			throw new RuntimeException("deleteBook failed - book id " + bookId + " not found");
		}
	}
}
