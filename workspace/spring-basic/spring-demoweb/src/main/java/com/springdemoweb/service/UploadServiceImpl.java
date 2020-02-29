package com.springdemoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springdemoweb.dao.UploadDao;
import com.springdemoweb.mapper.UploadMapper;
import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

@Service("uploadService") // == @Component("uploadService")
public class UploadServiceImpl implements UploadService {

	@Autowired
	@Qualifier("uploadDao")
	private UploadDao uploadDao;
	
	@Autowired
	@Qualifier("uploadMapper")
	private UploadMapper uploadMapper;
	
	@Override
	public List<Upload> findUploadList() {
		
//		List<Upload> uploads = uploadDao.selectUploads();
		List<Upload> uploads = uploadMapper.selectUploads();
		return uploads;
		
	}

	@Override
	public int writeUpload(Upload upload) {

		//return uploadDao.insertUpload(upload);
		int newUploadNo = uploadDao.insertUpload(upload);
		for(UploadFile uf : upload.getFiles()) {
			uf.setUploadNo(newUploadNo);// 새로 만들어진 자료 번호
			uploadDao.insertUploadFile(uf);
		}
		return newUploadNo;
	}

	@Override
	public Upload findUploadByUploadNo(int uploadNo) {
		//return uploadDao.selectUploadByUploadNo(uploadNo);
		
		Upload upload = uploadDao.selectUploadByUploadNo(uploadNo);
		List<UploadFile> files = uploadDao.selectUploadFilesByUploadNo(uploadNo);
		
		upload.setFiles(files);
		
		return upload;
	}

	@Override
	public void deleteUpload(int uploadNo) {
		uploadDao.deleteUpload(uploadNo);
		
	}

}
