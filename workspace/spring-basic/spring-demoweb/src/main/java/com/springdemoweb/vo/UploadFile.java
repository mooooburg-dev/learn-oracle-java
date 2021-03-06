package com.springdemoweb.vo;

import lombok.Data;

@Data
public class UploadFile {
	
	private int uploadFileNo;
	private int uploadNo;
	private String savedFileName;
	private String userFileName;
	private int downloadCount;
	
	//UploadFile Table을 기준으로 Upload Table과의 1:1관계를 구현하는 필드 
	private Upload upload;

}
