<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = 100;
	out.print("이곳에서는 자바코드를 사용할 수 있음 <br>");
	
%>
html 태그를 사용해서 줄을 바꿀 수 있다. <br>

<%

	out.print("변수 a값은 :" + a + "<p>");
	out.print(" \'out.print() \' 메서드내에서 html사용이 가능하다. <br>");

%>

<%= " <b> 출력문에서도 당연시 html태그를 사용할 수 있다. </b>" %>

</body>
</html>