package com.veryoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.veryoo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", bookService.getAllBooks());
		return "book/list";
	}
}
