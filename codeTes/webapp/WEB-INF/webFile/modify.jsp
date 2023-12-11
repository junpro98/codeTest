<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String hidden = request.getParameter("hidden");
%>
	<form action="modify_check" method="post">
		제목 : <input type="text" name="modify">
		<input type="hidden" value="<%= hidden %>" name=hidden>
		<input type="submit" name="submit">
	</form>
</body>
</html>