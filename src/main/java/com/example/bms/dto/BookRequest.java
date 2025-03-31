package com.example.bms.dto;


import com.example.bms.enums.AvailabilityStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	private String genre;
	@NotNull
	private AvailabilityStatus status;
}
