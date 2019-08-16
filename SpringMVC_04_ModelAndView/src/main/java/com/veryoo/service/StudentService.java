package com.veryoo.service;

import java.util.ArrayList;
import java.util.List;

import com.veryoo.entity.Student;

public class StudentService {

	public static List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "zhangsan", 18));
		list.add(new Student(2, "lisi", 28));
		list.add(new Student(3, "wangwu", 28));
		list.add(new Student(4, "zhangfei", 58));
		return list;
	}
}
