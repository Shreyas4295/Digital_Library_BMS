package com.example.bms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bms.exception.BookNotFoundByIdException;
import com.example.bms.exception.BookNotFoundByTitleException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class AppExceptionHandler {
	
	private ErrorStructure<String> errorStructure;
	
	@ExceptionHandler
	private ResponseEntity<ErrorStructure<String>> handleBookNotFoundById(BookNotFoundByIdException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(errorStructure.setMessage(e.getMessage())
				                                 .setRootCause("Book is not present in library")
				                                 .setStatus(HttpStatus.NOT_FOUND.value()));  
	}
	
	@ExceptionHandler
	private ResponseEntity<ErrorStructure<String>> handleBookNotFoundByTitle(BookNotFoundByTitleException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(errorStructure.setMessage(e.getMessage())
				                                 .setRootCause("Book is not present in library")
				                                 .setStatus(HttpStatus.NOT_FOUND.value()));  
	}
	
	@ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorStructure.setMessage("An unexpected error occurred")
                .setRootCause(e.getMessage())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
	
	

}
