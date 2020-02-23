package com.springdemoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springdemoweb.dao.UploadDao;
import com.springdemoweb.vo.Upload;

@Service("uploadService") // == @Component("uploadService")
public class UploadServiceImpl implements UploadService {

	@Autowired
	@Qualifier("uploadDao")
	private UploadDao uploadDao;
	
	@Override
	public List<Upload> findUploadList() {
		
		List<Upload> uploads = uploadDao.selectUploads();
		return uploads;
		
	}

	@Override
	public int writeUpload(Upload upload) {
		// TODO Auto-generated method stub
		return uploadDao.insertUpload(upload);
	}

	@Override
	public Upload findUploadByUploadNo(int uploadNo) {
		return uploadDao.selectUploadByUploadNo(uploadNo);
	}

	@Override
	public void deleteUpload(int uploadNo) {
		uploadDao.deleteUpload(uploadNo);
		
	}

}
