package com.springdemoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

@Mapper
public interface UploadMapper {
	
	List<Upload> selectUploads();
	
	Upload selectUploadByUploadNo(int uploadNo);
	
	List<UploadFile> selectUploadFilesByUploadNo(int uploadNo);
	
	UploadFile selectUploadFileByUploadFileNo(int uploadFileNo);
	
	void deleteUpload(int uploadNo);
	
	void insertUpload(Upload upload);
	void insertUpload2(Upload upload);
	
	void insertUploadFile(UploadFile file);
	
	void deleteUploadFile(int uploadFileNo);
	
	void updateUpload(Upload upload);

}
