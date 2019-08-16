package com.veryoo.entity;

public class Student {

	private Integer sid;
	private String stuName;
	private Integer age;
	private Address addr;
	
	
	
	public Student() {
		super();
	}
	public Student(Integer sid, String stuName, Integer age) {
		super();
		this.sid = sid;
		this.stuName = stuName;
		this.age = age;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
