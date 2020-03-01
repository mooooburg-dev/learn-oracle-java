package com.springdemoweb.service;

import java.util.List;

import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

public interface UploadService {
	
	List<Upload> findUploadList();

	int writeUpload(Upload upload);
	int writeUploadTx(Upload upload);

	Upload findUploadByUploadNo(int uploadNo);

	void deleteUpload(int uploadNo);
	
	public List<UploadFile> findUploadFilesByUploadNo(int uploadNo);
	
	public UploadFile findUploadFileByUploadFileNo(int uploadFileNo);
	
	public void deleteUploadFile(int fileNo);
	
	public void updateUpload(Upload upload);

}
