package com.example.bms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bms.model.Book;

import jakarta.validation.Valid;

public interface BookRepository extends JpaRepository<Book, Integer>{

	Optional<Book> findByTitle(String title);
	
}
