<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	MemberDao md = MemberDao.getInstance();
	int result = md.check(id,passwd);
	if(result ==1){
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
	}else if(result == 0){
%> 
	<script type="text/javascript">
		alert("암호 몰라 !");
		history.go(-1);
	</script>
<%  } else { %>
<script type="text/javascript">
	alert("이상한사람 발견");
	history.go(-1);
</script>
<% } %>
</body>
</html>









