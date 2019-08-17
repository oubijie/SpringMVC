package com.veryoo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String save(@Validated @ModelAttribute("book") Book book, BindingResult br, MultipartFile picFile, Model model) {
		if(br.hasErrors()) {
			List<FieldError> list = br.getFieldErrors();
			for(FieldError err : list) {
				System.out.println("--------------" + err.getDefaultMessage());
			}
			
			return "book/edit";
		}
		
		if(picFile != null && picFile.getSize() > 0) {
			System.out.println("=============" + picFile.getName());
			System.out.println("=============" + picFile.getSize());
			System.out.println("=============" + picFile.getOriginalFilename());
			System.out.println("=============" + picFile.getContentType());
			
			//上传文件的目录，此路径应配置在配置文件中
			String uploadPath="D:\\site\\upload\\";
			try {
				String newFileName = UUID.randomUUID().toString().replace("-", "") 
						+ picFile.getOriginalFilename().substring(picFile.getOriginalFilename().lastIndexOf("."));   //使用随机文件名
				picFile.transferTo(new File(uploadPath + newFileName));
				book.setPic(newFileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		bookService.saveBook(book);
		return "redirect:/book/list";
	}
	
	@RequestMapping("/ex")
	public String ex() {
		System.out.println(10/0);
		return "book/edit";
	}
	
	@RequestMapping("/or")
	public String or() {
		int[] arr = {1};
		System.out.println(arr[4]);
		return "book/edit";
	}
	
	@RequestMapping("/np")
	public String np() {
		Object o = null;
		System.out.println(o.equals(""));
		return "book/edit";
	}
	
	/**
	 * 异常处理，只能处理本类抛出的特定异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handArithmeticException(Exception ex) {
		System.out.println(ex);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/err");
		mv.addObject("exception", ex);
		return mv;
	}
	
	
	
	
}
