<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 여기에서 form 태그를 이용하여 서블릿으로 데이터 전송 -->
	<form action="b" method="post"> 
	<!-- b url로 전송되고 post (input 태그들의 값을 서버로 전송하기 위한 정보를 담고 있다. )  -->
        국어 <input type="text" name ="kor">
    <input type="submit" value="전송">
    </form>
</body>
</html>