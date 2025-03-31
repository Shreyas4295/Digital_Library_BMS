package com.example.bms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bms.dto.BookRequest;
import com.example.bms.dto.BookResponse;
import com.example.bms.service.BookService;
import com.example.bms.util.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/books")
@Validated
public class BookController {
	
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseStructure<BookResponse>> addBook(@RequestBody  @Valid BookRequest book) {
		return bookService.addBook(book);
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<ResponseStructure<List<BookResponse>>> viewAllBooks() {
		return bookService.viewAllBooks();
	}
	
	@GetMapping("/find/id/{bookId}")
	public ResponseEntity<ResponseStructure<BookResponse>> findBookById(@PathVariable("bookId") int bookId) {
		return bookService.findBookById(bookId);
	}
	
	@GetMapping("/find/title/{title}")
	public ResponseEntity<ResponseStructure<BookResponse>> findBookByTitle(@PathVariable("title") String title) {
		return bookService.findBookByTitle(title);
	}
	
	@PutMapping(value = "/update/{bookId}")
	public ResponseEntity<ResponseStructure<BookResponse>> updateBook(@PathVariable("bookId") int bookId, @RequestBody @Valid BookRequest bookRequest) {
		return bookService.updateBook(bookId, bookRequest);
	}
	
	@DeleteMapping(value = "/delete/{bookId}")
	public ResponseEntity<ResponseStructure<BookResponse>> deleteBook(@PathVariable("bookId") int bookId) {
		return bookService.deleteBook(bookId);
	}
	 
}
