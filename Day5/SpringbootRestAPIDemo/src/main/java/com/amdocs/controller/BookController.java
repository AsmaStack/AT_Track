package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.model.BookEntity;
import com.amdocs.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookserv;

	@Autowired
	public BookController(BookService bookserv) {
		//super();
		this.bookserv = bookserv;
	}
	//Basic URI for API Testing
	
	//http://localhost:8085/books
	
	//insert into book_entity(book_name, pub_date)values(?,?);
	//http://localhost:8085/books/insert
	@PostMapping("/insert")
	public BookEntity saveBook(@RequestBody BookEntity book)
	{
		return bookserv.saveBook(book);
	}
	
	//select *from book_entity
	//http://localhost:8085/books/allbooks

	@GetMapping("/allbooks")
	public List<BookEntity> getAllbooks()
	{
		return bookserv.getAllbooks();
		
	}
	
	//select *from book_entity where isbnno=?
	//http://localhost:8085/books/1
	@GetMapping("/{isbnno}")
	public BookEntity getBookById(@PathVariable Long isbnno)
	{
		return bookserv.getBookById(isbnno);
	}
	
	//http://localhost:8085/books/update/1
	@PutMapping("/update/{isbnno}")
	public BookEntity updateBook(@PathVariable Long isbnno,@RequestBody BookEntity book)
	{
		return bookserv.updateBook(isbnno, book);
	}
	
	
	@DeleteMapping("/delete/{isbnno}")
	public void deleteBook(@PathVariable Long isbnno)
	{
		bookserv.deleteBook(isbnno);
	}
	
}
