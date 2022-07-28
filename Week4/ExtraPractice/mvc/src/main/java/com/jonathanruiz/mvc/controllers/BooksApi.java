package com.jonathanruiz.mvc.controllers;



import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanruiz.mvc.models.Book;
import com.jonathanruiz.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@Valid @PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="numberOfPages") Integer numOfPages) {
		Book bookToUpdate = bookService.findBook(id);
		bookToUpdate.setTitle(title);
		bookToUpdate.setDescription(desc);
		bookToUpdate.setLanguage(lang);
		bookToUpdate.setNumberOfPages(numOfPages);
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
	
}
