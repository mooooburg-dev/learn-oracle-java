package com.example.hello.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(path = {"/", "/home"})
	public String home(Model model) {
		model.addAttribute("currentTime", new Date());
	
		return "home"; // /resources/template/home.html을 지정
	}
}
