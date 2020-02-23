package com.springdemoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdemoweb.service.UploadService;
import com.springdemoweb.service.UploadServiceImpl;
import com.springdemoweb.vo.Upload;

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
	public String write(Upload upload) {
		// Upload로 받기(꼭 Upload가 아니라 자유롭게 받을 수 있다)
		// System.out.println(upload);
		
		
		// 1. 요청 데이터 읽기 (DispatcherServlet이 처리해서 전달인자로 전달)
		
		// 2. 데이터 처리 (여기서는 데이터베이스에 데이터 저장)
		upload.setUploader("pantagruel");
		int newUploadNo = uploadService.writeUpload(upload);
		
		// 3. 다른 처리기 또는 jsp로 이동
		return "redirect:list"; // redirect: @GetMapping, @PostMapping, @RequestMapping된 메서드로 이동
		                             // viewname: jsp로 이동(forward)
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
	
	@GetMapping(path = {"/upload/delete/{uploadNo}"})
	public String delete(@PathVariable int uploadNo) {
		
		// 데이터 처리(데이터베이스의 데이터 삭제)
		uploadService.deleteUpload(uploadNo);
		
		// View 또는 다른 처리기로 이동
		return  "redirect:/upload/list";
	}
	
	
}
