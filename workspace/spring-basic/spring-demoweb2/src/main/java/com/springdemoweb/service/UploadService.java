package com.springdemoweb.service;

import java.util.List;

import com.springdemoweb.vo.Upload;

public interface UploadService {
	
	List<Upload> findUploadList();

	int writeUpload(Upload upload);

	Upload findUploadByUploadNo(int uploadNo);

	void deleteUpload(int uploadNo);

}
