<%@ page import = "student.vo.Score" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" scope="request" class="student.vo.Score"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생성적수정</title>
</head>
<body>
	<h1> 학생성적 수정 </h1>

	<form action="update" method="post">
	번호 : <input type ='text' name ='sno' value = '<%=student.getSno()%>' readonly><br>
	이름 : <input type ='text' name ='sname' value = '<%=student.getSname()%>'><br>
	국어 : <input type ='text' name ='kor' value = '<%=student.getKor()%>'><br>
	영어 : <input type ='text' name ='eng' value = '<%=student.getEng()%>'><br>
	수학 : <input type ='text' name ='math' value = '<%=student.getMath()%>'><br>
	<input type ='submit' value='저장'>
	<input type='button' value ='취소' onclick='location.href="list"'>
	</form>
</body>
</html>