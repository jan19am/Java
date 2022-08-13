package com.jonathanruiz.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanruiz.authentication.models.Book;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
	List<Book> findAll();
}
