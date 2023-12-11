<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.codeTest.spring.vo.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.codeTest.spring.repository.*" %>
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
    <%= id %>
    <table border="1">
        <tr>
            <th>책 번호</th>
            <th>책 이름</th>
            <th>대여여부</th>
            <th>동작</th>
        </tr>
        <%
            List<Book> list = (List<Book>) request.getAttribute("list");
            for (int i = 0; i < list.size(); i++) {
                Book book = list.get(i);
                %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getBookName() %></td>
            <td><%= (book.getRental() == 0) ? "대여 가능" : "대여 중" %></td>
            <td>
                <%
                    if (id.equals("admin")) {
                %>
                <form action="regi_modify" method="post">
                    <input type="hidden" value="<%= book.getBookId() %>" name="hidden">
                    <input type="submit" value="수정하기">
                </form>
                <%
                    } else if (book.getRental() == 1) {
                %>
                <form action="return" method="post">
                	<input type="hidden" value="<%= book.getBookId() %>" name="bookId">
                    <input type="hidden" value="<%= book.getRental() %>" name="rental">
                    <input type="submit" value="반납하기">
                </form>
                <%
                    } else if (book.getRental() == 0) {
                %>
                <form action="rent" method="post">
                    <input type="hidden" value="<%= book.getBookId() %>" name="bookId">
                    <input type="hidden" value="<%= id %>" name="userId">
                    <input type="submit" value="대여하기">
                </form>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div>
        <%
            if (id.equals("admin")) {
        %>
        <form action="regi" method="post">
            <input type="button" value="도서등록" onclick="regi()">
        </form>
        <%
            }
        %>
    </div>
    <script>
        function regi() {
            window.location.href = "regi";
        }
    </script>
</body>
</html>
