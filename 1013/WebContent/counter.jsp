<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" scope="application" class="green.Counter">
</jsp:useBean>

<%

	int count=0;
	session = request.getSession();
	session.setMaxInactiveInterval(1);
	String first = (String) session.getValue("checkFirst");
	
	if(first != null) {
		count = cnt.getCount();
	}
	else {
		
	}
		

%>