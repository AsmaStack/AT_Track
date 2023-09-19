package com.amdocs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.model.BookEntity;
import com.amdocs.repo.BookRepository;

@Service
public class BookService {
	

	private BookRepository bookrepo;
	
	@Autowired
	public BookService(BookRepository bookrepo) {
		//super();
		this.bookrepo = bookrepo;
	}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public BookEntity saveBook(BookEntity book)
	{
		return bookrepo.save(book); 
	}
	

	public List<BookEntity> getAllbooks()
	{
		return bookrepo.findAll();
	}
	
	public 	BookEntity getBookById(Long isbnno)
	{
		return bookrepo.findById(isbnno).orElse(null);
	}

	public BookEntity updateBook(Long isbnno, BookEntity book)
	{
		BookEntity existingbook=bookrepo.findById(isbnno).orElse(null);
		
		if(existingbook!=null)
		{
			existingbook.setBook_name(book.getBook_name());
			existingbook.setPublishDate(book.getPublishDate());
		return bookrepo.save(existingbook);
		}
		return null;
	}
	
	public void deleteBook(Long isbnno)
	{
		 bookrepo.deleteById(isbnno);
	}
	
}
