<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberCheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=id %> 님 환영합니다<p>
<table bgcolor="pink" border="1" width="80%">
	<tr><td><a href="logOut.jsp">로그아웃</a></td></tr>
	<tr><td><a href="joinForm.jsp">회원가입</a></td></tr>
	<tr><td><a href="memberlist.jsp">회원명단</a></td></tr>
	<tr><td><a href="updateForm.jsp">회원정보수정</a></td></tr>
	<tr><td><a href="deleteForm.jsp">회원탈퇴</a></td></tr>
</table>
</body>
</html>