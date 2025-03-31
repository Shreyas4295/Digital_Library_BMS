package com.example.bms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bms.dto.BookRequest;
import com.example.bms.dto.BookResponse;
import com.example.bms.exception.BookNotFoundByIdException;
import com.example.bms.model.Book;
import com.example.bms.repo.BookRepository;
import com.example.bms.service.BookService;
import com.example.bms.util.ResponseStructure;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	private ResponseStructure<BookResponse> bookStructure;
	private ResponseStructure<List<BookResponse>> bookListStructure;
	
	

	private Book mapToBookEntity(BookRequest book) {
		return Book.builder()
		    .author(book.getAuthor())
		    .genre(book.getGenre())
		    .status(book.getStatus())
		    .title(book.getTitle()).build();
	}
	
	private BookResponse mapToBookResponse(Book book) {
		return BookResponse.builder()
				           .author(book.getAuthor())
				           .bookId(book.getBookId())
				           .genre(book.getGenre())
				           .status(book.getStatus())
				           .title(book.getTitle())
				           .build();
	}
	
	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> addBook(BookRequest book) {
		Book savedBook = bookRepository.save(mapToBookEntity(book));
		return new ResponseEntity<ResponseStructure<BookResponse>>(bookStructure.setBody(mapToBookResponse(savedBook))
				                                  .setMessage("Book saved successfully")
				                                  .setStatusCode(HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<BookResponse>>> viewAllBooks() {
		List<Book> bookList = bookRepository.findAll();
		List<BookResponse> bookResponseList = new ArrayList<>();
		for(Book book : bookList) {
			bookResponseList.add(mapToBookResponse(book));
		}
		return new ResponseEntity<ResponseStructure<List<BookResponse>>>(bookListStructure.setBody(bookResponseList)
				                                  .setMessage("Books fetched successfully")
				                                  .setStatusCode(HttpStatus.OK.value()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> findBookById(int bookId) {
		return bookRepository.findById(bookId)
				             .map(book -> {
				            	 return ResponseEntity.ok(bookStructure.setBody(mapToBookResponse(book))
					                                                   .setMessage("Book fetched successfully by id")
					                                                   .setStatusCode(HttpStatus.OK.value()));
				            	 }).orElseThrow(() -> new BookNotFoundByIdException("Book not found by id"));
		
	}
	
	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> findBookByTitle(String title) {
		return bookRepository.findByTitle(title)
				             .map(book -> {
				            	 return ResponseEntity.ok(bookStructure.setBody(mapToBookResponse(book))
					                                                   .setMessage("Book fetched successfully by title")
					                                                   .setStatusCode(HttpStatus.OK.value()));
				            	 }).orElseThrow(() -> new BookNotFoundByIdException("Book not found by title"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> updateBook(int bookId,BookRequest bookRequest) {
		return bookRepository.findById(bookId)
				             .map(book -> {
				            	 Book updatedBook = mapToBookEntity(bookRequest);
				            	 updatedBook.setBookId(bookId);
				            	 Book newBook = bookRepository.save(updatedBook);
				            	 
				            	 return ResponseEntity.ok(bookStructure.setBody(mapToBookResponse(newBook))
				            			                               .setMessage("Book updated successfully")
				            			                               .setStatusCode(HttpStatus.OK.value()));
			
		                      }).orElseThrow(() -> new BookNotFoundByIdException("Book not found by id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<BookResponse>> deleteBook(int bookId) {
		return bookRepository.findById(bookId)
				             .map(book -> {
				            	 bookRepository.delete(book);
				            	 
				            	 return ResponseEntity.ok(bookStructure.setBody(mapToBookResponse(book))
				            			                               .setMessage("Book is deleted successfully")
				            			                               .setStatusCode(HttpStatus.OK.value()));
				             }).orElseThrow(()-> new BookNotFoundByIdException("Book id is not present"));
	}
	
	

}
