<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%=
	"jsp 컨테이너 정보 : " + application.getServerInfo() + "<br>"
%>

<%= "jsp 컨테이너 Major 정보 : " + application.getMajorVersion() + "<br>"  %>
<%= "jsp 컨테이너 Minor 정보 : " + application.getMinorVersion() + "<br>"  %>