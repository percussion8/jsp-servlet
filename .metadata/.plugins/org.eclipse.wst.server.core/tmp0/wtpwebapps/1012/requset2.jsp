<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- 여기의 getParameter는 무조건 아셔야 합니다.--%>
<%

    String FormData = request.getParameter("kor");
	String FormData1 = request.getParameter("math");
    out.print("웹 브라우저에서 받은 데이터 : " + FormData + "<br>");
    out.print("웹 브라우저에서 받은 데이터 : " + FormData1 + "<br>");
    int sum = Integer.parseInt(FormData) + Integer.parseInt(FormData1);
    out.print("웹 브라우저에서 받은 데이터 : " + sum);
    

%>