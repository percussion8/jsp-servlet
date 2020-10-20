<%@ page import = "green.vo.Member" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<jsp:include page ="/header.jsp"/>
	<h1> 회원 목록 </h1>
	<p><a href ='add'> 신규 회원 </a>
	<%	
	ArrayList<Member> members = (ArrayList<Member>)
		request.getAttribute("members");
	for (Member member : members) {	
		%>
		<%= member.getNo() %>,
		<a href='update?no=<%=member.getNo() %>'><%= member.getName() %></a>,
		<!-- update는 url no은 유니크한 멤버변수 -->
		<%= member.getEmail() %>,	
		<%= member.getCreatedDate() %>
		<a href='delete?no=<%=member.getNo() %>'>[삭제]</a><br>		
	<%} %>
<jsp:include page="/tail.jsp"/>

</body>
</html>