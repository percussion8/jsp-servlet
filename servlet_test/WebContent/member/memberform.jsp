<%@ page import = "student.vo.Score" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적정보 입력</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
	<h1> 회원 정보 </h1>
	<form action="add" method="post">
	이름 : <input type ='text' name ='sname'><br>
	국어 : <input type ='text' name ='kor'><br>
	영어 : <input type='text' name ='eng'><br>
	수학 : <input type='text' name ='math'><br>
	<input type ='submit' value='저장'>
	<input type='reset' value='취소'>
	</form>
<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>