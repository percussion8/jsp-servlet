<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "exception2.jsp" %>

<%-- page 디렉티브의 errorPage 속성과 isErrorPage 속성을 가지고 예외에 대한 대응르 할 수 있습니다. --%>

<%

	int div = 10/0; //0으로 나누면 예외 발생함 

%>