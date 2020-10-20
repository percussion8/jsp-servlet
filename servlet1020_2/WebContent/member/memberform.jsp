<%@ page import = "green.vo.Member" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
	<h1> 회원 정보 </h1>
	<form action="update" method="post">
	이름 : <input type ='text' name ='name'><br>
	이메일 : <input type ='text' name ='email'><br>
	암호 : <input type='password' name ='password'><br>
	<input type ='submit' value='저장'>
	<input type='reset' value='취소'>
	</form>
<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>