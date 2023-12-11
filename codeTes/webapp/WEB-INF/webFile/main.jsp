<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codeTest.spring.repository.*"%>
<%@ page import="com.codeTest.spring.vo.*"%>
<%@ page import="java.util.List"%>
<%
	String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서리스트</title>
</head>
<body>
    <h2>도서리스트</h2>
    <table border="1">
        <tr>
            <th>책 번호</th>
            <th>책 이름</th>
            <th>대여여부</th>
        </tr>
        <%
            List<Book> list = (List<Book>) request.getAttribute("list");
            for (int i = 0; i < list.size(); i++) {
                %>
                <tr>
                    <td><%= list.get(i).getBookId() %></td>
                    <td><%= list.get(i).getBookName() %></td>
                    <td><%= (list.get(i).getRental() == 0) ? "대여 가능" : "대여 중" %></td>
                </tr>
                <%
            }
        %>
    </table>
</body>
</html>
