package com.jonathanruiz.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jonathanruiz.authentication.models.Book;
import com.jonathanruiz.authentication.models.User;
import com.jonathanruiz.authentication.services.BookService;
import com.jonathanruiz.authentication.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books")
	public String welcome(Model model, HttpSession session) {

		model.addAttribute("books", bookServ.all());
    	model.addAttribute("user", userServ.find((Long)session.getAttribute("userId")));
		return "books.jsp";
	}
	
	@GetMapping("/books/new")
	public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	
    	User user = userServ.find((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
		return "addBook.jsp";
	}
	
	@PostMapping("/books/create")
 	public String create(
 			@Valid @ModelAttribute("book")Book book,
 			BindingResult result)
 	{
 		if(result.hasErrors()) {
 			return "addBook.jsp";
 		}
 		bookServ.create(book);
 		return "redirect:/books";
 	}
	
	@GetMapping("/books/{id}")
	public String find(@PathVariable("id") Long id, Model model) {
		Book bookItem = bookServ.find(id);
		model.addAttribute("bookItem", bookItem);
		return "bookDetails.jsp";
	}
}
