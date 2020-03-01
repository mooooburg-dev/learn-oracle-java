package com.springdemoweb.service;

import java.util.List;

import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

public interface UploadService {
	
	List<Upload> findUploadList();

	int writeUpload(Upload upload);

	Upload findUploadByUploadNo(int uploadNo);
	
	List<UploadFile> findUploadFilesByUploadNo(int uploadNo);
	
	UploadFile findUploadFileByUploadFileNo(int uploadFileNo);
	
	void deleteUpload(int uploadNo);
	
	void deleteUploadFile(int fileNo);
	
	void updateUpload(Upload upload);

}
