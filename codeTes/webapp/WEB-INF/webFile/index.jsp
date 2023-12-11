<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.contanier {
	display: flex;
}
</style>
</head>
<body>
	도서관리 프로그램
	<div class="contanier">
		<form action="login" method="post">
			<input type="button" value="로그인" name="login_btn" onclick="loginBtn()">
		</form>
		<form action="signUp" method="post">
			<input type="button" value="회원가입" name="signUp_btn" onclick="signUpBtn()">
		</form>
	</div>
	<script>
		function loginBtn() {
			window.location.href = "login";
		}
	
		function signUpBtn() {
			window.location.href = "signUp";
		}
	</script>
</body>
</html>