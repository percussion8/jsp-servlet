<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	int i =0; 
	int sum = 0;
	
	while (i<10) {
		i++;
		sum = sum+i;
		out.print("반복횟수 :" + i);
	}
	
	out.print("총합 :" + sum);
	
%>