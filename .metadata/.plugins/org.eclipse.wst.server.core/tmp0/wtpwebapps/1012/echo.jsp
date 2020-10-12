<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="myEcho" class="green.Echo" scope="page"></jsp:useBean>
<jsp:setProperty property="msg" name="myEcho"/>

<%-- 

jsp:useBean id="객체이름"
a.setMsg = (jsp:setProperty property ="멤버변수" = "a") 동일 

<%= a.getMsg() <=> jsp:getProperty name = "a"

--%>

<%
	myEcho.setMsg("와");
	out.print("Echo 빈즈에서 받은 내용: " + myEcho.getMsg() + "<br>");
%>