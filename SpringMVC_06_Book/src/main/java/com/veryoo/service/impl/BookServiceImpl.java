package com.veryoo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.veryoo.entity.Book;
import com.veryoo.mapper.BookMapper;
import com.veryoo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> getAllBooks() {
		PageHelper.startPage(1, 10);
		return bookMapper.selectByExample(null);
	}
	
	@Override
	public List<Book> getBookPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return bookMapper.selectByExample(null);
	}

	@Override
	public void saveBook(Book book) {
		if(book.getId() == null) {
			bookMapper.insert(book);
		}else {
			bookMapper.updateByPrimaryKeySelective(book);
		}
	}

}
