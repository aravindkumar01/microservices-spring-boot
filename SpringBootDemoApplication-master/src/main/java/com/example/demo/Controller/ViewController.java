package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	
	@RequestMapping("/reg")
	public String loginMessage(){
		return "register";
	}
	@RequestMapping("/")
	public String reg(){
		return "register";
	}
}
