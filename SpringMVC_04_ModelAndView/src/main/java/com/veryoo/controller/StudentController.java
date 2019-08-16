package com.veryoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.veryoo.entity.Student;
import com.veryoo.service.StudentService;


@Controller
@RequestMapping("/stu")
public class StudentController {

	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		//去数据库查找学生列表
		List<Student> list = StudentService.getAllStudent();
		
		System.out.println("list...");
		
		request.setAttribute("list", list);
		return "stu/list";
	}
	
	@RequestMapping("/list2")
	public String list2(Model model) {
		//去数据库查找学生列表
		List<Student> list = StudentService.getAllStudent();
		
		System.out.println("list2...");
		
		model.addAttribute("list", list);
		
		return "stu/list";
	}
	
	@RequestMapping("/list3")
	public String list3(ModelMap model) {
		//去数据库查找学生列表
		List<Student> list = StudentService.getAllStudent();
		
		System.out.println("list3...");
		
		model.addAttribute("list", list);
		
		
		return "stu/list";
	}
	
	@RequestMapping("/list4")
	public ModelAndView list4() {
		//去数据库查找学生列表
		List<Student> list = StudentService.getAllStudent();
		
		System.out.println("list4...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stu/list");
		mv.addObject("list", list);
		
		return mv;
	}
	
	
	@RequestMapping("/ff")
	public String ff() {
		return "forward:/stu/list";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session) {
		System.out.println("stu add...");
		
		String id = request.getParameter("id");
		System.out.println("======id:" + id);
		
		return "stu/add";
	}
	
	@RequestMapping("/{sid}/edit")
	public String edit(@PathVariable(name = "sid") Integer sid) {
		System.out.println("edit..." + sid);
		return "success";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST )
	public String save(@RequestParam(name="stuName1" ) String stuName, Integer age, Model model) {
		System.out.println("学生姓名：" + stuName);
		System.out.println("学生年龄：" + age);
		model.addAttribute("msg", "保存成功！");
		return "redirect:/stu/list";
	}
	
	@RequestMapping(value="/save2", method = RequestMethod.POST )
	public String save2(Student stu, RedirectAttributes attributes) {
		System.out.println("学生姓名2：" + stu.getStuName());
		System.out.println("学生年龄2：" + stu.getAge());
		System.out.println("学生city：" + stu.getAddr().getCity());
		System.out.println("学生detail：" + stu.getAddr().getDetail());
		
		attributes.addFlashAttribute("msg", "OK");
		return "redirect:/stu/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete() {
		System.out.println("delete...");
		return "success";
	}
	
}
