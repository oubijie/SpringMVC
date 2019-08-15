package com.veryoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veryoo.entity.Book;
import com.veryoo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@RequestMapping("/list")
//	public String list(Model model) {
//		model.addAttribute("list", bookService.getAllBooks());
//		return "book/list";
//	}
	
	@RequestMapping("/list")
	public String list(Model model, Integer pageNum, Integer pageSize) {
		if(pageNum == null || pageNum <= 0) {
			pageNum = 1;
		}
		
		if(pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
		model.addAttribute("list", bookService.getBookPage(pageNum, pageSize));
		return "book/list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "book/edit";
	}
	
	@RequestMapping("/save")
	public String save(Book book) {
		bookService.saveBook(book);
		return "redirect:/book/list";
	}
}
