package com.springdemoweb.service;

import java.util.List;

import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

public interface UploadService {
	
	List<Upload> findUploadList();

	int writeUpload(Upload upload);

	Upload findUploadByUploadNo(int uploadNo);

	void deleteUpload(int uploadNo);

	UploadFile findUploadFileByUploadFileNo(int uploadFileNo);

}
