package com.jonathanruiz.authentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanruiz.authentication.models.Book;
import com.jonathanruiz.authentication.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	public BookRepository bRepo;
	
	// Get all Books in the database
	public List<Book> all() {
		return bRepo.findAll();
	}
	
	// Create new Book
	public Book create(Book b) {
		return bRepo.save(b);
	}
	
	// Get one Book out of database
	public Book find(Long id) {
		return bRepo.findById(id).orElse(null);
	}
}