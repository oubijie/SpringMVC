package com.veryoo.service;

import java.util.List;

import com.veryoo.entity.Book;

public interface BookService {

	List<Book> getAllBooks();
	
	void saveBook(Book book);
	
	List<Book> getBookPage(int pageNum, int pageSize);
}
