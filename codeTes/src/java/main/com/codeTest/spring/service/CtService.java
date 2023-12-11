package com.codeTest.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.codeTest.spring.repository.CtDAO;
import com.codeTest.spring.vo.Book;
import com.codeTest.spring.vo.Login;
import com.codeTest.spring.vo.User;

@Service
public class CtService {

	@Autowired
	private CtDAO dao;
	
	public void signUp(User vo) {
		dao.signUp(vo);
	}
	
	public List<Login> checkLogin(String userId, String userPw) {
		List<Login> list = dao.checkLogin(userId, userPw);
		return list;
	}
	
	public List<Book> main1(Model book) {
		List<Book> list = dao.main1(book);
		return list;
	}
}
