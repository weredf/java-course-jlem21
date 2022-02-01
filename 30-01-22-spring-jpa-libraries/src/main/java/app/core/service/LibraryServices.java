package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.entities.Library;

@Service
@Transactional
public class LibraryServices extends MyService{

	// the repositories are defined in the super class

	public int addLibrary(Library library) {
		if(!this.libraryRepo.existsById(library.getId())) { // exist check because save will also update
			library = this.libraryRepo.save(library);
			return library.getId();
		} else {
			throw new RuntimeException("addLibrary failed - library id " + library.getId() + " already exists");
		}
	}
	
	public int addBook(Book book) {
		if(!this.bookRepo.existsById(book.getId())) { // exist check because save will also update
			book = this.bookRepo.save(book);
			return book.getId();
		} else {
			throw new RuntimeException("addBook failed - book id " + book.getId() + " already exists");
		}
	}
	
	public void addBookToLibrary(Book book, int libraryId) {
		if (this.libraryRepo.existsById(libraryId) && !this.bookRepo.existsById(book.getId())) {
			Library library = this.libraryRepo.findById(libraryId).get();
			library.addBook(book);
		} else {
			throw new RuntimeException("addBookToLibrary failed - library id " + libraryId + " doesn't exist or book already exists");
		}
	}
	
	public List<Book> getAllBooksOfLibrary(int libraryId) {
		return this.bookRepo.findByLibraryId(libraryId);
	}
	
	public void updateLibrary(Library library) {
		Optional<Library> opt = libraryRepo.findById(library.getId());
		if (opt.isPresent()) {
			Library libraryFromDb = opt.get();
			libraryFromDb.setName(library.getName());
			libraryFromDb.setAddress(library.getAddress());
		} else {
			throw new RuntimeException("updateLibrary failed - library id " + library.getId() + " doesn't exist");
		}
	}
	
	public void updateBook(Book book) {
		if(this.bookRepo.existsById(book.getId())) {
			Book bookFromDb = bookRepo.findById(book.getId()).get(); // immediate get of optional because in the if loop already checked that exists
			bookFromDb.setTitle(book.getTitle());
			bookFromDb.setPublication(book.getPublication());
		} else {
			throw new RuntimeException("updateBook failed - book id " + book.getId() + " doesn't exist");
		}
	}
	
	public Optional<Book> findBookById(int bookId) {
		return bookRepo.findById(bookId);
	}
	
	public Library findLibraryByName(String LibraryName) {
		Library library = libraryRepo.findByName(LibraryName);
		if (library != null) {
			return library;
		} else {
			throw new RuntimeException("findLibraryByName failed, not found");
		}
	}
	
	public List<Book> getAllBooksPublishedBefore(LocalDate date) {
		return bookRepo.findByPublicationBefore(date);
	}
	
	public List<Book> getAllBooksPublishedAfter(LocalDate date) {
		return bookRepo.findByPublicationAfter(date);
	}
	
	public List<Book> getAllBooksPublishedBetween(LocalDate date1, LocalDate date2) {
		return bookRepo.findByPublicationBetweenOrderByPublication(date1, date2);
	}
	
	public List<Book> getBooksByAuthorStartingWith(char prefix) {
		return bookRepo.findByAuthorStartingWith(prefix);
	}
}
