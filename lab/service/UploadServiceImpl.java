package com.springdemoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.springdemoweb.dao.UploadDao;
import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

public class UploadServiceImpl implements UploadService {

	private UploadDao uploadDao;	
	public UploadDao getUploadDao() {
		return uploadDao;
	}
	public void setUploadDao(UploadDao uploadDao) {
		this.uploadDao = uploadDao;
	}	
	
	@Override
	public Integer registerUploadTx(Upload upload) {
		
		int newUploadNo = uploadDao.insertUpload(upload);

		int result = 10 / 0;
		
		for (UploadFile file : upload.getFiles()) {
			file.setUploadNo(newUploadNo);
			uploadDao.insertUploadFile(file);
		}				
		
		return newUploadNo;
		
	}
	
	@Override
	public void registerUploadFile(UploadFile uploadFile) {
		uploadDao.insertUploadFile(uploadFile);		
	}

	@Override
	public List<Upload> findUploadList() {
		
		List<Upload> uploads = uploadDao.selectUploads();
		return uploads;
		
	}
	
	@Override
	public Upload findUploadByUploadNo(int uploadNo) {
		
		Upload upload = uploadDao.selectUploadByUploadNo(uploadNo);
		return upload;
		
	}
	
	@Override
	public List<UploadFile> findUploadFilesByUploadNo(int uploadNo) {
		
		List<UploadFile> files = uploadDao.selectUploadFilesByUploadNo(uploadNo);
		return files;
	}
	@Override
	public UploadFile findUploadFileByUploadFileNo(int uploadFileNo) {
		
		UploadFile file = uploadDao.selectUploadFileByUploadFileNo(uploadFileNo);		
		return file;
	}
	
	@Override
	public void deleteUpload(int uploadNo) {
		
		uploadDao.deleteUpload(uploadNo);
		
	}
	
	@Override
	public void deleteUploadFile(int fileNo) {
		
		uploadDao.deleteUploadFile(fileNo);
		
	}
	
	@Override
	public void updateUpload(Upload upload) {
		
		uploadDao.updateUpload(upload);
		
	}
	

}













