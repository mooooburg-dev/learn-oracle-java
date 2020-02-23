package com.springdemoweb.dao;

import java.util.ArrayList;

import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

public interface UploadDao {

	//반환 값은 UPLOAD 테이블에 새로 INSERT된 데이터의 UPLOADNO (NEXTVAL한 후의 CURRVAL)
	int insertUpload(Upload upload);

	void insertUploadFile(UploadFile file);

	ArrayList<Upload> selectUploads();

	Upload selectUploadByUploadNo(int uploadNo);

	ArrayList<UploadFile> selectUploadFilesByUploadNo(int uploadNo);

	UploadFile selectUploadFileByUploadFileNo(int fileNo);

	void deleteUpload(int uploadNo);

	void deleteUploadFile(int fileNo);

	void updateUpload(Upload upload);

}