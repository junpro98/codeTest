package com.codeTest.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeTest.spring.service.CtService;
import com.codeTest.spring.vo.Book;
import com.codeTest.spring.vo.Login;
import com.codeTest.spring.vo.Rental;
import com.codeTest.spring.vo.User;

@Controller
public class MainController {

	@Autowired
	private CtService cser;

	@RequestMapping("/index")
	public String main() {
		return "WEB-INF/webFile/index.jsp";
	}

	@RequestMapping("/signUp")
	public String signUp() {
		return "WEB-INF/webFile/signUp.jsp";
	}

	@RequestMapping("/sign_check")
	public String signCheck(@ModelAttribute User vo) {
		cser.signUp(vo);
		return "/index";
	}

	@RequestMapping("/login")
	public String login() {
		return "WEB-INF/webFile/login.jsp";
	}

	@RequestMapping("/check_login")
	public String check_login(@RequestParam String userId, @RequestParam String userPw, Model login,
			HttpSession session) {
		System.out.println(userId);
		List<Login> list = cser.checkLogin(userId, userPw);
		if (list != null && !list.isEmpty()) {
	        login.addAttribute("list", list);
	        session.setAttribute("id", userId);
	        return "redirect:/main";
	    } else {
	    	session.removeAttribute("id");
	        return "redirect:/login";
	    }
	}

	@RequestMapping("/main")
	public String main1(Model book) {
		List<Book> list = cser.main1(book);
		book.addAttribute("list", list);
		return "WEB-INF/webFile/main.jsp";
	}

	@RequestMapping("/regi")
	public String regi() {
		return "WEB-INF/webFile/regi.jsp";
	}

	@RequestMapping("/regi_check")
	public String regi_check(@RequestParam String bookName) {
		cser.regi_check(bookName);
		return "redirect:/main";
	}

	@RequestMapping("/regi_modify")
	public String regi_modify() {
		return "WEB-INF/webFile/modify.jsp";
	}

	@RequestMapping("/modify_check")
	public String modify_check(@RequestParam String modify, @RequestParam int hidden) {
		cser.modify_check(modify, hidden);
		return "redirect:/main";
	}

	@RequestMapping("/rent")
	public String rent(@RequestParam String userId, @RequestParam int bookId) {
		cser.rental(userId, bookId);
		return "redirect:/main";
	}

	@RequestMapping("/return")
	public String retu(@RequestParam int rental, @RequestParam int bookId) {
		cser.retu(rental, bookId);
		return "redirect:/main";
	}
}
