package com.example.bms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.bms.dto.BookRequest;
import com.example.bms.dto.BookResponse;
import com.example.bms.util.ResponseStructure;


public interface BookService {

	public ResponseEntity<ResponseStructure<BookResponse>> addBook(BookRequest book);
	
	public ResponseEntity<ResponseStructure<List<BookResponse>>> viewAllBooks();
	
	public ResponseEntity<ResponseStructure<BookResponse>> findBookById(int bookId);

	public ResponseEntity<ResponseStructure<BookResponse>> findBookByTitle(String title);

	public ResponseEntity<ResponseStructure<BookResponse>> updateBook(int bookId,BookRequest book);

	public ResponseEntity<ResponseStructure<BookResponse>> deleteBook(int bookId);
}
