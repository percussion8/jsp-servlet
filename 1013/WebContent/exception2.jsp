<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>

<%

	//위의 isErrorPage를 true로 설정할떄만 동작함 
	out.print("에러메시지 : " + exception.getMessage() + "<br>");

%>