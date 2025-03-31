package com.example.bms.dto;


import com.example.bms.enums.AvailabilityStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookResponse {
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private AvailabilityStatus status;
}
