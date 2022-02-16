package app.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repositories.BookRepo;
import app.core.repositories.LibraryRepo;

@Service
@Transactional
public class LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;
	@Autowired
	private BookRepo bookRepo;
	
	public int addLibrary(Library library) {
//		Optional<Library> opt = this.libraryRepo.findById(library.getId());
//		if (opt.isEmpty()) {
			library = this.libraryRepo.save(library);
			return library.getId();
//		} else {
//			throw new RuntimeException("addLibrary failed - library id " + library.getId() + " already exists");
//		}
	}
	
	public int addBook(Book book) {
//		Optional<Book> opt = this.bookRepo.findById(book.getId());
//		if (opt.isEmpty()) {
			book = this.bookRepo.save(book);
			return book.getId();
//		} else {
//			throw new RuntimeException("addBook failed - book id " + book.getId() + " already exists");
//		}
	}
	
	public void addBookToLibrary(Book book, int libraryId) {
		/*
		Optional<Book> optB = this.bookRepo.findById(bookId);
		if (optB.isPresent()) {
			Optional<Library> optL = this.libraryRepo.findById(libraryId);
			if (optL.isPresent()) {
				Library library = optL.get();
//				List<Book> books = library.getBooks();
//				books.add(optB.get());
//				library.setBooks(books);
				library.addBook(optB.get());
			} else {
				throw new RuntimeException("addBookToLibrary failed - library id " + libraryId + " doesn't exist");
			}
		} else {
			throw new RuntimeException("addBookToLibrary failed - book id " + bookId + " doesn't exist");
		}
		*/
		Library library = this.libraryRepo.findById(libraryId).orElseThrow();
		library.addBook(book);
	}
	
	public List<Book> getAllBooksInLibrary(int libraryId) {
		/*
		Optional<Library> opt = this.libraryRepo.findById(libraryId);
		if (opt.isPresent()) {
			List<Book> books = new ArrayList<>(opt.get().getBooks());
			return books;
		} else {
			throw new RuntimeException("getAllBooksInLibrary failed - library id " + libraryId + " doesn't exist");
		}
		*/
		return this.bookRepo.findByLibraryId(libraryId);
	}
	
	public Book findBook(int bookId) {
		/*
		Optional<Book> opt = this.bookRepo.findById(bookId);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("findBook failed - book id " + bookId + " not found");
		}
		*/
		return this.bookRepo.findById(bookId).orElseThrow();
	}
}
