package com.demoweb.vo;

import java.util.Date;

import lombok.Data;

// VO 클래스는 일반적으로 데이터베이스의 테이블과 매칭되도록 구현 
@Data
public class MemberVO {

	// 멤버변수는 테이블의 컬럼과 일치하도록 작성
	private String memberId;
	private String passwd;
	private String email;
	private Date regDate;
	private boolean active;
	private String userType;
	
}