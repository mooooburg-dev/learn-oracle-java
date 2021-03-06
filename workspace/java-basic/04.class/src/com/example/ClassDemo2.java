package com.example;

class Person {
	private int no;
	private String name;
	private String email;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		// this : 클래스의 멤버를 표현하기 위해 사용
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	String info() {
		return String.format("[%d][%s][%s]", no, name, email);
	}
}

public class ClassDemo2 {
	public static void main(String[] args) {
		Person person = new Person();
//		person.no = 1;
//		person.name = "John Doe";
//		person.email = "aaa@example.com";
		person.setNo(1);
		person.setName("Michael");
		person.setEmail("bcde@example.com");
		
		String info = person.info();
		System.out.println(info);
	}
}
