package com.codeTest.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/index")
	public String main() {
		return "WEB-INF/webFile/index.jsp";
	}
}
