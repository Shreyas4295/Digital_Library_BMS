package com.example.bms.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookNotFoundByIdException extends RuntimeException {
	private String message;

}
