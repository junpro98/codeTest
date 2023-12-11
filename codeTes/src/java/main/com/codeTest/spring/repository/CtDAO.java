package com.codeTest.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.codeTest.spring.vo.Book;
import com.codeTest.spring.vo.Login;
import com.codeTest.spring.vo.User;

@Repository
public class CtDAO {

	@Autowired
	private SqlSession session;
	
	public void signUp(User vo) {
		int signup = session.insert("signUp",vo);
	}
	
	public List<Login> checkLogin(String userId, String userPw) {
		Map<String, String> login = new HashMap<>();
		login.put("userId", userId);
		login.put("userPw", userPw);
		List<Login> list = session.selectList("login", login);
		return list;
	}
	
	public List<Book> main1(Model book) {
		List<Book> list = session.selectList("selectBook", book);
		return list;
	}
}
