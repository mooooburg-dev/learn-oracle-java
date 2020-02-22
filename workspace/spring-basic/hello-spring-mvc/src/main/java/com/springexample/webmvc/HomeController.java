package com.springexample.webmvc;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // == @Component + Spring Web MBC 관련 설정 추가
@RequestMapping(path  =  { "/" })
public class HomeController {
	
	// 요청 경로와 클래스 및 메서드를 연결(맵핑)
	// 어떤 요청이 발생했을 때 어떤 클래스의 어떤 메서드가 호출될 지 설정
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";	// ViewResolver에게 전달할 값
								// /WEB-INF/views/ + home + .jpg
	}
	
}
