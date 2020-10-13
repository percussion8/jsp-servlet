<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" scope="application" class="green.Counter">
</jsp:useBean>

<%

	int count=0;
	session = request.getSession(); //세션 얻어옴 (생성)
	//session 선언도 안하고 그냥 할 수 있는 이유 : 내장객체라서
	session.setMaxInactiveInterval(1); //1초 세션 유지
	session.putValue("checkFirst", "20"); //추가
	String first = (String) session.getValue("checkFirst");
	
	if(first != null) {
		count = cnt.getCount();
	}
	else {
		cnt.plusCount();
		count = cnt.getCount();
		session.putValue("checkFirst", "first");
	}
	out.println("현재까지 방문자 수 : " + count +
			"세션에 저장된 정보 : " + session.getValue("checkFirst"));
	
	//세션 예시 
	//session.putValue("key", "value");
	//session.putValue("key1", "value1");
	//session.getValue("key", "value");
	//session.getValue("key1", "value1");
	//session.getAttribute("key", "value");
	//session.getAttribute("key1", "value1");
%>