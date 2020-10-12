<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%

for(int i =1; i<10; i++) {
	for(int j=0; j<i; j++) {
		out.print("*");
	}
	out.print("<br>");
}
	
%>