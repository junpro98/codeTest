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
		System.out.println("dao " + userId);
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
	
	public void regi_check(String bookName) {
		int regi_check = session.insert("regi_check", bookName);
	}
	
	public void modify_check(String modify, int hidden) {
		Map<String, Object> modify1 = new HashMap<>();
		modify1.put("modify", modify);
		modify1.put("hidden", hidden);
		int modify_check = session.update("modify_check", modify1);
	}
	
	public void rental(String userId, int bookId) {
		Map<String, Object> rental = new HashMap<>();
		rental.put("userId", userId);
		rental.put("bookId", bookId);
		int rental1 = session.insert("rental", rental);
		
		if(rental1 > 0) {
			session.update("updateBookRental", bookId);
		}
	}
	
	public void retu(int rental, int bookId) {
		session.delete("deleteRental", rental);
		session.update("updateBookReturn", bookId);
	}
}
