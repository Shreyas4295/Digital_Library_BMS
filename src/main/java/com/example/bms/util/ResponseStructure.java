package com.example.bms.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ResponseStructure<T> {
	private String message;
	private int statusCode;
	private T body;
	
	public ResponseStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseStructure<T> setBody(T body) {
		this.body = body;
		return this;
	}
}
