<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="check_login" method="post">
		아이디 : <input type="text" name="userId">
		비밀번호 : <input type="password" name="userPw">
		<input type="submit" name="submit" value="로그인">
	</form>
	<div>
		admin계정은 ID:admin PW:admin 이상입니다.
		
	</div>
</body>
</html>