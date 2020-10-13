<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%-- 한글 깨지는 것을 방지 하기 위해 --%>

<%

	request.setCharacterEncoding("UTF-8");
	String FormData = request.getParameter("data");

	out.print("웹에서 받은 데이터: " + FormData);

%>
