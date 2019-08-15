package com.veryoo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veryoo.entity.Book;
import com.veryoo.mapper.BookMapper;
import com.veryoo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> getAllBooks() {
		return bookMapper.selectByExample(null);
	}

}
