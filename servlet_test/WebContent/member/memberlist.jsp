<%@ page import = "student.vo.Score" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적</title>
</head>
<body>
<jsp:include page ="/header.jsp"/>
	<h1> 학생성적 </h1>
	<p><a href ='add'> 신규 학생 성적 </a><br>
	<%
		ArrayList<Score> student = (ArrayList<Score>)
			request.getAttribute("student");
		for (Score students : student) {
	%>
		<%= students.getSno() %>,
		<a href='update?sno=<%=students.getSno() %>'><%= students.getSname() %></a>,
		<!-- update는 url no은 유니크한 멤버변수 -->
		<%= students.getKor() %>,
		<%= students.getEng() %>,
		<%= students.getMath() %>,
		<%= students.getTotalScore() %>,	
		<%= students.getAvgScore() %>,
		<%= students.getRankScore() %>
		<br>		
	<%} %>
<br>	
<jsp:include page="/tail.jsp"/>

</body>
</html>