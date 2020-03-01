package com.springdemo.bootboard.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;

@Entity // 데이터베이스의 테이블과 연동된 객체
@Table(name = "tbl_board") // 연동된 테이블 이름
@Data
public class BoardEntity {
	
	@Id // 이 속성이 primary key 컬럼
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="board_sequence")
    @SequenceGenerator(name = "board_sequence", sequenceName = "BOARD_SEQ")
	private int boardIdx;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String contents;
	@Column
	private int hitCount = 0;
	@Column(nullable = false)
	private String creatorId;
	@Column
	private Date createdDatetime = new Date();
	@Column
	private String updaterId;
	@Column
	private Date updatedDatetime = new Date();
	@Column
	private String deletedYn = "N";
	
	//Board : BoardFile의 1 : Many 관계를 구현하는 필드(변수)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "board_idx")
	private Collection<BoardFileEntity> fileList;

}







