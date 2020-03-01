package com.springdemoweb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemoweb.mapper.UploadMapper;
import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

@Repository("uploadDao")
public class UploadDaoImpl implements UploadDao {
	
	//JDBC의 구조 코드를 단순하게 만드는 스프링의 클래스
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Autowired
	private UploadMapper uploadMapper;
	
	//반환 값은 UPLOAD 테이블에 새로 INSERT된 데이터의 UPLOADNO (NEXTVAL한 후의 CURRVAL)
	@Override
	public int insertUpload(Upload upload) {
		
		//before insert : upload.getUploadNo() ==> 0 //비어 있는 값
		
//		sessionTemplate.insert(
//			"com.springdemoweb.mapper.UploadMapper.insertUpload", upload);
		//uploadMapper.insertUpload(upload);
		uploadMapper.insertUpload2(upload);
		
		//after insert : upload.getUploadNo() ==> new value
		
		return upload.getUploadNo(); //새로 생성된 자료 번호 반환
		
	}
	
	@Override
	public void insertUploadFile(UploadFile file) {
		
//		sessionTemplate.insert(
//			"com.springdemoweb.mapper.UploadMapper.insertUploadFile", file);
		uploadMapper.insertUploadFile(file);
		
	}
	
	@Override
	public List<Upload> selectUploads() {
		
		List<Upload> uploads = 
			//sessionTemplate.selectList("com.springdemoweb.mapper.UploadMapper.selectUploads");
			uploadMapper.selectUploads();
		
		return uploads;
		
	}

	@Override
	public Upload selectUploadByUploadNo(int uploadNo) {
		
//		Upload upload = sessionTemplate.selectOne(
//			"com.springdemoweb.mapper.UploadMapper.selectUploadByUploadNo", uploadNo);
		Upload upload = uploadMapper.selectUploadByUploadNo(uploadNo);
		
		return upload; //호출한 곳으로 조회한 데이터를 반환
	}

	@Override
	public List<UploadFile> selectUploadFilesByUploadNo(int uploadNo) {
		
//		List<UploadFile> files = sessionTemplate.selectList(
//			"com.springdemoweb.mapper.UploadMapper.selectUploadFilesByUploadNo", uploadNo);
		List<UploadFile> files = uploadMapper.selectUploadFilesByUploadNo(uploadNo);
		
		return files;
	}

	@Override
	public UploadFile selectUploadFileByUploadFileNo(int fileNo) {
		
//		UploadFile file = sessionTemplate.selectOne(
//			"com.springdemoweb.mapper.UploadMapper.selectUploadFileByUploadFileNo", fileNo);
		UploadFile file = uploadMapper.selectUploadFileByUploadFileNo(fileNo);
				
		return file; //호출한 곳으로 조회한 데이터를 반환
	}

	@Override
	public void deleteUpload(int uploadNo) {
		
//		sessionTemplate.delete(
//			"com.springdemoweb.mapper.UploadMapper.deleteUpload", uploadNo);
		
		uploadMapper.deleteUpload(uploadNo);		
				
	}

	@Override
	public void deleteUploadFile(int fileNo) {
		
//		sessionTemplate.delete(
//			"com.springdemoweb.mapper.UploadMapper.deleteUploadFile", fileNo);
		uploadMapper.deleteUploadFile(fileNo);
		
	}

	@Override
	public void updateUpload(Upload upload) {
		
//		sessionTemplate.update(
//			"com.springdemoweb.mapper.UploadMapper.updateUpload", upload);
		uploadMapper.updateUpload(upload);
		
	}
	
}




















