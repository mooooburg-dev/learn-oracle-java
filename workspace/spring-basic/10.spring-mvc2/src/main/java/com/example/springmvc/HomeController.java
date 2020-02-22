package com.example.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // IoC 컨테이너에 빈으로 등록하세요 + 이 빈을 웹 요청을 처리하는 컨트롤러로 설정
//@RequestMapping("/") //  생략 가능
//@RequestMapping(value = "/") //  생략 가능
@RequestMapping(path = { "/" }) //  생략 가능
public class HomeController {
	
	// "/" 또는 "/home.action" 경로의 요청이 발생하면 HomeController의 home 메서드를 호출하도록 설정
	@RequestMapping(value = { "/", "/home.action" }, method = RequestMethod.GET)  
	public String home() {
		
		// 반환 값은 View 이름 -> jsp 파일의 이름 (home.jsp)
		// InternalResourceViewResolver.prefix + "home" + InternalResourceViewResolver.suffix
		// /WEB-INF/views/ + "home" + ".jsp"
		return "home"; 
	}
	
}
