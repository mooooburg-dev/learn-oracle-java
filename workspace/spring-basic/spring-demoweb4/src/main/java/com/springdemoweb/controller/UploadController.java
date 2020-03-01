package com.springdemoweb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.springdemoweb.common.Util;
import com.springdemoweb.service.UploadService;
import com.springdemoweb.service.UploadServiceImpl;
import com.springdemoweb.view.DownloadView;
import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

@Controller
public class UploadController {
	
	@Autowired
	@Qualifier("uploadService")
	private UploadService uploadService; 

	@GetMapping(path = {"/upload/list"})
	public String list(Model model) {	// Model 타입의 전달인자에 데이터를 저장하면 View로 전달(request 객체에 데이터 저장)
		
		//1. 요청 데이터 읽기
		
		//2. 요청 데이터에 따라 처리 (데이터베이스에서 데이저 조회)
		List<Upload> uploads = uploadService.findUploadList();
		
		//3. view에서 읽을 수 있도록 데이터 전달
		model.addAttribute("uploads", uploads); // == request.setAttribute("uploads", upload); 와 같다.
		
		//3. view 또는 다른 Controller로 이동
		return "upload/list"; // /WEB-INF/views/ + "upload/list" + .jsp
	}
	
	
	// GepMapping : method="get"인 요청에 대한 처리기
	@GetMapping(path = {"/upload/write"})
	public String showWriteForm() {
		return  "upload/write";
	}
	
	// PostMapping : method="post"인 요청에 대한 처리기
	@PostMapping(path = {"/upload/write"})
	//public String write(MultipartFile attach, Upload upload) {
	public String write(MultipartHttpServletRequest req, Upload upload) {		
		
		upload.setUploader("iamuserone");
		
//		MultipartFile attach = req.getFile("attach"); // 1개의 파일 읽기
		List<MultipartFile> attaches = req.getFiles("attach"); // 모든 파일(여러개) 읽기
						
		if (attaches != null && attaches.size() > 0) {
			
			ServletContext application = req.getServletContext();
			//application.getRealPath("웹경로") : 컴퓨터 경로 반환
			String path = application.getRealPath("/upload-files");
			
			ArrayList<UploadFile> files = new ArrayList<UploadFile>();
			
			for (MultipartFile attach : attaches) {			
				String userFileName = attach.getOriginalFilename();
				if (userFileName.contains("\\")) { // iexplore 경우
					//C:\AAA\BBB\CCC.png -> CCC.png 
					userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
				}
				//중복되지 않는 고유한 파일 이름 만들기
				String savedFileName = Util.makeUniqueFileName(userFileName);
				
				try {
					//첨부파일을 지정된 경로에 저장 (컴퓨터의 Disk에 저장)
					attach.transferTo(new File(path, savedFileName)); //파일 저장
					
					//------------------------------------
					
					//VO 객체를 만들고 파일 정보 저장
					UploadFile uploadFile = new UploadFile();
					uploadFile.setUserFileName(userFileName);
					uploadFile.setSavedFileName(savedFileName);
					
					files.add(uploadFile);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			upload.setFiles(files);
		
			try {
				//데이터 저장
				uploadService.writeUpload(upload);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return "redirect:list";
	}
	
	
	// path에 {} 중괄호는 경로상의 데이터를 의미
	// -> 메소드의 전달인자에서 @PathVariable을 읽을 수 있습니다.
	@GetMapping(path= {"/upload/detail/{uploadNo}"})
	public String detail(@PathVariable int uploadNo, Model model) { // @PathVarialbe 
			
		// 데이터 처리 (데이터베이스의 데이터 조회)
		Upload upload = uploadService.findUploadByUploadNo(uploadNo);

		// 조회된 데이터를 View(.jsp)에서 읽을 수 있도록 Model 전달인자를 저장
		model.addAttribute("upload", upload);
		
		// View 또는 다른 처리기로 이동
		return "upload/detail";
	}
	
	//@PathVariable : 요청 경로의 {}부분을 데이터로 읽는 annotation
	@GetMapping(path = "/upload/download/{fileNo}")
	public View download(@PathVariable int fileNo, Model model) {
		
		UploadFile file = uploadService.findUploadFileByUploadFileNo(fileNo);
		if (file == null) {
			return new RedirectView("/upload/list");
		}
		
		model.addAttribute("file", file);
		
		DownloadView v = new DownloadView();
		return v;
	}
	
	//@PathVariable : 요청 경로의 {}부분을 데이터로 읽는 annotation
	@GetMapping(path = "/upload/delete/{uploadNo}")
	public String delete(@PathVariable int uploadNo) {

		uploadService.deleteUpload(uploadNo);
		
		return "redirect:/upload/list"; // new RedirectView("/upload/list");
	}
	
	//@PathVariable : 요청 경로의 {}부분을 데이터로 읽는 annotation
	@GetMapping(path = "/upload/edit/{uploadNo}")
	public String editForm(@PathVariable int uploadNo, Model model) {

		Upload upload = uploadService.findUploadByUploadNo(uploadNo);
		if (upload == null) { //uploadno가 유효하지 않은 경우 (데이터베이스에 없는 번호인 경우)
			return "redirect:list";
		}		
		List<UploadFile> files = uploadService.findUploadFilesByUploadNo(uploadNo);
		upload.setFiles((ArrayList<UploadFile>)files);
		
		model.addAttribute("upload", upload);

		
		return "upload/update";
	}
	
	//@PathVariable : 요청 경로의 {}부분을 데이터로 읽는 annotation
	@GetMapping(path = "/upload/delete-file/{uploadNo}/{fileNo}")
	public String deleteFile(
			@PathVariable int uploadNo, @PathVariable int fileNo, Model model) {

		UploadFile file = uploadService.findUploadFileByUploadFileNo(fileNo);
		//파일 삭제
		File f = new File(file.getSavedFileName());
		if (f.exists()) {
			f.delete();
		}		
		//데이터베이스에서 파일 데이터 삭제		
		uploadService.deleteUploadFile(fileNo);
		
		return "redirect:/upload/edit/" + uploadNo;
	}

	@PostMapping(path = "/upload/update")
	public String update(MultipartHttpServletRequest req, Upload upload) {

		List<MultipartFile> attaches = req.getFiles("attach");
		
		if (attaches != null && attaches.size() > 0) {
			
			ServletContext application = req.getServletContext();
			//application.getRealPath("웹경로") : 컴퓨터 경로 반환
			String path = application.getRealPath("/upload-files");
			
			ArrayList<UploadFile> files = new ArrayList<UploadFile>();
			
			for (MultipartFile attach : attaches) {			
				String userFileName = attach.getOriginalFilename();
				if (userFileName.contains("\\")) { // iexplore 경우
					//C:\AAA\BBB\CCC.png -> CCC.png 
					userFileName = userFileName.substring(userFileName.lastIndexOf("\\") + 1);
				}
				//중복되지 않는 고유한 파일 이름 만들기
				String savedFileName = Util.makeUniqueFileName(userFileName);
				
				try {
					//첨부파일을 지정된 경로에 저장 (컴퓨터의 Disk에 저장)
					attach.transferTo(new File(path, savedFileName)); //파일 저장
					
					//------------------------------------
					
					//VO 객체를 만들고 파일 정보 저장
					UploadFile uploadFile = new UploadFile();
					uploadFile.setUserFileName(userFileName);
					uploadFile.setSavedFileName(savedFileName);
					uploadFile.setUploadNo(upload.getUploadNo());
					
					files.add(uploadFile);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			upload.setFiles(files);
			
			try {
				//데이터 저장				
				uploadService.updateUpload(upload);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return "redirect:/upload/detail/" + upload.getUploadNo();
	}	
	
	
}
