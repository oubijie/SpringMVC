package com.veryoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.veryoo.entity.Student;

@Controller
@RequestMapping("/stu")
public class StudentController {

	@RequestMapping("/add")
	public String add() {
		return "stu/add";
	}
	
	@RequestMapping("/save")
	public String save(String stuName, Integer age) {
		System.out.println("保存学生的姓名：" + stuName);
		System.out.println("保存学生的年龄：" + age);
		return "stu/success";
	}
	
	
	@RequestMapping("/save2")
	public String save2(Student stu) {
		System.out.println("保存学生的姓名：" + stu.getStuName());
		System.out.println("保存学生的年龄：" + stu.getAge());
		System.out.println("保存学生的城市：" + stu.getAddr().getCity());
		System.out.println("保存学生的详细地址：" + stu.getAddr().getDetail());
		return "stu/success";
	}
	
	@RequestMapping("/{sid}/delete")
	public String delete(@PathVariable("sid") Integer sid) {
		System.out.println("要删除的学生ID：" + sid);
		return "stu/success";
	}
	
}
