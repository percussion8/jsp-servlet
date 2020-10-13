<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat" %>
    
<%
	Date t = new Date();
	SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

%>


<%

	request.setCharacterEncoding("UTF-8");
	String FormData = request.getParameter("id");	
	String FormData2 = request.getParameter("passwd");
	
	
	String sessionId = session.getId();
	
	
	t.setTime(session.getCreationTime()); //세션 생성 시간
	out.print(st.format(t) + "세션 생성시간 <br>");
	
	int sessionTime = session.getMaxInactiveInterval(); //세션 시간 설정
	
	out.print(FormData + "님 환영합니다. <br>");
	out.print("생성된 세션 아이디 : " + sessionId + "<br>");
	out.print(sessionTime + "세션유지시간 <br>");
	
	t.setTime(session.getLastAccessedTime()); //최근 접속 시간
	out.print(st.format(t) + "세션 생성시간 <br>");
	
%>

