package com.example;

import lombok.Data;

// 어노테이션 : 컴파일러한테 지시하는 지시문
@Data // getter, setter 등을 자동으로 만드는 설정
class Person2 {
	//@Setter / @Getter로 구분지어 지정할 수 있음
	private int no;
	private String name;
	private String email;
	
	String info() {
		return String.format("[%d][%s][%s]", no, name, email);
	}
}

public class ClassDemo3 {
	public static void main(String[] args) {
		
		Person2 person = new Person2();
		person.setNo(1);
		person.setName("Michael");
		person.setEmail("bcde@example.com");
		
		String info = person.info();
		System.out.println(info);
	}
}
