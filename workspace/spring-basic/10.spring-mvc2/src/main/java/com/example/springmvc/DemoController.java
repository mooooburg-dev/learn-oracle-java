package com.example.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/demo/")
public class DemoController {

//	//@RequestMapping(value = "/demo/param.action")
//	@RequestMapping(value = "/param.action")
//	public String processRequest1(HttpServletRequest req) { // DispatcherServlet이 Request 객체를 전달
//		
//		//브라우저에서 전송한 데이터 읽기
//		String data1 = req.getParameter("data1");
//		
//		return "demo/param-result"; //    /WEB-INF/views/ + "demo/param-result" + .jsp
//	}
	
//	//@RequestMapping(value = "/demo/param.action")
//	@RequestMapping(value = "/param.action")
//	public String processRequest1(String data1) {//DispatcherServlet이 요청 데이터 중에서 data1을 읽고 전달
//		
//		//브라우저에서 전송한 데이터 읽기
//		System.out.println(data1);
//		
//		return "demo/param-result"; //    /WEB-INF/views/ + "demo/param-result" + .jsp
//	}
	
	//@RequestMapping(value = "/demo/param.action", method = RequestMethod.GET)
	//@RequestMapping(value = "/param.action", method = RequestMethod.GET)
	@GetMapping(value = "/param.action")
	public String processRequest1(
			@RequestParam("data1")String data, //DispatcherServlet이 요청 데이터 중에서 data1을 읽고 전달
			Model model) { //jsp로 데이터를 전달하기 위한 도구 (여기에 데이터를 저장하면 request에 저장됨)
		
		//브라우저에서 전송한 데이터 읽기
		System.out.println(data);
		model.addAttribute("my_data", data); // 결과적으로 request.setAttribute("my_data", data);와 같음
		
		return "demo/param-result"; //    /WEB-INF/views/ + "demo/param-result" + .jsp
	}
	
	
	// ---------------------------------------------------------------------------------------------------------
	
	
	
	//@RequestMapping(value = "/demo/param.action", method = RequestMethod.POST)
	//@RequestMapping(value = "/param.action", method = RequestMethod.POST)
//	@PostMapping(value = "/param.action")
//	public String processRequest2(String name, String phone, String email, int age) {
//		
//		//브라우저에서 전송한 데이터 읽기
//		System.out.println(name);
//		System.out.println(age);
//		
//		return "demo/param-result"; //    /WEB-INF/views/ + "demo/param-result" + .jsp
//	}
	
//	//@RequestMapping(value = "/demo/param.action", method = RequestMethod.POST)
//	@RequestMapping(value = "/param.action", method = RequestMethod.POST)	
//	public String processRequest2(Person person) {
//		
//		//브라우저에서 전송한 데이터 읽기
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//		
//		return "demo/param-result"; //    /WEB-INF/views/ + "demo/param-result" + .jsp
//	}
	
	//@RequestMapping(value = "/demo/param.action", method = RequestMethod.POST)
	@RequestMapping(value = "/param.action", method = RequestMethod.POST)
	public ModelAndView processRequest2(
			Person personx) { //VO 전달인자는 자동으로 request 객체에 저장 (이름은 Person -> person으로 고쳐서 사용)
							  //                      request.setAttribute("person", personx)
		
		//브라우저에서 전송한 데이터 읽기
		System.out.println(personx.getName());
		System.out.println(personx.getAge());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("demo/param-result"); // /WEB-INF/views/ + "demo/param-result" + .jsp
		mav.addObject("person2", personx); //결과적으로 request.setAttribute("person2", person);과 같음
		
		return mav; //    
	}
	
	
	//------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/redirect.action", method = RequestMethod.GET)
	public String redirect() {
		
		return "redirect:/home.action";
	}
	
	@RequestMapping(value = "/forward.action", method = RequestMethod.GET)
	public String forward() {
		
		return "forward:/resources/forward-result.html";
	}
	
}









