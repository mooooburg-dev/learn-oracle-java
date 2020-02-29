package com.springdemoweb.vo;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class Upload {

	private int uploadNo;
	private String title;
	private String uploader;
	private String content;
	private int readCount;
	private Date regDate;
	private boolean deleted;
	
	//Upload Table과 UploadFile Table 사이의 1:Many 관계를 구현하는 필드
	private List<UploadFile> files;
	
}
