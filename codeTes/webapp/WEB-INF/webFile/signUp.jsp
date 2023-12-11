<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sign_check" method="post" onsubmit="sec();">
		아이디 : <input type="text" name="userId"> <br>
		비밀번호 : <input type="password" name="userPw"> <br>
		이름 : <input type="text" name="userName"> <br>
		전화번호 : <input type="text" name="phone"> <br>
		<input type="submit" name="submit" value="회원가입">
	</form>
	<script>
		function sec() {
			alert("회원가입이 완료되었습니다!");
			return false;
		}
	</script>
</body>
</html>